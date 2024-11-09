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
        donor.setEmail(scanner.nextLine());
        System.out.printf(RED + "4." + RESET + " Age: ");
        int age = scanner.nextInt();
        while (age < 18) {
            System.out.println("You must be at least 18 years old to donate blood.");
            System.out.printf(RED + "4." + RESET + " Age: ");
            age = scanner.nextInt();
        }
        scanner.nextLine();
        ParseINT parseINT = new ParseINT();
        donor.setAge(parseINT.intTOString(age));
        System.out.printf(RED + "5." + RESET + " Phone Number: ");
        donor.setPhoneNumber(scanner.nextLine());
        System.out.printf(RED + "6." + RESET + " Address: ");
        System.out.printf(RED + "City: ");
        donor.setcity(scanner.nextLine());
        System.out.printf(RED + "Area: ");
        donor.setArea(scanner.nextLine());
        System.out.printf(RED + "7." + RESET + " Zipcode: ");
        donor.setZipCode(scanner.nextLine());
        System.out.printf(RED + "8." + RESET + " Preferred area for donation: ");
        donor.setPreferedHospital(scanner.nextLine());

        System.out.printf(RED + "9." + RESET + " Blood Group: ");
        String bloodGroup = scanner.nextLine();
        while (!bloodGroup.equals("A+") && !bloodGroup.equals("A-") && !bloodGroup.equals("B+") &&
                !bloodGroup.equals("B-") && !bloodGroup.equals("AB+") && !bloodGroup.equals("AB-") &&
                !bloodGroup.equals("O+") && !bloodGroup.equals("O-")) {
            System.out.println("Invalid blood group. Please enter a valid blood group.");
            System.out.printf(RED + "9." + RESET + " Blood Group: ");
            bloodGroup = scanner.nextLine();
        }
        donor.setBloodGroup(bloodGroup);

        System.out.printf(RED + "10." + RESET + " NID Number: ");
        donor.setNID(scanner.nextLine());
        System.out.printf(RED + "11." + RESET + " Password: ");
        PasswordMasking passwordMasking = new PasswordMasking();
        donor.setPassword(passwordMasking.getPassword());

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
