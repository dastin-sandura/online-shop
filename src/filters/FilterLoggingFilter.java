package filters;

import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.FilterChain;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter("/*")
public class FilterLoggingFilter extends HttpFilter{

	@Override
	public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("Running Logging filter");
		//response.getWriter().println("Logging filter addition");//I commented appending text to the response
		//because it broke the display of html in Google Chrome:w
		
		chain.doFilter(request, response);
	}



}
