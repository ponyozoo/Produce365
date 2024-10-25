package produce365.debut;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/debuts")
public class DebutListServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		JDBCDebutDAO debutDao = new JDBCDebutDAO();
		List<Debut> list = debutDao.findAll();
		
		req.setAttribute("list", list);
		
		RequestDispatcher rd = req.getRequestDispatcher("/debut/debut.jsp");
		rd.forward(req, resp);
	}
}
