package Code;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DonationManager {
    private String donorID;
    private String recipientName;
    private String recipientPhoneNumber;
    private String status;
    private String donationType;

    public DonationManager(String donorID, String recipientName, String recipientPhoneNumber, String donationType) {
        this.donorID = donorID;
        this.recipientName = recipientName;
        this.recipientPhoneNumber = recipientPhoneNumber;
        this.status = "Pending";
        this.donationType = donationType;
    }

    public void addRequest() {
        try {
            File file = new File("DonationRequestHistory.txt");
            FileWriter fileWriter = new FileWriter(file, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(donorID + ";" + recipientName + ";" + recipientPhoneNumber + ";" + donationType + ";" + status);
            bufferedWriter.newLine();
            bufferedWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public DonationManager(String donorID, String recipientPhoneNumber) {
        this.donorID = donorID;
        this.recipientPhoneNumber = recipientPhoneNumber;
    }
    public void acceptRequest() {
        File file = new File("DonationRequestHistory.txt");
        List<String> lines = new ArrayList<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] requestData = line.split(";");
                if (requestData.length == 5 && requestData[0].trim().equals(donorID.trim()) &&
                        requestData[2].trim().equals(recipientPhoneNumber.trim()) &&
                        requestData[4].trim().equals("Pending")) {

                    requestData[4] = "Accepted";
                    line = String.join(";", requestData);
                }
                lines.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))) {
            for (String updatedLine : lines) {
                bufferedWriter.write(updatedLine);
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Request status updated to 'Accepted' for Donor ID: " + donorID + ", Recipient Phone: " + recipientPhoneNumber);
    }
    public void removePendingRequests() {
        File file = new File("DonationRequestHistory.txt");
        List<String> lines = new ArrayList<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] requestData = line.split(";");

                if (!(requestData[0].trim().equals(donorID.trim()) && requestData[4].trim().equals("Pending"))) {
                    lines.add(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))) {
            for (String remainingLine : lines) {
                bufferedWriter.write(remainingLine);
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("All pending requests removed for Donor ID: " + donorID);
    }
    public void removePendingRequestsForRecipient() {
        File file = new File("DonationRequestHistory.txt");
        List<String> lines = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] requestData = line.split(";");
                if (requestData.length == 5) {
                    String fileDonorID = requestData[0];
                    String recipientPhoneNumber = requestData[2];
                    String status = requestData[4];

                    // Only keep the accepted request for the recipient and remove other requests with pending status
                    if (recipientPhoneNumber.equals(this.recipientPhoneNumber) && !status.equals("Accepted")) {
                        continue; // Skip adding this line (it will be removed)
                    }
                }
                lines.add(line);
            }

            // Write the updated list back to the file
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                for (String updatedLine : lines) {
                    writer.write(updatedLine);
                    writer.newLine();
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
