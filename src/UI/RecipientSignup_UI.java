package UI;

import Code.Recipient;

import java.util.Scanner;

public class RecipientSignup_UI {
    public static void main(String[] args) {
        Recipient recipient = new Recipient();
        Scanner scanner = new Scanner(System.in);
        final String RED = "\033[31m";
        final String RESET = "\033[0m";


        System.out.println("==============================================================================================");
        System.out.println("                                    Recipient Signup");
        System.out.println("==============================================================================================");
        System.out.println("Enter your name: ");
        recipient.setName(scanner.nextLine());
        System.out.println("Enter your phone number: ");
        recipient.setPhoneNumber(scanner.nextLine());
        System.out.println("Enter your address: ");
        System.out.println("Enter your city: ");
        recipient.setCity(scanner.nextLine());
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
        System.out.println("Enter your password: ");
        recipient.setPassword(scanner.nextLine());
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
