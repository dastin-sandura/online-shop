package servlets;

import html.HtmlTemplateComponents;
import org.apache.catalina.core.ApplicationServletRegistration;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import java.util.Date;
import java.util.Enumeration;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/context-browser")
public class ServletContextBrowser extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException {

		try {
			ServletContext context = request.getServletContext();

			PrintWriter p = response.getWriter();
			p.println("<html>");

			//Include bootstrap
			p.println("<head>");
			p.println(HtmlTemplateComponents.getHtmlBootstrapImportLink(request.getContextPath()));
			p.println("</head>");

			p.println("<body>");
			p.println("<p>"+"Response from ServletServletContextBrowser servlet " + new Date().toString() + "</p>");

			p.println("<p>"+"Request remote host: " + request.getRemoteHost() + "</p>");
			p.println("<p>"+"Request remote port: " + request.getRemotePort() + "</p>");

			p.println("<p>" + "</p>");

			p.println("<p>"+"Here is the data stored in the ServletContext" + "</p>");
			Enumeration<String> attNames = context.getAttributeNames();
			String tmpAttName;
			p.println("<p>" + "</p>");
			p.println("<p>"+"Attributes and their values:" + "</p>");
			while(attNames.hasMoreElements()) {
				tmpAttName = attNames.nextElement();
				p.println("<p>"+tmpAttName + ":" + context.getAttribute(tmpAttName) + "</p>");
			}

			p.println("<p>"+"End of attributes and their values" + "</p>");
			p.println();

			p.println("<p>"+"ClassLoader: " + context.getClassLoader() + "</p>");
			p.println("<p>"+"Context path: " + context.getContextPath() + "</p>");
			p.println("<p>"+"Default Session Tracking modes: " + context.getDefaultSessionTrackingModes() + "</p>");
			p.println("<p>"+"EffectiveMajorVersion: " + context.getEffectiveMajorVersion() + "</p>");
			p.println("<p>"+"EffectiveMinorVersion: " + context.getEffectiveMinorVersion() + "</p>");
			p.println("<p>"+"Effective Session Tracking modes: " + context.getEffectiveSessionTrackingModes() + "</p>");
			p.println("<p>"+"Filter registrations: " + context.getFilterRegistrations() + "</p>");
			p.println("<p>"+"Initialization parameter names: " + context.getInitParameterNames() + "</p>");
			p.println("<p>"+"Jsp Config Descriptor: " + context.getJspConfigDescriptor() + "</p>");
			p.println("<p>"+"Major version: " + context.getMajorVersion() + "</p>");
			p.println("<p>"+"Minor version: " + context.getMinorVersion() + "</p>");
			p.println("<p>"+"Server Info: " + context.getServerInfo() + "</p>");
			p.println("<p>"+"Servlet Context Name: " + context.getServletContextName() + "</p>");
			//TODO iterate over servlet registrations and see if method ServletRegistration.getMappings() can return addresses of every servlet
			p.println("<p>"+"Servlet Registrations: " + context.getServletRegistrations() + "</p>");
			p.println("<p>"+"Session cookie config: " + context.getSessionCookieConfig() + "</p>");
			p.println("<p>"+"Virtual server name: " + context.getVirtualServerName() + "</p>");

			p.println("<p>"+"</p>");

			for (String a : context.getServletRegistrations().keySet()) {
				p.println("<p>"+"Mappings for key " + a + "</p>");
				for (String mapping: context.getServletRegistrations().get(a).getMappings()) {
					p.println("<p>"+"Mappings: for registration " + mapping.getClass() + "</p>");
					p.println("<p>"+"Mapping " + mapping + "</p>");
				}
			}
			p.println("<p>"+ "</p>");

			p.println("</body>");
			p.println("</html>");

			context.log("Let me know if this log is visible in the logs! :)");

		} catch (IOException ioe) {
			System.err.println(ioe);
		}
	}
}
