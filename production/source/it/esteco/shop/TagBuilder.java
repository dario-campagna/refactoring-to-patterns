package it.esteco.shop;

public class TagBuilder {

    private TagNode rootNode;
    private TagNode currentNode;

    public TagBuilder(String rootTagName) {
        rootNode = new TagNode(rootTagName);
        currentNode = rootNode;
    }

    public String toXml() {
        return rootNode.toString();
    }

    public void addChild(String childTagName) {
        TagNode parentNode = currentNode;
        currentNode = new TagNode(childTagName);
        parentNode.add(currentNode);
    }
}
