package shop;

import javax.servlet.http.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import java.io.*;

import shop.ShopProductsListDatabase;
import shop.ShoppingCartEntry;

import java.util.*;

@WebServlet("/shop/cart")
public class ServletShoppingCart extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		HttpSession s = req.getSession();
		Map<Integer,ShoppingCartEntry> shoppingCart = (Map<Integer,ShoppingCartEntry>)s.getAttribute("shopping-cart");
		if (shoppingCart == null) {
			shoppingCart = new HashMap<Integer, ShoppingCartEntry>();	
		}
		Integer productId = new Integer(req.getParameter("id"));
		//a += req.getParameter("product");
		ShoppingCartEntry entry = shoppingCart.get(productId);
		
		if (entry!=null) {	
			entry.quantity++;
		} else {
			Product p = ShopProductsListDatabase.getProductById(productId);
			if (p!=null) {
				shoppingCart.put(productId, new ShoppingCartEntry(1,p));
			}
		}
		s.setAttribute("shopping-cart", shoppingCart);

		PrintWriter p = resp.getWriter();

		p.println("<html><body>");
		p.println("<p>Current state of shopping cart: " + shoppingCart + "</p>");
		p.println("</body></html>");
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		
		Map<Integer, ShoppingCartEntry> shoppingCart = (Map<Integer, ShoppingCartEntry>)req.getSession().getAttribute("shopping-cart");
		if (shoppingCart == null) {
			shoppingCart = new HashMap<Integer, ShoppingCartEntry>();
		}

		resp.getWriter().println("Content of shopping cart stored in session with cookie:  " + req.getSession().getId());
		for (Integer key : shoppingCart.keySet()) {
			resp.getWriter().println("" + key + shoppingCart.get(key));
		}
		

	}

	
}
