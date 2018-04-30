package org.util.string;

import java.lang.reflect.Method;
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

    public enum Trim {
        BOTH,
        LEADING,
        TRAILING,

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
        char[] dst = new char[to - from];
        builder.getChars(from, to, dst, 0);
        return dst;
    }

    public StringUtil util(int from, int to) {
        return new StringUtil(builder.substring(from, to));
    }

    /**
     * In result of execution of this method will be insert value of argument 'int value'
     * in field 'builder' in place 'index' with create new instance StringUtil
     *
     * @arg int index, int value
     * @returns void
     */
    public StringUtil insert(int index, char value) {
        StringUtil other = new StringUtil(builder);
        other.builder.insert(index, value);
        return other;
    }

    public StringUtil insert(int index, String value) {
        StringUtil other = new StringUtil(builder);
        other.builder.insert(index, value);
        return other;
    }

    public StringUtil insert(int index, char[] value) {
        StringUtil other = new StringUtil(builder);
        other.builder.insert(index, value);
        return other;
    }

    public StringUtil insert(int index, StringBuilder value) {
        StringUtil other = new StringUtil(builder);
        other.builder.insert(index, value);
        return other;
    }

    public StringUtil insert(int index, StringBuffer value) {
        StringUtil other = new StringUtil(builder);
        other.builder.insert(index, value);
        return other;
    }

    public StringUtil insert(int index, StringUtil value) {
        StringUtil other = new StringUtil(builder);
        other.builder.insert(index, value);
        return other;
    }

    public <T> T convert(Function<StringUtil, T> function) {
        return function.apply(this);
    }

    public char[] characters() {
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
        Boolean bool = new Boolean("true");
        Boolean bool1 = new Boolean("false");
        if (builder.toString().equals(bool.toString()) || builder.toString().equals(bool1.toString())) {
            return true;
        } else {
            return false;
        }
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
                return '2';
            case 'D':
            case 'T':
                return '3';
            case 'L':
                return '4';
            case 'M':
            case 'N':
                return '5';
            case 'R':
                return '6';
            default:
                break;
        }

        return '0';
    }

    @Override
    public int compareTo(StringUtil o) {
        return toString().compareTo(o.toString());
    }

    public byte[] bytes() {
        return toString().getBytes();
    }

    public byte[] bytes(Charset charset) {
        return toString().getBytes(charset);
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

        while ((lastIndex = builder.indexOf(value, lastIndex)) != -1) {
            count++;
            lastIndex += value.length();
        }
        return count;
    }

    public int count(char[] value) {
        int count = 0;
        int index = 0;
        String str = value.toString();
        while (index < size()) {
            int indexOf = builder.indexOf(str, index);
            if (indexOf == -1) {
                return count;
            }
            count++;
            index = indexOf + str.length();
        }
        return count;
    }

    public int count(StringBuilder value) {
        int count = 0;
        int lastIndex = 0;
        String str = value.toString();

        while ((lastIndex = builder.indexOf(str, lastIndex)) != -1) {
            count++;
            lastIndex += value.length();
        }
        return count;
    }

    public int count(StringBuffer value) {
        int count = 0;
        int lastIndex = 0;
        String str = value.toString();

        while ((lastIndex = builder.indexOf(str, lastIndex)) != -1) {
            count++;
            lastIndex += value.length();
        }
        return count;
    }

    public int count(StringUtil value) {
        int count = 0;
        int lastIndex = 0;
        String str = value.toString();

        while ((lastIndex = builder.indexOf(str, lastIndex)) != -1) {
            count++;
            lastIndex += value.size();
        }
        return count;
    }

    public int findFirst(char value, int offset) {
        return builder.indexOf(Character.toString(value), offset);
    }

    public int findFirst(char value) {
        return findFirst(value, 0);
    }

    public int findFirst(String value, int offset) {
        return builder.indexOf(value, offset);
    }

    public int findFirst(String value) {
        return findFirst(value, 0);
    }

    public int findFirst(char[] value, int offset) {
        return builder.indexOf(new String(value), offset);
    }

    public int findFirst(char[] value) {
        return findFirst(value, 0);
    }

    public int findFirst(StringBuilder value, int offset) {
        return builder.indexOf(value.toString(), offset);
    }

    public int findFirst(StringBuilder value) {
        return findFirst(value, 0);
    }

    public int findFirst(StringBuffer value, int offset) {
        return builder.indexOf(value.toString(), offset);
    }

    public int findFirst(StringBuffer value) {
        return findFirst(value, 0);
    }

    public int findFirst(StringUtil value, int offset) {
        return builder.indexOf(value.toString(), offset);
    }

    public int findFirst(StringUtil value) {
        return findFirst(value, 0);
    }

    public int findLast(char value, int offset) {
        return builder.lastIndexOf(Character.toString(value), offset);
    }

    public int findLast(char value) {
        return findLast(value, builder.length());
    }

    public int findLast(String value, int offset) {
        return builder.lastIndexOf(value, offset);
    }

    public int findLast(String value) {
        return findLast(value, builder.length());
    }

    public int findLast(char[] value, int offset) {
        return builder.lastIndexOf(new String(value), offset);
    }

    public int findLast(char[] value) {
        return findLast(value, builder.length());
    }

    public int findLast(StringBuilder value, int offset) {
        return builder.lastIndexOf(value.toString(), offset);
    }

    public int findLast(StringBuilder value) {
        return findLast(value, builder.length());
    }

    public int findLast(StringBuffer value, int offset) {
        return builder.lastIndexOf(value.toString(), offset);
    }

    public int findLast(StringBuffer value) {
        return findLast(value, builder.length());
    }

    public int findLast(StringUtil value, int offset) {
        return builder.lastIndexOf(value.toString(), offset);
    }

    public int findLast(StringUtil value) {
        return findLast(value, builder.length());
    }

    public boolean contains(char value) {
        return findFirst(value) != -1;
    }

    public boolean contains(String value) {
        return findFirst(value) != -1;
    }

    public boolean contains(char[] value) {
        return findFirst(value) != -1;
    }

    public boolean contains(StringBuilder value) {
        return findFirst(value) != -1;
    }

    public boolean contains(StringBuffer value) {
        return findFirst(value) != -1;
    }

    public boolean contains(StringUtil value) {
        return findFirst(value) != -1;
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
        String[] words = builder.toString().split(Character.toString(value));
        StringUtil[] arrUtil = new StringUtil[words.length];

        for (int i = 0; i < words.length; i++) {
            arrUtil[i] = new StringUtil(words[i]);
        }
        return arrUtil;
    }

    public StringUtil[] split(String value) {
        String[] words = builder.toString().split(value);
        StringUtil[] arrUtil = new StringUtil[words.length];

        for (int i = 0; i < words.length; i++) {
            arrUtil[i] = new StringUtil(words[i]);
        }
        return arrUtil;
    }

    public StringUtil[] split(char[] value) {
        String[] words = builder.toString().split(new String(value));
        StringUtil[] arrUtil = new StringUtil[words.length];

        for (int i = 0; i < words.length; i++) {
            arrUtil[i] = new StringUtil(words[i]);
        }
        return arrUtil;
    }

    public StringUtil[] split(StringBuilder value) {
        String[] words = builder.toString().split(new String(value));
        StringUtil[] arrUtil = new StringUtil[words.length];

        for (int i = 0; i < words.length; i++) {
            arrUtil[i] = new StringUtil(words[i]);
        }
        return arrUtil;

    }

    public StringUtil[] split(StringBuffer value) {
        String[] words = builder.toString().split(new String(value));
        StringUtil[] arrUtil = new StringUtil[words.length];

        for (int i = 0; i < words.length; i++) {
            arrUtil[i] = new StringUtil(words[i]);
        }
        return arrUtil;
    }

    public StringUtil[] split(StringUtil value) {
        String[] words = builder.toString().split(value.toString());
        StringUtil[] arrUtil = new StringUtil[words.length];

        for (int i = 0; i < words.length; i++) {
            arrUtil[i] = new StringUtil(words[i]);
        }
        return arrUtil;
    }

    /**
     * Split string util into parts which has size <= size
     * e.g. 3, 3, 3, 2
     *
     * @param sizePart
     * @return
     */
    public StringUtil[] split(int sizePart) {
        int sizeTemp = sizePart;
        int count1 = size() % sizePart > 0 ? size() / sizePart + 1 : size() / sizePart;
        int dif = sizePart * count1 - size();
        StringUtil[] arrUtil = new StringUtil[count1];

        for (int i = 0, j = 0; j < count1; i = i + sizePart, sizeTemp += sizePart, j++) {
            if (dif != 0) {
                if (sizeTemp - size() < 0) {
                    arrUtil[j] = new StringUtil(builder.substring(i, sizeTemp));
                } else {
                    arrUtil[j] = new StringUtil(builder.substring(i, size()));
                }
            }
            if (dif == 0) {
                arrUtil[j] = new StringUtil(builder.substring(i, sizeTemp));
            }
        }
        return arrUtil;
    }

    // return substring with length 'length' starting from 0 pos
    public StringUtil left(int length) {
        return new StringUtil(builder.substring(0, length));
    }

    // return substring with length = length starting from 'from' pos
    public StringUtil left(int length, int from) {
        return new StringUtil(builder.substring(from, from + length));
    }

    public StringUtil right(int length) {
        return new StringUtil(builder.substring(size() - length, size()));
    }

    public boolean begins(char value) {
        return builder.charAt(0) == value;
    }

    public boolean begins(String value) {
        return builder.indexOf(value) == 0;
    }

    public boolean begins(char[] value) {
        return builder.indexOf(new String(value)) == 0;
    }

    public boolean begins(StringBuilder value) {
        return builder.indexOf(new String(value)) == 0;
    }

    public boolean begins(StringBuffer value) {
        return builder.indexOf(new String(value)) == 0;
    }

    public boolean begins(StringUtil value) {
        return builder.indexOf(value.toString()) == 0;
    }

    public boolean ends(char value) {
        return builder.charAt(size() - 1) == value;
    }

    public boolean ends(String value) {
        return builder.lastIndexOf(value) == size() - 1;
    }

    public boolean ends(char[] value) {
        return builder.lastIndexOf(new String(value)) == size() - 1;
    }

    public boolean ends(StringBuilder value) {
        return builder.indexOf(new String(value)) == size() - 1;
    }

    public boolean ends(StringBuffer value) {
        return builder.indexOf(new String(value)) == size() - 1;
    }

    public boolean ends(StringUtil value) {
        return builder.indexOf(value.toString()) == size() - 1;
    }

    @Override
    public int hashCode() {
        return builder.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        boolean bool = false;
        if (builder.equals(obj) || this == obj || builder.toString().equals(obj.toString()))
            bool = true;
        else if (obj == null || builder.getClass() != obj.getClass() || obj.toString().length() != builder.length())
            bool = false;
        return bool;
    }

    // this method group uses default
    // type
    public boolean equals(String value) {
        return toString().equals(value);
    }

    public boolean equals(char[] value) {
        return toString().equals(new String(value));
    }

    public boolean equals(StringBuilder value) {
        return builder.equals(value);
    }

    public boolean equals(StringBuffer value) {
        return builder.equals(value);
    }

    public boolean equals(StringUtil value) {
        return toString().equals(value.toString());
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

    public StringUtil trim() {
        return trim(Trim.BOTH);
    }

    public StringUtil trim(Trim trim) {

        String str = "";
        char[] charArray = new char[size()];

        builder.getChars(0, size(), charArray, 0);
        if (trim == Trim.BOTH) {
            str = toString().trim();
        } else if (trim == Trim.LEADING) {
            int j = 0;
            for (int i = 0; i < size(); i++) {
                if (charArray[i] != ' ' && j == 0) {
                    j = i;
                }
            }
            if (j == 0) {
                j = size();
            }
            str = toString().substring(j, size());
        } else if (trim == Trim.TRAILING) {
            int j = 0;
            for (int i = size() - 1; i > 0; i--) {
                if (charArray[i] != ' ' && j == 0) {
                    j = i + 1;
                }
            }
            str = toString().substring(0, j);
        }
        return new StringUtil(str);

    }

    @Override
    public int compare(StringUtil o1, StringUtil o2) {
        return o1.compareTo(o2);
    }
}