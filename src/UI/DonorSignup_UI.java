package UI;
import Code.Donor;
import external_Functions.*;
import Code.AuthorizationConstraintsValidator;
import Code.PasswordMasking;

import java.util.Scanner;

public class DonorSignup_UI {
    public static void main(String[] args) {
        final String RED = "\033[31m";
        final String RESET = "\033[0m";
        Donor donor = new Donor();
        AuthorizationConstraintsValidator authorizationConstraintsValidator = new AuthorizationConstraintsValidator();
        PasswordMasking passwordMasking = new PasswordMasking();
        ConsoleUtils consoleUtils = new ConsoleUtils();
        Scanner scanner = new Scanner(System.in);


        System.out.println("==============================================================================================");
        System.out.println("                                    Donor Signup");
        System.out.println("==============================================================================================");
        System.out.printf(RED + "1." + RESET + " Name: ");
        String name = scanner.nextLine();
        while(!authorizationConstraintsValidator.validateName(name)){
            System.out.println("Please input 2-100 letter & only alphabetic letters");
            System.out.printf(RED + "1." + RESET + " Name: ");
            name = scanner.nextLine();
        }
        donor.setName(name);
        System.out.printf(RED + "2." + RESET + " Username: ");
        String username = scanner.nextLine();
        validateUsername validateUsername = new validateUsername();
        while (!authorizationConstraintsValidator.repeatUserName(username) || !authorizationConstraintsValidator.validateUserName(username)) {
            if(!authorizationConstraintsValidator.repeatUserName(username)){
                System.out.println("Username already exists. Please enter a different username.");
                System.out.printf(RED + "2." + RESET + " Username: ");
                username = scanner.nextLine();
            }
            else if(!authorizationConstraintsValidator.validateUserName(username)){
                System.out.println("Please input 5-30 letters & only alphanumeric letters or underscore with no spaces");
                System.out.printf(RED + "2." + RESET + " Username: ");
                username = scanner.nextLine();
            }
        }
        donor.setUsername(username);

        System.out.printf(RED + "3." + RESET + " Email: ");
        String email = scanner.nextLine();
        while(!authorizationConstraintsValidator.validateEmail(email) || !authorizationConstraintsValidator.repeatEmail(email)){
            if(!authorizationConstraintsValidator.validateEmail(email)){
                System.out.println("Please input valid email format (example@domain.com)");
                System.out.printf(RED + "3." + RESET + " Email: ");
                email = scanner.nextLine();
            }
            else if(!authorizationConstraintsValidator.repeatEmail(email)){
                System.out.println("Email already exists. Please enter a different email.");
                System.out.printf(RED + "3." + RESET + " Email: ");
                email = scanner.nextLine();
            }
        }
        donor.setEmail(email);
        System.out.printf(RED + "4." + RESET + " Age: ");
        int age = scanner.nextInt();
        while (!authorizationConstraintsValidator.validateAge(age)) {
            System.out.println("You must be 18-65 years old to donate blood.");
            System.out.printf(RED + "4." + RESET + " Age: ");
            age = scanner.nextInt();
        }
        scanner.nextLine();
        ParseINT parseINT = new ParseINT();
        donor.setAge(parseINT.intTOString(age));

        System.out.printf(RED + "5." + RESET + " Phone Number: ");
        String phoneNumber = scanner.nextLine();
        if (phoneNumber.length() == 14){
            if (phoneNumber.charAt(0) == '+' && phoneNumber.charAt(1) == '8' && phoneNumber.charAt(2) == '8') {
                String s = "";
                for (int i = 3; i < 14; i++) {
                    s += phoneNumber.charAt(i);
                }
                phoneNumber = s;
            } else {
                System.out.println("Please input valid phone number");
                System.out.printf(RED + "5." + RESET + " Phone Number: ");
                phoneNumber = scanner.nextLine();
            }
        }
        while (!authorizationConstraintsValidator.validatePhoneNumber(phoneNumber) || !authorizationConstraintsValidator.repeatPhoneNumber(phoneNumber)) {
            if (!authorizationConstraintsValidator.validatePhoneNumber(phoneNumber)) {
                System.out.println("Please input valid phone number");
                System.out.printf(RED + "5." + RESET + " Phone Number: ");
                phoneNumber = scanner.nextLine();
            } else if (!authorizationConstraintsValidator.repeatPhoneNumber(phoneNumber)) {
                System.out.println("Phone number already exists. Please enter a different phone number.");
                System.out.printf(RED + "5." + RESET + " Phone Number: ");
                phoneNumber = scanner.nextLine();
            }
        }
        donor.setPhoneNumber(phoneNumber);

        toLower toLower = new toLower();

        System.out.println(RED + "6." + RESET + " Address - ");
        System.out.printf("City: ");
        String city = scanner.nextLine();
        city = toLower.toLower(city);
        while (!authorizationConstraintsValidator.validateCity(city)) {
            System.out.println("Please input 2-50 letters & only alphabetic letters");
            System.out.printf(" City: ");
            city = scanner.nextLine();
        }
        donor.setcity(city);

        System.out.printf("Area: ");
        String area = scanner.nextLine();
        area = toLower.toLower(area);
        while (!authorizationConstraintsValidator.validateArea(area)) {
            System.out.println("Please input at max 50 letters");
            System.out.printf(" Area: ");
            area = scanner.nextLine();
        }
        donor.setArea(area);
        System.out.printf(RED + "7." + RESET + " Zipcode: ");
        String zipCode = scanner.nextLine();
        while (!authorizationConstraintsValidator.validateZipCode(zipCode)) {
            System.out.println("Please input min-max 4 numeric letters only");
            System.out.printf(RED + "7." + RESET + " Zipcode: ");
            zipCode = scanner.nextLine();
        }
        donor.setZipCode(zipCode);
        System.out.printf(RED + "8." + RESET + " Preferred area for donation: ");
        String preferedHospitalArea = scanner.nextLine();
        while (!authorizationConstraintsValidator.validateArea(preferedHospitalArea)) {
            System.out.println("Please input at max 50 letters");
            System.out.printf(RED + "8." + RESET + " Preferred Hospital Area: ");
            preferedHospitalArea = scanner.nextLine();
        }
        donor.setPreferedHospital(preferedHospitalArea);

        System.out.printf(RED + "9." + RESET + " Blood Group: ");
        String bloodGroup = scanner.nextLine();
        while (!authorizationConstraintsValidator.validateBloodGroup(bloodGroup)) {
            System.out.println("Invalid blood group. Please enter a valid blood group.");
            System.out.printf(RED + "9." + RESET + " Blood Group: ");
            bloodGroup = scanner.nextLine();
        }
        donor.setBloodGroup(bloodGroup);

        System.out.printf(RED + "11." + RESET + " Password: ");
        String password = scanner.nextLine();
        while (!authorizationConstraintsValidator.validatePassword(password)) {
            System.out.println("Please input 8-32 character");
            System.out.println("Please include at least one uppercase,lowercase,numeric and special character");
            System.out.printf(RED + "11." + RESET + " Password: ");
            password = scanner.nextLine();
        }
        donor.setPassword(password);

        System.out.printf(RED + "10." + RESET + " NID Number: ");
        String NID = scanner.nextLine();
        while (!authorizationConstraintsValidator.validateNID(NID) || !authorizationConstraintsValidator.repeatNID(NID)) {
            if (!authorizationConstraintsValidator.validateNID(NID)) {
                System.out.println("Please input min-max 10 numeric letters");
                System.out.printf(RED + "10." + RESET + " NID: ");
                NID = scanner.nextLine();
            } else if (!authorizationConstraintsValidator.repeatNID(NID)) {
                System.out.println("NID already exists. Please enter a different NID.");
                System.out.printf(RED + "10." + RESET + " NID Number: ");
                NID = scanner.nextLine();
            }
        }
        donor.setNID(NID);

        System.out.println("==============================================================================================");
        System.out.println("Have you donated blood recently?");
        System.out.println(RED + "[1]" + RESET + " Yes");
        System.out.println(RED + "[2]" + RESET + " No");
        System.out.println("==============================================================================================");
        int choice = scanner.nextInt();
        scanner.nextLine();

        while (choice != 1 && choice != 2) {
            System.out.println("Invalid choice. Please select 1 or 2.");
            System.out.println("==============================================================================================");
            System.out.println("Have you donated blood recently?");
            System.out.println(RED + "[1]" + RESET + " Yes");
            System.out.println(RED + "[2]" + RESET + " No");
            System.out.println("==============================================================================================");
            choice = scanner.nextInt();
            scanner.nextLine();
        }

        if (choice == 1){
            System.out.println("==============================================================================================");
            System.out.println("Did you donate Power Red in the last 4 months?");
            System.out.println(RED + "[1]" + RESET + " Yes");
            System.out.println(RED + "[2]" + RESET + " No");
            System.out.println("==============================================================================================");
            choice = scanner.nextInt();
            scanner.nextLine();

            while (choice != 1 && choice != 2) {
                System.out.println("Invalid choice. Please select 1 or 2.");
                System.out.println("==============================================================================================");
                System.out.println("Did you donate Power Red in the last 4 months?");
                System.out.println(RED + "[1]" + RESET + " Yes");
                System.out.println(RED + "[2]" + RESET + " No");
                System.out.println("==============================================================================================");
                choice = scanner.nextInt();
                scanner.nextLine();
            }

            if (choice == 1){
                System.out.println("When did you donate Power Red last? (dd/mm/yyyy)");
                String date = scanner.nextLine();
                while (!authorizationConstraintsValidator.validateLastDonationDate(date)) {
                    System.out.println("Please input valid Date (dd/mm/yyyy)");
                    System.out.printf("Date: ");
                    date = scanner.nextLine();
                }

                MyDate myDate = new MyDate(date);
                DateDifference dateDifference = new DateDifference(myDate);
                int difference = dateDifference.getDifference();

                if (difference < 120) {
                    System.out.println("You are not eligible to donate blood for the next " + (120 - difference) + " days.");
                    donor.setEligibleForPowerRed(false);
                    donor.setEligibleForPlatelets(false);
                    donor.setEligibleForWholeBlood(false);
                    donor.setEligibleForPlasma(false);
                    donor.setLastDonatedDatePlatelets("null");
                    donor.setLastDonatedDateWholeBlood("null");
                    donor.setLastDonatedDatePlasma("null");
                } else {
                    System.out.println("You donated blood " + difference + " days ago.");
                    System.out.println("You are eligible to donate blood.");
                    donor.setEligibleForPowerRed(true);
                }
                donor.setLastDonatedDatePowerRed(date);
            } else if (choice == 2){
                donor.setEligibleForPowerRed(true);
                donor.setLastDonatedDatePowerRed("null");
            }

            if (donor.isEligibleForPowerRed()){
                System.out.println("Did you donate Whole Blood in the last 3 months?");
                System.out.println(RED + "[1]" + RESET + " Yes");
                System.out.println(RED + "[2]" + RESET + " No");
                System.out.println("==============================================================================================");
                choice = scanner.nextInt();
                scanner.nextLine();

                while (choice != 1 && choice != 2) {
                    System.out.println("Invalid choice. Please select 1 or 2.");
                    System.out.println("==============================================================================================");
                    System.out.println("Did you donate Whole Blood in the last 3 months?");
                    System.out.println(RED + "[1]" + RESET + " Yes");
                    System.out.println(RED + "[2]" + RESET + " No");
                    System.out.println("==============================================================================================");
                    choice = scanner.nextInt();
                    scanner.nextLine();
                }

                if (choice == 1){
                    System.out.println("When did you donate Whole Blood last? (dd/mm/yyyy)");
                    String date = scanner.nextLine();
                    while (!authorizationConstraintsValidator.validateLastDonationDate(date)) {
                        System.out.println("Please input valid Date (dd/mm/yyyy)");
                        System.out.printf("Date: ");
                        date = scanner.nextLine();
                    }
                    MyDate myDate = new MyDate(date);
                    DateDifference dateDifference = new DateDifference(myDate);
                    int difference = dateDifference.getDifference();

                    if (difference < 90) {
                        System.out.println("You are not eligible to donate blood for the next " + (90 - difference) + " days.");
                        donor.setEligibleForWholeBlood(false);
                    } else {
                        System.out.println("You donated blood " + difference + " days ago.");
                        System.out.println("You are eligible to donate blood.");
                        donor.setEligibleForWholeBlood(true);
                    }
                    donor.setLastDonatedDateWholeBlood(date);
                } else {
                    System.out.println("You are eligible to donate blood.");
                    donor.setLastDonatedDateWholeBlood("null");
                    donor.setEligibleForWholeBlood(true);
                }

                System.out.println("==============================================================================================");
                System.out.println("Did you donate Platelets in the last 15 days?");
                System.out.println(RED + "[1]" + RESET + " Yes");
                System.out.println(RED + "[2]" + RESET + " No");
                System.out.println("==============================================================================================");
                choice = scanner.nextInt();
                scanner.nextLine();

                while (choice != 1 && choice != 2) {
                    System.out.println("Invalid choice. Please select 1 or 2.");
                    System.out.println("==============================================================================================");
                    System.out.println("Did you donate Platelets in the last 7 days?");
                    System.out.println(RED + "[1]" + RESET + " Yes");
                    System.out.println(RED + "[2]" + RESET + " No");
                    System.out.println("==============================================================================================");
                    choice = scanner.nextInt();
                    scanner.nextLine();
                }

                if (choice == 1){
                    System.out.println("When did you donate Platelets last? (dd/mm/yyyy)");
                    String date = scanner.nextLine();
                    while (!authorizationConstraintsValidator.validateLastDonationDate(date)) {
                        System.out.println("Please input valid Date (dd/mm/yyyy)");
                        System.out.printf("Date: ");
                        date = scanner.nextLine();
                    }

                    MyDate myDate = new MyDate(date);
                    DateDifference dateDifference = new DateDifference(myDate);
                    int difference = dateDifference.getDifference();

                    if (difference < 15) {
                        System.out.println("You are not eligible to donate blood for the next " + (15 - difference) + " days.");
                        donor.setEligibleForPlatelets(false);
                    } else {
                        System.out.println("You donated blood " + difference + " days ago.");
                        System.out.println("You are eligible to donate blood.");
                        donor.setEligibleForPlatelets(true);
                    }
                    donor.setLastDonatedDatePlatelets(date);
                } else if (choice == 2){
                    donor.setEligibleForPlatelets(true);
                    donor.setLastDonatedDatePlatelets("null");
                }

                System.out.println("==============================================================================================");
                System.out.println("Did you donate Plasma in the last 1 month?");
                System.out.println(RED + "[1]" + RESET + " Yes");
                System.out.println(RED + "[2]" + RESET + " No");
                System.out.println("==============================================================================================");
                choice = scanner.nextInt();
                scanner.nextLine();

                while (choice != 1 && choice != 2) {
                    System.out.println("Invalid choice. Please select 1 or 2.");
                    System.out.println("==============================================================================================");
                    System.out.println("Did you donate Plasma in the last 1 month?");
                    System.out.println(RED + "[1]" + RESET + " Yes");
                    System.out.println(RED + "[2]" + RESET + " No");
                    System.out.println("==============================================================================================");
                    choice = scanner.nextInt();
                    scanner.nextLine();
                }

                if (choice == 1){
                    System.out.println("When did you donate Plasma last? (dd/mm/yyyy)");
                    String date = scanner.nextLine();
                    while (!authorizationConstraintsValidator.validateLastDonationDate(date)) {
                        System.out.println("Please input valid Date (dd/mm/yyyy)");
                        System.out.printf("Date: ");
                        date = scanner.nextLine();
                    }

                    MyDate myDate = new MyDate(date);
                    DateDifference dateDifference = new DateDifference(myDate);
                    int difference = dateDifference.getDifference();

                    if (difference < 30) {
                        System.out.println("You are not eligible to donate blood for the next " + (30 - difference) + " days.");
                        donor.setEligibleForPlasma(false);
                    } else {
                        System.out.println("You donated blood " + difference + " days ago.");
                        System.out.println("You are eligible to donate blood.");
                        donor.setEligibleForPlasma(true);
                    }
                    donor.setLastDonatedDatePlasma(date);
                } else if (choice == 2){
                    donor.setEligibleForPlasma(true);
                    donor.setLastDonatedDatePlasma("null");
                }
            } else {
                System.out.println("As you have donated Power Red in the last 4 months, you are not eligible to donate Whole Blood, Platelets and Plasma.");
                donor.setEligibleForWholeBlood(false);
                donor.setEligibleForPlatelets(false);
                donor.setEligibleForPlasma(false);
            }
        } else if (choice == 2){
            donor.setEligibleForWholeBlood(true);
            donor.setEligibleForPlasma(true);
            donor.setEligibleForPlatelets(true);
            donor.setEligibleForPowerRed(true);
        }

        System.out.println("==============================================================================================");
        System.out.println("By signing up you are agreeing to our " + RED + "Terms and Conditions ");
        System.out.println(RED + "[1]" + RESET + " Signup");
        System.out.println(RED + "[0]" + RESET + " Cancel and go back to login");
        System.out.println("==============================================================================================");

        int choice1 = scanner.nextInt();
        scanner.nextLine();

        switch (choice1) {
            case 1:
                consoleUtils.clearScreen();
                donor.registerDonor();
                Login_UI.main(args);
                break;
            case 0:
                consoleUtils.clearScreen();
                Login_UI.main(args);
                break;
            default:
                System.out.println("Invalid choice. Please select 1 or 0.");
        }
    }
}
