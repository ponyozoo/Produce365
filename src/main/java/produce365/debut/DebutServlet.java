package produce365.debut;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jdt.internal.compiler.batch.Main;

@WebServlet("/debuts/*")
public class DebutServlet extends HttpServlet {
	
	
	
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

		if (action.equals("debuts")) {
			// 데뷔조 목록 출력.
			DebutDAO debutDao = new JDBCDebutDAO();
			List<Debut> debuts = debutDao.findAll();
			req.setAttribute("list", debuts);

		} else if (action.equals("groupPage")) {
			// 데뷔조 상세 페이지 = 데뷔조 id로 검색
			DebutDAO debutDAO = new JDBCDebutDAO();
			int groupId = Integer.parseInt(req.getParameter("id"));
			req.setAttribute("debut", debutDAO.findById(groupId));

		} else if (action.equals("update")) {
			// 데뷔조 상세 페이지에서 수정하기 버튼 눌렀을 때
			DebutDAO debutDAO = new JDBCDebutDAO();

			Debut debut = new Debut(
					req.getParameter("name"), 
					Integer.parseInt(req.getParameter("memberCount")),
					req.getParameter("concept"), 
					req.getParameter("grade"),
					Date.valueOf(req.getParameter("debutDate")),
					Integer.parseInt(req.getParameter("id")));
			debutDAO.update(debut);
			
		} else if (action.equals("delete")) { //경로가 delete일때,
			
			//int id = Integer.parseInt(req.getParameter("id"));
			//int형 변수 id에 Integer로 감싼 "id"라는 name을 가진 변수를 리퀘스트하고
			
			JDBCDebutDAO debutDAO = new JDBCDebutDAO(); 
			//debutDAO라고 하는 새로운 JDBCDebutDAO형 객체를 만들어
			
			debutDAO.deleteById(Integer.parseInt(req.getParameter("id")));
			//debutDAO에 대하여 deleteById라는 메소드를 실행하는데, 그 매개변수로 위의 id를 넣는다.

			
		} else if (action.equals("save")) {
			// 새 데뷔조 만들기 : 저장하기 버튼 눌렀을 때
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

		if (action.equals("debuts")) {
			dispatcherUrl = "/debut/debut.jsp";
		} else if (action.equals("input")) {
			dispatcherUrl = "/debut/debutNew.jsp";
		} else if (action.equals("save")) {
			dispatcherUrl = "/debut/debut.jsp";
		} else if (action.equals("groupPage")) {
			dispatcherUrl = "/debut/debutUpdate.jsp";
		} else if (action.equals("update")) {
			dispatcherUrl = "/debuts";
		} else if (action.equals("delete")) {
			dispatcherUrl = "/debuts";
		}

		RequestDispatcher rd = req.getRequestDispatcher(dispatcherUrl);
		rd.forward(req, resp);

	
	}
}
