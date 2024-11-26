package UI;

import Code.ChatSystem;

import java.util.Scanner;
import java.util.Vector;

public class Donor_Chat_UI {

    public static void main(String donorID,String pass,String phoneNumber, String[] args) {
        System.out.println("==============================================================================================");
        System.out.println("\t\t\t\t Chat System");
        System.out.println("==============================================================================================");

        ChatSystem chatSystem = new ChatSystem();
        Vector<String> list = chatSystem.availableRecipientToChat(donorID);
        Scanner scanner = new Scanner(System.in);
        ConsoleUtils consoleUtils = new ConsoleUtils();
        final String RED = "\033[31m";
        final String RESET = "\033[0m";

        if (list.size() == 0) {
            System.out.println("No recipient available to chat.");
            System.out.println("Press enter to exit.");
            scanner.nextLine();

            consoleUtils.clearScreen();
            Donor_UI.main(phoneNumber, pass, args);

        } else {
            System.out.println("Available recipient to chat:");
            for (int i = 0; i < list.size(); i++) {
                System.out.println((i + 1) + ". " + list.get(i));
            }

            System.out.println("Enter the serial number of the recipient to chat with or " + RED + "[0]" + RESET + " to Go back");
            int choice = scanner.nextInt();
            scanner.nextLine();

            while (choice < 0 || choice > list.size()) {
                System.out.println("Invalid choice. Please select a valid option.");
                choice = scanner.nextInt();
                scanner.nextLine();
            }

            if (choice == 0) {
                consoleUtils.clearScreen();
                Donor_UI.main(phoneNumber, pass, args);
            } else {
                consoleUtils.clearScreen();
                Donor_Chat_UI_2.main(donorID, pass, phoneNumber, list, choice, args);
            }
        }
    }
}
