package it.esteco.shop;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

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

    @Test
    public void testRepeatingChildrenAndGrandChildren() throws Exception {
        String expectedXml =
            "<flavors>" +
                "<flavor>" +
                    "<requirements>" +
                        "<requirement/>" +
                    "</requirements>" +
                "</flavor>" +
                "<flavor>" +
                    "<requirements>" +
                        "<requirement/>" +
                    "</requirements>" +
                "</flavor>" +
            "</flavors>";

        TagBuilder builder = new TagBuilder("flavors");
        for (int i = 0; i < 2; i++) {
            builder.addToParent("flavors", "flavor");
            builder.addChild("requirements");
            builder.addChild("requirement");
        }

        assertThat(builder.toXml(), is(equalTo(expectedXml)));
    }

    @Test
    public void testParentNameNotFound() throws Exception {
        TagBuilder builder = new TagBuilder("flavors");
        try {
            for (int i = 0; i < 2; i++) {
                builder.addToParent("favors", "flavor");
                builder.addChild("requirements");
                builder.addChild("requirement");
            }
            fail("Should not allow adding to parent that doesn't exist.");
        } catch (RuntimeException runtimeException) {
            String expectedErrorMessage = "missing parent tag: favors";
            assertThat(runtimeException.getMessage(), is(equalTo(expectedErrorMessage)));
        }
    }
}
