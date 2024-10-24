package produce365.care;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import produce365.trainee.Trainee;

@SuppressWarnings("serial")
@WebServlet("/careHistories/*")
public class CareHistoryServlet extends HttpServlet{
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
		int lastIndex = uri.lastIndexOf("/");//마지막 /를 가져오는것
		String action = uri.substring(lastIndex + 1); //마지막 /이후의 값인 list를 가져오게됌 => action은 list 주소의 따라서 action값이 달라짐
		System.out.println(action);
		
		if (action.equals("insert")) {
			JDBCCareHistoryDAO JdbcCareHistoryDao = new JDBCCareHistoryDAO();
			CareHistory careHistory = new CareHistory(
					Integer.parseInt(req.getParameter("idx")),
					Date.valueOf(req.getParameter("care_date")),
					new Care(req.getParameter("c.category")),
					new Trainee(req.getParameter("t.name")));
			JdbcCareHistoryDao.insert(careHistory);
		}else if(action.equals("careHistories")){
			CareHistoryDAO careHistoryDao = new JDBCCareHistoryDAO();
			List<CareHistory>careHistories =careHistoryDao.selectAll();
			req.setAttribute("careHistories",careHistories);
		}else if(action.equals("selectByTraineeId")) {
			CareHistoryDAO careHistoryDao = new JDBCCareHistoryDAO();
			List<CareHistory>careHistories =careHistoryDao.selectByTraineeId(Integer.parseInt(req.getParameter("t.id")));
			req.setAttribute("careHistories", careHistories);
		}else if(action.equals("selectByCareId")) {
			CareHistoryDAO careHistoryDao = new JDBCCareHistoryDAO();
			List<CareHistory>careHistories =careHistoryDao.selectByCareId(Integer.parseInt(req.getParameter("c.id")));
			req.setAttribute("careHistories", careHistories);
		}
		
		String dispatcherUrl = null;
		
		if (action.equals("careHistories")) {
			dispatcherUrl = "/care/careHistoryList.jsp";
		}else if(action.equals("selectAll")) {
			dispatcherUrl = "";
		}else if(action.equals("selectByTraineeId")) {
			dispatcherUrl = "";
		}else if(action.equals("selectByCareId")) {
			dispatcherUrl = "";
		}
		RequestDispatcher rd = req.getRequestDispatcher(dispatcherUrl);
	  	 rd.forward(req, resp);
	}
	
	
}	
