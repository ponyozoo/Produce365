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
		
		if(action.equals("lessons")) {
			LessonDAO lessonDao = new JDBCLessonDAO();
			List<Lesson> lessons = lessonDao.findAll();
			req.setAttribute("lessons", lessons);
		} else if(action.equals("save")) {
			JDBCLessonDAO jdbcLessonDAO = new JDBCLessonDAO();
			Lesson lesson = new Lesson(
					req.getParameter("trainer"),
					req.getParameter("subject"),
					Float.parseFloat(req.getParameter("time")));
			jdbcLessonDAO.insert(lesson);
			
			resp.sendRedirect("/produce365/lessons");
			return ;
		} else if(action.equals("delete")) {
			LessonDAO lessonDao = new JDBCLessonDAO();
			lessonDao.deleteById(Integer.parseInt(req.getParameter("id")));
			
			resp.sendRedirect("/produce365/lessons");
			return ;
		}
		
		String dispatcherUrl = null;
		
		if(action.equals("lessons")) {
			dispatcherUrl = "/lesson/lessonList.jsp";
		} else if (action.equals("input")) {
			dispatcherUrl = "/lesson/lessonNew.jsp";
		}
		
		RequestDispatcher rd = req.getRequestDispatcher(dispatcherUrl);
		rd.forward(req, resp);
	}	
}
