package UI;

import Code.Donor;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

class DonationHistory_UI {
    public static void main(String phoneNumber, String password, String[] args) {
        String phone = phoneNumber;
        String pass = password;

        ConsoleUtils consoleUtils = new ConsoleUtils();
        Donor donor = new Donor();
        donor.loginDonor(phoneNumber, password);

        final String RED = "\033[31m";
        final String RESET = "\033[0m";


        System.out.println("==========================================================================");
        System.out.println("\t\tDonation History");
        System.out.println("==========================================================================");

        try{
            File file = new File("DonationRequestHistory.txt");
            BufferedReader reader = new BufferedReader(new FileReader(file));

            String line;
            int count = 1;

            while ((line = reader.readLine()) != null) {
                String[] requestData = line.split(";");
                if (requestData.length > 1) {
                    String fileDonorID = requestData[0];
                    String recipientName = requestData[1];
                    String recipientPhoneNumber = requestData[2];
                    String donationType = requestData[3];
                    String status = requestData[4];

                    if (fileDonorID.equals(donor.getDonorID()) && !status.equals("Accepted") && !status.equals("Pending")) {
                        System.out.println(RED + "[" + count + "]" + RESET +
                                " Recipient Name: " + RED + recipientName + RESET + " | Contact Number: " + RED + recipientPhoneNumber + RESET + " | Donation Type: " + RED + donationType + RESET + " | Status: " + RED + status + RESET);
                        System.out.println("==========================================================================");
                        count++;
                    }
                }
            }

            if (count == 1) {
                System.out.println("No donation history found for this donor.");
            }
        } catch (Exception e) {
            System.out.println("Error reading the donation history file.");
            e.printStackTrace();
        }

        System.out.println("==========================================================================");

        System.out.println(RED + "[0]" + RESET + " Go back");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        switch (choice) {
            case 0:
                consoleUtils.clearScreen();
                Donor_UI.main(phone, pass, args);
                break;
            default:
                System.out.println("Invalid choice. Please select 0.");
        }
    }
}