package it.esteco.shop;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class TagTests {

    public static final String SAMPLE_PRICE = "8.65";

    @Test
    public void testSimpleTag() throws Exception {
        TagNode priceTag = new TagNode("price");

        String expected =
                "<price>" +
                "</price>";

        assertThat(priceTag.toString(), is(equalTo(expected)));
    }

    @Test
    public void testSimpleTagWithValue() throws Exception {
        TagNode priceTag = new TagNode("price");
        priceTag.addValue(SAMPLE_PRICE);

        String expected =
                "<price>" +
                        SAMPLE_PRICE +
                "</price>";

        assertThat(priceTag.toString(), is(equalTo(expected)));
    }

    @Test
    public void testSimpleTagWithOneAttributeAndValue() throws Exception {
        TagNode priceTag = new TagNode("price");
        priceTag.addAttribute("currency", "USD");
        priceTag.addValue(SAMPLE_PRICE);

        String expected =
                "<price currency=" +
                        "'" +
                        "USD" +
                        "'>" +
                    SAMPLE_PRICE +
                "</price>";

        assertThat(priceTag.toString(), is(equalTo(expected)));
    }
}
