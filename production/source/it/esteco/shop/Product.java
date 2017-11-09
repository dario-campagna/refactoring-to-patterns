package it.esteco.shop;

public class Product {

    private String id;
    private Color color;
    private ProductSize size;
    private Currency currency;
    private String price;
    private String name;

    public Product(String id, String name, String price, Currency currency, Color color) {
        this(id, name, price, currency, color, ProductSize.NOT_APPLICABLE);
    }

    public Product(String id, String name, String price, Currency currency, Color color, ProductSize size) {
        this.id = id;
        this.color = color;
        this.size = size;
        this.currency = currency;
        this.price = price;
        this.name = name;
    }

    public String getID() {
        return id;
    }

    public Color getColor() {
        return color;
    }

    public ProductSize getSize() {
        return size;
    }

    public Currency getCurrency() {
        return currency;
    }

    public String getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (!id.equals(product.id)) return false;
        if (color != product.color) return false;
        if (size != product.size) return false;
        if (currency != product.currency) return false;
        return price.equals(product.price);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + color.hashCode();
        result = 31 * result + size.hashCode();
        result = 31 * result + currency.hashCode();
        result = 31 * result + price.hashCode();
        return result;
    }
}
