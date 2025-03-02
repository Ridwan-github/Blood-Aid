package UI;

import Code.TopDonor;

import java.util.Scanner;

public class TopDonor_UI {
    public static void main(String phoneNumber, String pass, String[] args) {
        TopDonor topDonor = new TopDonor();
        topDonor.showTopDonors();

        final String RED = "\033[31m";
        final String RESET = "\033[0m";
        ConsoleUtils consoleUtils = new ConsoleUtils();

        System.out.println("==============================================================================================");
        System.out.println(RED + "[0]" + RESET + " Back");
        System.out.println("==============================================================================================");

        int choice;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your choice: ");
        choice = scanner.nextInt();
        scanner.nextLine();

        if (choice == 0) {
            consoleUtils.clearScreen();
            Donor_UI.main(phoneNumber, pass, args);
        } else {
            System.out.println("Invalid choice. Please select 0.");
        }
    }
}
