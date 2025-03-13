package UI;

import Code.Donor;
import Code.Recipient;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

public class ReceivedHistory_UI {
    public static void main(String phoneNumber, String password, String[] args) {
        String phone = phoneNumber;
        String pass = password;

        ConsoleUtils consoleUtils = new ConsoleUtils();
        Recipient recipient = new Recipient();
        recipient.loginRecipient(phone, pass);

        final String RED = "\033[31m";
        final String RESET = "\033[0m";


        System.out.println("==========================================================================");
        System.out.println("                       Blood Received History");
        System.out.println("==========================================================================");

        int count = 1;

        try{
            File file = new File("DonationRequestHistory.txt");
            BufferedReader reader = new BufferedReader(new FileReader(file));

            String line;

            while ((line = reader.readLine()) != null) {
                String[] requestData = line.split(";");
                if (requestData.length > 1) {
                    String fileDonorID = requestData[0];
                    String recipientName = requestData[1];
                    String recipientPhoneNumber = requestData[2];
                    String donationType = requestData[3];
                    String status = requestData[4];

                    if (recipientPhoneNumber.equals(phone) && status.equals("Donated")) {
                        System.out.println(RED + "[" + count + "]" + RESET + "Donor ID: " + RED + fileDonorID + RESET +
                                " Recipient Name: " + RED + recipientName + RESET + " | Contact Number: " + RED + recipientPhoneNumber + RESET + " | Donation Type: " + RED + donationType + RESET + " | Status: " + RED + status + RESET);
                        System.out.println("==========================================================================");
                        count++;
                    }
                }
            }

        } catch (Exception e) {
            System.out.println("Error reading the donation history file.");
            e.printStackTrace();
        }

        if (count == 1) {
            System.out.println("No blood receive history found for this donor.");
            System.out.println("Going back to Dashboard ......");
            consoleUtils.holdTime();
            consoleUtils.clearScreen();
            Recipient_UI.main(phone, pass, args);
        } else {
            System.out.println("==========================================================================");

            System.out.println(RED + "[0]" + RESET + " Go back");
            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();

            while (choice != 0) {
                System.out.println("Invalid choice. Please select a valid option.");
                choice = scanner.nextInt();
            }

            consoleUtils.clearScreen();
            Recipient_UI.main(phone, pass, args);
        }


    }
}
