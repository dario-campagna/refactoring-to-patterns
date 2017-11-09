package it.esteco.shop;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.assertThat;

public class ProductEqualsTest {

    @Test
    public void sameProduct() throws Exception {
        Product product = new Product("g456", "a", "2.20", Currency.EUR, Color.GREEN, ProductSize.LARGE);
        Product anotherProduct = new Product("g456", "a", "2.20", Currency.EUR, Color.GREEN, ProductSize.LARGE);
        assertThat(product, is(equalTo(anotherProduct)));
    }

    @Test
    public void differentProducts() throws Exception {
        Product product = new Product("g456", "c", "1.11", Currency.EUR, Color.GREEN, ProductSize.LARGE);
        Product anotherProduct = new Product("g451", "v", "1.11", Currency.EUR, Color.RED);
        assertThat(product, not(equalTo(anotherProduct)));
    }
}
