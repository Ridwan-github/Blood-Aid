package UI;

import Code.AuthorizationConstraintsValidator;
import Code.PasswordMasking;
import Code.Recipient;

import java.util.Scanner;

public class RecipientSignup_UI {
    public static void main(String[] args) {
        Recipient recipient = new Recipient();
        Scanner scanner = new Scanner(System.in);
        final String RED = "\033[31m";
        final String RESET = "\033[0m";
        AuthorizationConstraintsValidator recieptentValidator = new AuthorizationConstraintsValidator();

        System.out.println("==============================================================================================");
        System.out.println("                                    Recipient Signup");
        System.out.println("==============================================================================================");
        System.out.println("Enter your name: ");
        String name = scanner.nextLine();
        while(!recieptentValidator.validateName(name)){
            System.out.println("Please input 2-100 letter & only alphabetic letters");
            System.out.printf(" Name: ");
            name = scanner.nextLine();
        }
        recipient.setName(name);
        System.out.println("Enter your phone number: ");
        String phoneNumber = scanner.nextLine();
        while(!recieptentValidator.validatePhoneNumber(phoneNumber)){
            System.out.println("Please input valid phoneNumber of 11 digits only");
            System.out.printf(" Phone Number: ");
            phoneNumber = scanner.nextLine();
        }
        recipient.setPhoneNumber(phoneNumber);
        System.out.println("Enter your address - ");
        System.out.println("Enter your city: ");
        String city = scanner.nextLine();
        while (!recieptentValidator.validateCity(city)) {
            System.out.println("Please input 2-50 letters & only alphabetic letters");
            System.out.printf(" City: ");
            city = scanner.nextLine();
        }
        recipient.setCity(city);
        System.out.println("Enter your area: ");
        recipient.setArea(scanner.nextLine());
        System.out.println("Enter your blood group: ");
        String bloodGroup = scanner.nextLine();
        while (!bloodGroup.equals("A+") && !bloodGroup.equals("A-") && !bloodGroup.equals("B+") &&
                !bloodGroup.equals("B-") && !bloodGroup.equals("AB+") && !bloodGroup.equals("AB-") &&
                !bloodGroup.equals("O+") && !bloodGroup.equals("O-")) {
            System.out.println("Invalid blood group. Please enter a valid blood group.");
            System.out.printf(RED + "4." + RESET + " Blood Group: ");
            bloodGroup = scanner.nextLine();
        }
        recipient.setBloodGroup(bloodGroup);
        System.out.println("Enter your password: ");
        PasswordMasking passwordMasking = new PasswordMasking();
        recipient.setPassword(passwordMasking.getPassword());
        System.out.println("==============================================================================================");
        System.out.println(RED + "[1]" + RESET + " Signup");
        System.out.println(RED + "[2]" + RESET + " Back");
        System.out.println("Select an option: ");

        int choice = scanner.nextInt();

        while (choice != 1 && choice != 2) {
            System.out.println("Invalid choice. Please select 1 or 2.");
            System.out.println("Select an option: ");
            choice = scanner.nextInt();
        }

        switch (choice) {
            case 1:
                recipient.registerRecipient();
                Login_UI.main(args);
                break;
            case 2:
                Login_UI.main(args);
                break;
            default:
                System.out.println("Invalid choice. Please select 1 or 2.");
        }
    }
}
