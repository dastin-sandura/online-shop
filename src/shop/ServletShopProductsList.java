package shop;

import html.HtmlTemplateComponents;
import shop.database.ShopProductsListDatabase;
import shop.domain.Product;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.annotation.WebServlet;

import java.io.PrintWriter;
import java.io.IOException;

@WebServlet("/shop/products")
public class ServletShopProductsList extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response ) throws IOException, ServletException {
		PrintWriter p = response.getWriter();
		p.println("<html>");

		//Include bootstrap
		p.println("<head>");
		p.println(HtmlTemplateComponents.getHtmlBootstrapImportLink(request.getContextPath()));
		p.println("</head>");

		p.println(" <body>");

		p.println("  <ol>");
		for (Product product : ShopProductsListDatabase.getProductsList()) {
			p.println("   <li>");
		        p.println("    <form action='/online-shop/shop/cart?id=" + product.getId() + "' method='POST'>");
			p.println("     <div>");
			p.println(product);
			p.println("      <button>Buy me</button>");
			p.println("     </div>");
			p.println("    </form>");
			p.println("   </li>");
		}
		p.println("  </ol>");
		p.println(" </body>");
		p.println("</html>");
	}

}
