package UI;

import Code.Donor;
import Code.DonationManager;
import Code.Recipient;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RecipientBloodRequest_UI {
    public static void main(String phoneNumber, String pass, String[] args) {
        String phone = phoneNumber;
        String password = pass;

        ConsoleUtils consoleUtils = new ConsoleUtils();
        Recipient recipient = new Recipient();
        recipient.loginRecipient(phoneNumber, password);
        final String RED = "\033[31m";
        final String RESET = "\033[0m";


        System.out.println("==============================================================================================");
        System.out.println("                                    Blood Donation Requests");
        System.out.println("                                    Blood Group: " + recipient.getBloodGroup());
        System.out.println("==============================================================================================");

        File file = new File("DonationRequestHistory.txt");
        List<String[]> matchingRequests = new ArrayList<>();
        int requestCount = 1;

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] requestData = line.split(";");
                if (requestData.length == 5) {
                    String fileDonorID = requestData[0];
                    String recipientName = requestData[1];
                    String recipientPhoneNumber = requestData[2];
                    String donationType = requestData[3];
                    String status = requestData[4];

                    if (recipientPhoneNumber.equals(phoneNumber)) {
                        matchingRequests.add(new String[]{fileDonorID, recipientName, donationType, status});
                        System.out.println(RED + "[" + requestCount + "]" + RESET +
                                " Donor ID: " + RED + fileDonorID + RESET + " | Recipient Name: " + RED + recipientName + RESET +
                                " | Donation Type: " + RED + donationType + RESET + " | Status: " + RED + status + RESET);
                        requestCount++;
                    }
                }
            }

        } catch (IOException e) {
            System.out.println("Error reading the donation request history file.");
            e.printStackTrace();
        }

        if (requestCount == 1) {
            System.out.println("No donation requests found for this recipient.");
            return;
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("==============================================================================================");
        System.out.println("Enter 0 to Go back Or 1 to refresh");

        int choice = scanner.nextInt();
        scanner.nextLine();

        while (choice != 0 && choice != 1) {
            System.out.println("Invalid choice. Please select a valid option.");
            choice = scanner.nextInt();
            scanner.nextLine();
        }

        if (choice == 0) {
            consoleUtils.clearScreen();
            Recipient_UI.main(phoneNumber, password, args);
        }
        else {
            consoleUtils.clearScreen();
            RecipientBloodRequest_UI.main(phoneNumber, password, args);
        }
    }
}
