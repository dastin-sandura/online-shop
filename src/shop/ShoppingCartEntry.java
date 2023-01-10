package shop;

import shop.Product;

public class ShoppingCartEntry {
	
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