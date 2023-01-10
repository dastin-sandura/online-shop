package shop;

import javax.servlet.http.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import java.io.*;


@WebServlet("/shop/cart")
public class ServletShoppingCart extends HttpServlet {

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		HttpSession s = req.getSession();
		String shoppingCart = (String)s.getAttribute("shopping-cart");
		if (shoppingCart == null) {
			shoppingCart = "";	
		} 
		shoppingCart += req.getParameter("product");
			
		s.setAttribute("shopping-cart", shoppingCart);

		PrintWriter p = resp.getWriter();

		p.println("<html><body>");
		p.println("<p>Current state of shopping cart: " + shoppingCart + "</p>");
		p.println("</body></html>");
	}
}
