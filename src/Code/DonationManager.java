package Code;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DonationManager {
    private String donorID;
    private String recipientPhoneNumber;
    private String status;

    public String getDonorID() {
        return donorID;
    }

    public void setDonorID(String donorID) {
        this.donorID = donorID;
    }

    public String getRecipientPhoneNumber() {
        return recipientPhoneNumber;
    }

    public void setRecipientPhoneNumber(String recipientPhoneNumber) {
        this.recipientPhoneNumber = recipientPhoneNumber;
    }

    public DonationManager(String donorID, String recipientPhoneNumber){
        this.donorID = donorID;
        this.recipientPhoneNumber = recipientPhoneNumber;
        this.status = "Pending";
    }
    public void addRequest(){
        try{
            File file = new File("DonationRequestHistory.txt");
            FileWriter fileWriter = new FileWriter(file, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(
                    donorID + ";" +
                            recipientPhoneNumber + ";" +
                                status

            );
            bufferedWriter.newLine();
            bufferedWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void removeRequest(String donorID, String recipientID) {
        File file = new File("DonationRequestHistory.txt");
        List<String> lines = new ArrayList<>();
        boolean requestFound = false;

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] requestData = line.split(";");
                if (requestData.length == 3 && requestData[0].equals(donorID) && requestData[1].equals(recipientID)) {
                    requestFound = true;
                    continue;
                }
                lines.add(line);
            }
            bufferedReader.close();

            if (requestFound) {
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
                for (String remainingLine : lines) {
                    bufferedWriter.write(remainingLine);
                    bufferedWriter.newLine();
                }
                bufferedWriter.close();
            } else {
                System.out.println("Request not found for Donor ID: " + donorID + ", Recipient ID: " + recipientID);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

