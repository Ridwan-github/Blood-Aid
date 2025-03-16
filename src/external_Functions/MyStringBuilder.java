package external_Functions;

public class MyStringBuilder {
    private char[] value;
    private int count;
    private static final int DEFAULT_CAPACITY = 16;

    public MyStringBuilder() {
        value = new char[DEFAULT_CAPACITY];
        count = 0;
    }

    public MyStringBuilder(String str) {
        if (str == null) {
            value = new char[DEFAULT_CAPACITY];
            count = 0;
        } else {
            value = new char[str.length() + DEFAULT_CAPACITY];
            append(str);
        }
    }

    public MyStringBuilder append(String str) {
        if (str == null) {
            return append("null");
        }

        int len = str.length();
        ensureCapacity(count + len);
        for (int i = 0; i < len; i++) {
            value[count++] = str.charAt(i);
        }
        return this;
    }

    public MyStringBuilder append(char c) {
        ensureCapacity(count + 1);
        value[count++] = c;
        return this;
    }

    public MyStringBuilder deleteCharAt(int index) {
        if (index < 0 || index >= count) {
            throw new StringIndexOutOfBoundsException(index);
        }
        System.arraycopy(value, index + 1, value, index, count - index - 1);
        count--;
        return this;
    }

    private void ensureCapacity(int minimumCapacity) {
        if (minimumCapacity > value.length) {
            int newCapacity = Math.max(minimumCapacity, value.length * 2);
            char[] newValue = new char[newCapacity];
            System.arraycopy(value, 0, newValue, 0, count);
            value = newValue;
        }
    }

    public String toString() {
        return new String(value, 0, count);
    }

    public int length() {
        return count;
    }

    public void clear() {
        count = 0;
    }
}