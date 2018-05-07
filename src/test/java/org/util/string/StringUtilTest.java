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

    // test<MethodName><Expectation><When>
    // testSplitReturnEmptyArrayWhenInputStringIsEmpty
    //[Тестируемый метод]_[Сценарий]_[Ожидаемое поведение].

    @Test
    public void testSplitReturnArrayWhenSplitStringIsEmpty() {
        StringUtil stringUtil = new StringUtil("a@-");
        StringUtil[] actual = stringUtil.split("");
        assertEquals("a", actual[0].toString());
        assertEquals("@", actual[1].toString());
        assertEquals("-", actual[2].toString());
    }

    @Test
    public void testSplitReturnEmptyArrayWhenInputStringIsEmpty() {
        StringUtil stringUtil = new StringUtil("");
        StringUtil[] actual = stringUtil.split("hjgj");
        StringUtil[] expected = new StringUtil[]{};
        assertEquals(Arrays.toString(expected), Arrays.toString(actual));
    }

    @Test
    public void testSplitReturnArrayWhenSizePartIsThree() {
        StringUtil stringUtil = new StringUtil("a@-b@");
        StringUtil[] actual = stringUtil.split(3);
        assertEquals("a@-", actual[0].toString());
        assertEquals("b@", actual[1].toString());
    }

    @Test
    public void testSplitHasCorrectSizeWhenReturnedArray() {
        StringUtil stringUtil = new StringUtil("a@-b@");
        StringUtil[] actual = stringUtil.split(3);
        assertEquals(2, actual.length);
    }

    @Test
    public void testSplitReturnArrayWhenInputOneElementAndSizePartOne() {
        StringUtil stringUtil = new StringUtil("1");
        StringUtil[] actual = stringUtil.split(1);
        StringUtil[] expected = new StringUtil[]{new StringUtil("1")};
        assertEquals(Arrays.toString(expected), Arrays.toString(actual));
    }

    @Test
    public void testSizeWhenStringUtilIsEmpty() {
        int stringUtilSize = new StringUtil("").size();
        assertEquals(0, stringUtilSize);
    }

    @Test
    public void testSizeWhenStringUtilIsNotEmpty() {
        int stringUtilSize = new StringUtil(" qwerty ").size();
        assertEquals(8, stringUtilSize);
    }

    @Test
    public void testCharacterWhenGetFirstElement() {
        StringUtil stringUtil = new StringUtil("qwerty");
        char actual = stringUtil.character(0);
        assertEquals('q', actual);
    }

    @Test
    public void testCharacterWhenGetLastElement() {
        StringUtil stringUtil = new StringUtil("q");
        char actual = stringUtil.character(stringUtil.size() - 1);
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
    public void testAppendNotChangeBaseObject() {
        StringUtil stringUtil = new StringUtil("qwerty");
        stringUtil.append("asdf");
        assertEquals("qwerty", stringUtil.toString());
    }

    @Test
    public void testPrependStringBufferData() {
        StringUtil stringUtil = new StringUtil("qwerty");
        StringUtil actual = stringUtil.prepend(new StringBuffer("asdfg"));
        assertEquals("asdfgqwerty", actual.toString());
    }

    @Test
    public void testPrependEmptyStringBufferData() {
        StringUtil stringUtil = new StringUtil("qwerty");
        StringUtil actual = stringUtil.append(new StringBuffer(""));
        assertEquals("qwerty", actual.toString());
    }

    @Test
    public void testPrependNotChangeBaseObject() {
        StringUtil stringUtil = new StringUtil("qwerty");
        stringUtil.prepend("asdf");
        assertEquals("qwerty", stringUtil.toString());

    }

    @ParameterizedTest
    @ValueSource(strings = {"this", "is ", "ball", "implementation",})
    public void testReverseWhenStringUtilHaveDifferentSize(String argument) {
        StringUtil stringUtil = new StringUtil(argument);
        StringUtil actual = stringUtil.reverse();
        String expected = new String(new StringBuffer(argument).reverse());
        assertEquals(expected, actual.toString());
    }

    @Test
    public void testReverseWhenStringUtilIsEmpty() {
        StringUtil stringUtil = new StringUtil("");
        StringUtil actual = stringUtil.reverse();
        assertEquals("", actual.toString());
    }

    @Test
    public void testReverseWhenInStringUtilOneElement() {
        List<StringUtil> stringUtilArray = new ArrayList<>();
        stringUtilArray.add(new StringUtil(new char[]{'k'}));
        stringUtilArray.add(new StringUtil(new char[]{'r'}));
        stringUtilArray.add(new StringUtil(new char[]{'d'}));

        assertEquals("k", stringUtilArray.get(0).reverse().toString());
        assertEquals("r", stringUtilArray.get(1).reverse().toString());
        assertEquals("d", stringUtilArray.get(2).reverse().toString());
    }

    @ParameterizedTest
    @ValueSource(strings = {"kayak", "rotator", "dad"})
    public void testReverseWhenStringUtilIsPalindrome(String palyndrom) {
        StringUtil stringUtil = new StringUtil(palyndrom);
        assertEquals(palyndrom, stringUtil.reverse().toString());
    }

    @Test
    public void testSetWhenStringUtilIsEmpty() {
        StringUtil stringUtil = new StringUtil("");
        StringUtil actual = stringUtil.set(0, 'a');
        assertEquals("a", actual.toString());
    }

    @Test
    public void testSetElementsInDifferentPlaces() {
        StringUtil stringUtil = new StringUtil("kvadrat");

        assertAll("testing set first, last and central elements",
                () -> assertEquals("svadrat", stringUtil.set(0, 's').toString()),
                () -> assertEquals("kvadrad", stringUtil.set(6, 'd').toString()),
                () -> assertEquals("kvanrat", stringUtil.set(3, 'n').toString())
        );
    }

    @Test
    public void testUtilReturnCorrectSubstring() throws Exception {
        StringUtil stringUtil = new StringUtil("qwerty");
        StringUtil actual = stringUtil.util(1, 5);
        assertEquals("wert", actual.toString());
    }

    @Test
    public void testUtilReturnCorrectSubstringWithLastElement() {
        StringUtil stringUtil = new StringUtil("qwerty");
        StringUtil actual = stringUtil.util(5, 6);
        assertEquals("y", actual.toString());
    }

    @Test
    public void testUtilReturnCorrectSubstringWithFirstElement() {
        StringUtil stringUtil = new StringUtil("qwerty");
        StringUtil actual = stringUtil.util(0, 1);
        assertEquals("q", actual.toString());
    }

    @Test
    public void testCharactersReturnCorrectCharacterArray() {
        StringUtil stringUtil = new StringUtil("qwerty");
        String actual = new String(stringUtil.characters(1, 4));
        String expected = new String(new char[]{'w', 'e', 'r'});
        assertEquals(expected, actual);
    }

    @Test
    public void testInsertSubstringWhenBeginInsertFromTheStart() {
        StringUtil stringUtil = new StringUtil("qwerty");
        StringUtil actual = stringUtil.insert(0, "asd");
        String expected = "asdqwerty";
        assertEquals(expected, actual.toString());
    }

    @Test
    public void testInsertSubstringWhenBeginInsertFromTheEnd() {
        StringUtil stringUtil = new StringUtil("qwerty");
        StringUtil actual = stringUtil.insert(6, "asd");
        String expected = "qwertyasd";
        assertEquals(expected, actual.toString());
    }

    @Test
    public void testInsertSubstringWhenBeginInsertFromTheMiddle() {
        StringUtil stringUtil = new StringUtil("qwerty");
        StringUtil actual = stringUtil.insert(3, "asd");
        String expected = "qweasdrty";
        assertEquals(expected, actual.toString());
    }

    @Test
    public void testInsertSubstringWhenInsertingSubstringIsEmpty() {
        StringUtil stringUtil = new StringUtil("qwerty");
        StringUtil actual = stringUtil.insert(5, "");
        String expected = "qwerty";
        assertEquals(expected, actual.toString());
    }

    @Test
    public void testInsertSubstringWhenTargetStringIsEmpty() {
        StringUtil stringUtil = new StringUtil("");
        StringUtil actual = stringUtil.insert(0, "qwerty");
        String expected = "qwerty";
        assertEquals(expected, actual.toString());
    }

    @Test
    public void testCloneCheckCreatedWhenNewObjectTheSameOldObject() {
        StringUtil stringUtil = new StringUtil("qwerty");
        StringUtil actual = stringUtil.clone();
        assertTrue(stringUtil.equals(actual));
    }
}