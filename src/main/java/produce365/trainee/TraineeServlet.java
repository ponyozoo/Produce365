package produce365.trainee;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import produce365.rating.JDBCRatingDAO;
import produce365.rating.Rating;

@SuppressWarnings("serial")
@WebServlet({ "/trainees/*" })
public class TraineeServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		process(request, response);

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		process(request, response);

	}

	private void process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String uri = request.getRequestURI();

		int lastIndex = uri.lastIndexOf("/");
		String action = uri.substring(lastIndex + 1);
		request.setCharacterEncoding("UTF-8");

		if (action.equals("trainees")) {
			JDBCTraineeDAO traineeDao = new JDBCTraineeDAO();
			List<Trainee> list = traineeDao.selectAll();
			request.setAttribute("list", list);
		} else if (action.equals("save")) {
			JDBCTraineeDAO traineeDao = new JDBCTraineeDAO();
			Trainee trainee = new Trainee();

			int id = 123;

			trainee.setId(id);
			trainee.setName(request.getParameter("name"));
			trainee.setSex(request.getParameter("sex"));
			trainee.setBirth(Date.valueOf(request.getParameter("birth")));
			trainee.setNationality(request.getParameter("nationality"));
			trainee.setHeight(Integer.parseInt(request.getParameter("height")));
			trainee.setWeight(Integer.parseInt(request.getParameter("weight")));
			trainee.setHireDate(Date.valueOf(request.getParameter("hireDate")));
			trainee.setPhoto("photo");

			traineeDao.insert(trainee);

			JDBCRatingDAO ratingDao = new JDBCRatingDAO();
			Rating rating = new Rating();
			rating.setTrainee(trainee); // rating객체 안에 trainee를 넣는다

			rating.setGrade(request.getParameter("total"));
			rating.setCategory("TOTAL");
			ratingDao.insert(rating);

			rating.setGrade(request.getParameter("vocal"));
			rating.setCategory("VOCAL");
			ratingDao.insert(rating);

			rating.setGrade(request.getParameter("rap"));
			rating.setCategory("RAP");
			ratingDao.insert(rating);

			rating.setGrade(request.getParameter("dance"));
			rating.setCategory("DANCE");
			ratingDao.insert(rating);

		} else if (action.equals("update")) {

			JDBCTraineeDAO traineeDao = new JDBCTraineeDAO();

			int id = Integer.parseInt(request.getParameter("id"));
			String name = (request.getParameter("name"));
			String nationality = (request.getParameter("nationality"));
			int height = (Integer.parseInt(request.getParameter("height")));
			int weight = (Integer.parseInt(request.getParameter("weight")));

			Trainee trainee = new Trainee(id, name, nationality, height, weight);

			boolean res = traineeDao.update(trainee);

			JDBCRatingDAO ratingDao = new JDBCRatingDAO();

			Rating rating = new Rating("TOTAL", trainee, request.getParameter("total"));

			ratingDao.update(rating);

			rating.setCategory("VOCAL");
			rating.setGrade(request.getParameter("vocal"));

			boolean resu = ratingDao.update(rating);

			rating.setCategory("RAP");
			rating.setGrade(request.getParameter("rap"));

			boolean resu1 = ratingDao.update(rating);

			rating.setCategory("DANCE");
			rating.setGrade(request.getParameter("dance"));
			ratingDao.update(rating);

			boolean resu2 = ratingDao.update(rating);

			request.setAttribute("result", res && resu && resu1 && resu2);

		} else if (action.equals("detail")) {

			JDBCTraineeDAO traineeDao = new JDBCTraineeDAO();

			int id = Integer.parseInt(request.getParameter("id"));
			Trainee trainee = traineeDao.selectById(id);

			request.setAttribute("trainee", trainee);

		} else if (action.equals("delete")) {
			
			int deleteId = Integer.parseInt(request.getParameter("id"));
			
			JDBCTraineeDAO traineeId = new JDBCTraineeDAO();
			
//			boolean result = traineeDao.deleteById(id);
			request.setAttribute("result", traineeId.deleteById(deleteId));
		}

		String dispatcherUrl = null;

		if (action.equals("trainees")) {
			dispatcherUrl = "/trainee/trainee.jsp";
		} else if (action.equals("input")) {
			dispatcherUrl = "/trainee/traineeNew.jsp";
		} else if (action.equals("save")) {
			dispatcherUrl = "/trainees";
		} else if (action.equals("update")) {
			dispatcherUrl = "/trainees";
		} else if (action.equals("detail")) {
			dispatcherUrl = "/trainee/traineeDetail.jsp";
		} else if (action.equals("delete")) {
			dispatcherUrl = "/trainees";
		}
		RequestDispatcher rd = request.getRequestDispatcher(dispatcherUrl);
		rd.forward(request, response);
	}

}