package shop;

import javax.servlet.http.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import java.io.*;

import html.HtmlTemplateComponents;
import shop.database.ShopProductsListDatabase;
import shop.domain.Product;
import shop.domain.ShoppingCartEntry;

import java.util.*;

@WebServlet("/shop/cart")
public class ServletShoppingCart extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		HttpSession session = req.getSession();
		//TODO introduce class ShoppingCart which will wrap the items in the shopping cart
		Map<Integer, ShoppingCartEntry> shoppingCart = (Map<Integer,ShoppingCartEntry>)session.getAttribute("shopping-cart");
		if (shoppingCart == null) {
			shoppingCart = new HashMap<>();
		}
		Integer purchasedProductId = new Integer(req.getParameter("id"));
		//a += req.getParameter("product");
		//TODO use a service for checking if the Product is already in the shopping cart
		ShoppingCartEntry entry = shoppingCart.get(purchasedProductId);

		if (entry!=null) { // customer already has this type of product in the shopping cart
			entry.setQuantity(entry.getQuantity()+1);
		} else { // customer does not have this product in the shopping cart
			Product p = ShopProductsListDatabase.getProductById(purchasedProductId);
			if (p!=null) {
				shoppingCart.put(purchasedProductId, new ShoppingCartEntry(1,p));
			}
		}

		//Update the session with updated shopping cart
		//TODO, check if setting this attribute is necessary -
		// maybe modifying the Map has already modified the object in the session
		// if there is no need to set it again, then I should set this attribute only in case when I am creating new
		// Map for storing the shopping cart.
		// This would reduce the number of #setAttribute method calls from O(n) to O(1)

		session.setAttribute("shopping-cart", shoppingCart);

		PrintWriter p = resp.getWriter();
		p.println("<html>");

		//Include bootstrap
		p.println("<head>");
		p.println(HtmlTemplateComponents.getHtmlBootstrapImportLink(req.getContextPath()));
		p.println("</head>");

		p.println("<body>");

		p.println("<p>Current state of shopping cart: " + shoppingCart + "</p>");

		p.println("</body>");
		p.println("</html>");
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		String contextPath = req.getContextPath();

		PrintWriter p = resp.getWriter();
		p.println("<html lang=\"eng\">");

		//Include bootstrap
		p.println("<head>");
		p.println(HtmlTemplateComponents.getHtmlBootstrapImportLink(contextPath));
		p.println("</head>");

		Map<Integer, ShoppingCartEntry> shoppingCart = (Map<Integer, ShoppingCartEntry>)req.getSession().getAttribute("shopping-cart");
		if (shoppingCart == null) {
			shoppingCart = new HashMap<Integer, ShoppingCartEntry>();
		}

		p.println("<body>");
		resp.getWriter().println("<p>Content of shopping cart stored in session with cookie:  </p>" + req.getSession().getId());
		for (Integer key : shoppingCart.keySet()) {
			resp.getWriter().println("<p>" + key + shoppingCart.get(key) + "</p>");
		}
		p.println("<script src=\"../js/bootstrap.min.js\"></script>");
		p.println("</body>");
		p.println("</html>");


	}


}
