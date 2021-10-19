package pk1;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import utils.*;


@WebServlet("/cartServlet")
public class CartServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		if (!LoginUtil.erInnlogget(request)) {
			response.sendRedirect("login");
		} else {
			HttpSession session = request.getSession(true);
			Cart cart=(Cart) session.getAttribute("cartSession");
			PrintWriter out = response.getWriter();
			//response.setContentType("text/html; charset=ISO-8859-1");
			
			out.println(HTMLhead());
			out.println("<p>Min Handleliste</p>");
			out.println("<form action=\"cartServlet\" method=\"post\">");
			out.println("<input type=\"text\" name=\"nyttElement\" />");
			out.println("<p><input type=\"submit\" value=\"Legg til\" /></p>");
			
			
			
			for(String str:cart.getLinkedList()) {
				out.println("<p>- "+str);
				out.println("<button type=\"submit\" value=\""+str+"\" name=\"slett\">x</button>"+"</p>");
				

				
			}
			
			
			
			out.println(HTMLlegs());
			
		}
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		if (!LoginUtil.erInnlogget(request)) {
			response.sendRedirect("login");
		} else {
			HttpSession session = request.getSession(true);
			Cart cart= (Cart) session.getAttribute("cartSession");
			String objektInn = request.getParameter("nyttElement");
			String objektUt =  request.getParameter("slett");
			if(objektInn!=null&&!objektInn.equals("")) {
				cart.add(objektInn);
			}else if(objektUt!=null) {
				if(!objektUt.equals("")&&!cart.isEmpty()) 
						cart.remove(objektUt);
				
			}
			
			
			response.sendRedirect("cartServlet");
			
		}
	}

	
	private String HTMLhead() {
		return "<!DOCTYPE html>" + "<html>" + "<head>" + "<meta charset=\"ISO-8859-1\">" + "<title>Cart</title>" + "</head>"
				+ "<body>";
	}

	private String HTMLlegs() {
		return
		"</body>" + "</html>";
	}
}
