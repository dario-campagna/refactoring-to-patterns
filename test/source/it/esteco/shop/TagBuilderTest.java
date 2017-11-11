package it.esteco.shop;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class TagBuilderTest {

    @Test
    public void testBuildOneNode() throws Exception {
        String expectedXml = "<flavors/>";
        String actualXml = new TagBuilder("flavors").toXml();
        assertThat(actualXml, is(equalTo(expectedXml)));
    }

    @Test
    public void testBuildOneChild() throws Exception {
        String expectedXml =
                "<flavors>" +
                        "<flavor/>" +
                        "</flavors>";

        TagBuilder builder = new TagBuilder("flavors");
        builder.addChild("flavor");

        assertThat(builder.toXml(), is(equalTo(expectedXml)));
    }

    @Test
    public void testBuildChildrenOfChildren() throws Exception {
        String expectedXml =
                "<flavors>" +
                        "<flavor>" +
                        "<requirements>" +
                        "<requirement/>" +
                        "</requirements>" +
                        "</flavor>" +
                        "</flavors>";

        TagBuilder builder = new TagBuilder("flavors");
        builder.addChild("flavor");
        builder.addChild("requirements");
        builder.addChild("requirement");

        assertThat(builder.toXml(), is(equalTo(expectedXml)));
    }

    @Test
    public void testBuildSibling() throws Exception {
        String expectedXml =
                "<flavors>" +
                        "<flavor1/>" +
                        "<flavor2/>" +
                        "</flavors>";

        TagBuilder builder = new TagBuilder("flavors");
        builder.addChild("flavor1");
        builder.addSibling("flavor2");

        assertThat(builder.toXml(), is(equalTo(expectedXml)));
    }
}
