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
		@SuppressWarnings("unchecked")
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
			//Update the shopping cart stored in the session
			Product p = ShopProductsListDatabase.getProductById(purchasedProductId);
			shoppingCart.put(purchasedProductId, new ShoppingCartEntry(1,p));
		}

		PrintWriter p = resp.getWriter();
		p.println("<html>");

		//Include bootstrap
		p.println("<head>");
		p.println(HtmlTemplateComponents.getHtmlBootstrapImportLink(req.getContextPath()));
		p.println("</head>");

		p.println("<body>");
		p.println(HtmlTemplateComponents.getHtmlNavigationDropdown());

		p.println("<p>Current state of shopping cart: " + shoppingCart + "</p>");
		p.println(HtmlTemplateComponents.getBootstrapJavascriptImport(req.getContextPath()));

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

		@SuppressWarnings("unchecked")
		Map<Integer, ShoppingCartEntry> shoppingCart = (Map<Integer, ShoppingCartEntry>)req.getSession().getAttribute("shopping-cart");
		if (shoppingCart == null) {
			shoppingCart = new HashMap<>();
		}

		p.println("<body>");
		p.println(HtmlTemplateComponents.getHtmlNavigationDropdown());
		resp.getWriter().println("<p>Content of shopping cart stored in session with cookie:  </p>" + req.getSession().getId());
		for (Integer key : shoppingCart.keySet()) {
			resp.getWriter().println("<p>" + key + shoppingCart.get(key) + "</p>");
		}
		p.println(HtmlTemplateComponents.getBootstrapJavascriptImport(contextPath));
		p.println("</body>");
		p.println("</html>");


	}


}
