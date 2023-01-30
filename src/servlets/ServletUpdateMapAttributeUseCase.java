package servlets;

import html.HtmlTemplateComponents;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/servlet/attribute")
public class ServletUpdateMapAttributeUseCase extends HttpServlet {
    final String attributeKey = "map-attribute-update-use-case";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        @SuppressWarnings("unchecked")
        Map<String, String> map = (Map<String, String>) session.getAttribute(attributeKey);

        PrintWriter p = response.getWriter();

        p.println(HtmlTemplateComponents.getStandardBeginningOfTheHtml(request.getContextPath()));

        if (map == null) {
            map = new HashMap<>();
            String message = "<p>Initialized session attribute " + attributeKey + " with a new HashMap<String,String></p>";
            System.out.println(message);
            session.setAttribute(attributeKey,map);
        }
        String product = request.getParameter("product");
        String quantity = request.getParameter("quantity");
        p.println("<p>Received request parameters \"product\"=" + product + " and quantity=\"" + quantity + "\"</p>");
        if (product != null && quantity != null) {
            map.put(product, quantity);
            p.println("<p>" + "I have updated product \"" + product + "\" to quantity \"" + quantity + "\"</p>");
        } else {
            p.println("</p>No new products added.</p>");
        }
        p.println("</p>The map object, stored in the attribute looks like this: " + map + " these are its values:</p>");
        for (String key : map.keySet()) {
            p.println("<p>" + key + "=" + map.get(key) + "</p>");
        }
        p.println(HtmlTemplateComponents.getStandardEndOfTheHtml(request.getContextPath()));

    }
}
