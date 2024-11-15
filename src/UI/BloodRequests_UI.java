package UI;

import Code.Donor;
import Code.DonationManager;

import java.io.*;
import java.util.Scanner;

public class BloodRequests_UI {
    public static void main(String phoneNumber, String pass, String[] args) {
        String phone = phoneNumber;
        String password = pass;

        ConsoleUtils consoleUtils = new ConsoleUtils();
        Donor donor = new Donor();
        donor.loginDonor(phoneNumber, password);
        final String RED = "\033[31m";
        final String RESET = "\033[0m";

        String donorID = donor.getDonorID();

        System.out.println("==============================================================================================");
        System.out.println("                                    Blood Donation Requests");
        System.out.println("                                    Blood Group: " + donor.getBloodGroup());
        System.out.println("==============================================================================================");

        File file = new File("DonationRequestHistory.txt");
        int recipientCount = 1;
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] requestData = line.split(";");
                if (requestData.length == 4) {
                    String fileDonorID = requestData[0];
                    String recipientName = requestData[1];
                    String recipientPhoneNumber = requestData[2];
                    String status = requestData[3];

                    if (fileDonorID.equals(donorID)) {
                        System.out.println(RED + "[" + recipientCount + "]" + RESET +
                                " Recipient Name: " + RED + recipientName + RESET + " | Location: " + RED + "Hospital name, Address" + RESET +
                                " | Contact Number: " + RED + recipientPhoneNumber + RESET);
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
        }
        Scanner scanner = new Scanner(System.in);
        System.out.println("==============================================================================================");
        System.out.println(RED + "[0]" + RESET + " Go Back ");
        System.out.println(RED + "[1]" + RESET + " Accept Request ");
        System.out.println("Select an option: ");
        int choice = scanner.nextInt();
        scanner.nextLine();
        while(choice != 0 || choice != 1){
            System.out.println("==============================================================================================");
            System.out.println(RED + "[0]" + RESET + " Go Back ");
            System.out.println(RED + "[1]" + RESET + " Accept Request ");
            System.out.println("Select an option: ");
            choice = scanner.nextInt();
            scanner.nextLine();
        }
        String recipientPhoneNumber = scanner.nextLine();
        String recipientName = scanner.nextLine();

        switch (choice) {
            case 1:

                acceptRequest(recipientPhoneNumber, recipientName, donorID);

                break;
            case 0:
                consoleUtils.clearScreen();
                Donor_UI.main(phoneNumber, password, args);
                break;
            default:
                System.out.println("Invalid choice. Please select a valid option.");
        }
    }


    private static void acceptRequest(String recipientPhoneNumber,String recipientName, String donorID) {
        DonationManager donationManager = new DonationManager(donorID, recipientName, recipientPhoneNumber);

        donationManager.removeRequest();

        System.out.println("Donation request accepted for " + recipientName + " with contact number " + recipientPhoneNumber);
    }
}
