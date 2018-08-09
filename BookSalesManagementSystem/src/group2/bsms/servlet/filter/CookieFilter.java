package group2.bsms.servlet.filter;

import group2.bsms.models.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import group2.bsms.repository.AccountRepository;
import group2.bsms.repository.UserUtils;

@WebFilter(filterName="cookieFilter", urlPatterns= {"/*"})
public class CookieFilter implements Filter{
	public CookieFilter() {
		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest hsr = (HttpServletRequest)request;
		HttpSession session = hsr.getSession();
		
		Account userInSession = UserUtils.getLoginedUser(session);
		if(userInSession != null) {
			session.setAttribute("COOKIE_CHECKED", "CHECKED");
			chain.doFilter(request, response);
			return;
		}
		
		Connection connection = UserUtils.getStoredConnection(request);
		
		String checked = (String)session.getAttribute("COOKIE_CHECKED");
		if(checked==null&&connection!=null) {
			String userName = UserUtils.getUserNameInCookie(hsr);
			try {
				AccountRepository ar = new AccountRepository();
				ResultSet rs = ar.retrieveAccount(userName);
				if(rs.next()) {
					Account user = new Account(rs.getString(1), rs.getString(2));
					UserUtils.storeLoginedUser(session, user);
				}
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
			session.setAttribute("COOKIE_CHECKED", "CHECKED");
		}
		chain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}
	
	
}
