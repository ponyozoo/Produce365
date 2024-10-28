package produce365.care;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import produce365.trainee.JDBCTraineeDAO;
import produce365.trainee.Trainee;

@SuppressWarnings("serial")
@WebServlet("/careHistory/*")
public class CareHistoryServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		process(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		process(req, resp);
	}

	private void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri = req.getRequestURI();
		int lastIndex = uri.lastIndexOf("/");
		String action = uri.substring(lastIndex + 1);

		if (action.equals("careHistory")) {
			CareHistoryDAO careHistoryDao = new JDBCCareHistoryDAO();
			List<CareHistory> careHistories = careHistoryDao.selectAll();
			req.setAttribute("careHistories", careHistories);
			
			JDBCCareDAO jdbcCareDao = new JDBCCareDAO();
			List<Care> cares = jdbcCareDao.findAll();
			req.setAttribute("cares", cares);
			
			JDBCTraineeDAO traineeDAO = new JDBCTraineeDAO();
			List<Trainee> trainees = traineeDAO.selectAll();
			req.setAttribute("trainees", trainees);
			
			RequestDispatcher rd = req.getRequestDispatcher("/care/careHistoryList.jsp");
			rd.forward(req, resp);
		} else if (action.equals("save")) {
			JDBCCareHistoryDAO JdbcCareHistoryDao = new JDBCCareHistoryDAO();
			
			CareHistory careHistory = new CareHistory(Date.valueOf(req.getParameter("careDate")),
					new Care(Integer.parseInt(req.getParameter("category"))),
					new Trainee(Integer.parseInt(req.getParameter("trainee"))));
			
			JdbcCareHistoryDao.insert(careHistory);
			
			resp.sendRedirect("/produce365/careHistory");
			return ;
		}
	}
}
