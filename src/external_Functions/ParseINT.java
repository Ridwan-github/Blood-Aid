package external_Functions;

public class ParseINT {
    public static int stringToInt(String str) {
        int result = 0;
        int sign = 1;
        int i = 0;

        if (str.charAt(0) == '-') {
            sign = -1;
            i = 1;
        } else if (str.charAt(0) == '+') {
            i = 1;
        }

        for (; i < str.length(); i++) {
            char c = str.charAt(i);

            int digit = c - '0';

            if (digit < 0 || digit > 9) {
                throw new IllegalArgumentException("Invalid character in input string");
            }

            result = result * 10 + digit;
        }

        return result * sign;
    }

    public String intTOString(int num) {
        return "" + num;
    }

    public static void main(String[] args) {
        String str = "-12345";
        int number = stringToInt(str);
        System.out.println("Converted number: " + number);
    }
}
