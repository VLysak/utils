package org.util.string;

import java.nio.charset.Charset;
import java.text.MessageFormat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Function;
import java.util.stream.Stream;

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

    private StringUtil() {
        this.builder = new StringBuilder();
    }

    /**
     * StringUtil constructor.
     * Initialize "StringBuilder builder" by concatenate "String data"
     *
     * @param data
     * @returns new StringUtil (String data)
     */
    public StringUtil(String data) {
        this.builder = new StringBuilder(data);
    }

    /**
     * StringUtil constructor.
     * Initialize "StringBuilder builder" by concatenate "StringBuffer data"
     *
     * @param data
     * @returns new StringUtil (StringBuffer data)
     */

    public StringUtil(StringBuffer data) {
        this.builder = new StringBuilder(data);

    }

    /**
     * StringUtil constructor.
     * Initialize "StringBuilder builder" by concatenate "StringBuilder data"
     * new StringUtil (StringBuilder data)
     *
     * @param data
     * @returns void
     */

    public StringUtil(StringBuilder data) {
        this.builder = new StringBuilder(data);
    }

    /**
     * StringUtil constructor.
     * Initialize "StringBuilder builder" by concatenate "char [] data"
     *
     * @param data
     * @returns new StringUtil (char [] data)
     */

    public StringUtil(char[] data) {
        this.builder = new StringBuilder().append(data);
    }

    /**
     * StringUtil constructor.
     * Initialize "StringBuilder builder" by concatenate "byte [] data"
     *
     * @param data
     * @returns new StringUtil (byte [] data)
     */

    public StringUtil(byte[] data, Charset charset) {
        this(new String(data, charset));
    }

    /// ALL METHODS MUST RETURN NEW EXEMPLAR OF StringUtil which replace old StringUtil (other object)

    /**
     * void append StringBuffer data
     * this method append StringBuffer data to field StringBuilder builder
     *
     * @param data
     * @returns void
     */
    public StringUtil append(StringBuffer data) {
        StringUtil other = new StringUtil();
        other.builder.append(builder);
        other.builder.append(data);
        return other;
    }

    /**
     * this method returns new instance of StringUtil
     * with append String data to field StringBuilder builder
     *
     * @param data
     * @returns StringUtil
     */
    public StringUtil append(String data) {
        StringUtil other = new StringUtil();
        other.builder.append(builder);
        other.builder.append(data);
        return other;
    }

    /**
     * void append StringBui
     * lder data
     * this method append StringBuilder data to field StringBuilder builder
     *
     * @param data
     * @returns void
     */
    public StringUtil append(StringBuilder data) {
        StringUtil other = new StringUtil();
        other.builder.append(builder);
        other.builder.append(data);
        return other;
    }

    /**
     * void append  data
     * this method append StringBuilder data to field StringBuilder builder
     *
     * @param data
     * @returns void
     */
    public StringUtil append(char[] data) {
        StringUtil other = new StringUtil();
        other.builder.append(builder);
        other.builder.append(data);
        return other;
    }

    /**
     * void append data from 'byte[] data'  with 'Charset charset' over call of constructor with
     * parameters types (byte[] data, Charset charset)
     *
     * @param data
     * @returns void
     */
    public StringUtil append(byte[] data, Charset charset) {
        StringUtil other = new StringUtil();
        StringUtil other1 = new StringUtil(data, charset);
        other.builder.append(other);
        other.builder.append(other1);
        return other;
    }

    /**
     * void prepend StringBuffer data
     * this method prepend data to "StringBuffer data" from parameters
     *
     * @param data
     * @returns void
     */
    public StringUtil prepend(StringBuffer data) {
        StringUtil other = new StringUtil();
        other.builder.append(data);
        other.builder.append(builder);
        return other;
    }

    /**
     * void prepend String data
     * this method prepend data from parameter to field builder
     *
     * @param data
     * @returns void
     */
    public StringUtil prepend(String data) {
        StringUtil other = new StringUtil();
        other.builder.append(data);
        other.builder.append(builder);
        return other;
    }

    /**
     * void prepend StringBuilder data
     * this method prepend StringBuilder data to field StringBuilder builder
     *
     * @param data
     * @returns void
     */
    public StringUtil prepend(StringBuilder data) {
        StringUtil other = new StringUtil();
        other.builder.append(data);
        other.builder.append(builder);
        return other;
    }

    /**
     * void prepend data
     * this method prepend 'char[] data' to field 'StringBuilder builder'
     * <p>
     * 1. old data 'StringBuilder builder' append to new data 'char[] data'
     * 1.1 convert 'char data' to type 'String'
     * 1.1.1 create variable 'String temp'
     * 1.1.2 to temp add new data from parameters
     * 1.2 temp + old data from field 'builder'
     * <p>
     * 2.
     *
     * @param data
     * @returns void
     */
    public StringUtil prepend(char[] data) {
        StringUtil other = new StringUtil();
        other.builder.append(data);
        other.builder.append(builder);
        return other;
    }

    /**
     * void append data from 'byte[] data'  with 'Charset charset' over call of constructor with
     * parameters types (byte[] data, Charset charset)
     * 1. prepend new data from 'byte[] data' to old data 'StringBuilder builder' and create new instance of
     * StringUtil
     * 1.1 take new data 'byte[] data' and concatenate with old data 'StringBuilder builder'
     * 1.1.1 'byte[] data' convert to type compatible with 'StringBuilder builder'
     * 1.1.2 concatenate new data with old data
     * 1.2 create new instance StringUtil by call constructor with new data as parameter
     *
     * @param data
     * @returns void
     */
    public StringUtil prepend(byte[] data, Charset charset) {
        StringUtil other = new StringUtil();
        StringUtil other1 = new StringUtil(data, charset);
        other.builder.append(other1);
        other.builder.append(other);
        return other;
    }

    /**
     * returns new instance of StringUtil which have reversed order of its data(field builder)
     *
     * @returns StringUtil
     */
    public StringUtil reverse() {
        return new StringUtil(builder.reverse());
    }

    /**
     * returns char with index
     *
     * @returns StringUtil
     */

    public char getCharacter(int index) {
        return builder.charAt(index);
    }

    /**
     * in result of execute this method argument 'velue' will be set in field builder to 'index'
     * 1. set value in field builder with index
     * 1.1 builder
     *
     * @arg int index, char value
     * @returns void
     */

    public StringUtil set(int index, char value) {
        StringUtil other = new StringUtil();
        other.builder.toString().toCharArray()[index] = value;
        return other;
    }

    /**
     * in result of execution of this method will be returned char[] and which
     * will be contains all elements field builder from 'int index' to 'int to'
     *
     * @arg int from, int to
     * @returns char[]
     */

    public char[] characters(int from, int to) {
        return builder.substring(from, to).toCharArray();
    }

    public StringUtil range(int from, int to) {
        StringUtil other = new StringUtil();
        other.builder.substring(from, to);
        return other;
    }

    /**
     * in result of execution of this method will be insert value of argument 'int value'
     * in field 'builder' in place 'index' with create new instance StringUtil
     *
     * @arg int index, int value
     * @returns void
     */
    public StringUtil insert(int index, char value) {
        return new StringUtil(builder.insert(index, value));
    }

    public StringUtil insert(int index, String value) {
        return new StringUtil(builder.insert(index, value));
    }

    public StringUtil insert(int index, char[] value) {
        return new StringUtil(builder.insert(index, value));
    }

    public StringUtil insert(int index, StringBuilder value) {
        return new StringUtil(builder.insert(index, value));
    }

    public StringUtil insert(int index, StringBuffer value) {
        return new StringUtil(builder.insert(index, value));
    }

    public StringUtil insert(int index, StringUtil value) {
        return new StringUtil(builder.insert(index, value));
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
        throw new UnsupportedOperationException();
    }

    @Override
    public String toString() {
        return builder.toString();
    }

    public StringUtil soundex() {
        char[] charArray = builder.toString().toUpperCase().toCharArray();
        for (int i = 1; i < 4; i++) {
            switch (charArray[i]) {
                case 'B':
                case 'P':
                case 'F':
                case 'V':
                    charArray[i] = '1';
                    break;
                case 'C':
                case 'S':
                case 'K':
                case 'G':
                case 'J':
                case 'Q':
                case 'X':
                case 'Z':
                    charArray[i] = '2';
                    break;
                case 'D':
                case 'T':
                    charArray[i] = '3';
                    break;
                case 'L':
                    charArray[i] = '4';
                    break;
                case 'M':
                case 'N':
                    charArray[i] = '5';
                    break;
                case 'R':
                    charArray[i] = '6';
                    break;
                default:
                    charArray[i] = '0';
                    break;
            }
        }
        char[] charArrayTemp = new char[4];
        System.arraycopy(charArray, 0, charArrayTemp, 0, charArrayTemp.length);

        return new StringUtil(new String(charArrayTemp));
    }

    @Override
    public int compareTo(StringUtil o) {

        if (builder.equals(o))
            return 0;
        else if (builder.length() - o.size() > 0)
            return 1;
        else
            return -1;
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
        StringUtil other = new StringUtil();
        other.builder.delete(from, to);
        return other;
    }

    /**
     * In result of execution of this method will be returned quantity of occurrences
     * 'value' type of char into builder
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
        int lastIndex = 0;
        String str = "";
        for (int i = 0; i < value.length; i++) {
            if(value[i] == '[') {

            }
        }

        int index = 0;
        while (index < value.length) {
            int indexOf = builder.indexOf(new String(value), index);
            if (indexOf == -1) {
                return count;
            }
            count++;
            index = indexOf + value.length;
        }
        return count;

        String str = new String()
        String str = Arrays.toString(value);
        while ((lastIndex = builder.toString().indexOf(str, lastIndex)) != -1) {
            count++;
            lastIndex += str.length();
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
    public int findFirst(char value) {
        return 0;
    }

    public int findFirst(String value) {
        return 0;
    }

    public int findFirst(char[] value) {
        return 0;
    }

    public int findFirst(StringBuilder value) {
        throw new UnsupportedOperationException();
    }

    public int findFirst(StringBuffer value) {
        throw new UnsupportedOperationException();
    }

    public int findFirst(StringUtil value) {
        throw new UnsupportedOperationException();
    }

    public int findLast(char value) {
        return 0;
    }

    public int findLast(String value) {
        return 0;
    }

    public int findLast(char[] value) {
        return 0;
    }

    public int findLast(StringBuilder value) {
        throw new UnsupportedOperationException();
    }

    public int findLast(StringBuffer value) {
        throw new UnsupportedOperationException();
    }

    public int findLast(StringUtil value) {
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
        throw new UnsupportedOperationException();
    }

    // this method group uses default equality type
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
        throw new UnsupportedOperationException();
    }
}