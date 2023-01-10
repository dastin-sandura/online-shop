package servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpSession;

import java.util.Date;
import java.util.Enumeration;

import java.io.IOException;

@WebServlet("/session")
public class ServletHttpSessionUseCase extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException {
		try {			
			res.getWriter().println("This is the Session use case");
			HttpSession session = req.getSession();
			Integer counter = (Integer)session.getAttribute("incremental-attribute");
			if(counter != null) {
				counter+=1;
				session.setAttribute("incremental-attribute",counter);	
			} else {
				session.setAttribute("incremental-attribute", 1);
			}

			session.setAttribute("last-request-timestamp", new Date().toString());
			res.getWriter().println(session);

			Enumeration<String> sessionAttributes = session.getAttributeNames();


			String attributeKey = "";
			//attNames = sessionAttributes.elements();
			while(sessionAttributes.hasMoreElements()) {
				attributeKey = sessionAttributes.nextElement();
				res.getWriter().println(attributeKey + ":" + session.getAttribute(attributeKey));
			}

		} catch (IOException ioe) {
			System.out.println("Exception occured");
		        System.out.println(ioe);
		}
	}
		

}
