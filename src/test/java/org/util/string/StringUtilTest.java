package org.util.string;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class StringUtilTest {

    @Test
    public void testDoNothing() {
        System.out.println("This is a dummy test");
    }

    @Test
    public void testStringUtil() {
        StringUtil a = new StringUtil("abc");
        StringBuffer b = new StringBuffer().append("b");

        System.out.println(a); // a
        System.out.println(b); // b

        StringUtil ab = a.append(b);
        System.out.println(ab); // ab
        System.out.println(ab.reverse());
        System.out.println(a.insert(1, a));
        System.out.println(a.count('b'));
        System.out.println(a.soundex());

    }

//    @Test
//    public void testDoNothingSupposedToFail() {
//        Assert.fail();
//    }

}