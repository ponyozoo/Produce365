package produce365.debutMember;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import produce365.trainee.JDBCTraineeDAO;
import produce365.trainee.Trainee;

@WebServlet("/debutMembers/*")
public class DebutMemberServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		process(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		process(req, resp);
	}

	@SuppressWarnings("unchecked")
	private void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {		
		String uri = req.getRequestURI();
		int lastIndex = uri.lastIndexOf("/");
		String action = uri.substring(lastIndex + 1);
		
		if (action.equals("search")) {
			String name = req.getParameter("name");

			if (!name.equals("")) {
				JDBCTraineeDAO traineeDao = new JDBCTraineeDAO();
				List<Trainee> list = traineeDao.selectByName(name);
				
				JSONObject json = new JSONObject();
				for (Trainee trainee : list) {
					json.put(trainee.getId(), trainee.getName());
				}
				
				resp.setContentType("application/x-json; charset=utf-8");
				resp.getWriter().print(json);
			}
		} else if (action.equals("add")) {
	        String body = req.getReader().readLine();
	        JSONParser parser = new JSONParser();
	        try {
				JSONObject jsonObject = (JSONObject)parser.parse(body);
				int traineeId = Integer.parseInt((String)jsonObject.get("traineeId"));
	            int groupId = Integer.parseInt((String)jsonObject.get("groupId"));
	            
	            DebutMemberDAO debutMemberDao = new JDBCDebutMemberDAO();
	            debutMemberDao.insert(new DebutMember(groupId, traineeId));
			} catch (ParseException e) {
				e.printStackTrace();
			}
		} else if (action.equals("del")) {
			String body = req.getReader().readLine();
			JSONParser parser = new JSONParser();
			try {
				JSONObject jsonObject = (JSONObject)parser.parse(body);
				int traineeId = Integer.parseInt((String)jsonObject.get("traineeId"));
				int groupId = Integer.parseInt((String)jsonObject.get("groupId"));
				
				DebutMemberDAO debutMemberDao = new JDBCDebutMemberDAO();
				debutMemberDao.delete(new DebutMember(groupId, traineeId));
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}	
	}
	
	
}
