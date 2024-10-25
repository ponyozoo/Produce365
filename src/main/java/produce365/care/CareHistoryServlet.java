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

import produce365.trainee.JDBCTraineeDAO;
import produce365.trainee.Trainee;

@SuppressWarnings("serial")
@WebServlet("/careHistories/*")
public class CareHistoryServlet extends HttpServlet {
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
		int lastIndex = uri.lastIndexOf("/");// 마지막 /를 가져오는것
		String action = uri.substring(lastIndex + 1); // 마지막 /이후의 값인 list를 가져오게됌 => action은 list 주소의 따라서 action값이 달라짐
		System.out.println(action);

		if (action.equals("input")) {
			JDBCCareDAO jdbcCareDao = new JDBCCareDAO();
			List<Care> cares = jdbcCareDao.findAll();
			req.setAttribute("cares", cares);
			JDBCTraineeDAO traineeDAO = new JDBCTraineeDAO();
			List<Trainee> trainees = traineeDAO.selectAll();
			req.setAttribute("trainees", trainees);
		} else if (action.equals("insert")) {
			JDBCCareHistoryDAO JdbcCareHistoryDao = new JDBCCareHistoryDAO();
			CareHistory careHistory = new CareHistory(Date.valueOf(req.getParameter("careDate")),
					new Care(Integer.parseInt(req.getParameter("category"))),
					new Trainee(Integer.parseInt(req.getParameter("trainee"))));
			JdbcCareHistoryDao.insert(careHistory);
		} else if (action.equals("careHistories")) {
			CareHistoryDAO careHistoryDao = new JDBCCareHistoryDAO();
			List<CareHistory> careHistories = careHistoryDao.selectAll();
			req.setAttribute("careHistories", careHistories);
		}

		String dispatcherUrl = null;

		if (action.equals("input")) {
			dispatcherUrl = "/care/careHistoryNew.jsp";
		} else if (action.equals("careHistories")) {
			dispatcherUrl = "/care/careHistoryList.jsp";
		} else if (action.equals("insert")) {
			dispatcherUrl = "careHistories";
		}
		RequestDispatcher rd = req.getRequestDispatcher(dispatcherUrl);
		rd.forward(req, resp);
	}

}
