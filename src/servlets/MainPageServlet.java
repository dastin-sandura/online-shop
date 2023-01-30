package servlets;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

import configuration.ContainerServletMappingsExtractor;
import html.HtmlTemplateComponents;

import java.io.PrintWriter;
import java.io.IOException;
import java.util.List;

@WebServlet("/main")
public class MainPageServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        List<String> mappings = ContainerServletMappingsExtractor.getMappingsFromContext(request.getServletContext());

        String contextPath = request.getContextPath();

        PrintWriter p = response.getWriter();
        p.println(HtmlTemplateComponents.getStandardBeginningOfTheHtml(request.getContextPath()));
//        //Include a dropdown which will show links after pressing the button
//        p.println("<div class=\"dropdown\">");
//        p.println(" <button class=\"btn btn-secondary dropdown-toggle\" type=\"button\" id=\"dropdownMenuButton\" " +
//                "data-bs-toggle=\"dropdown\" aria-haspopup=\"true\" aria-expanded=\"false\">");
//        p.println("  Dropdown button");
//        p.println(" </button>");
//        p.println(" <div class=\"dropdown-menu\" aria-labelledby=\"dropdownMenuButton\">");
////        p.println("  <a class=\"dropdown-item\">Action</a>");
////        p.println("  <a>");
////        p.println("  <a>");
//        for (String mapping : mappings) {
//            p.println("<a class=\"dropdown-item\" href=\"http://localhost:8080" + contextPath + mapping + "\">" + mapping + "</a>");
//        }
//        p.println(" </div>");
//
//        p.println("</div>");
        //end of dropdown button
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
        //href=\"" + contextPath + "/css/bootstrap.min.css\"

        p.println(HtmlTemplateComponents.getStandardEndOfTheHtml(request.getContextPath()));
    }

}
