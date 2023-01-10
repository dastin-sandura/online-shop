package servlets;

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
			
			PrintWriter w = response.getWriter();
			w.println("Response from ServletServletContextBrowser servlet " + new Date().toString());
			
			w.println("Request remote host: " + request.getRemoteHost());
			w.println("Request remote port: " + request.getRemotePort());

			w.println();

			w.println("Here is the data stored in the ServletContext");
			Enumeration<String> attNames = context.getAttributeNames();
			String tmpAttName;
			w.println();
			w.println("Attributes and their values:");
			while(attNames.hasMoreElements()) {
				tmpAttName = attNames.nextElement();
				w.println(tmpAttName + ":" + context.getAttribute(tmpAttName));
			}
			
			w.println("End of attributes and their values");
			w.println();
			
			w.println("ClassLoader: " + context.getClassLoader());
			w.println("Context path: " + context.getContextPath());
			w.println("Default Session Tracking modes: " + context.getDefaultSessionTrackingModes());
			w.println("EffectiveMajorVersion: " + context.getEffectiveMajorVersion());
			w.println("EffectiveMinorVersion: " + context.getEffectiveMinorVersion());
			w.println("Effective Session Tracking modes: " + context.getEffectiveSessionTrackingModes());
			w.println("Filter registrations: " + context.getFilterRegistrations());
			w.println("Initialization parameter names: " + context.getInitParameterNames());
			w.println("Jsp Config Descriptor: " + context.getJspConfigDescriptor());
			w.println("Major version: " + context.getMajorVersion());
			w.println("Minor version: " + context.getMinorVersion());
			w.println("Server Info: " + context.getServerInfo());
			w.println("Servlet Context Name: " + context.getServletContextName());
			//TODO iterate over servlet registrations and see if method ServletRegistration.getMappings() can return addresses of every servlet
			w.println("Servlet Registrations: " + context.getServletRegistrations());
			w.println("Session cookie config: " + context.getSessionCookieConfig());
			w.println("Virtual server name: " + context.getVirtualServerName());
			
			w.println("");

			for (String a : context.getServletRegistrations().keySet()) {
				w.println("Mappings for key " + a);
				for (String mapping: context.getServletRegistrations().get(a).getMappings()) {
					w.println("Mappings: for registration " + mapping.getClass());
					w.println("Mapping " + mapping);
				}
			}
			w.println();
			context.log("Let me know if this log is visible in the logs! :)");



		} catch (IOException ioe) {
			System.err.println(ioe);
		}
	}
}
