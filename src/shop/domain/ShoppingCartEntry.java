package shop.domain;

import shop.domain.Product;

import java.io.Serializable;

public class ShoppingCartEntry implements Serializable {

    private Product product;

    private Integer quantity;

    public ShoppingCartEntry(Integer q, Product p) {
        product = p;
        quantity = q;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String toString() {
        return "Shopping cart item: " + product + " in quantity:" + quantity;
    }
}
