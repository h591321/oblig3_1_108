package pk1;

import java.io.IOException;
import utils.*;
import java.io.PrintWriter;
import java.text.DecimalFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.cxf.transport.commons_text.StringEscapeUtils;

@WebServlet("/login")
public class loginServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String errorString = request.getParameter("feilmelding");
		out.println(HTMLhead());
		out.println("<form action=\"login\" method=\"post\">");
		out.println("<p>Gi inn passord:</p>");
		out.println("<input type=\"text\" name=\"passord\" />");
		out.println("<p><input type=\"submit\" value=\"Logg inn\" /></p>");
		
		if(errorString!=null&&errorString.equals("1")) {
			out.println("<p>Ugyldig Passord</p>");
		}
		out.println(HTMLlegs());
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String password = StringEscapeUtils.escapeHtml4(request.getParameter("passord"));
		if (Validator.isValidPassword(password)) {    // passord er riktig		
			LoginUtil.logIn(request, password);
			response.sendRedirect("cartServlet");
		} else {
			response.sendRedirect("login"+"?feilmelding=1");
		}
	}

	private String HTMLhead() {
		return "<!DOCTYPE html>" + "<html>" + "<head>" + "<meta charset=\"UTF-8\">" + "<title>Login</title>" + "</head>"
				+ "<body>";
	}

	private String HTMLlegs() {
		return
		"</body>" + "</html>";
	}
}
