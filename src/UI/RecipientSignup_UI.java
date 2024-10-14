package UI;

import java.util.Scanner;

public class RecipientSignup_UI {
    public static void main(String[] args) {
        final String RED = "\033[31m";
        final String RESET = "\033[0m";


        System.out.println("==============================================================================================");
        System.out.println("                                    Recipient Signup");
        System.out.println("==============================================================================================");
        System.out.println("Enter your name: ");
        System.out.println("Enter your phone number: ");
        System.out.println("Enter your address: ");
        System.out.println("Enter your blood group: ");
        System.out.println("Enter your password: ");
        System.out.println("==============================================================================================");
        System.out.println(RED + "[1]" + RESET + " Signup");
        System.out.println(RED + "[2]" + RESET + " Back");
        System.out.println("Select an option: ");

        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                Recipient_UI.main(args);
                break;
            case 2:
                Login_UI.main(args);
                break;
            default:
                System.out.println("Invalid choice. Please select 1 or 2.");
        }
    }
}
