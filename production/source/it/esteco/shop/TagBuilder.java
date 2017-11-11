package it.esteco.shop;

public class TagBuilder {

    private TagNode rootNode;

    public TagBuilder(String rootTagName) {
        rootNode = new TagNode(rootTagName);
    }

    public String toXml() {
        return rootNode.toString();
    }
}
