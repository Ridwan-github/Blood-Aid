package external_Functions;

public class MySplit {
    public static String[] split(String str, String delimiter) {
        if (str == null || delimiter == null || delimiter.length() == 0) {
            return new String[0];
        }

        MyVector parts = new MyVector();
        int startIndex = 0;
        int delimiterIndex;

        while ((delimiterIndex = MyStringUtils.indexOf(str.substring(startIndex), delimiter)) != -1) {
            parts.add(str.substring(startIndex, startIndex + delimiterIndex));
            startIndex += delimiterIndex + delimiter.length();
        }

        if (startIndex <= str.length()) {
            parts.add(str.substring(startIndex));
        }

        String[] result = new String[parts.size()];
        for (int i = 0; i < parts.size(); i++) {
            result[i] = parts.get(i);
        }

        return result;
    }
}