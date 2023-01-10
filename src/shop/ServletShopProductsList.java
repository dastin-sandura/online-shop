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
		w.println("<body>");

		w.println("<ol>");
		for (String product : ShopProductsListDatabase.getProductsList()) {
			w.println("<li>" + product + " </li>");
		}
		w.println("</ol>");
		w.println("</body>");
		w.println("</html>");
	}

}
