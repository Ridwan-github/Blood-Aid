package external_Functions;

import java.util.Scanner;

public class MyString {

    public static int length(String str) {
        int count = 0;
        for (char c : str.toCharArray()) {
            count++;
        }
        return count;
    }

    public static char charAt(String str, int index) {
        if (index < 0 || index >= length(str)) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        return str.toCharArray()[index];
    }

    public static int indexAt(String str, char ch) {
        for (int i = 0; i < length(str); i++) {
            if (charAt(str, i) == ch) {
                return i;
            }
        }
        return -1;
    }

    public static String substring(String str, int start, int end) {
        if (start < 0 || end > length(str) || start > end) {
            throw new IndexOutOfBoundsException("Invalid range");
        }
        String result = "";
        for (int i = start; i < end; i++) {
            result += charAt(str, i);
        }
        return result;
    }

    public static boolean matches(String str, String pattern) {
        return str.equals(pattern);
    }

    public static boolean equals(String str1, String str2) {
        if (length(str1) != length(str2)) {
            return false;
        }
        for (int i = 0; i < length(str1); i++) {
            if (charAt(str1, i) != charAt(str2, i)) {
                return false;
            }
        }
        return true;
    }

    public static String[] split(String str, char delimiter) {
        int count = 1;
        for (char c : str.toCharArray()) {
            if (c == delimiter) {
                count++;
            }
        }

        String[] result = new String[count];
        String temp = "";
        int index = 0;

        for (char c : str.toCharArray()) {
            if (c == delimiter) {
                result[index++] = temp;
                temp = "";
            } else {
                temp += c;
            }
        }
        result[index] = temp;

        return result;
    }
}

