package it.esteco.shop;

import java.util.ArrayList;
import java.util.List;

public class Order {

    private String id;
    private List<Product> products;

    public Order(String id) {
        this.id = id;
        this.products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public int getProductCount() {
        return products.size();
    }

    public Product getProduct(int i) {
        return products.get(i);
    }

    public String getOrderId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;

        if (!id.equals(order.id)) return false;
        return products.equals(order.products);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + products.hashCode();
        return result;
    }
}
