package produce365.lesson;

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
@WebServlet("/lessonHistory/*")
public class LessonHistoryServlet extends HttpServlet{
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
		System.out.println(action);
		
		if(action.equals("input")) {
			JDBCLessonDAO jdbcLessonDao = new JDBCLessonDAO();
			List<Lesson> lessons = jdbcLessonDao.findAll();
			req.setAttribute("lessons", lessons);
			JDBCTraineeDAO jdbcTraineeDao = new JDBCTraineeDAO();
			List<Trainee> trainees = jdbcTraineeDao.selectAll();
			req.setAttribute("trainees",trainees);
		}else if(action.equals("insert")) {
			JDBCLessonHistoryDAO JdbcLessonHistoryDao = new JDBCLessonHistoryDAO();
			LessonHistory lessonHistory = new LessonHistory(
					Date.valueOf(req.getParameter("lessonDate")),
					new Lesson(Integer.parseInt(req.getParameter("subject"))),
					new Trainee(Integer.parseInt(req.getParameter("trainee"))));
			JdbcLessonHistoryDao.insert(lessonHistory);
		}else if(action.equals("lessonHistories")) {
			LessonHistoryDAO lessonHistoryDao = new JDBCLessonHistoryDAO();
			List<LessonHistory> lessonHistories = lessonHistoryDao.selectAll();
			req.setAttribute("lessonHistories", lessonHistories);
		}
		
		String dispatcherUrl = null;
		
		if (action.equals("input")) {
			dispatcherUrl = "/lesson/lessonHistoryNew.jsp";
		}else if(action.equals("lessonHistories")){
			dispatcherUrl = "/lesson/lessonHistoryList.jsp";
		}else if(action.equals("insert")) {
			dispatcherUrl = "lessonHistories";
		}
		RequestDispatcher rd = req.getRequestDispatcher(dispatcherUrl);
		rd.forward(req, resp);
	}

}
