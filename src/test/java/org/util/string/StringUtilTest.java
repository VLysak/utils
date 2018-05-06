package org.util.string;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.params.provider.EnumSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class StringUtilTest {

    public enum Palindrome {
        k,
        r,
        d;
    }

    // test<MethodName><Expectation><When>
    // testSplitReturnEmptyArrayWhenInputStringIsEmpty

    @Test
    public void testSplitReturnArrayWhenSplitStringIsEmpty() {
        StringUtil input = new StringUtil("a@-");
        StringUtil[] actual = input.split("");
        assertAll(() -> assertEquals("a", actual[0].toString()),
                () -> assertEquals("@", actual[1].toString()),
                () -> assertEquals("-", actual[2].toString()));
    }

    @Test
    public void testSplitReturnEmptyArrayWhenInputStringIsEmpty() {
        StringUtil input = new StringUtil("");
        StringUtil[] actual = input.split("hjgj");
        StringUtil[] expected = new StringUtil[]{};
        assertEquals(Arrays.toString(expected), Arrays.toString(actual));
    }

    @Test
    public void testSplitReturnArrayWhenSizePartIsThree() {
        StringUtil input = new StringUtil("a@-b@");
        StringUtil[] actual = input.split(3);
        StringUtil[] expected = new StringUtil[]{new StringUtil("a@-"), new StringUtil("b@")};
        assertEquals(Arrays.toString(expected), Arrays.toString(actual));
    }

    @Test
    public void testSplitReturnArrayWithCorrectSireReturnedArray() {
        StringUtil input = new StringUtil("a@-b@");
        StringUtil[] actual = input.split(3);
        int expected = 2;
        assertEquals(expected, actual.length);
    }

    @Test
    public void testSplitReturnArrayWhenInputOneElementAndSizePartOne() {
        StringUtil input = new StringUtil("1");
        StringUtil[] actual = input.split(1);
        StringUtil[] expected = new StringUtil[]{new StringUtil("1")};
        assertEquals(Arrays.toString(expected), Arrays.toString(actual));
    }


    @Test
    public void testSizeWhenStringUtilIsEmpty() {
        int actual = new StringUtil("").size();
        assertEquals(0, actual);
    }

    @Test
    public void testSizeWhenStringUtilIsNotEmpty() {
        int actual = new StringUtil(" qwerty ").size();
        assertEquals(8, actual);
    }

    @Test
    public void testCharacterWhenGetFirstElement() {
        StringUtil input = new StringUtil("qwerty");
        char actual = input.character(0);
        assertEquals('q', actual);
    }

    @Test
    public void testCharacterWhenGetLastElement() {
        StringUtil input = new StringUtil("q");
        char actual = input.character(input.size() - 1);
        assertEquals('q', actual);
    }

    @Test
    public void testAppendStringBufferData() {
        StringUtil input = new StringUtil("qwerty");
        StringUtil actual = input.append(new StringBuffer("asdfg"));
        assertEquals("qwertyasdfg", actual.toString());
    }

    @Test
    public void testAppendEmptyStringBufferData() {
        StringUtil input = new StringUtil("qwerty");
        StringUtil actual = input.append(new StringBuffer(""));
        assertEquals("qwerty", actual.toString());
    }

    @Test
    public void testPrependStringBufferData() {
        StringUtil input = new StringUtil("qwerty");
        StringUtil actual = input.prepend(new StringBuffer("asdfg"));
        assertEquals("asdfgqwerty", actual.toString());
    }

    @ParameterizedTest
    @ValueSource(strings = {"this", "is ", "ball", "implementation",})
    public void testReverseWhenStringUtilHaveDifferentSize(String argument) {
        StringUtil input = new StringUtil(argument);
        StringUtil actual = input.reverse();
        String expected = new String(new StringBuffer(argument).reverse());
        assertEquals(expected, actual.toString());
    }

    @Test
    public void testReverseWhenStringUtilIsEmpty() {
        StringUtil input = new StringUtil("");
        StringUtil actual = input.reverse();
        assertEquals("", actual.toString());
    }

    @ParameterizedTest
    @EnumSource(Palindrome.class)
    public void testReverseWhenInStringUtilOneElement() {
        List<StringUtil> stringArray = new ArrayList<>();
        stringArray.add(new StringUtil(new char[]{'k'}));
        stringArray.add(new StringUtil(new char[]{'r'}));
        stringArray.add(new StringUtil(new char[]{'d'}));

        assertAll(() -> assertEquals(Palindrome.k.toString(), stringArray.get(0).reverse().toString()),
                () -> assertEquals(Palindrome.r.toString(), stringArray.get(1).reverse().toString()),
                () -> assertEquals(Palindrome.d.toString(), stringArray.get(2).reverse().toString())
        );

    }

    @ParameterizedTest
    @ValueSource(strings = {"kayak", "rotator", "dad"})
    public void testReverseWhenStringUtilIsPalindrome(String palyndrom) {
        StringUtil actual = new StringUtil(palyndrom);
        assertEquals(palyndrom, actual.reverse().toString());
    }

    @Test
    public void testSetWhenStringUtilIsEmpty() {
        StringUtil input = new StringUtil("");
        StringUtil actual = input.set(0, 'a');
        assertEquals("a", actual.toString());
    }

    @Test
    public void testUtilReturnCorrectSubstring() throws Exception {
        StringUtil input = new StringUtil("qwerty");
        StringUtil actual = input.util(1, 5);
        assertEquals("wert", actual.toString());
    }

}