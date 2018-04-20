package org.util.string;

import org.junit.Assert;
import org.junit.Test;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class StringUtilTest {

    @Test
    public void testDoNothing() {
        System.out.println("This is a dummy test");
    }

    @Test
    public void testStringUtil() {
        StringUtil a = new StringUtil("true");
        StringBuffer b = new StringBuffer(" buffer ");
        StringBuilder c = new StringBuilder(" builder ");
        StringUtil ab = a.append(b);
        StringUtil cd = new StringUtil("abcd");
        char[] charArrays = new char[]{' ', 'c', 'h', 'a', 'r', 'A', 'r', 'r', 'a', 'r', 'y', 's', ' '};
        byte[] byteArrays = new byte[]{'\u0020', '\u0056', '\u0069', '\u0074', '\u0061', '\u006C', '\u0069', '\u006B', '\u0020'};
        Charset charset = StandardCharsets.UTF_8;
        StringUtil charDefine = new StringUtil(charArrays);
        char[] charFind = new char[]{'a', 'r'};
        charDefine.isBool();
//        a.set(2,'Z');

//        System.out.println(a); // a
//        System.out.println(b); // b
//        System.out.println(ab); // ab
//        System.out.println(a.insert(1, a));
//        System.out.println(a.count('b'));
//        System.out.println(a.set(0, 'k'));
//        System.out.println(a.findLast('b', a.size()));
        System.out.println(a.append(" string"));
        System.out.println(a.append(b));
        System.out.println(a.append(c));
        System.out.println(a.append(charArrays));
        System.out.println(a.append(byteArrays, charset));
        System.out.println(a);
        System.out.println(a.prepend(b));
        System.out.println(a.prepend(" string "));
        System.out.println(a.prepend(c));
        System.out.println(a.prepend(charArrays));
        System.out.println(a.prepend(byteArrays, charset));
        System.out.println(a.reverse());
        System.out.println(a.soundex());
        System.out.println(a.insert(2, 't'));
        System.out.println(a.insert(2, " string "));
        System.out.println(a.insert(2, charArrays));
        System.out.println(a.insert(2, c));
        System.out.println(a.insert(2, b));
        System.out.println(a.insert(2, a));
        System.out.println(a.set(2, 'x'));
        System.out.println(a.util(1, 3));
        System.out.println(a.compareTo(cd));
        System.out.println(a.remove(1, 3));
        System.out.println(a.isBool());
        System.out.println(charDefine.count(charFind));

        System.out.println(a);


    }

    @Test
    public void testDoNothingSupposedToFail() {
//        Assert.fail();
    }

}