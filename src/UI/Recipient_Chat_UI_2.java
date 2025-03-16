package UI;

import Code.ChatSystem;

import java.util.Scanner;
import java.util.Vector;

public class Recipient_Chat_UI_2 {
    public static void main(String phoneNumber, String password, Vector<String> list, int choice, String[] args) {
        System.out.println("==========================================================================");
        System.out.println("\t\tChat System");
        System.out.println("==========================================================================");

        ChatSystem chatSystem = new ChatSystem();
        Scanner scanner = new Scanner(System.in);
        ConsoleUtils consoleUtils = new ConsoleUtils();
        final String RED = "\033[31m";
        final String RESET = "\033[0m";

        String donorID = list.get(choice - 1);
        chatSystem.loadMessageForRecipient(phoneNumber, donorID);

        System.out.println("==========================================================================");
        System.out.println("Enter your message or " + RED + "[0]" + RESET + " to Go back or " + RED + "[1]" + RESET + " to Refresh or " + RED + "[2]" + RESET + " to Clear Chat");
        String message = scanner.nextLine();

        if (message.equals("2")) {
            chatSystem.clearChat(phoneNumber, donorID);
            consoleUtils.clearScreen();
            Recipient_Chat_UI_2.main(phoneNumber, password, list, choice, args);
        }

        while (!message.equals("0") && !message.equals("1") && !message.equals("2")) {
            consoleUtils.clearScreen();
            System.out.println("==========================================================================");
            System.out.println("\t\t Chat System");
            System.out.println("==========================================================================");

            chatSystem.sendMessageToDonor(phoneNumber, donorID, message);
            chatSystem.loadMessageForRecipient(phoneNumber, donorID);

            System.out.println("==========================================================================");
            System.out.println("Enter your message or " + RED + "[0]" + RESET + " to Go back or " + RED + "[1]" + RESET + " to Refresh or " + RED + "[2]" + RESET + " to Clear Chat");
            message = scanner.nextLine();
        }

        if (message.equals("0")) {
            consoleUtils.clearScreen();
            Recipient_Chat_UI.main(phoneNumber, password, args);
        } else {
            consoleUtils.clearScreen();
            Recipient_Chat_UI_2.main(phoneNumber, password,list, choice, args);
        }
    }
}
