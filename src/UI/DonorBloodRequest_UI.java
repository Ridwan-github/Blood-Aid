package UI;

import Code.Donation_Confirmation;
import Code.Donor;
import Code.DonationManager;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DonorBloodRequest_UI {
    public static void main(String phoneNumber, String pass, String[] args) {
        String phone = phoneNumber;
        String password = pass;

        ConsoleUtils consoleUtils = new ConsoleUtils();
        Donor donor = new Donor();
        donor.loginDonor(phone, password);
        final String RED = "\033[31m";
        final String RESET = "\033[0m";

        String donorID = donor.getDonorID();

        System.out.println("==============================================================================================");
        System.out.println("                                    Blood Donation Requests");
        System.out.println("                                    Blood Group: " + donor.getBloodGroup());
        System.out.println("==============================================================================================");

        File file = new File("DonationRequestHistory.txt");
        List<String[]> matchingRequests = new ArrayList<>();
        int recipientCount = 1;

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] requestData = line.split(";");
                if (requestData.length > 1) {
                    String fileDonorID = requestData[0];
                    String recipientName = requestData[1];
                    String recipientPhoneNumber = requestData[2];
                    String donationType = requestData[3];
                    String status = requestData[4];


                    if (fileDonorID.equals(donorID) && !status.equals("Accepted") && !status.equals("Donated")) {
                        matchingRequests.add(new String[]{recipientName, recipientPhoneNumber, donationType, status});
                        System.out.println(RED + "[" + recipientCount + "]" + RESET +
                                " Recipient Name: " + RED + recipientName + RESET + " | Location: " + RED + "Hospital name, Address" + RESET +
                                " | Contact Number: " + RED + recipientPhoneNumber + RESET + " | Donation Type: " + RED + donationType + RESET + " | Status: " + RED + status + RESET);
                        recipientCount++;
                    }
                }
            }

        } catch (IOException e) {
            System.out.println("Error reading the donation request history file.");
            e.printStackTrace();
        }

        if (recipientCount == 1) {
            System.out.println("No donation requests found for this donor.");
            System.out.println("Going back to Dashboard ......");
            consoleUtils.holdTime();
            consoleUtils.clearScreen();
            Donor_UI.main(phoneNumber, password, args);
        } else {
            Scanner scanner = new Scanner(System.in);
            System.out.println("==============================================================================================");
            System.out.println("Enter the serial number of the request to accept or 0 to Go back");

            int choice = scanner.nextInt();
            scanner.nextLine();

            while (choice < 0 || choice >= recipientCount) {
                System.out.println("Invalid choice. Please select a valid option.");
                choice = scanner.nextInt();
                scanner.nextLine();
            }

            if (choice == 0) {
                consoleUtils.clearScreen();
                Donor_UI.main(phoneNumber, password, args);
            } else {
                String[] selectedRequest = matchingRequests.get(choice - 1);
                String recipientName = selectedRequest[0];
                String recipientPhoneNumber = selectedRequest[1];
                String donationType = selectedRequest[2];

                acceptRequest(recipientPhoneNumber, donorID, donationType);
                System.out.println("Accepted. Going back to Dashboard ......");
                consoleUtils.holdTime();
                consoleUtils.clearScreen();
                Donor_UI.main(phoneNumber, password, args);
            }
        }
    }

    private static void acceptRequest(String recipientPhoneNumber, String donorID, String donationType) {
        Donation_Confirmation confirmation = new Donation_Confirmation();
        confirmation.updateDonationState(recipientPhoneNumber, donorID, donationType, "Accepted");

        System.out.println("Donation request accepted for recipient with contact number " + recipientPhoneNumber);
    }
}