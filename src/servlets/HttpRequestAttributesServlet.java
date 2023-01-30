package servlets;

import html.HtmlTemplateComponents;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/http-request-attributes")
public class HttpRequestAttributesServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        PrintWriter p = response.getWriter();
        p.println(HtmlTemplateComponents.getStandardBeginningOfTheHtml(request.getContextPath()));

        System.out.println(request);
        p.println("<h1>Servlet, showing data contained in the HttpServletRequest object.</h1>");
        if (request.isAsyncStarted()) {
            p.println("<p>request.getAsyncContext()=" + request.getAsyncContext() + "</p>");
            System.out.println(request.getAsyncContext());
        }
        p.println("<p>request.getAttributeNames()=" + request.getAttributeNames() + "</p>");
        System.out.println(request.getAttributeNames());
        p.println("<p>request.getCharacterEncoding()=" + request.getCharacterEncoding() + "</p>");
        System.out.println(request.getCharacterEncoding());
        p.println("<p>request.getContentLength()=" + request.getContentLength() + "</p>");
        System.out.println(request.getContentLength());
        p.println("<p>request.getContentType()=" + request.getContentType() + "</p>");
        System.out.println(request.getContentType());
        p.println("<p>request.getDispatcherType()=" + request.getDispatcherType() + "</p>");
        System.out.println(request.getDispatcherType());
        p.println("<p>request.getLocalAddr()=" + request.getLocalAddr() + "</p>");
        System.out.println(request.getLocalAddr());
        p.println("<p>request.getLocale()=" + request.getLocale() + "</p>");
        System.out.println(request.getLocale());
        p.println("<p>request.getLocales()=" + request.getLocales() + "</p>");
        System.out.println(request.getLocales());
        p.println("<p>request.getLocalName()=" + request.getLocalName() + "</p>");
        System.out.println(request.getLocalName());
        p.println("<p>request.getLocalPort()=" + request.getLocalPort() + "</p>");
        System.out.println(request.getLocalPort());
        p.println("<p>request.getParameterMap()=" + request.getParameterMap() + "</p>");
        System.out.println(request.getParameterMap());
        p.println("<p>request.getParameterNames()=" + request.getParameterNames() + "</p>");
        System.out.println(request.getParameterNames());
        p.println("<p>request.getProtocol()=" + request.getProtocol() + "</p>");
        System.out.println(request.getProtocol());
        p.println("<p>request.getRemoteAddr()=" + request.getRemoteAddr() + "</p>");
        System.out.println(request.getRemoteAddr());
        p.println("<p>request.getRemoteHost()=" + request.getRemoteHost() + "</p>");
        System.out.println(request.getRemoteHost());
        p.println("<p>request.getRemotePort()=" + request.getRemotePort() + "</p>");
        System.out.println(request.getRemotePort());
        p.println("<p>request.getScheme()=" + request.getScheme() + "</p>");
        System.out.println(request.getScheme());
        p.println("<p>request.getServerName()=" + request.getServerName() + "</p>");
        System.out.println(request.getServerName());
        p.println("<p>request.getServerPort()=" + request.getServerPort() + "</p>");
        System.out.println(request.getServerPort());
        p.println("<p>request.getServletContext()=" + request.getServletContext() + "</p>");
        System.out.println(request.getServletContext());
        p.println("<p>request.isAsyncStarted()=" + request.isAsyncStarted() + "</p>");
        System.out.println(request.isAsyncStarted());
        p.println("<p>request.isAsyncSupported()=" + request.isAsyncSupported() + "</p>");
        System.out.println(request.isAsyncSupported());
        p.println("<p>request.isSecure()=" + request.isSecure() + "</p>");
        System.out.println(request.isSecure());

        p.println(HtmlTemplateComponents.getStandardEndOfTheHtml(request.getContextPath()));
    }

}
