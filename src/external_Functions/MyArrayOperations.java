package external_Functions;

public class MyArrayOperations {
    public static String toString(int[] arr) {
        if (arr == null) {
            return "null";
        }
        if (arr.length == 0) {
            return "[]";
        }

        StringBuilder result = new StringBuilder();
        result.append('[');
        for (int i = 0; i < arr.length; i++) {
            result.append(arr[i]);
            if (i < arr.length - 1) {
                result.append(", ");
            }
        }
        result.append(']');
        return result.toString();
    }

    public static String toString(String[] arr) {
        if (arr == null) {
            return "null";
        }
        if (arr.length == 0) {
            return "[]";
        }

        StringBuilder result = new StringBuilder();
        result.append('[');
        for (int i = 0; i < arr.length; i++) {
            result.append('"').append(arr[i]).append('"');
            if (i < arr.length - 1) {
                result.append(", ");
            }
        }
        result.append(']');
        return result.toString();
    }

    public static int[] copyOf(int[] original, int newLength) {
        if (original == null) {
            return null;
        }

        int[] copy = new int[newLength];
        int copyLength = Math.min(original.length, newLength);
        for (int i = 0; i < copyLength; i++) {
            copy[i] = original[i];
        }
        return copy;
    }

    public static String[] copyOf(String[] original, int newLength) {
        if (original == null) {
            return null;
        }

        String[] copy = new String[newLength];
        int copyLength = Math.min(original.length, newLength);
        for (int i = 0; i < copyLength; i++) {
            copy[i] = original[i];
        }
        return copy;
    }
}