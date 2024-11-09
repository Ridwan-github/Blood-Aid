package Code;

import external_Functions.validateUsername;

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
    public static boolean validatePhoneNumber(String phoneNumber) {
        if (phoneNumber == null || phoneNumber.length() < 10 || phoneNumber.length() > 15) {
            return false;
        }
        for (int i = 0; i < phoneNumber.length(); i++) {
            if (!Character.isDigit(phoneNumber.charAt(i))) {
                return false;
            }
        }

        return true;
    }
    public static boolean validateEmail(String email){
        if(email == null || email.length() < 5){
            return false;
        }

        int atIndex = email.indexOf('@');
        if(atIndex == 1 || atIndex == 0 || atIndex == email.length() -1){
            return false;
        }

        String domain = email.substring(atIndex + 1);
        if(domain.indexOf('.') == -1){
            return  false;
        }
        return true;
    }

    public static boolean validateCity(String city){
        if(city == null || city.length() < 2 || city.length() > 50){
            return false;
        }
        for(int i = 0; i < city.length(); i++){
            char c = city.charAt(i);
            if(!Character.isAlphabetic(c)){
                return false;
            }
        }
        return true;
    }

    public static boolean validateArea(String area){
        if(area == null || area.length() < 2 || area.length() > 50){
            return false;
        }
        return true;
    }

    public static boolean validateNID(String NID){
        if (NID == null || NID.length() < 10 || NID.length() > 10) {
            return false;
        }
        for (int i = 0; i < NID.length(); i++) {
            if (!Character.isDigit(NID.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static boolean validatePassword(String password){
        if (password == null || password.length() < 8 || password.length() > 32) {
            return false;
        }
        boolean hasUpper = false;
        boolean hasLower = false;
        boolean hasDigit = false;
        boolean hasSpecial = false;
        for(int i = 0; i < password.length(); i++){
            char c = password.charAt(i);
            if(Character.isUpperCase(c)){
                hasUpper = true;
            } else if (Character.isLowerCase(c)) {
                hasLower = true;
            } else if (Character.isDigit(c)) {
                hasDigit = true;
            } else if (!Character.isLetterOrDigit(c)) {
                hasSpecial = true;
            }
        }
        return hasUpper && hasLower && hasDigit && hasSpecial;
    }

    public static boolean validateZipCode(String zip){
        if (zip == null || zip.length() < 4 || zip.length() > 4) {
            return false;
        }
        for (int i = 0; i < zip.length(); i++) {
            if (!Character.isDigit(zip.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}
