package html;

public class HtmlTemplateComponents {

    public static String getHtmlBootstrapImportLink(String contextPath){
        return "<link rel=\"stylesheet\" href=\"" + contextPath + "/css/bootstrap.min.css\"";
    }
}
