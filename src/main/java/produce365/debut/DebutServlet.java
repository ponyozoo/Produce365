package produce365.debut;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/debuts/*")
public class DebutServlet extends HttpServlet{
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
		
		if(action.equals("input")) {
			//입력 첫 페이지.
		} else if(action.equals("save")) {
			//저장하기 버튼 눌렀을 때 
			DebutDAO debutDAO = new JDBCDebutDAO();
			Debut debut = new Debut();
			
			debut.setName(req.getParameter("name"));
			debut.setMemberCount(Integer.parseInt(req.getParameter("memberCount")));
			debut.setConcept(req.getParameter("concept"));
			debut.setGrade(req.getParameter("grade"));
			debut.setDebutDate(Date.valueOf(req.getParameter("debutDate")));
			debut.setPhoto(req.getParameter("photo"));
			
			debutDAO.insert(debut);
			
		}
		
		String dispatcherUrl = null;
		
		if(action.equals("input")) {
			dispatcherUrl = "/debut/debutNew.jsp";
		}else if (action.equals("save")) {
			dispatcherUrl = "";
		}
		
		RequestDispatcher rd = req.getRequestDispatcher(dispatcherUrl);
		rd.forward(req, resp);
		
	}
}
