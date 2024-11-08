package Code;

public class DonorValidator {
    public static boolean validateName(String name){
        if(name == null || name.length() < 2 || name.length() > 100){
            return false;
        }
        for(int i = 0; i < name.length(); i++){
            char c = name.charAt(i);
            if(!Character.isAlphabetic(c) && c != ' '){
                return false;
            }
        }
        return true;
    }
}
