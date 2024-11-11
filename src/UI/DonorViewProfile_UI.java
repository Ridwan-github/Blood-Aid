package UI;

import Code.DonorViewProfile;
import java.util.Scanner;

public class DonorViewProfile_UI {

    public static void main(DonorViewProfile donorViewProfile, String[] args) {
        final String RED = "\033[31m";
        final String RESET = "\033[0m";
        ConsoleUtils consoleUtils = new ConsoleUtils();
        Scanner scanner = new Scanner(System.in);

        System.out.println("==============================================================================================");
        System.out.println("                                    Donor Profile");
        System.out.println("==============================================================================================");

        // Display profile information
        donorViewProfile.viewProfile();

        System.out.println("==============================================================================================");
        System.out.println(RED + "[0]" + RESET + " Back");
        System.out.println("==============================================================================================");

        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        if (choice == 0) {
            // Return to Donor Dashboard
            consoleUtils.clearScreen();
            Donor_UI.main(donorViewProfile.getPhoneNumber(), donorViewProfile.getPassword(), args);
        } else {
            System.out.println("Invalid choice. Please select 0.");
        }

        scanner.close(); // Close the scanner to prevent resource leaks
    }
}
