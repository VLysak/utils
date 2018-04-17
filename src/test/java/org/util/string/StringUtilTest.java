package org.util.string;

import org.junit.Assert;
import org.junit.Test;

public class StringUtilTest {

    @Test
    public void testDoNothing() {
        System.out.println("This is a dummy test");
    }

    @Test
    public void testStringUtil() {
        StringUtil a = new StringUtil("abcdb");
        StringBuffer b = new StringBuffer().append("b");
        StringUtil ab = a.append(b);
//        a.set(2,'Z');

        System.out.println(a); // a
//        System.out.println(b); // b
//        System.out.println(ab); // ab
//        System.out.println(a.insert(1, a));
//        System.out.println(a.count('b'));
//        System.out.println(a.soundex());
//        System.out.println(a.set(0, 'k'));
        System.out.println(a.findLast('b', a.size()));


    }

    @Test
    public void testDoNothingSupposedToFail() {
        Assert.fail();
    }

}