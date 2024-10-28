package produce365.debut;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import produce365.trainee.JDBCTraineeDAO;
import produce365.trainee.Trainee;
import produce365.trainee.TraineeDAO;

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
			
		} else if(action.equals("findAll")) {
			//데뷔조 전체 목록
			
			DebutDAO debutDAO = new JDBCDebutDAO();
			req.setAttribute("debuts", debutDAO.findAll());
			
		} else if(action.equals("groupPage")) {
			//데뷔조 상세 페이지 = 데뷔조 id로 검색
			DebutDAO debutDAO = new JDBCDebutDAO();
			int groupId = Integer.parseInt(req.getParameter("id"));
			req.setAttribute("debuts", debutDAO.findById(groupId));
			
		}else if(action.equals("update")) {
			//데뷔조 상세 페이지에서 수정하기 버튼 눌렀을 때
			DebutDAO debutDAO = new JDBCDebutDAO();
			Debut debut = new Debut();
			
			debut.setName(req.getParameter("name"));
			debut.setMemberCount(Integer.parseInt(req.getParameter("memberCount")));
			debut.setConcept(req.getParameter("concept"));
			debut.setGrade(req.getParameter("grade"));
			debut.setDebutDate(Date.valueOf(req.getParameter("debutDate")));
			debut.setId(Integer.parseInt(req.getParameter("id")));
			
			debutDAO.update(debut);
		}
		
		
		
		String dispatcherUrl = null;
		
		if(action.equals("input")) {
			dispatcherUrl = "/debut/debutNew.jsp";
		}else if (action.equals("save")) {
			dispatcherUrl = "";
		} else if(action.equals("findAll")) {
			
		} else if(action.equals("groupPage")) {
			dispatcherUrl = "/debut/debutUpdate.jsp";
		}
		
		RequestDispatcher rd = req.getRequestDispatcher(dispatcherUrl);
		rd.forward(req, resp);
		
	}
}
