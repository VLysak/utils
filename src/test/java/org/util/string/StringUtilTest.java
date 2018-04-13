package org.util.string;

import org.junit.Assert;
import org.junit.Test;

public class StringUtilTest {

    @Test
    public void testDoNothing() {
        System.out.println("This is a dummy test");
    }

    @Test
    public void testDoNothingSupposedToFail() {
        Assert.fail();
    }

}