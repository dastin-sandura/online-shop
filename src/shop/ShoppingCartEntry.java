package shop;

import shop.Product;
import java.io.Serializable;

public class ShoppingCartEntry implements Serializable{
	
		Product product;

		Integer quantity;	

		public ShoppingCartEntry(Integer q, Product p) {
			product=p;
			quantity=q;
		}

		public String toString() {
			return "Shopping cart item: " + product + " in quantity:" + quantity;
		}
	}
