package shop;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import shop.Product;

public class ShopProductsListDatabase {

	private static List<Product> shopProducts;

	private static Map<Integer, Product> shopProductsMap;

	private static void populateShopProductsMap(){
		if(shopProductsMap == null) {
			shopProductsMap = new HashMap<Integer, Product>();
			shopProductsMap.put(1, new Product(1, "Dog leash", 5));
			shopProductsMap.put(2, new Product(2, "Dog collar", 4));
			shopProductsMap.put(3, new Product(3, "Poop bags", 9));
		}
		
	}

	public static List<Product> getProductsList() {
		
		if(shopProducts == null ) {
			shopProducts = new ArrayList<Product>();	
			shopProducts.add(new Product(1,"Dog leash",5));
			shopProducts.add(new Product(2,"Dog collar",4));
			shopProducts.add(new Product(3,"Poop bags",10));
		}
		return shopProducts;
	}

	

	public static Product getProductById(Integer id) {
		populateShopProductsMap();
		Product dbProduct = shopProductsMap.get(id);
		if(dbProduct == null) throw new RuntimeException("There is no Product with id=" + id);
		return new Product(dbProduct.getId(), dbProduct.getDescription(), dbProduct.getPrice());
	}
}
