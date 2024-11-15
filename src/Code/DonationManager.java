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

    public void removeRequest() {
        File file = new File("DonationRequestHistory.txt");
        List<String> lines = new ArrayList<>();
        boolean requestFound = false;

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] requestData = line.split(";");

                if (requestData.length == 5) {
                    String fileDonorID = requestData[0].trim();

                    // Skip lines matching donorID to remove all requests for that donor
                    if (fileDonorID.equals(donorID.trim())) {
                        requestFound = true;
                        continue;
                    }

                    lines.add(line);
                }
            }

            if (requestFound) {
                try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))) {
                    for (String remainingLine : lines) {
                        bufferedWriter.write(remainingLine);
                        bufferedWriter.newLine();
                    }
                }
                System.out.println("All requests successfully removed for Donor ID: " + donorID);
            } else {
                System.out.println("No requests found for Donor ID: " + donorID);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
