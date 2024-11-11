package UI;
import Code.Donor;
import external_Functions.DateDifference;
import external_Functions.MyDate;
import Code.AuthorizationConstraintsValidator;
import Code.PasswordMasking;
import external_Functions.validateUsername;
import external_Functions.ParseINT;

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
        while (!validateUsername.validate(username) || !authorizationConstraintsValidator.validateUserName(username)) {
            if(!validateUsername.validate(username)){
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
        while(!authorizationConstraintsValidator.validateEmail(email)){
            System.out.println("Please input valid email format (example@domain.com)");
            System.out.printf(RED + "3." + RESET + " Email: ");
            email = scanner.nextLine();
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
        while (!authorizationConstraintsValidator.validatePhoneNumber(phoneNumber)) {
            System.out.println("Please input valid phoneNumber of 11 digits only");
            System.out.printf(RED + "5." + RESET + " Phone Number: ");
            phoneNumber = scanner.nextLine();
        }
        donor.setPhoneNumber(phoneNumber);
        System.out.println(RED + "6." + RESET + " Address - ");
        System.out.printf("City: ");
        String city = scanner.nextLine();
        while (!authorizationConstraintsValidator.validateCity(city)) {
            System.out.println("Please input 2-50 letters & only alphabetic letters");
            System.out.printf(" City: ");
            city = scanner.nextLine();
        }
        donor.setcity(city);
        System.out.printf("Area: ");
        String area = scanner.nextLine();
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

        System.out.printf(RED + "10." + RESET + " NID Number: ");
        String NID = scanner.nextLine();
        while (!authorizationConstraintsValidator.validateNID(NID)) {
            System.out.println("Please input min-max 10 numeric letters");
            System.out.printf(RED + "10." + RESET + " NID: ");
            NID = scanner.nextLine();
        }
        donor.setNID(NID);
        System.out.printf(RED + "11." + RESET + " Password: ");
        String password = passwordMasking.getPassword();
        while (!authorizationConstraintsValidator.validatePassword(password)) {
            System.out.println("Please input 8-32 character");
            System.out.println("Please include at least one uppercase,lowercase,numeric and special character");
            System.out.printf(RED + "11." + RESET + " Password: ");
            password = passwordMasking.getPassword();
        }
        donor.setPassword(password);
        System.out.println("==============================================================================================");
        System.out.println("Have you donated blood in the last 3 months?");
        System.out.println(RED + "[1]" + RESET + " Yes");
        System.out.println(RED + "[2]" + RESET + " No");
        System.out.println("==============================================================================================");
        String choice = scanner.nextLine();
        while(!choice.equals("1") && !choice.equals("2")){
            System.out.println("Invalid choice. Please select 1 or 2.");
            System.out.println("==============================================================================================");
            System.out.println("Have you donated blood in the last 3 months?");
            System.out.println(RED + "[1]" + RESET + " Yes");
            System.out.println(RED + "[2]" + RESET + " No");
            System.out.println("==============================================================================================");
            choice = scanner.nextLine();
        }
        if (choice.equals("1")) {
            System.out.println("When did you donate blood last? (dd/mm/yyyy)");
            String date = scanner.nextLine();
            while (!authorizationConstraintsValidator.validateLastDonationDate(date)) {
                System.out.println("Please input valid Date (dd/mm/yyyy)");
                System.out.printf(RESET + " Date: ");
                date = scanner.nextLine();
            }
            MyDate myDate = new MyDate(date);
            DateDifference dateDifference = new DateDifference(myDate);
            int difference = dateDifference.getDifference();

            if (difference < 90) {
                System.out.println("You are not eligible to donate blood for the next " + (90 - difference) + " days.");
                donor.setEligible(false);
            } else {
                System.out.println("You donated blood " + difference + " days ago.");
                System.out.println("You are eligible to donate blood.");
                donor.setEligible(true);
            }
            donor.setLastDonatedDate(date);
        } else if(choice.equals("2")){
            System.out.println("You are eligible to donate blood.");
            donor.setLastDonatedDate("null");
            donor.setEligible(true);
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
