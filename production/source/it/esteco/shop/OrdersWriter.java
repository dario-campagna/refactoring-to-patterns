package it.esteco.shop;

public class OrdersWriter {

    private Orders orders;

    public OrdersWriter(Orders orders) {
        this.orders = orders;
    }

    public String getContents() {
        StringBuffer xml = new StringBuffer();
        writeOrderTo(xml);
        return xml.toString();
    }

    private void writeOrderTo(StringBuffer xml) {
        xml.append("<orders>");
        for (int i = 0; i < orders.getOrderCount(); i++) {
            Order order = orders.getOrder(i);
            xml.append("<order");
            xml.append(" id='");
            xml.append(order.getOrderId());
            xml.append("'>");
            writeProductsTo(xml, order);
            xml.append("</order>");
        }
        xml.append("</orders>");
    }

    private void writeProductsTo(StringBuffer xml, Order order) {
        for (int j = 0; j < order.getProductCount(); j++) {
            Product product = order.getProduct(j);
            TagNode productTag = new TagNode("product");
            productTag.addAttribute("id", product.getID());
            productTag.addAttribute("color", colorFor(product));
            if (product.getSize() != ProductSize.NOT_APPLICABLE) {
                productTag.addAttribute("size", sizeFor(product));
            }
            writePriceTo(productTag, product);
            productTag.addValue(product.getName());
            xml.append(productTag.toString());
        }
    }

    private void writePriceTo(TagNode productNode, Product product) {
        TagNode priceTag = new TagNode("price");
        priceTag.addAttribute("currency", currencyFor(product));
        priceTag.addValue(product.getPrice());
        productNode.add(priceTag);
    }

    private String currencyFor(Product product) {
        return product.getCurrency().toString();
    }

    private String sizeFor(Product product) {
        return product.getSize().toString();
    }

    private String colorFor(Product product) {
        return product.getColor().toString();
    }
}
