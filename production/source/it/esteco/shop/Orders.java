package it.esteco.shop;

import java.util.ArrayList;
import java.util.List;

public class Orders {

    private List<Order> orders = new ArrayList<>();

    public void addOrder(Order order) {
        orders.add(order);
    }

    public int getOrderCount() {
        return orders.size();
    }

    public Order getOrder(int i) {
        return orders.get(i);
    }

}
