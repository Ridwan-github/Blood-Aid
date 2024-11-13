package UI;

import Code.AuthorizationConstraintsValidator;
import Code.PasswordMasking;
import Code.Recipient;
import external_Functions.toLower;

import java.util.Scanner;

public class RecipientSignup_UI {
    public static void main(String[] args) {
        Recipient recipient = new Recipient();
        PasswordMasking passwordMasking = new PasswordMasking();
        ConsoleUtils consoleUtils = new ConsoleUtils();
        Scanner scanner = new Scanner(System.in);
        toLower toLower = new toLower();

        final String RED = "\033[31m";
        final String RESET = "\033[0m";
        AuthorizationConstraintsValidator recieptentValidator = new AuthorizationConstraintsValidator();

        System.out.println("==============================================================================================");
        System.out.println("                                    Recipient Signup");
        System.out.println("==============================================================================================");
        System.out.printf("Enter your name: ");
        String name = scanner.nextLine();
        while(!recieptentValidator.validateName(name)){
            System.out.println("Please input 2-100 letter & only alphabetic letters");
            System.out.printf(" Name: ");
            name = scanner.nextLine();
        }
        recipient.setName(name);

        System.out.printf("Enter your phone number: ");
        String phoneNumber = scanner.nextLine();
        while(!recieptentValidator.validatePhoneNumber(phoneNumber) || !recieptentValidator.recipientRepeatPhone(phoneNumber)){
            if (!recieptentValidator.validatePhoneNumber(phoneNumber)) {
                System.out.println("Please input valid phoneNumber of 11 digits only");
                System.out.printf(" Phone Number: ");
                phoneNumber = scanner.nextLine();
            } else {
                System.out.println("Phone number already exists. Please enter a new phone number.");
                System.out.printf(" Phone Number: ");
                phoneNumber = scanner.nextLine();
            }
        }
        recipient.setPhoneNumber(phoneNumber);

        System.out.println("Enter your address - ");
        System.out.printf("Enter your city: ");
        String city = scanner.nextLine();
        while (!recieptentValidator.validateCity(city)) {
            System.out.println("Please input 2-50 letters & only alphabetic letters");
            System.out.printf(" City: ");
            city = scanner.nextLine();
        }
        city = toLower.toLower(city);
        while (!recieptentValidator.validCity(city)) {
            System.out.println("Please input a valid city.");
            System.out.printf(" City: ");
            city = scanner.nextLine();
            city = toLower.toLower(city);
        }
        recipient.setCity(city);

        System.out.printf("Enter your area: ");
        String area = scanner.nextLine();
        while (!recieptentValidator.validateArea(area)) {
            System.out.println("Please input at max 50 letters");
            System.out.printf(" Area: ");
            area = scanner.nextLine();
        }
        recipient.setArea(area);

        System.out.printf("Enter your blood group: ");
        String bloodGroup = scanner.nextLine();
        while (!recieptentValidator.validateBloodGroup(bloodGroup)) {
            System.out.println("Invalid blood group. Please enter a valid blood group.");
            System.out.printf(" Blood Group: ");
            bloodGroup = scanner.nextLine();
        }
        recipient.setBloodGroup(bloodGroup);

        System.out.printf("Enter your password: ");
        String password = passwordMasking.getPassword();
        while (!recieptentValidator.validatePassword(password)) {
            System.out.println("Please input 8-32 character");
            System.out.println("Please include at least one uppercase,lowercase,numeric and special character");
            System.out.printf(" Password: ");
            password = passwordMasking.getPassword();
        }
        recipient.setPassword(password);

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
                consoleUtils.clearScreen();
                recipient.registerRecipient();
                Login_UI.main(args);
                break;
            case 2:
                consoleUtils.clearScreen();
                Login_UI.main(args);
                break;
            default:
                System.out.println("Invalid choice. Please select 1 or 2.");
        }
    }
}
