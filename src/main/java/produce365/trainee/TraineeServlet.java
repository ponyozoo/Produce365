package produce365.trainee;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import produce365.common.Util;
import produce365.rating.JDBCRatingDAO;
import produce365.rating.Rating;
import produce365.rating.RatingDAO;

@SuppressWarnings("serial")
@WebServlet("/trainees/*")
@MultipartConfig(
		fileSizeThreshold = 1024*1024,
		maxFileSize = 1024*1024*50,
		maxRequestSize = 1024*1024*50*5
	)
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
		
		String dispatcherUrl = null;

		if (action.equals("trainees")) {
			String param = request.getParameter("id");
			if (param == null) {
				JDBCTraineeDAO traineeDao = new JDBCTraineeDAO();
				List<Trainee> list = traineeDao.selectAll();
				request.setAttribute("list", list);
				dispatcherUrl = "/trainee/trainee.jsp";
			} else {
				JDBCTraineeDAO traineeDao = new JDBCTraineeDAO();
				Trainee trainee = traineeDao.selectById(Integer.parseInt(param));
				request.setAttribute("trainee", trainee);
				
				RatingDAO ratingDao = new JDBCRatingDAO();
				List<Rating> ratings = ratingDao.selectByTraineeId(Integer.parseInt(param));
				request.setAttribute("ratings", ratings);

				dispatcherUrl = "/trainee/traineeDetail.jsp";
			}
		} else if (action.equals("save")) {
			JDBCTraineeDAO traineeDao = new JDBCTraineeDAO();
			Trainee trainee = new Trainee();
			Util util = new Util();
			
			int traineeId = 0;
			
			while (true) {
				traineeId = util.makeTraineeId(request.getParameter("hireDate"), request.getParameter("sex"));
				Trainee trainees = traineeDao.selectById(traineeId);
				if (trainees == null) {
					break;
				}
			}
			
			String filePath = "";
			Part part = request.getPart("photo");
			if (part.getSubmittedFileName() != null) {
				filePath = "photos/trainee_" + traineeId + ".jpg";				
				part.write(request.getServletContext().getRealPath("") + "/" + filePath);
			} else
				filePath = "resources/defaultImg.png";

			trainee.setId(traineeId);
			trainee.setName(request.getParameter("name"));
			trainee.setSex(request.getParameter("sex"));
			trainee.setBirth(Date.valueOf(request.getParameter("birth")));
			trainee.setNationality(request.getParameter("nationality"));
			trainee.setHeight(Integer.parseInt(request.getParameter("height")));
			trainee.setWeight(Integer.parseInt(request.getParameter("weight")));
			trainee.setHireDate(Date.valueOf(request.getParameter("hireDate")));
			trainee.setPhoto(filePath);
			traineeDao.insert(trainee);

			JDBCRatingDAO ratingDao = new JDBCRatingDAO();
			Rating rating = new Rating();
			
			rating.setTrainee(trainee);
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
			
			response.sendRedirect("/produce365/trainees");
			return ;

		} else if (action.equals("update")) {

			JDBCTraineeDAO traineeDao = new JDBCTraineeDAO();

			int id = Integer.parseInt(request.getParameter("id"));
			String name = (request.getParameter("name"));
			String nationality = (request.getParameter("nationality"));
			int height = (Integer.parseInt(request.getParameter("height")));
			int weight = (Integer.parseInt(request.getParameter("weight")));

			Trainee trainee = new Trainee(id, name, nationality, height, weight);

			traineeDao.update(trainee);

			JDBCRatingDAO ratingDao = new JDBCRatingDAO();

			Rating rating = new Rating("TOTAL", trainee, request.getParameter("total"));
			ratingDao.update(rating);

			rating.setCategory("VOCAL");
			rating.setGrade(request.getParameter("vocal"));
			ratingDao.update(rating);

			rating.setCategory("RAP");
			rating.setGrade(request.getParameter("rap"));
			ratingDao.update(rating);

			rating.setCategory("DANCE");
			rating.setGrade(request.getParameter("dance"));
			ratingDao.update(rating);
			
			response.sendRedirect("/produce365/trainees");
			return ;

		} else if (action.equals("delete")) {
			
			int deleteId = Integer.parseInt(request.getParameter("id"));
			
			JDBCTraineeDAO traineeId = new JDBCTraineeDAO();
			
			request.setAttribute("result", traineeId.deleteById(deleteId));
			
			response.sendRedirect("/produce365/trainees");
			return ;
		} else if (action.equals("new")) {
			dispatcherUrl = "/trainee/traineeNew.jsp";
		}
		
		RequestDispatcher rd = request.getRequestDispatcher(dispatcherUrl);
		rd.forward(request, response);
	}

}