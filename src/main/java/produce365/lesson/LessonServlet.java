package produce365.lesson;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@SuppressWarnings("serial")
@WebServlet("/lessons/*")
public class LessonServlet extends HttpServlet{
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
		
		if (action.equals("input")) {
			
		}else if(action.equals("save")) {
			JDBCLessonDAO jdbcLessonDAO = new JDBCLessonDAO();
			Lesson lesson = new Lesson(
					req.getParameter("trainer"),
					req.getParameter("subject"),
					Integer.parseInt(req.getParameter("time")));
			jdbcLessonDAO.insert(lesson);
		}else if(action.equals("findAll")) {
			LessonDAO lessonDao = new JDBCLessonDAO();
			List<Lesson> lessons = lessonDao.findAll();
			req.setAttribute("lessons", lessons);
		}else if(action.equals("delete")) {
			LessonDAO lessonDao = new JDBCLessonDAO();
			lessonDao.deleteById(Integer.parseInt(req.getParameter("id")));
		}
		
		String dispatcherUrl = null;
		
		if (action.equals("input")) {
			dispatcherUrl = "/lesson/lessonNew.jsp";
		}else if(action.equals("save")) {
			dispatcherUrl = "/lessons/findAll";
		}else if(action.equals("findAll")) {
			dispatcherUrl = "/lesson/lessonList.jsp";
		}else if(action.equals("delete")) {
			dispatcherUrl = "/lessons/findAll";
		}
		RequestDispatcher rd = req.getRequestDispatcher(dispatcherUrl);
		rd.forward(req, resp);
	}	
}
