package shop.domain;

import java.io.Serializable;

public class Product implements Serializable{

	private Integer id;

	private String description;

	private Integer price;

	public Product (Integer id, String description, Integer price) {
		this.id=id;
		this.description=description;
		this.price=price;
	}

	public Integer getId() {
		return id;
	}

	public String getDescription() {
		return description;
	}

	public Integer getPrice() {
		return price;
	}

	public void setId(Integer id) {
		this.id=id;
	}

	public void setDescription(String description) {
		this.description=description;
	}

	public void setPrice(Integer price) {
		this.price=price;
	}

	public String toString() {
		return "{Product = {id=" + id + ", description=" + description +", price=" + price + "}}";
	}
}
