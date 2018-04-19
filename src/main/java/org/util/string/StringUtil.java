package org.util.string;

import java.nio.charset.Charset;
import java.text.MessageFormat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Function;
import java.util.stream.Stream;
import java.lang.Character;

public class StringUtil implements Cloneable, Comparable<StringUtil>, Iterable<Character>, Comparator<StringUtil> {

    private final StringBuilder builder;

    public enum Equality {
        REFERENCE, // only reference should match
        LENGTH, // strings are equal if length same
        VALUE, // strings are equal if value is the same -- default one
        IGNORE_CASE // string are equal if value is equal but ignoring case differences

        // placeholder
        ;
    }

    public enum Case {
        LOWER,// "abc xyz"
        UPPER, // "ABC XYZ"
        CAMEL, // "Abc Xyz"
        TITLE, // "Abc xyz."

        // placeholder
        ;
    }

    /**
     * Initializes instance with default value
     */
    private StringUtil() {
        this.builder = new StringBuilder();
    }

    /**
     * Initializes instance with provided value
     */
    public StringUtil(String data) {
        this.builder = new StringBuilder(data);
    }

    /**
     * Initializes instance with provided value
     */
    public StringUtil(StringBuffer data) {
        this.builder = new StringBuilder(data);
    }

    /**
     * Initializes instance with provided value
     */
    public StringUtil(StringBuilder data) {
        this.builder = new StringBuilder(data);
    }

    /**
     * Initializes instance with provided value
     */

    public StringUtil(char[] data) {
        this.builder = new StringBuilder().append(data);
    }

    /**
     * Initializes instance with provided value
     */
    public StringUtil(byte[] data, Charset charset) {
        this(new String(data, charset));
    }

    /// ALL METHODS MUST RETURN NEW EXEMPLAR OF StringUtil which replace old StringUtil (other object)

    /**
     * Appends data to the end. Does not change state of this instance.
     *
     * @param data - value to append
     * @return another object with modified state
     */
    public StringUtil append(StringBuffer data) {
        StringUtil other = new StringUtil(builder);
        other.builder.append(data);
        return other;
    }

    /**
     * Appends data to the end. Does not change state of this instance.
     *
     * @param data - value to append
     * @return another object with modified state
     */
    public StringUtil append(String data) {
        StringUtil other = new StringUtil(builder);
        other.builder.append(data);
        return other;
    }

    /**
     * Appends data to the end. Does not change state of this instance.
     *
     * @param data - value to append
     * @return another object with modified state
     */
    public StringUtil append(StringBuilder data) {
        StringUtil other = new StringUtil(builder);
        other.builder.append(data);
        return other;
    }

    /**
     * Appends data to the end. Does not change state of this instance.
     *
     * @param data - value to append
     * @return another object with modified state
     */
    public StringUtil append(char[] data) {
        StringUtil other = new StringUtil(builder);
        other.builder.append(data);
        return other;
    }

    /**
     * Appends data to the end. Does not change state of this instance.
     *
     * @param data    - value to append
     * @param charset
     * @return another object with modified state
     */
    public StringUtil append(byte[] data, Charset charset) {
        StringUtil other = new StringUtil(builder);
        other.builder.append(new StringUtil(data, charset));
        return other;
    }

    /**
     * Prepends data to the start. Does not change state of this instance.
     *
     * @param data - value to prepend
     * @return another object with modified state
     */
    public StringUtil prepend(StringBuffer data) {
        StringUtil other = new StringUtil(data);
        other.builder.append(builder);
        return other;
    }

    /**
     * Prepends data to the start. Does not change state of this instance.
     *
     * @param data - value to prepend
     * @return another object with modified state
     */
    public StringUtil prepend(String data) {
        StringUtil other = new StringUtil(data);
        other.builder.append(builder);
        return other;
    }

    /**
     * Prepends data to the start. Does not change state of this instance.
     *
     * @param data - value to prepend
     * @return another object with modified state
     */
    public StringUtil prepend(StringBuilder data) {
        StringUtil other = new StringUtil(data);
        other.builder.append(builder);
        return other;
    }

    /**
     * Prepends data to the start. Does not change state of this instance.
     *
     * @param data - value to prepend
     * @return another object with modified state
     */
    public StringUtil prepend(char[] data) {
        StringUtil other = new StringUtil(data);
        other.builder.append(builder);
        return other;
    }

    /**
     * Prepends data to the start. Does not change state of this instance.
     *
     * @param data    - value to prepend
     * @param charset
     * @return another object with modified state
     */
    public StringUtil prepend(byte[] data, Charset charset) {
        StringUtil other = new StringUtil(data, charset);
        other.builder.append(builder);
        return other;
    }

    /**
     * Returns new instance which have reversed order of its field builder
     *
     * @return another object with modified state
     */
    public StringUtil reverse() {
        StringUtil other = new StringUtil(builder);
        other.builder.reverse();
        return other;
    }

    /**
     * Returns char by index
     *
     * @return char
     */
    public char character(int index) {
        return builder.charAt(index);
    }

    /**
     * Returns new instance which contains builder with set 'value' to 'index'
     *
     * @param index
     * @param value
     * @return another object with modified state
     */
    public StringUtil set(int index, char value) {
        StringUtil other = new StringUtil(builder);
        other.builder.setCharAt(index, value);
        return other;
    }

    /**
     * Method will be returned char[] and which will be contains
     * all elements field builder from 'int index' to 'int to'
     *
     * @param from
     * @param to
     * @return char[]
     */
    public char[] characters(int from, int to) {
        return builder.substring(from, to).toCharArray();
    }

    public StringUtil range(int from, int to) {
        return new StringUtil(builder.substring(from, to));
    }


    /**
     * in result of execution of this method will be insert value of argument 'int value'
     * in field 'builder' in place 'index' with create new instance StringUtil
     *
     * @arg int index, int value
     * @returns void
     */
    public StringUtil insert(int index, char value) {
        return new StringUtil(new StringUtil(builder).builder.insert(index, value));
    }

    public StringUtil insert(int index, String value) {
        return new StringUtil(new StringUtil(builder).builder.insert(index, value));
    }

    public StringUtil insert(int index, char[] value) {
        return new StringUtil(new StringUtil(builder).builder.insert(index, value));
    }

    public StringUtil insert(int index, StringBuilder value) {
        return new StringUtil(new StringUtil(builder).builder.insert(index, value));
    }

    public StringUtil insert(int index, StringBuffer value) {
        return new StringUtil(new StringUtil(builder).builder.insert(index, value));
    }

    public StringUtil insert(int index, StringUtil value) {
        return new StringUtil(new StringUtil(builder).builder.insert(index, value));
    }

    public <T> T convert(Function<StringUtil, T> function) {
        return function.apply(this);
    }

    public char[] allCharacters() {
        char[] dst = new char[builder.length()];
        builder.getChars(0, builder.length(), dst, 0);
        return dst;
    }

    @Override
    public StringUtil clone() {
        return new StringUtil(this.builder);
    }

    public String string() {
        return builder.toString();
    }

    public StringBuilder builder() {
        return new StringBuilder(builder);
    }

    public StringBuffer buffer() {
        return new StringBuffer(builder);
    }

    public boolean isNumber() {
        for (int i = 0; i < builder.length(); i++) {
            if (!Character.isDigit(builder.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public boolean isBool() {
        Boolean bool = new Boolean();
        return bool.equals(builder);
    }

    @Override
    public String toString() {
        return builder.toString();
    }

    public StringUtil soundex() {
        StringUtil result = new StringUtil();
        for (int i = 0; i < 4; i++) {
            char c = builder.charAt(i);
            c = Character.toUpperCase(c);
            c = (i > 0) ? replace(c) : c;
            result.builder.append(c);
        }
        return result;
    }

    private char replace(char c) {
        switch (c) {
            case 'B':
            case 'P':
            case 'F':
            case 'V':
                return '1';
            case 'C':
            case 'S':
            case 'K':
            case 'G':
            case 'J':
            case 'Q':
            case 'X':
            case 'Z':
                return  '2';
            case 'D':
            case 'T':
                return  '3';
            case 'L':
                return  '4';
            case 'M':
            case 'N':
                return  '5';
            case 'R':
                return  '6';
            default:
                break;
        }

        return '0';
    }

    @Override
    public int compareTo(StringUtil o) {
        return compare(this, o);
    }

    public byte[] bytes() {
        return builder.toString().getBytes();
    }

    public byte[] bytes(Charset charset) {
        return builder.toString().getBytes(charset);
    }

    private static class BuilderIterator implements Iterator<Character> {

        private final StringBuilder builder;
        private final int cursor;
        int current = 0;

        public BuilderIterator(StringBuilder builder) {
            this.builder = builder;
            this.cursor = 0;
        }

        @Override
        public boolean hasNext() {
            return current < builder.length();
        }

        @Override
        public Character next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return builder.charAt(current++);
        }
    }

    @Override
    public Iterator<Character> iterator() {
        return new BuilderIterator(builder);
    }

    public StringUtil remove(int from, int to) {
        return new StringUtil(new StringUtil(builder).builder.delete(from, to));
    }

    /**
     * Count method occurrences
     *
     * @param value
     * @return int
     */
    public int count(char value) {
        int count = 0;
        for (int i = 0; i < size(); i++) {
            if (builder.charAt(i) == value) {
                count++;
            }
        }
        return count;
    }

    /**
     * In result of execution of this method will be returned quantity of occurrences
     * 'value' type of String into builder
     *
     * @param value
     * @return int
     */
    public int count(String value) {
        int count = 0;
        int lastIndex = 0;

        while ((lastIndex = builder.toString().indexOf(value, lastIndex)) != -1) {
            count++;
            lastIndex += value.length();
        }
        return count;
    }

    public int count(char[] value) {
        int count = 0;
        int index = 0;
        while (index < builder.length()) {
            int indexOf = builder.indexOf(new String(value), index);
            if (indexOf == -1) {
                return count;
            }
            count++;
            index = indexOf + value.length;
        }
        return count;
    }

    public int count(StringBuilder value) {
        int count = 0;
        int lastIndex = 0;
        String str = value.toString();

        while ((lastIndex = builder.toString().indexOf(str, lastIndex)) != -1) {
            count++;
            lastIndex += value.length();
        }
        return count;
    }

    public int count(StringBuffer value) {
        int count = 0;
        int lastIndex = 0;
        String str = value.toString();

        while ((lastIndex = builder.toString().indexOf(str, lastIndex)) != -1) {
            count++;
            lastIndex += value.length();
        }
        return count;
    }

    public int count(StringUtil value) {
        int count = 0;
        int lastIndex = 0;
        String str = value.toString();

        while ((lastIndex = builder.toString().indexOf(str, lastIndex)) != -1) {
            count++;
            lastIndex += value.size();
        }
        return count;
    }

    // TODO: create copy of methods findFirst, findLast with odd parameter: offset
    // example: public int findFirst(char value, int offset) {...}

    public int findFirst(char value, int offset) {
        int findFirst = builder.toString().indexOf(value, offset);
        return findFirst;
    }

    public int findFirst(String value, int offset) {
        int findFirst = builder.indexOf(value, offset);
        return findFirst;
    }

    public int findFirst(char[] value, int offset) {
        String str = new String(value);
        int findFirst = builder.indexOf(str, offset);
        return findFirst;
    }

    public int findFirst(StringBuilder value, int offset) {
        int findFirst = builder.indexOf(value.toString(), offset);
        return findFirst;
    }

    public int findFirst(StringBuffer value, int offset) {
        int findFirst = builder.indexOf(value.toString(), offset);
        return findFirst;
    }

    public int findFirst(StringUtil value, int offset) {
        int findFirst = builder.indexOf(value.toString(), offset);
        return findFirst;
    }

    public int findLast(char value, int offset) {
        String str = String.valueOf(value);
        int findLast = builder.lastIndexOf(str, offset);
        return findLast;
    }

    public int findLast(String value, int offset) {
        return 0;
    }

    public int findLast(char[] value, int offset) {
        return 0;
    }

    public int findLast(StringBuilder value, int offset) {
        throw new UnsupportedOperationException();
    }

    public int findLast(StringBuffer value, int offset) {
        throw new UnsupportedOperationException();
    }

    public int findLast(StringUtil value, int offset) {
        throw new UnsupportedOperationException();
    }


    public boolean contains(char value) {
        throw new UnsupportedOperationException();
    }

    public boolean contains(String value) {
        throw new UnsupportedOperationException();
    }

    public boolean contains(char[] value) {
        throw new UnsupportedOperationException();
    }

    public boolean contains(StringBuilder value) {
        throw new UnsupportedOperationException();
    }

    public boolean contains(StringBuffer value) {
        throw new UnsupportedOperationException();
    }

    public boolean contains(StringUtil value) {
        throw new UnsupportedOperationException();
    }


    public StringUtil format(Object... parameters) {
        return new StringUtil(String.format(builder.toString(), parameters));
    }

    public StringUtil messageFormat(Object... parameters) {
        return new StringUtil(MessageFormat.format(builder.toString(), parameters));
    }

    public Stream<Character> stream() {
        throw new UnsupportedOperationException();
    }

    public int size() {
        return builder.length();
    }

    public StringUtil[] split(char value) {
        throw new UnsupportedOperationException();
    }

    public StringUtil[] split(String value) {
        throw new UnsupportedOperationException();
    }

    public StringUtil[] split(char[] value) {
        throw new UnsupportedOperationException();
    }

    public StringUtil[] split(StringBuilder value) {
        throw new UnsupportedOperationException();
    }

    public StringUtil[] split(StringBuffer value) {
        throw new UnsupportedOperationException();
    }

    public StringUtil[] split(StringUtil value) {
        throw new UnsupportedOperationException();
    }

    /**
     * Split string util into parts which has size <= size
     * e.g. 3, 3, 3, 2
     *
     * @param size
     * @return
     */
    public StringUtil[] split(int size) {
        throw new UnsupportedOperationException();
    }

    public StringUtil left(int length) {
        throw new UnsupportedOperationException();
    }

    public StringUtil left(int length, int from) {
        throw new UnsupportedOperationException();
    }

    public StringUtil right(int length) {
        throw new UnsupportedOperationException();
    }

    public boolean begins(char value) {
        throw new UnsupportedOperationException();
    }

    public boolean begins(String value) {
        throw new UnsupportedOperationException();
    }

    public boolean begins(char[] value) {
        throw new UnsupportedOperationException();
    }

    public boolean begins(StringBuilder value) {
        throw new UnsupportedOperationException();
    }

    public boolean begins(StringBuffer value) {
        throw new UnsupportedOperationException();
    }

    public boolean begins(StringUtil value) {
        throw new UnsupportedOperationException();
    }

    public boolean ends(char value) {
        throw new UnsupportedOperationException();
    }

    public boolean ends(String value) {
        throw new UnsupportedOperationException();
    }

    public boolean ends(char[] value) {
        throw new UnsupportedOperationException();
    }

    public boolean ends(StringBuilder value) {
        throw new UnsupportedOperationException();
    }

    public boolean ends(StringBuffer value) {
        throw new UnsupportedOperationException();
    }

    public boolean ends(StringUtil value) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int hashCode() {
        return builder.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (builder.equals(obj))
            return true;
        else
            return false;
    }

    // this method group uses default
    // type
    public boolean equals(String value) {
        throw new UnsupportedOperationException();
    }

    public boolean equals(char[] value) {
        throw new UnsupportedOperationException();
    }

    public boolean equals(StringBuilder value) {
        throw new UnsupportedOperationException();
    }

    public boolean equals(StringBuffer value) {
        throw new UnsupportedOperationException();
    }

    public boolean equals(StringUtil value) {
        throw new UnsupportedOperationException();
    }

    public boolean equals(String value, Equality equality) {
        throw new UnsupportedOperationException();
    }

    public boolean equals(char[] value, Equality equality) {
        throw new UnsupportedOperationException();
    }

    public boolean equals(StringBuilder value, Equality equality) {
        throw new UnsupportedOperationException();
    }

    public boolean equals(StringBuffer value, Equality equality) {
        throw new UnsupportedOperationException();
    }

    public boolean equals(StringUtil value, Equality equality) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int compare(StringUtil o1, StringUtil o2) {
        return o1.builder.toString().compareTo(o2.builder.toString());
    }
}