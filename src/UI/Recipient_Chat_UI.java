package UI;

import Code.ChatSystem;

import java.util.Scanner;
import java.util.Vector;

public class Recipient_Chat_UI {
    public static void main(String phoneNumber, String password, String[] args) {
        System.out.println("==============================================================================================");
        System.out.println("\t\t\t\t Chat System");
        System.out.println("==============================================================================================");

        ChatSystem chatSystem = new ChatSystem();
        Vector<String> list = chatSystem.availableDonorToChat(phoneNumber);

        Scanner scanner = new Scanner(System.in);
        ConsoleUtils consoleUtils = new ConsoleUtils();
        final String RED = "\033[31m";
        final String RESET = "\033[0m";

        if (list.size() == 0) {
            System.out.println("No donor available to chat.");
            System.out.println("Press enter to exit.");
            scanner.nextLine();

            consoleUtils.clearScreen();
            Recipient_UI.main(phoneNumber, password, args);
        } else {
            System.out.println("Available donor to chat:");
            for (int i = 0; i < list.size(); i++) {
                System.out.println((i + 1) + ". " + list.get(i));
            }

            System.out.println("Enter the serial number of the donor to chat with or " + RED + "[0]" + RESET + " to Go back");
            int choice = scanner.nextInt();
            scanner.nextLine();

            while (choice < 0 || choice > list.size()) {
                System.out.println("Invalid choice. Please select a valid option.");
                choice = scanner.nextInt();
                scanner.nextLine();
            }

            if (choice == 0) {
                consoleUtils.clearScreen();
                Recipient_UI.main(phoneNumber, password, args);
            } else {
                consoleUtils.clearScreen();
                Recipient_Chat_UI_2.main(phoneNumber, password, list, choice, args);
            }
        }
    }
}
