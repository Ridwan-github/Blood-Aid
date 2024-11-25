package Code;

<<<<<<< Updated upstream
=======
import external_Functions.CurrentDate;
import external_Functions.MyDate;

import java.io.*;
import java.util.ArrayList;
>>>>>>> Stashed changes
import java.util.List;

class DonationManager {
    private FileManager fileManager;
    private List<DonationHistory> donationHistories;

    public void recordDonation(Donor donor, DonationType donationType){

    }
    public boolean isEligibleForDonation(Donor donor, DonationType donationType){
        return false;
    }
    public void updatePoints(Donor donor, int points){

    }
    public void saveDonationHistory(){

    }
    public void loadDonationHistory(){

    }
<<<<<<< Updated upstream
}
=======
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

                    if (recipientPhoneNumber.equals(this.recipientPhoneNumber) && !status.equals("Accepted")) {
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

    public void updateEligibleStatues(String donationType){
        try{
            List<String> lines = new ArrayList<>();
            BufferedReader reader = new BufferedReader(new FileReader("Donor.txt"));
            String header = reader.readLine();
            lines.add(header);

            String line;
            while ((line = reader.readLine()) != null) {
                String[] donorData = line.split(";");
                if (donorData.length > 0 && donorData[7].equals(donorID)) {
                    CurrentDate currentDate = new CurrentDate();

                    if (donationType.equals("Whole Blood")){
                        donorData[15] = "false";
                        donorData[19] = currentDate.toString();
                    } else if (donationType.equals("Plasma")){
                        donorData[16] = "false";
                        donorData[20] = currentDate.toString();
                    } else if (donationType.equals("Platelets")){
                        donorData[17] = "false";
                        donorData[21] = currentDate.toString();
                    } else if (donationType.equals("Power Red")){
                        donorData[18] = "false";
                        donorData[22] = currentDate.toString();
                    }
                } else {
                    lines.add(line);
                }
                lines.add(String.join(";", donorData));
            }

            reader.close();

            BufferedWriter writer = new BufferedWriter(new FileWriter("Donor.txt", false));

            for (String updatedLine : lines) {
                writer.write(updatedLine);
                writer.newLine();
            }

            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }


}
>>>>>>> Stashed changes
