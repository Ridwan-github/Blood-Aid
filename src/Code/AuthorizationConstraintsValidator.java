package Code;

import external_Functions.DateDifference;
import external_Functions.MyDate;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;

public class AuthorizationConstraintsValidator {
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
    public static boolean validateFirstThreeDigits(String PhoneNumber){
        if(PhoneNumber.length() == 11){
            if (PhoneNumber.charAt(0) == '0' && PhoneNumber.charAt(1) == '1' && (PhoneNumber.charAt(2) == '9' || PhoneNumber.charAt(2) == '7' ||
                            PhoneNumber.charAt(2) == '3' || PhoneNumber.charAt(2) == '4' ||
                            PhoneNumber.charAt(2) == '5' || PhoneNumber.charAt(2)=='6')) {
                return true;
            }

        }
        return false;
    }

    public static boolean repeatPhoneNumber(String phoneNumber){
        try{
            File file = new File("Donor.txt");
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] donor = line.split(";");
                if (donor.length > 12) {
                    if (donor[1].equals(phoneNumber)) {
                        return false;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return  true;
    }

    public static boolean recipientRepeatPhone(String phoneNumber){
        try{
            File file = new File("Recipient.txt");
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] recipient = line.split(";");
                if (recipient[1].equals(phoneNumber)) {
                    return false;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return  true;
    }

    public static boolean validatePhoneNumber(String phoneNumber) {
        if (phoneNumber == null || (phoneNumber.length() != 11 && phoneNumber.length() != 14)) {
            return false;
        }

        if (phoneNumber.length() == 11) {
            if (validateFirstThreeDigits(phoneNumber)==true){
                for (int i = 0; i < phoneNumber.length(); i++) {
                    if (!Character.isDigit(phoneNumber.charAt(i))) {
                        return false;
                    }
                }
                return true;
            }
            else {
                return false;
            }
        }

        if (phoneNumber.length() == 14) {
            if (phoneNumber.charAt(0) == '+' && phoneNumber.charAt(1) == '8' && phoneNumber.charAt(2) == '8') {

                String s = "";
                for (int i = 3; i < 14; i++) {
                    s += phoneNumber.charAt(i);
                }

                if (validateFirstThreeDigits(s)==true){
                    for (int i = 0; i < s.length(); i++) {
                        if (!Character.isDigit(s.charAt(i))) {
                            return false;
                        }
                    }
                    return true;
                }
                else {
                    return false;
                }
            }
            else {
                return false;
            }
        }

        return true;
    }

    public static boolean repeatEmail(String email){
        try{
            File file = new File("Donor.txt");
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] donor = line.split(";");
                if (donor.length > 12) {
                    if (donor[13].equals(email)) {
                        return false;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
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
        int dotindex = domain.indexOf('.');
        if(dotindex == 1 || dotindex == domain.length() -1){
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
        if(area == null || area.length() > 50){
            return false;
        }
        return true;
    }

    public static boolean repeatNID(String NID){
        try{
            File file = new File("Donor.txt");
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] donor = line.split(";");
                if (donor.length > 12) {
                    if (donor[5].equals(NID)) {
                        return false;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
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

    public static boolean repeatUserName(String name){
        try{
            File file = new File("Donor.txt");
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] donor = line.split(";");
                if (donor.length > 12) {
                    if (donor[11].equals(name)) {
                        return false;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }

    public static boolean validateUserName(String name){
        if (name == null || name.length() < 5 || name.length() > 30) {
            return false;
        }
        else if (!name.matches("^[a-zA-Z0-9_-]+$")) {
            return false;
        }
        else if (name.startsWith(" ") || name.endsWith(" ") || name.matches(" ")){
            return false;
        }
        return true;
    }

    public static boolean validateLastDonationDate(String date){
        if(date == null || date.length() !=10){
            return false;
        }
        MyDate myDate = new MyDate(date);
        DateDifference dateDifference = new DateDifference(myDate);
        if(!myDate.isValidDate() || dateDifference.isFutureDate()){
            return false;
        }
        return true;
    }

    public static boolean validateAge(int age){
        if (age < 18 || age > 65) {
            return false;
        }
        return true;
    }

    public static boolean validateBloodGroup(String bloodgroup){
        if(bloodgroup == null){
            return false;
        }

        String[] validBloodGroups = {"A+", "A-", "B+", "B-", "O+", "O-", "AB+", "AB-"};
        for(String validGroup: validBloodGroups){
            if(bloodgroup.equals(validGroup)){
                return true;
            }
        }
        return false;
    }

}
