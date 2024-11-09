package UI;
import Code.Donor;
import Code.DonorValidator;
import Code.PasswordMasking;
import external_Functions.validateUsername;
import external_Functions.ParseINT;

import java.util.Scanner;

public class DonorSignup_UI {
    public static void main(String[] args) {
        final String RED = "\033[31m";
        final String RESET = "\033[0m";
        Donor donor = new Donor();
        DonorValidator donorValidator = new DonorValidator();
        PasswordMasking passwordMasking = new PasswordMasking();
        Scanner scanner = new Scanner(System.in);


        System.out.println("==============================================================================================");
        System.out.println("                                    Donor Signup");
        System.out.println("==============================================================================================");
        System.out.printf(RED + "1." + RESET + " Name: ");
        String name = scanner.nextLine();
        while(!donorValidator.validateName(name)){
            System.out.println("Please input 2-100 letter & only alphabetic letters");
            System.out.printf(RED + "1." + RESET + " Name: ");
            name = scanner.nextLine();
        }
        donor.setName(name);
        System.out.printf(RED + "2." + RESET + " Username: ");
        String username = scanner.nextLine();
        validateUsername validateUsername = new validateUsername();
        while (!validateUsername.validate(username) || !donorValidator.validateUserName(username)) {
            if(!validateUsername.validate(username)){
                System.out.println("Username already exists. Please enter a different username.");
                System.out.printf(RED + "2." + RESET + " Username: ");
                username = scanner.nextLine();
            }
            else if(!donorValidator.validateUserName(username)){
                System.out.println("Please input 5-30 letters & only alphanumeric letters or underscore with no spaces");
                System.out.printf(RED + "2." + RESET + " Username: ");
                username = scanner.nextLine();
            }
        }
        donor.setUsername(username);
        System.out.printf(RED + "3." + RESET + " Email: ");
        String email = scanner.nextLine();
        while(!donorValidator.validateEmail(email)){
            System.out.println("Please input valid email format (example@domain.com)");
            System.out.printf(RED + "3." + RESET + " Name: ");
            email = scanner.nextLine();
        }
        donor.setEmail(email);
        System.out.printf(RED + "4." + RESET + " Age: ");
        int age = scanner.nextInt();
        while (!donorValidator.validateAge(age)) {
            System.out.println("You must be 18-65 years old to donate blood.");
            System.out.printf(RED + "4." + RESET + " Age: ");
            age = scanner.nextInt();
        }
        scanner.nextLine();
        ParseINT parseINT = new ParseINT();
        donor.setAge(parseINT.intTOString(age));
        System.out.printf(RED + "5." + RESET + " Phone Number: ");
        String phoneNumber = scanner.nextLine();
        while (!donorValidator.validatePhoneNumber(phoneNumber)) {
            System.out.println("Please input valid phoneNumber of 11 digits only");
            System.out.printf(RED + "5." + RESET + " Phone Number: ");
            phoneNumber = scanner.nextLine();
        }
        donor.setPhoneNumber(phoneNumber);
        System.out.printf(RED + "6." + RESET + " Address - ");
        System.out.printf(RED + "City: ");
        String city = scanner.nextLine();
        while (!donorValidator.validateCity(city)) {
            System.out.println("Please input 2-50 letters & only alphabetic letters");
            System.out.printf(" City: ");
            city = scanner.nextLine();
        }
        donor.setcity(city);
        System.out.printf(RED + "Area: ");
        String area = scanner.nextLine();
        while (!donorValidator.validateArea(area)) {
            System.out.println("Please input at max 50 letters");
            System.out.printf(" Area: ");
            area = scanner.nextLine();
        }
        donor.setArea(area);
        System.out.printf(RED + "7." + RESET + " Zipcode: ");
        String zipCode = scanner.nextLine();
        while (!donorValidator.validateZipCode(zipCode)) {
            System.out.println("Please input min-max 4 numeric letters only");
            System.out.printf(RED + "7." + RESET + " Zipcode: ");
            zipCode = scanner.nextLine();
        }
        donor.setZipCode(zipCode);
        System.out.printf(RED + "8." + RESET + " Preferred area for donation: ");
        String preferedHospitalArea = scanner.nextLine();
        while (!donorValidator.validateArea(preferedHospitalArea)) {
            System.out.println("Please input at max 50 letters");
            System.out.printf(RED + "8." + RESET + " Preferred Hospital Area: ");
            preferedHospitalArea = scanner.nextLine();
        }
        donor.setPreferedHospital(preferedHospitalArea);

        System.out.printf(RED + "9." + RESET + " Blood Group: ");
        String bloodGroup = scanner.nextLine();
        while (!donorValidator.validateBloodGroup(bloodGroup)) {
            System.out.println("Invalid blood group. Please enter a valid blood group.");
            System.out.printf(RED + "9." + RESET + " Blood Group: ");
            bloodGroup = scanner.nextLine();
        }
        donor.setBloodGroup(bloodGroup);

        System.out.printf(RED + "10." + RESET + " NID Number: ");
        String NID = scanner.nextLine();
        while (!donorValidator.validateNID(NID)) {
            System.out.println("Please input min-max 10 numeric letters");
            System.out.printf(RED + "10." + RESET + " NID: ");
            NID = scanner.nextLine();
        }
        donor.setNID(NID);
        System.out.printf(RED + "11." + RESET + " Password: ");
        String password = passwordMasking.getPassword();
        while (!donorValidator.validatePassword(password)) {
            System.out.println("Please input 8-32 character");
            System.out.println("Please include at least one uppercase,lowercase,numeric and special character");
            System.out.printf(RED + "11." + RESET + " Password: ");
            password = passwordMasking.getPassword();
        }
        donor.setPassword(password);

        System.out.println("==============================================================================================");
        System.out.println("By signing up you are agreeing to our " + RED + "Terms and Conditions ");
        System.out.println(RED + "[1]" + RESET + " Signup");
        System.out.println(RED + "[0]" + RESET + " Back");
        System.out.println("==============================================================================================");

        int choice1 = scanner.nextInt();

        switch (choice1) {
            case 1:
                donor.registerDonor();
                Login_UI.main(args);
                break;
            case 0:
                Login_UI.main(args);
                break;
            default:
                System.out.println("Invalid choice. Please select 1 or 0.");
        }
    }
}
