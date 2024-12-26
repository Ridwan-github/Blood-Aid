package Code;

import external_Functions.CurrentDate;

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

    public DonationManager(String donorID, String recipientPhoneNumber) {
        this.donorID = donorID;
        this.recipientPhoneNumber = recipientPhoneNumber;
    }

    public DonationManager(String recipientPhoneNumber) {
        this.recipientPhoneNumber = recipientPhoneNumber;
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
        updateNotification(donorID, "true");
    }

    public DonationManager(){}

    public void acceptRequest() {
        File file = new File("DonationRequestHistory.txt");
        List<String> lines = new ArrayList<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] requestData = line.split(";");
                if (requestData[0].trim().equals(donorID.trim()) &&
                        requestData[2].trim().equals(recipientPhoneNumber.trim()) &&
                        requestData[4].trim().equals("Accepted")) {

                    requestData[4] = "Donated";
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

    public void removeOnePendingRequests() {
        File file = new File("DonationRequestHistory.txt");
        List<String> lines = new ArrayList<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] requestData = line.split(";");

                if (!(requestData[0].trim().equals(donorID.trim()) && requestData[2].trim().equals(recipientPhoneNumber.trim()) && requestData[4].trim().equals("Pending"))) {
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
        System.out.println("All pending requests removed");
    }

    public void removePendingRequestsForRecipient() {
        File file = new File("DonationRequestHistory.txt");
        List<String> lines = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] requestData = line.split(";");
                if (requestData.length == 5) {
                    String recipientPhoneNumber = requestData[2];
                    String status = requestData[4];

                    if (recipientPhoneNumber.equals(this.recipientPhoneNumber) && !status.equals("Donated")) {
                        continue;
                    }
                }
                lines.add(line);
            }

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


    public void updateEligibilityStatus(String donationType){
        File file = new File("Donor.txt");
        List<String> lines = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;

            CurrentDate currentDate = new CurrentDate();
            String currentdate = currentDate.getDateAsString();

            while ((line = reader.readLine()) != null) {
                String[] data = line.split(";");
                if (data.length > 0) {
                    String donorId = data[7];

                    if (donorId.equals(donorID)) {
                        if (donationType.equals("Whole Blood")){
                            lines.add(data[0] + ";" + data[1] + ";" + data[2] + ";" + data[3] + ";" + data[4] + ";" + data[5] + ";" + data[6] + ";" + data[7] + ";" + data[8] + ";" + data[9] + ";" + data[10] + ";" + data[11] + ";" + data[12] + ";" + data[13] + ";false;" + data[15] + ";" + data[16] + ";" + data[17] + ";" + currentdate + ";" + data[19] + ";" + data[20] + ";" + data[21] + ";" + data[22] + ";" + data[23] + ";");
                        } else if (donationType.equals("Plasma")){
                            lines.add(data[0] + ";" + data[1] + ";" + data[2] + ";" + data[3] + ";" + data[4] + ";" + data[5] + ";" + data[6] + ";" + data[7] + ";" + data[8] + ";" + data[9] + ";" + data[10] + ";" + data[11] + ";" + data[12] + ";" + data[13] + ";" + data[14] + ";false;" + data[16] + ";" + data[17] + ";" + data[18] + ";" + currentdate + ";" + data[20] + ";" + data[21] + ";" + data[22] + ";" + data[23] + ";");
                        } else if (donationType.equals("Platelets")){
                            lines.add(data[0] + ";" + data[1] + ";" + data[2] + ";" + data[3] + ";" + data[4] + ";" + data[5] + ";" + data[6] + ";" + data[7] + ";" + data[8] + ";" + data[9] + ";" + data[10] + ";" + data[11] + ";" + data[12] + ";" + data[13] + ";" + data[14] + ";" + data[15] + ";false;" + data[17] + ";" + data[18] + ";" + data[19] + ";" + currentdate + ";" + data[21] + ";" + data[22] + ";" + data[23] + ";");
                        } else if (donationType.equals("Power Red")){
                            lines.add(data[0] + ";" + data[1] + ";" + data[2] + ";" + data[3] + ";" + data[4] + ";" + data[5] + ";" + data[6] + ";" + data[7] + ";" + data[8] + ";" + data[9] + ";" + data[10] + ";" + data[11] + ";" + data[12] + ";" + data[13] + ";" + data[14] + ";" + data[15] + ";" + data[16] + "false;" + data[18] + ";" + data[19] + ";" + data[20] + ";" + currentdate + ";" + data[22] + ";" + data[23] + ";");
                        }
                    } else {
                        lines.add(line);
                    }
                }
            }

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, false))) {
                for (String updatedLine : lines) {
                    writer.write(updatedLine);
                    writer.newLine();
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void updateNotification(String donorID, String tf){
        File file = new File("Donor.txt");
        List<String> lines = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;

            while ((line = reader.readLine()) != null) {
                String[] data = line.split(";");
                if (data.length > 0) {
                    String donorId = data[7];

                    if (donorId.equals(donorID)) {
                        lines.add(data[0] + ";" + data[1] + ";" + data[2] + ";" + data[3] + ";" + data[4] + ";" + data[5] + ";" + data[6] + ";" + data[7] + ";" + data[8] + ";" + data[9] + ";" + data[10] + ";" + data[11] + ";" + data[12] + ";" + data[13] + ";" + data[14] + ";" + data[15] + ";" + data[16] + ";" + data[17] + ";" + data[18] + ";" + data[19] + ";" + data[20] + ";" + data[21] + ";" + tf +";" + data[23] + ";");
                    } else {
                        lines.add(line);
                    }
                }
            }

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, false))) {
                for (String updatedLine : lines) {
                    writer.write(updatedLine);
                    writer.newLine();
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getDonationType(){
        String donationType = "";
        try{
            File file = new File("DonationRequestHistory.txt");
            BufferedReader reader = new BufferedReader(new java.io.FileReader(file));
            String line;
            while((line = reader.readLine()) != null){
                String[] data = line.split(";");
                if(data[2].equals(recipientPhoneNumber) && data[0].equals(donorID)){
                    donationType = data[3];
                }
            }
        } catch (Exception e){
            System.out.println("Error: " + e.getMessage());
        }
        return donationType;
    }


}
