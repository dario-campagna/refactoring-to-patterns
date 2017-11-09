package it.esteco.shop;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class AddProductToOrderTest {

    @Test
    public void addProducts() throws Exception {
        Order order = new Order("123");

        Product product = new Product("j876", "a", "8.50", Currency.USD, Color.GREEN, ProductSize.SMALL);

        order.addProduct(product);

        assertThat(order.getProductCount(), is(equalTo(1)));
        assertThat(order.getProduct(0), is(equalTo(product)));

        Product anotherProduct = new Product("k455", "n", "11.1", Currency.USD, Color.RED);

        order.addProduct(anotherProduct);

        assertThat(order.getProductCount(), is(equalTo(2)));
        assertThat(order.getProduct(1), is(equalTo(anotherProduct)));
    }
}
