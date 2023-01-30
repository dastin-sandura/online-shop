package html;

import java.util.ArrayList;

public class HtmlTemplateComponents {

    public static String getHtmlBootstrapImportLink(String contextPath) {
        return "<link rel=\"stylesheet\" href=\"" + contextPath + "/css/bootstrap.min.css\"\n";
    }

    public static String getHtmlNavigationDropdown() {
        ArrayList<String> mappings = new ArrayList<>();

        mappings.add("/headers");
        mappings.add("/params");
//        mappings.add("/");
        mappings.add("/shop/products");
        mappings.add("/context-browser");
        mappings.add("/hello");
//        mappings.add("*.jspx");
//        mappings.add("*.jsp");
        mappings.add("/shop/cart");
        mappings.add("/http-request-attributes");
        mappings.add("/servlet-context");
        mappings.add("/session");
        mappings.add("/main");
        StringBuilder p = new StringBuilder();

        //Include a dropdown which will show links after pressing the button
        p.append("\n" + ("<div class=\"dropdown\">"));
        p.append("\n" + (" <button class=\"btn btn-secondary dropdown-toggle\" type=\"button\" id=\"dropdownMenuButton\" " +
                "data-bs-toggle=\"dropdown\" aria-haspopup=\"true\" aria-expanded=\"false\">"));
        p.append("\n" + ("  Dropdown button"));
        p.append("\n" + (" </button>"));
        p.append("\n" + (" <div class=\"dropdown-menu\" aria-labelledby=\"dropdownMenuButton\">"));
//        p+="\n"+("  <a class=\"dropdown-item\">Action</a>"));
//        p+="\n"+("  <a>"));
//        p+="\n"+("  <a>"));
        for (String mapping : mappings) {
            p.append("\n" + ("<a class=\"dropdown-item\" href=\"http://localhost:8080" + "/online-shop" + mapping + "\">" + mapping + "</a>"));
        }
        p.append("\n" + (" </div>"));

        p.append("\n" + ("</div>"));
        p.append("\n");
        return p.toString();
    }

    public static String getBootstrapJavascriptImport(String contextPath) {
        return "<script src=\"" + contextPath + "/js/bootstrap.bundle.min.js\"></script>\n";
    }

    public static String getStandardBeginningOfTheHtml(String contextPath) {
        String result = "";
        result += "<html>\n";

        //Include bootstrap
        result += "<head>\n";
        result += HtmlTemplateComponents.getHtmlBootstrapImportLink(contextPath);
        result += "</head>\n";

        result += "<body>\n";
        result += HtmlTemplateComponents.getHtmlNavigationDropdown();
        return result;
    }

    public static String getStandardEndOfTheHtml(String contextPath) {
        String result = "";
        result += HtmlTemplateComponents.getBootstrapJavascriptImport(contextPath);
        result += "</body>\n";
        result += "</html>\n";
        return result;
    }
}
