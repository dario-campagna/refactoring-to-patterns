package it.esteco.shop;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

public class TagTests {

    public static final String SAMPLE_PRICE = "8.65";

    @Test
    public void testSimpleTag() throws Exception {
        TagNode priceTag = new TagNode("price");

        String expected = "<price/>";

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

    @Test
    public void testCompositeTagOneChild() throws Exception {
        TagNode productTag = new TagNode("product");
        productTag.add(new TagNode("price"));

        String expected =
                "<product>" +
                        "<price/>" +
                "</product>";

        assertThat(productTag.toString(), is(equalTo(expected)));
    }

    @Test
    public void testAddingChildrenAndGrandChildren() throws Exception {
        TagNode ordersTag = new TagNode("orders");
        TagNode orderTag = new TagNode("order");
        TagNode productTag = new TagNode("product");
        ordersTag.add(orderTag);
        orderTag.add(productTag);

        String expected =
                "<orders>" +
                        "<order>" +
                        "<product/>" +
                        "</order>" +
                        "</orders>";

        assertThat(ordersTag.toString(), is(equalTo(expected)));
    }

    @Test
    public void testCompositeTagWithChildrenAndAttributes() throws Exception {
        TagNode orderTag = new TagNode("order");
        orderTag.addAttribute("id", "343");
        TagNode productTag = new TagNode("product");
        productTag.addAttribute("color", "red");
        TagNode priceNode = new TagNode("price");
        priceNode.addValue("11.98");

        orderTag.add(productTag);
        productTag.add(priceNode);

        String expected =
                "<order id='343'>" +
                        "<product color='red'>" +
                        "<price>" +
                        "11.98" +
                        "</price>" +
                        "</product>" +
                        "</order>";

        assertThat(orderTag.toString(), is(equalTo(expected)));
    }

    @Test
    public void testParents() throws Exception {
        TagNode rootNode = new TagNode("root");

        assertNull(rootNode.getParent());

        TagNode childNode = new TagNode("child");
        rootNode.add(childNode);

        assertThat(childNode.getParent(), is(equalTo(rootNode)));
        assertThat(childNode.getParent().getName(), is(equalTo("root")));
    }
}
