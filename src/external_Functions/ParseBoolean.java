package external_Functions;

public class ParseBoolean {
    public static boolean parseBoolean(String str) {
        if (str == null) {
            return false;
        }
        
        toLower toLower = new toLower();
        String lowerStr = toLower.toLower(str);
        
        return MyString.equals(lowerStr, "true");
    }
    
    public static String toString(boolean b) {
        return b ? "true" : "false";
    }
}