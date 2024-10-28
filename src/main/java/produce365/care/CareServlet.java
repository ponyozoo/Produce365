package produce365.care;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/cares/*")
public class CareServlet extends HttpServlet {

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

		if (action.equals("cares")) {
			CareDAO careDao = new JDBCCareDAO();
			List<Care> cares = careDao.findAll();
			req.setAttribute("cares", cares);
		} else if (action.equals("save")) {
			JDBCCareDAO jdbcCareDao = new JDBCCareDAO();
			Care care = new Care(req.getParameter("category"), Integer.parseInt(req.getParameter("cost")));
			jdbcCareDao.insert(care);
			resp.sendRedirect("/produce365/cares");
			return ;
		} else if (action.equals("delete")) {
			CareDAO careDao = new JDBCCareDAO();
			careDao.deleteById(Integer.parseInt(req.getParameter("id")));
			resp.sendRedirect("/produce365/cares");
			return ;
		}

		String dispatcherUrl = null;

		if (action.equals("cares")) {
			dispatcherUrl = "/care/careList.jsp";			
		} else if (action.equals("input")) {
			dispatcherUrl = "/care/careNew.jsp";
		}

		RequestDispatcher rd = req.getRequestDispatcher(dispatcherUrl);
		rd.forward(req, resp);
	}
}
