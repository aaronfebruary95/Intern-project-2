package group2.bsms.repository;

import group2.bsms.models.*;

import java.sql.Connection;

import javax.servlet.ServletRequest;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;

public class UserUtils {
	public static final String ATT_NAME_CONNECTION = "ATTRIBUTE_FOR_CONNECTION";
	private static final String ATT_NAME_USERNAME = "ATTRIBUTE_FOR_STORED_USERNAME_IN_COOKIE";
	
	public static void storeConnection(ServletRequest request, Connection connection) {
		request.setAttribute(ATT_NAME_CONNECTION, connection);
	}
	
	public static Connection getStoredConnection(ServletRequest request) {
		Connection connection = (Connection)request.getAttribute(ATT_NAME_CONNECTION);
		return connection;
	}
	
	public static void storeLoginedUser(HttpSession session, Account loginedUser) {
		session.setAttribute("loginedUser", loginedUser);
	}
	
	public static Account getLoginedUser(HttpSession session) {
		Account loginedUser = (Account)session.getAttribute("loginedUser");
		return loginedUser;
	}
	
	public static void storeUserCookie(HttpServletResponse response, Account user) {
		System.out.println("Storing user cookie");
		Cookie cookieUserName = new Cookie(ATT_NAME_USERNAME, user.getUsername());
		cookieUserName.setMaxAge(86400);
		response.addCookie(cookieUserName);
	}
	
	public static String getUserNameInCookie(HttpServletRequest hsr) {
		Cookie[] cookies = hsr.getCookies();
		if(cookies!=null) {
			for(Cookie cookie:cookies) {
				if(ATT_NAME_USERNAME.equals(cookie.getName())) {
					return cookie.getValue();
				}
			}
		}
		return null;
	}
	
	public static void deleteUserCookie(HttpServletResponse response) {
		Cookie cookieUserName = new Cookie(ATT_NAME_USERNAME, null);
		cookieUserName.setMaxAge(0);
		response.addCookie(cookieUserName);
	}
}
