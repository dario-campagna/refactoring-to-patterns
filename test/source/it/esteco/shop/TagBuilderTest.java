package it.esteco.shop;

import org.junit.Ignore;
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
}
