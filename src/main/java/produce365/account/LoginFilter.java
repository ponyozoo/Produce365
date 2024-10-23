package produce365.account;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter("/*")
public class LoginFilter implements Filter {
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		HttpSession session = req.getSession(false);
				
		boolean login = false;
		
		if (session != null && session.getAttribute("account") != null)
			login = true;
		
		String uri = req.getRequestURI();
		int lastIdx = uri.lastIndexOf("/");
		String action = uri.substring(lastIdx + 1);

		if (login && action.equals("login"))
			((HttpServletResponse)response).sendRedirect("/produce365/trainee");
		else if (login || action.equals("") || (!login && action.equals("login")))
			chain.doFilter(request, response);
		else
			((HttpServletResponse)response).sendRedirect("/produce365/login");
	}
}
