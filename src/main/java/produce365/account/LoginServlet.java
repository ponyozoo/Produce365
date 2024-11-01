package produce365.account;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher rd = req.getRequestDispatcher("/login.jsp");
		rd.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String _id = req.getParameter("id");
		String _pw = req.getParameter("pw");
		
		JDBCAccountDAO accountDao = new JDBCAccountDAO();
		Account account = accountDao.selectById(_id);
		
		if (account != null && account.getPw().equals(_pw)) {
			HttpSession session = req.getSession();
			session.setAttribute("account", account.getId());
			resp.sendRedirect("/produce365/trainees");
		} else {
			req.setAttribute("msg", "아이디가 존재하지 않거나 비밀번호가 일치하지 않습니다.");
			req.getRequestDispatcher("/login.jsp").forward(req, resp);
		}
	}
}
