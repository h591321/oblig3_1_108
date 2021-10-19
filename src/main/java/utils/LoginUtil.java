package utils;

import java.util.LinkedList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import pk1.Cart;


public class LoginUtil {
	
	public static void logIn(HttpServletRequest request, String password) {
		logOut(request);
		HttpSession session = request.getSession(true);
		session.setMaxInactiveInterval(45);
		session.setAttribute("anine", "anine");
		session.setAttribute("cartSession", new Cart());

	}
	
	public static boolean erInnlogget(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		return session != null && session.getAttribute("anine") != null;
	}
	
	public static void logOut(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		if (session != null) {
			session.invalidate();
		}
	}
}
