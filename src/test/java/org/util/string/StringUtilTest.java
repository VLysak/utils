package org.util.string;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.params.provider.EnumSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class StringUtilTest {

    public enum Polindrome {
        k,
        r,
        d;
    }

    // test<MethodName><Expectation><When>
    // testSplitReturnEmptyArrayWhenInputStringIsEmpty
    @Test
    public void testDoNothing() {
        System.out.println("This is a dummy test");
    }

    @Test
    public void testDoNothingSupposedToFail() {
//        Assert.fail();
    }

    @Test
    public void testSplit() {
        StringUtil abc = new StringUtil("a@-");
        StringUtil[] actual = abc.split("");
        assertEquals("a", actual[0].toString());
    }

    @Test
    public void testSplitReturnEmptyArrayWhenInputStringIsEmpty() {
        StringUtil abc = new StringUtil("");
        StringUtil[] actual = abc.split("hjgj");
        assertEquals(Arrays.toString(new StringUtil[]{}), Arrays.toString(actual));
    }

    @Test
    public void testSplitReturnsRmptyArrayWhenIn() {
        StringUtil abc = new StringUtil("1");
        StringUtil[] actual = abc.split(1);
        assertEquals(Arrays.toString(new StringUtil[]{new StringUtil("1")}), Arrays.toString(actual));
    }

    @Test
    public void testSizeWithEmptyStringUtil() {
        int actual = new StringUtil("").size();
        assertEquals(0, actual);
    }

    @Test
    public void testSizeStringUtilWithString() {
        int actual = new StringUtil(" qwerty ").size();
        assertEquals(8, actual);
    }

    @Test
    public void testSizeStringUtilWithCharArray() {
        char[] charArrays = new char[]{' ', 'c', 'h', 'a', 'r', ' '};
        int actual = new StringUtil(charArrays).size();
        assertEquals(6, actual);
    }

    @Test
    public void testCharacterGetFirstElement() {
        StringUtil a = new StringUtil("qwerty");
        char actual = a.character(0);
        assertEquals('q', actual);
    }

    @Test
    public void testCharacterGetLastElement() {
        StringUtil a = new StringUtil("q");
        char actual = a.character(a.size() - 1);
        assertEquals('q', actual);
    }

    @Test
    public void testAppendStringBufferData() {
        StringUtil stringUtil = new StringUtil("qwerty");
        StringUtil actual = stringUtil.append(new StringBuffer("asdfg"));
        assertEquals("qwertyasdfg", actual.toString());
    }

    @Test
    public void testAppendEmptyStringBufferData() {
        StringUtil stringUtil = new StringUtil("qwerty");
        StringUtil actual = stringUtil.append(new StringBuffer(""));
        assertEquals("qwerty", actual.toString());
    }

    @Test
    public void testPrependStringBufferData() {
        StringUtil stringUtil = new StringUtil("qwerty");
        StringUtil actual = stringUtil.prepend(new StringBuffer("asdfg"));
        assertEquals("asdfgqwerty", actual.toString());
    }

    @Test
    public void testReverse() {
        StringUtil stringUtil = new StringUtil("qwerty");
        StringUtil actual = stringUtil.reverse();
        assertEquals("ytrewq", actual.toString());
    }

    @Test
    public void testReverseEmpty() {
        StringUtil stringUtil = new StringUtil("");
        StringUtil actual = stringUtil.reverse();
        assertEquals("", actual.toString());
    }

    @ParameterizedTest
    @EnumSource(Polindrome.class)
    public void testReverseOneElement() {
        List<StringUtil> stringArray = new ArrayList<>();
        stringArray.add(new StringUtil(new char[]{'k'}));
        stringArray.add(new StringUtil(new char[]{'r'}));
        stringArray.add(new StringUtil(new char[]{'d'}));

        assertAll(() -> assertEquals(Polindrome.k.toString(), stringArray.get(0).reverse().toString()),
                () -> assertEquals(Polindrome.r.toString(), stringArray.get(1).reverse().toString()),
                () -> assertEquals(Polindrome.d.toString(), stringArray.get(2).reverse().toString())
        );

    }

    @ParameterizedTest
    @ValueSource(strings = {"kayak", "rotator", "dad"})
    public void testReversePalindromeParameterized(String polyndrom) {
        StringUtil a = new StringUtil(polyndrom);
        assertEquals(polyndrom, a.reverse().toString());
    }

    @Test
    public void testReversePalindrome() {
        List<StringUtil> stringArray = new ArrayList<>();
        stringArray.add(new StringUtil("kayak"));
        stringArray.add(new StringUtil("rotator"));
        stringArray.add(new StringUtil("dad"));

        assertAll(() -> assertEquals(stringArray.get(0).toString(), stringArray.get(0).reverse().toString()),
                () -> assertEquals(stringArray.get(1).toString(), stringArray.get(1).reverse().toString()),
                () -> assertEquals(stringArray.get(2).toString(), stringArray.get(2).reverse().toString())
        );
    }

    @Test
    public void testSet() {
        StringUtil stringUtil = new StringUtil("qwerty");
        StringUtil actual = stringUtil.set(5, 'a');
        assertEquals("qwerta", actual.toString());
    }

    @Test
    public void testUtil() throws Exception {
        StringUtil stringUtil = new StringUtil("qwerty");
        StringUtil actual = stringUtil.util(1, 5);
        assertEquals("wert", actual.toString());
    }

}