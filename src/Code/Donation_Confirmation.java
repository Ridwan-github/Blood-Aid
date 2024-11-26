package Code;

import java.awt.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.util.List;
import java.util.ArrayList;
import java.util.Vector;

public class Donation_Confirmation {
    public static void updateDonationState(String phoneNumber, String donorID, String donationType, String status){
        try{
            File file = new File("DonationRequestHistory.txt");
            List<String> lines = new ArrayList<>();

            try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    String[] requestData = line.split(";");
                    if (requestData[2].trim().equals(phoneNumber.trim()) &&
                            requestData[0].trim().equals(donorID.trim()) &&
                            requestData[3].trim().equals(donationType.trim()) &&
                            (requestData[4].trim().equals("Pending") && status.equals("Accepted"))    ||
                            (requestData[4].trim().equals("Accepted") && status.equals("Donated"))
                    ) {
                        requestData[4] = status;
                        line = String.join(";", requestData);
                    }
                    lines.add(line);
                }
            }

            try (BufferedWriter bufferedWriter = new BufferedWriter(new java.io.FileWriter(file, false))) {
                for (String line : lines) {
                    bufferedWriter.write(line);
                    bufferedWriter.newLine();
                }
            }
        } catch (Exception e){
            System.out.println("Error: " + e.getMessage());
        }
    }

    public Vector<String> donorsToConfirm(String phoneNumber){
        Vector<String> donorList = new Vector<>();
        try{
            File file = new File("DonationRequestHistory.txt");
            BufferedReader reader = new BufferedReader(new java.io.FileReader(file));

            String line;
            while((line = reader.readLine()) != null){
                String[] data = line.split(";");
                if(data[2].equals(phoneNumber) && data[4].equals("Donated") && !donorList.contains(data[0])){
                    donorList.add(data[0]);
                }
            }
        } catch (Exception e){
            System.out.println("Error: " + e.getMessage());
        }
        return donorList;
    }

    public static void main(String recipientPhoneNumber, String donorID, String donationType, String[] args) {

    }
}
