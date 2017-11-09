package it.esteco.shop;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class AddOrdersTest {

    @Test
    public void addOrders() throws Exception {
        Orders orders = new Orders();

        Order order = new Order("321");
        order.addProduct(new Product("c129", "f", "23.44", Currency.EUR, Color.GREEN));

        orders.addOrder(order);
        assertThat(orders.getOrderCount(), is(equalTo(1)));
        assertThat(orders.getOrder(0), is(equalTo(order)));

        Order anotherOrder = new Order("909");
        anotherOrder.addProduct(new Product("v777", "r", "11.99", Currency.EUR, Color.RED));

        orders.addOrder(anotherOrder);
        assertThat(orders.getOrderCount(), is(equalTo(2)));
        assertThat(orders.getOrder(1), is(equalTo(anotherOrder)));
    }
}
