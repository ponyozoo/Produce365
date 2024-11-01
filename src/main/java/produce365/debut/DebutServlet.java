package produce365.debut;

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

import produce365.debutMember.DebutMember;
import produce365.debutMember.DebutMemberDAO;
import produce365.debutMember.JDBCDebutMemberDAO;

@SuppressWarnings("serial")
@WebServlet("/debuts/*")
@MultipartConfig(
	fileSizeThreshold = 1024*1024,
	maxFileSize = 1024*1024*50,
	maxRequestSize = 1024*1024*50*5
)
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
		
		String dispatcherUrl = null;

		if (action.equals("debuts")) {
			String param = req.getParameter("id");
			if (param == null) {
				DebutDAO debutDao = new JDBCDebutDAO();
				List<Debut> debuts = debutDao.findAll();
				req.setAttribute("list", debuts);
				dispatcherUrl = "/debut/debut.jsp";
			} else {
				DebutDAO debutDAO = new JDBCDebutDAO();
				int groupId = Integer.parseInt(param);
				req.setAttribute("debut", debutDAO.findById(groupId));
				
				DebutMemberDAO debutMemberDao = new JDBCDebutMemberDAO();
				List<DebutMember> list = debutMemberDao.selectByGroup(groupId);
				req.setAttribute("trainees", list);
				dispatcherUrl = "/debut/debutUpdate.jsp";
			}

		} else if (action.equals("save")) {
			DebutDAO debutDAO = new JDBCDebutDAO();
			Debut debut = new Debut();

			String filePath = "";
			Part part = req.getPart("photo");
			if (part.getSubmittedFileName() != null) {
				filePath = "photos/debut_" + (debutDAO.getLastIdx() + 1) + ".jpg";				
				part.write(req.getServletContext().getRealPath("") + "/" + filePath);
			} else
				filePath = "resources/defaultImg.png";
				
			debut.setName(req.getParameter("name"));
			debut.setMemberCount(Integer.parseInt(req.getParameter("memberCount")));
			debut.setConcept(req.getParameter("concept"));
			debut.setGrade(req.getParameter("grade"));
			debut.setDebutDate(Date.valueOf(req.getParameter("debutDate")));
			debut.setPhoto(filePath);
			
			debutDAO.insert(debut);
			
			resp.sendRedirect("/produce365/debuts");
			return ;
			
		} else if (action.equals("update")) {
			DebutDAO debutDAO = new JDBCDebutDAO();

			Debut debut = new Debut(
					req.getParameter("name"), 
					Integer.parseInt(req.getParameter("memberCount")),
					req.getParameter("concept"), 
					req.getParameter("grade"),
					Date.valueOf(req.getParameter("debutDate")),
					Integer.parseInt(req.getParameter("id")));
			debutDAO.update(debut);
			
			resp.sendRedirect("/produce365/debuts");
			return ;
			
		} else if (action.equals("delete")) {
			JDBCDebutDAO debutDAO = new JDBCDebutDAO(); 
			debutDAO.deleteById(Integer.parseInt(req.getParameter("id")));
			
			resp.sendRedirect("/produce365/debuts");
			return ;
			
		} else if (action.equals("new")) {
			dispatcherUrl = "/debut/debutNew.jsp";
		}

		RequestDispatcher rd = req.getRequestDispatcher(dispatcherUrl);
		rd.forward(req, resp);
	}
}
