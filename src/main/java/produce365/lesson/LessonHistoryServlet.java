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
		
		if (action.equals("lessonHistory")) {
			LessonHistoryDAO lessonHistoryDao = new JDBCLessonHistoryDAO();
			List<LessonHistory> lessonHistories = lessonHistoryDao.selectAll();
			req.setAttribute("lessonHistories", lessonHistories);
			
			JDBCLessonDAO jdbcLessonDao = new JDBCLessonDAO();
			List<Lesson> lessons = jdbcLessonDao.findAll();
			req.setAttribute("lessons", lessons);
			
			JDBCTraineeDAO jdbcTraineeDao = new JDBCTraineeDAO();
			List<Trainee> trainees = jdbcTraineeDao.selectAll();
			req.setAttribute("trainees",trainees);
			
			RequestDispatcher rd = req.getRequestDispatcher("/lesson/lessonHistoryList.jsp");
			rd.forward(req, resp);
		} else if(action.equals("save")) {
			JDBCLessonHistoryDAO JdbcLessonHistoryDao = new JDBCLessonHistoryDAO();
			
			LessonHistory lessonHistory = new LessonHistory(
					Date.valueOf(req.getParameter("lessonDate")),
					new Lesson(Integer.parseInt(req.getParameter("subject"))),
					new Trainee(Integer.parseInt(req.getParameter("trainee"))));
			
			JdbcLessonHistoryDao.insert(lessonHistory);
			
			resp.sendRedirect("/produce365/lessonHistory");
			return ;
		}
	}
}
