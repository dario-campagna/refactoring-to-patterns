package it.esteco.shop;

public class OrdersWriter {

    private Orders orders;

    public OrdersWriter(Orders orders) {
        this.orders = orders;
    }

    public String getContents() {
        TagBuilder tagBuilder = new TagBuilder("orders");
        writeOrderTo(tagBuilder);
        return tagBuilder.toXml();
    }

    private void writeOrderTo(TagBuilder tagBuilder) {
        for (int i = 0; i < orders.getOrderCount(); i++) {
            Order order = orders.getOrder(i);
            tagBuilder.addToParent("orders", "order");
            tagBuilder.addAttribute("id", order.getOrderId());
            writeProductsTo(tagBuilder, order);
        }
    }

    private void writeProductsTo(TagBuilder tagBuilder, Order order) {
        for (int j = 0; j < order.getProductCount(); j++) {
            Product product = order.getProduct(j);
            tagBuilder.addToParent("order", "product");
            tagBuilder.addAttribute("id", product.getID());
            tagBuilder.addAttribute("color", colorFor(product));
            if (product.getSize() != ProductSize.NOT_APPLICABLE) {
                tagBuilder.addAttribute("size", sizeFor(product));
            }
            tagBuilder.addValue(product.getName());
            writePriceTo(tagBuilder, product);
        }
    }

    private void writePriceTo(TagBuilder tagBuilder, Product product) {
        tagBuilder.addChild("price");
        tagBuilder.addAttribute("currency", currencyFor(product));
        tagBuilder.addValue(product.getPrice());
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
