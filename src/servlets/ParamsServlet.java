package servlets;

import html.HtmlTemplateComponents;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.annotation.WebServlet;

import java.io.IOException;

@WebServlet("/params")
public class ParamsServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();

		String name = req.getParameter("name");
		if(name == null) {
			name = "Leonidas?";
		}
		session.setAttribute("name", name);	
		
		String surname = req.getParameter("surname");

		session.setAttribute("surname", surname);

		ServletOutputStream out = resp.getOutputStream();
		out.println("<html>");

		//Include bootstrap
		out.println("<head>");
		out.println(HtmlTemplateComponents.getHtmlBootstrapImportLink(req.getContextPath()));
		out.println("</head>");

		out.println("<body>");
		
		out.println("<p>" + "Hallo " + name + " " + surname + "</p>");

		out.println("</body>");
		out.println("</html>");
	}
}
