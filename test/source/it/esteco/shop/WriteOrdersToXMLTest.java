package it.esteco.shop;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class WriteOrdersToXMLTest {

    @Test
    public void oneOrderWithTwoProducts() throws Exception {
        Order order = new Order("321");
        order.addProduct(new Product("f1234", "Fire truck", "8.95", Currency.USD, Color.RED, ProductSize.MEDIUM));
        order.addProduct(new Product("p1112", "Toy Porsche Convertible", "230.0", Currency.USD, Color.RED));
        Orders orders = new Orders();
        orders.addOrder(order);
        OrdersWriter ordersWriter = new OrdersWriter(orders);

        String expectedResult =
                "<orders>" +
                        "<order id='321'>" +
                        "<product id='f1234' color='red' size='medium'>" +
                        "<price currency='USD'>" +
                        "8.95" +
                        "</price>" +
                        "Fire truck" +
                        "</product>" +
                        "<product id='p1112' color='red'>" +
                        "<price currency='USD'>" +
                        "230.0" +
                        "</price>" +
                        "Toy Porsche Convertible" +
                        "</product>" +
                        "</order>" +
                        "</orders>";

        assertThat(ordersWriter.getContents(), is(equalTo(expectedResult)));
    }
}
