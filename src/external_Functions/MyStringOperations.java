package external_Functions;

public class MyStringOperations {
    public static String replaceAll(String str, String target, String replacement) {
        if (str == null || target == null || replacement == null) {
            return str;
        }

        StringBuilder result = new StringBuilder();
        int i = 0;
        while (i < str.length()) {
            boolean found = true;
            if (i <= str.length() - target.length()) {
                for (int j = 0; j < target.length(); j++) {
                    if (str.charAt(i + j) != target.charAt(j)) {
                        found = false;
                        break;
                    }
                }
                if (found) {
                    result.append(replacement);
                    i += target.length();
                    continue;
                }
            }
            result.append(str.charAt(i));
            i++;
        }
        return result.toString();
    }

    public static String replace(String str, char oldChar, char newChar) {
        if (str == null) {
            return str;
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char currentChar = str.charAt(i);
            result.append(currentChar == oldChar ? newChar : currentChar);
        }
        return result.toString();
    }

    public static String trim(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }

        int start = 0;
        int end = str.length() - 1;

        while (start <= end && Character.isWhitespace(str.charAt(start))) {
            start++;
        }

        while (end >= start && Character.isWhitespace(str.charAt(end))) {
            end--;
        }

        return str.substring(start, end + 1);
    }

    public static String toUpperCase(String str) {
        if (str == null) {
            return str;
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c >= 'a' && c <= 'z') {
                result.append((char)(c - 32));
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }
}