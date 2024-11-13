package external_Functions;

public class toLower {
    public String toLower(String str) {
        char[] chars = new char[str.length()];

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if (c >= 'A' && c <= 'Z') {
                chars[i] = (char) (c + 32);
            } else {
                chars[i] = c;
            }
        }
        return new String(chars);
    }


    public static void main(String[] args) {
        toLower toLower = new toLower();
        System.out.println(toLower.toLower("hello65"));
    }
}
