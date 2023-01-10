package servlets;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

import configuration.ContainerServletMappingsExtractor;

import java.io.PrintWriter;
import java.io.IOException;
import java.util.List;

@WebServlet("/")
public class MainPageServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		List<String> mappings = ContainerServletMappingsExtractor.getMappingsFromContext(request.getServletContext());
		
		String contextPath = request.getContextPath();		

		PrintWriter p = response.getWriter();
		p.println("<html><body>");

		p.println("<ol>");
		for (String mapping : mappings) {
			p.println("<li><a href='http://localhost:8080" + contextPath + mapping + "'>" + mapping + "</a></li>");
		}
		//p.println("<li><a href='http://localhost:8080" + contextPath + "/servlet-context'>servlet-context</a></li>");
		//p.println("<li><a href='http://localhost:8080" + contextPath + "/hello'>hello</a></li>");
		//p.println("<li><a href='http://localhost:8080" + contextPath + "/context-browser'>context-browser</a></li>");
		//p.println("<li><a href='http://localhost:8080" + contextPath + "/headers'>headers</a></li>");
		//p.println("<li><a href='http://localhost:8080" + contextPath + "/session'>session</a></li>");
		
		p.println("</ol>");
		p.println("</body></html>");	
	}
		
}
