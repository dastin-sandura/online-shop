package shop;

import shop.ShopProductsListDatabase;
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
		PrintWriter w = response.getWriter();
		w.println("<html>");
		w.println(" <body>");

		w.println("  <ol>");
		for (Product product : ShopProductsListDatabase.getProductsList()) {
			w.println("   <li>");
		        w.println("    <form action='/online-shop/shop/cart?id=" + product.getId() + "' method='POST'>");
			w.println("     <div>");
			w.println(product);
			w.println("      <button>Buy me</button>");
			w.println("     </div>");
			w.println("    </form>");
			w.println("   </li>");
		}
		w.println("  </ol>");
		w.println(" </body>");
		w.println("</html>");
	}

}
