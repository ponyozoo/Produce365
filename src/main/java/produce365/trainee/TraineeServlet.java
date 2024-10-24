package produce365.trainee;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet({ "/trainees/*" })
public class TraineeServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		process(request, response);

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		process(request, response);

	}

	private void process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String uri = request.getRequestURI();

		int lastIndex = uri.lastIndexOf("/");
		String action = uri.substring(lastIndex + 1);
		request.setCharacterEncoding("UTF-8");

		if (action.equals("trainees")) {
			JDBCTraineeDAO traineeDao = new JDBCTraineeDAO();
			List<Trainee> list = traineeDao.selectAll();
			request.setAttribute("list", list);
		} else if (action.equals("save")) {
			JDBCTraineeDAO traineeDao = new JDBCTraineeDAO();
			Trainee trainee = new Trainee();

			trainee.setId(45464);
			trainee.setName(request.getParameter("name"));
			trainee.setSex(request.getParameter("sex"));
			trainee.setBirth(Date.valueOf(request.getParameter("birth")));
			trainee.setNationality(request.getParameter("nationality"));
			trainee.setHeight(Integer.parseInt(request.getParameter("height")));
			trainee.setWeight(Integer.parseInt(request.getParameter("weight")));
			trainee.setHireDate(Date.valueOf(request.getParameter("hireDate")));
			trainee.setPhoto("photo");

			traineeDao.insert(trainee);

		}

		String dispatcherUrl = null;

		if (action.equals("trainees")) {
			dispatcherUrl = "/trainee/trainee.jsp";
		} else if (action.equals("input")) {
			dispatcherUrl = "/trainee/traineeNew.jsp";
		} else if (action.equals("save")) {
			dispatcherUrl = "/trainees";
		}

		RequestDispatcher rd = request.getRequestDispatcher(dispatcherUrl);
		rd.forward(request, response);

	}

}