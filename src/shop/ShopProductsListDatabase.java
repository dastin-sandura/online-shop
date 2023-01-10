package shop;

import java.util.List;
import java.util.ArrayList;


public class ShopProductsListDatabase {

	private static List<String> shopProducts;

	public static List<String> getProductsList() {
		
		if(shopProducts == null ) {
			shopProducts = new ArrayList<String>();	
			shopProducts.add("1,Dog leash,5$");
			shopProducts.add("2,Dog collar,4$");
			shopProducts.add("3,Poop bags,10$");
		}
		return shopProducts;
	}
}
