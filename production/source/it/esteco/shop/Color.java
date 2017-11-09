package it.esteco.shop;

public enum Color {
    RED("red"),
    GREEN("green");

    private String asText;

    Color(String asText) {
        this.asText = asText;
    }

    @Override
    public String toString() {
        return asText;
    }
}
