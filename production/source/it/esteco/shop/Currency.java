package it.esteco.shop;

public enum Currency {
    USD("USD"),
    EUR("EUR");

    private String asText;

    Currency(String asText) {
        this.asText = asText;
    }

    @Override
    public String toString() {
        return asText;
    }
}
