package it.esteco.shop;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TagNode {

    private String name = "";
    private String value = "";
    private StringBuffer attributes;
    private List<TagNode> children;

    public TagNode(String name) {
        this.name = name;
        this.attributes = new StringBuffer("");
    }

    public void addAttribute(String attribute, String value) {
        attributes.append(" ");
        attributes.append(attribute);
        attributes.append("='");
        attributes.append(value);
        attributes.append("'");
    }

    public void addValue(String value) {
        this.value = value;
    }

    public void add(TagNode child) {
        children().add(child);
    }

    @Override
    public String toString() {
        String result;
        result = "<" + name + attributes;
        if (emptyTag()) {
            result += "/>";
        } else {
            result += ">";
            Iterator<TagNode> iterator = children().iterator();
            while (iterator.hasNext()) {
                TagNode node = iterator.next();
                result += node.toString();
            }
            result += value;
            result += "</" + name + ">";
        }
        return result;
    }

    private boolean emptyTag() {
        return value.isEmpty() && children().isEmpty();
    }

    private List<TagNode> children() {
        if (children == null) {
            children = new ArrayList<TagNode>();
        }
        return children;
    }
}
