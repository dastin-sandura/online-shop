package servlets;

import html.HtmlTemplateComponents;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.ServletContext;

import java.util.Enumeration;
import java.util.concurrent.atomic.AtomicInteger;

import java.io.PrintWriter;
import java.io.IOException;

@WebServlet("/servlet-context")
public class ServletContextUseCase extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		PrintWriter p = response.getWriter();
		ServletContext context = request.getServletContext();
		int initializingCounterValue = 1;
		int counterValueAfterServletExecution;
		String contextAttributeName = "counter";
		AtomicInteger counter = (AtomicInteger)context.getAttribute(contextAttributeName);
		p.println(HtmlTemplateComponents.getStandardBeginningOfTheHtml(request.getContextPath()));

		if (counter == null) {
			p.println("attribute '"+ contextAttributeName +
					"' is empty, which is why we initialize it with value: " + initializingCounterValue);
			AtomicInteger atomicCounter = new AtomicInteger(initializingCounterValue);
			context.setAttribute(contextAttributeName, atomicCounter);

		} else {
			//AtomicInteger count = counter;
			counter.getAndIncrement();
			//context.setAttribute(contextAttributeName, counter);
			p.println("attribute '" + contextAttributeName + "' has value " + counter.get());
		}
		Enumeration<String> attributeNames = context.getAttributeNames();
		System.out.println(attributeNames);
		System.out.println("Printing elements of enumeration holding attribute names");
		String attributeName;
		String printedMessage;
		while (attributeNames.hasMoreElements()) {
			attributeName = attributeNames.nextElement();
			printedMessage = attributeName + "=" + context.getAttribute(attributeName);
			//System.out.println(printedMessage);
			p.println(printedMessage);
		}
		
		context.log("This should be logged in a Tomcat fashion =)");

		String message = "Servlet showing use of Servlet Context";
		System.out.println(message);
		p.println("<p>" + message + "</p>");
		p.println(HtmlTemplateComponents.getStandardEndOfTheHtml(request.getContextPath()));

	}
}
