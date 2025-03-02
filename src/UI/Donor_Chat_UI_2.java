package UI;

import Code.ChatSystem;

import java.util.Scanner;
import java.util.Vector;

public class Donor_Chat_UI_2 {
    public static void main(String donorID, String pass, String phoneNumber, Vector<String> list,int choice, String[] args) {
        System.out.println("==============================================================================================");
        System.out.println("\t\t\t\t Chat System");
        System.out.println("==============================================================================================");

        ChatSystem chatSystem = new ChatSystem();
        Scanner scanner = new Scanner(System.in);
        ConsoleUtils consoleUtils = new ConsoleUtils();
        final String RED = "\033[31m";
        final String RESET = "\033[0m";

        String recipientPhoneNumber = list.get(choice - 1);
        chatSystem.loadMessagesForDonor(donorID, recipientPhoneNumber);

        System.out.println("==============================================================================================");
        System.out.println("Enter your message or " + RED + "[0]" + RESET + " to Go back or " + RED + "[1]" + RESET + " to Refresh");
        String message = scanner.nextLine();

        while (!message.equals("0") && !message.equals("1")) {
            consoleUtils.clearScreen();
            System.out.println("==============================================================================================");
            System.out.println("\t\t\t\t Chat System");
            System.out.println("==============================================================================================");

            chatSystem.sendMessageToRecipient(donorID, recipientPhoneNumber, message);
            chatSystem.loadMessagesForDonor(donorID, recipientPhoneNumber);

            System.out.println("Enter your message or " + RED + "[0]" + RESET + " to Go back or " + RED + "[1]" + RESET + " to Refresh");
            message = scanner.nextLine();
        }

        if (message.equals("0")){
            consoleUtils.clearScreen();
            Donor_Chat_UI.main(donorID, pass, phoneNumber, args);
        } else {
            consoleUtils.clearScreen();
            Donor_Chat_UI_2.main(donorID, pass, phoneNumber, list,choice, args);
        }
    }
}
