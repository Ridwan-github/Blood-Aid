package UI;

import Code.BadgeManagement;
import Code.DonationManager;
import Code.Donation_Confirmation;
import Code.Recipient;

import java.util.Scanner;
import java.util.Vector;

public class Donation_Confirmation_UI {
    public static void main(String phoneNumber, String password ,String[] args) {
        final String RED = "\033[31m";
        final String RESET = "\033[0m";
        Scanner scanner = new Scanner(System.in);
        ConsoleUtils consoleUtils = new ConsoleUtils();

        System.out.println("==============================================================================================");
        System.out.println("\t\t\t\t Donation Confirmation");
        System.out.println("==============================================================================================");

        Donation_Confirmation donationConfirmation = new Donation_Confirmation();
        Recipient recipient = new Recipient();
        recipient.loginRecipient(phoneNumber, password);
        Vector<String> list = donationConfirmation.donorsToConfirm(phoneNumber);

        if (list.isEmpty()) {
            System.out.println("No donor available to confirm donation.");
            System.out.println("Going back to Dashboard ......");
            consoleUtils.holdTime();
            consoleUtils.clearScreen();
            Recipient_UI.main(phoneNumber, password, args);
        } else {
            System.out.println("Available donor to confirm donation:");
            for (int i = 0; i < list.size(); i++) {
                System.out.println(RED + (i + 1) + ". " + RESET + list.get(i));
            }

            System.out.println("Enter the serial number of the donor to confirm donation with or " + RED + "[0]" + RESET + " to Go back");
            int choice = scanner.nextInt();
            scanner.nextLine();

            while (choice < 0 || choice > list.size()) {
                System.out.println("Invalid choice. Please select a valid option.");
                choice = scanner.nextInt();
                scanner.nextLine();
            }

            if (choice == 0) {
                Recipient_UI.main(phoneNumber, password, args);
            } else {
                String donorID = list.get(choice - 1);
                DonationManager donationManager = new DonationManager(donorID, phoneNumber);
                BadgeManagement badgeManagement = new BadgeManagement();
                String donationType = donationManager.getDonationType();

                donationManager.acceptRequest();
                donationManager.removePendingRequests();
                donationManager.removePendingRequestsForRecipient();
                donationManager.updateEligibilityStatus(donationType);

                badgeManagement.updateFirstDropBadge(donorID);
                if (recipient.getBloodGroup().equals("O-")) {
                    badgeManagement.updateRareBloodHeroBadge(donorID);
                }

                System.out.println("Donation request confirmed for donor with contact number " + list.get(choice - 1));
                System.out.println("Going back to Dashboard ......");
                consoleUtils.holdTime();
                consoleUtils.clearScreen();

                Recipient_UI.main(phoneNumber, password, args);
            }
        }


    }
}
