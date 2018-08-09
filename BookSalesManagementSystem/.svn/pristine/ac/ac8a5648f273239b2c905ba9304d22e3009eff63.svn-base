package group2.bsms.servlet.filter;

import java.io.IOException;
import java.sql.Connection;
import java.util.Collection;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import group2.bsms.connection.DBConnection;
import group2.bsms.repository.UserUtils;

@WebFilter(filterName="jdbcFilter", urlPatterns= {"/*"})
public class JDBCFilter implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest hsr = (HttpServletRequest)req; 
		if(this.isServlet(hsr)) {
			System.out.println("Open connection for: "+hsr.getServletPath());
			Connection connection = null;
			try {
				connection = DBConnection.getConnection();
				connection.setAutoCommit(false);
				UserUtils.storeConnection(hsr, connection);
				chain.doFilter(hsr, response);
			}
			catch(Exception e) {
				e.printStackTrace();
				DBConnection.rollbackQuietly(connection);
			}
			finally {
				DBConnection.closeQuietly(connection);
			}
		}
		else {
			chain.doFilter(hsr, response);
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}
	
	private boolean isServlet(HttpServletRequest request) {
		System.out.println("JDBC Filter");
		String servletPath = request.getServletPath();
		String pathInfo = request.getPathInfo();
		String urlPattern = servletPath;
		if(pathInfo!=null) {
			urlPattern += "/*";
		}
		Map<String, ? extends ServletRegistration> servletRegistrations = request.getServletContext().getServletRegistrations();
		Collection<? extends ServletRegistration> values = servletRegistrations.values();
		for(ServletRegistration sr:values) {
			Collection<String> mappings = sr.getMappings();
			if(mappings.contains(urlPattern))
				return true;
		}
		return false;
	}

}
