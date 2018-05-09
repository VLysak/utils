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
    public void testSplitWorkWithStringDataWhenSplitStringIsEmpty() {
        StringUtil stringUtil = new StringUtil("a@-");
        StringUtil[] actual = stringUtil.split("");
        assertEquals("a@-", actual[0].toString());
    }

    @Test
    public void testSplitWorkWithStringDataWhenInputStringIsEmpty() {
        StringUtil stringUtil = new StringUtil("");
        StringUtil[] actual = stringUtil.split("hjgj");
        assertEquals("", actual[0].toString());
    }

    @Test
    public void testSplitWorkWithIntegerDataWhenSizePartIsThree() {
        StringUtil stringUtil = new StringUtil("a@-b@");
        StringUtil[] actual = stringUtil.split(3);
        assertEquals("a@-", actual[0].toString());
        assertEquals("b@", actual[1].toString());
    }

    @Test
    public void testSplitWorkWithIntegerDataWhenQuantityOfElementsOfArrayIsTwo() {
        StringUtil stringUtil = new StringUtil("a@-b@");
        StringUtil[] actual = stringUtil.split(3);
        assertEquals(2, actual.length);
    }

    @Test
    public void testSplitWorkWithIntegerDataWhenInputOneElementAndSizePartOne() {
        StringUtil stringUtil = new StringUtil("1");
        StringUtil[] actual = stringUtil.split(1);
        assertEquals("1", actual[0].toString());
    }

    @Test
    public void testSplitWorkWithCharDataWhenSplitElementPresentInStringUtil() {
        StringUtil stringUtil = new StringUtil("a@-b@");
        StringUtil[] actual = stringUtil.split('@');
        assertEquals("a", actual[0].toString());
        assertEquals("-b", actual[1].toString());
    }

    @Test
    public void testSplitWorkWithCharDataWhenSplitElementNotPresentInStringUtil() {
        StringUtil stringUtil = new StringUtil("a@-b@");
        StringUtil[] actual = stringUtil.split('d');
        assertEquals("a@-b@", actual[0].toString());
    }

    @Test
    public void testSplitWorkWithCharArrayDataWhenSplitElementPresentInStringUtil() {
        StringUtil stringUtil = new StringUtil("a@-b@");
        StringUtil[] actual = stringUtil.split(new char[]{'@', '-'});
        assertEquals("a", actual[0].toString());
        assertEquals("b@", actual[1].toString());
    }

    @Test
    public void testSplitWorkWithCharArrayDataWhenSplitCharArrayIsEmpty() {
        StringUtil stringUtil = new StringUtil("a@-b@");
        StringUtil[] actual = stringUtil.split(new char[]{});
        assertEquals("a@-b@", actual[0].toString());
    }

    @Test
    public void testSplitWorkWithStringBuilderDataWhenStringBuilderIsContainData() {
        StringUtil stringUtil = new StringUtil("a@-b@");
        StringUtil[] actual = stringUtil.split(new StringBuilder("-b"));
        assertEquals("a@", actual[0].toString());
    }

    @Test
    public void testSplitWorkWithStringBuilderDataWhenStringBuilderIsEmpty() {
        StringUtil stringUtil = new StringUtil("a@-b@");
        StringUtil[] actual = stringUtil.split(new StringBuilder());
        assertEquals("a@-b@", actual[0].toString());
    }

    @Test
    public void testSplitWorkWithStringBufferDataWhenStringBufferIsContainData() {
        StringUtil stringUtil = new StringUtil("a@-b@");
        StringUtil[] actual = stringUtil.split(new StringBuffer("-b"));
        assertEquals("a@", actual[0].toString());
    }

    @Test
    public void testSplitWorkWithStringBufferDataWhenStringBufferIsEmpty() {
        StringUtil stringUtil = new StringUtil("a@-b@");
        StringUtil[] actual = stringUtil.split(new StringBuffer());
        assertEquals("a@-b@", actual[0].toString());
    }

    @Test
    public void testSplitWorkWithStringUtilDataWhenStringUtilIsContainData() {
        StringUtil stringUtil = new StringUtil("a@-b@");
        StringUtil[] actual = stringUtil.split(new StringUtil("-b"));
        assertEquals("a@", actual[0].toString());
    }

    @Test
    public void testSplitWorkWithStringUtilDataWhenStringUtilIsEmpty() {
        StringUtil stringUtil = new StringUtil("a@-b@");
        StringUtil[] actual = stringUtil.split(new StringUtil(""));
        assertEquals("a@-b@", actual[0].toString());
    }

    @Test
    public void testSizeWhenStringUtilIsEmpty() {
        int actual = new StringUtil("").size();
        assertEquals(0, actual);
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
        char actual = stringUtil.character(0);
        assertEquals('q', actual);
    }

    @Test
    public void testAppendWhenAddedStringBufferData() {
        StringUtil stringUtil = new StringUtil("qwerty");
        StringUtil actual = stringUtil.append(new StringBuffer("asdfg"));
        assertEquals("qwertyasdfg", actual.toString());
    }

    @Test
    public void testAppendWhenAddedEmptyStringBufferData() {
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

    @ParameterizedTest
    @ValueSource(strings = {"k", "r", "d"})
    public void testReverseWhenIntoStringUtilPutOneElement(String argument) {
        List<StringUtil> stringUtilArray = new ArrayList<>();
        stringUtilArray.add(new StringUtil(argument));
        assertEquals(argument, stringUtilArray.get(0).reverse().toString());
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
    public void testSetElementIntoStartString() {
        StringUtil stringUtil = new StringUtil("kvadrat");
        assertEquals("svadrat", stringUtil.set(0, 's').toString());
    }

    @Test
    public void testSetElementIntoEndString() {
        StringUtil stringUtil = new StringUtil("kvadrat");
        assertEquals("kvadrad", stringUtil.set(6, 'd').toString());
    }

    @Test
    public void testSetElementIntoMiddleString() {
        StringUtil stringUtil = new StringUtil("kvadrat");
        assertEquals("kvanrat", stringUtil.set(3, 'n').toString());
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

    @Test
    public void testIsNumberWhenStringUtilComposedOfNumbers() {
        StringUtil stringUtil = new StringUtil("123");
        assertTrue(stringUtil.isNumber());
    }

    @Test
    public void testIsNumberWhenStringUtilComposedOfNotOnlyNumbers() {
        StringUtil stringUtil = new StringUtil("123asd");
        assertFalse(stringUtil.isNumber());
    }

    @Test
    public void testIsNumberWhenStringUtilIsEmpty() {
        StringUtil stringUtil = new StringUtil("");
        assertFalse(stringUtil.isNumber());
    }

    @Test
    public void testIsBoolWhenStringUtilContainsFalse(){
        assertTrue(new StringUtil("false").isBool());
    }

    @Test
    public void testIsBoolWhenStringUtilContainsTrue(){
        assertTrue(new StringUtil("true").isBool());
    }

    @Test
    public void testIsBoolWhenStringUtilContainNeitherFalseNorTrue(){
        assertFalse(new StringUtil("asd").isBool());
    }

}