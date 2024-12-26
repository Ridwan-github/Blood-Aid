package UI;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RecipientRequestCancel_UI {
    public static void main(String phoneNumber, String password, String[] args) {
        final String RED = "\033[31m";
        final String RESET = "\033[0m";

        System.out.println("==============================================================================================");
        System.out.println("                                    Request List");
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
    }
}
