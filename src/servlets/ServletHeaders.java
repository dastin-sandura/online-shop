package servlets;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.ServletException;
import java.io.IOException;
import java.util.Locale;

@WebServlet("/headers")
public class ServletHeaders extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		response.getOutputStream().println("Headers Servlet");
		Locale requestLocale = request.getLocale();
		System.out.println("Request Locale display language: " + requestLocale.getDisplayLanguage());
		System.out.println("Request Locale display name: " + requestLocale.getDisplayName());
		System.out.println("Request Locale converted to language tag: " + requestLocale.toLanguageTag());

		System.out.println("Value of the Accept-Language header from HttpServletRequest : " + request.getHeader("Accept-Language"));
		
		String requestAcceptLanguageHeader = requestLocale.toLanguageTag().split("-")[0];

		System.out.println("Language extracted from the Locale language tag: " + requestAcceptLanguageHeader);
		
		String greeting;

		switch (requestAcceptLanguageHeader) {
			case "pl":
				greeting = "Witaj";
				break;
			case "en":
				greeting = "Hello";
				break;
			case "fr":
				greeting = "Bonjour";
				break;
			default:
				greeting = "Yo";
		}

		response.getOutputStream().println(greeting);
	}
	
	public static String str(){
		return new String[]{"Dog","Cat","Wolf"}[2];
	}

}
