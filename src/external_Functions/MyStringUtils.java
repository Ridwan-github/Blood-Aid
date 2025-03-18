package external_Functions;

public class MyStringUtils {
    public static boolean contains(String str, String substr) {
        if (str == null || substr == null) {
            return false;
        }
        
        for (int i = 0; i <= str.length() - substr.length(); i++) {
            boolean found = true;
            for (int j = 0; j < substr.length(); j++) {
                if (str.charAt(i + j) != substr.charAt(j)) {
                    found = false;
                    break;
                }
            }
            if (found) {
                return true;
            }
        }
        return false;
    }

    public static boolean startsWith(String str, String prefix) {
        if (str == null || prefix == null || prefix.length() > str.length()) {
            return false;
        }
        
        for (int i = 0; i < prefix.length(); i++) {
            if (str.charAt(i) != prefix.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public static boolean endsWith(String str, String suffix) {
        if (str == null || suffix == null || suffix.length() > str.length()) {
            return false;
        }
        
        int strOffset = str.length() - suffix.length();
        for (int i = 0; i < suffix.length(); i++) {
            if (str.charAt(strOffset + i) != suffix.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public static int indexOf(String str, String substr) {
        if (str == null || substr == null) {
            return -1;
        }
        
        for (int i = 0; i <= str.length() - substr.length(); i++) {
            boolean found = true;
            for (int j = 0; j < substr.length(); j++) {
                if (str.charAt(i + j) != substr.charAt(j)) {
                    found = false;
                    break;
                }
            }
            if (found) {
                return i;
            }
        }
        return -1;
    }

    public static int indexOf(String str, char ch) {
        if (str == null) {
            return -1;
        }
        
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ch) {
                return i;
            }
        }
        return -1;
    }
}