package Code;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DonationManager {
    private String donorID;
    private String recipientName;
    private String recipientPhoneNumber;
    private String status;

    public String getRecipientPhoneNumber() {
        return recipientPhoneNumber;
    }

    public void setRecipientPhoneNumber(String recipientPhoneNumber) {
        this.recipientPhoneNumber = recipientPhoneNumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDonorID() {
        return donorID;
    }

    public void setDonorID(String donorID) {
        this.donorID = donorID;
    }

    public String getRecipientName() {
        return recipientName;
    }

    public void setRecipientName(String recipientName) {
        this.recipientName = recipientName;
    }

    public DonationManager(String donorID, String recipientName, String recipientPhoneNumber){
        this.donorID = donorID;
        this.recipientName = recipientName;
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
                            recipientName + ";" +
                                recipientPhoneNumber + ";" +
                                    status

            );
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

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] requestData = line.split(";");
                if (requestData.length == 3 && requestData[0].equals(donorID) && requestData[2].equals(recipientPhoneNumber)) {
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
                System.out.println("Request not found for Donor ID: " + donorID + ", Recipient ID: " + recipientPhoneNumber);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

