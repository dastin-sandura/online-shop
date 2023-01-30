package servlets;

import html.HtmlTemplateComponents;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import java.io.IOException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;

@WebServlet(urlPatterns = "/hello")
public class ServletHelloWorld extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
		//throw new IOException("Wasup.");
		ServletOutputStream outStream = resp.getOutputStream();
		outStream.println(HtmlTemplateComponents.getStandardBeginningOfTheHtml(request.getContextPath()));

		outStream.println("Ich bin Dastin. Tschuss!");

		outStream.println(HtmlTemplateComponents.getStandardEndOfTheHtml(request.getContextPath()));

		//outStream.
		//response.getWriter().println("Ich bin Dastin");
	}
}
