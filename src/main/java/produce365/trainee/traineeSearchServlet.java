package produce365.trainee;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import produce365.debutMember.DebutMember;
import produce365.debutMember.DebutMemberDAO;
import produce365.debutMember.JDBCDebutMemberDAO;
import produce365.rating.JDBCRatingDAO;
import produce365.rating.Rating;
import produce365.rating.RatingDAO;

@SuppressWarnings("serial")
@WebServlet("/traineeSearch/*")
public class traineeSearchServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		process(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		process(req, resp);
	}
	
	private void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		TraineeDAO traineeDao = new JDBCTraineeDAO();
		RatingDAO ratingDao = new JDBCRatingDAO();
		DebutMemberDAO debutMemberDao = new JDBCDebutMemberDAO();
		
		List<String> nations = traineeDao.selectDistinctNationality();
		req.setAttribute("nationality", nations);
		
		String menu = req.getParameter("menu");
		String value = req.getParameter("value");
		
		if (menu != null && value != null) {
			List<Trainee> list = null;
			
			if (menu.equals("sex")) {
				list = traineeDao.selectBySex(req.getParameter("value"));
			} else if (menu.equals("nation")) {
				list = traineeDao.selectByNationality(req.getParameter("value"));
			} else if (menu.equals("grade")) {
				List<Rating> ratingList = ratingDao.selectByTotalGrade(req.getParameter("value"));
				list = new ArrayList<Trainee>();
				for (Rating rating : ratingList)
					list.add(rating.getTrainee());			
			} else if (menu.equals("debut")) {
				if (value.equals("true")) {
					List<DebutMember> members = debutMemberDao.selectAll();
					list = new ArrayList<Trainee>();
					for (DebutMember member : members)
						list.add(member.getTrainee());
				} else if (value.equals("false"))
					list = traineeDao.selectNoDebut();
			}
			
			req.setAttribute("trainees", list);
			req.setAttribute("menu", menu);
			req.setAttribute("value", value);	
		}

		RequestDispatcher rd = req.getRequestDispatcher("/trainee/traineeSearch.jsp");
		rd.forward(req, resp);
	}
}
