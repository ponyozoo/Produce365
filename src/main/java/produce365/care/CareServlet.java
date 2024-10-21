package produce365.care;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/care/*")
public class CareServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		process(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		process(req, resp);
	}
	private void process(HttpServletRequest req, HttpServletResponse resp) {
		String uri = req.getRequestURI();
		int lastIndex = uri.lastIndexOf("/");//마지막 /를 가져오는것
		String action = uri.substring(lastIndex + 1); //마지막 /이후의 값인 list를 가져오게됌 => action은 list 주소의 따라서 action값이 달라짐
		System.out.println(action);
		
		if (action.equals("input")) {
		}else if(action.equals("save")) {
			JDBCCareDAO jdbcCareDao = new JDBCCareDAO();
			Care care = new Care(req.getParameter("CATEGORY"),Integer.parseInt(req.getParameter("COST")));
			jdbcCareDao.insert(care);
		}else if(action.equals("findAll")) {
			CareDAO careDao = new JDBCCareDAO();
			List<Care> cares = careDao.findAll();
			req.setAttribute("cares", cares);
		}else if(action.equals("findById")) {
			CareDAO careDao = new JDBCCareDAO();
			Care care = careDao.findById(Integer.parseInt(req.getParameter("ID")));
			req.setAttribute("care", care);
		}
		
	}
}
