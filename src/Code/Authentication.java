package Code;
import UI.*;

import java.io.BufferedReader;
import java.io.File;

public class Authentication {
    public Donor loginDonor(String phoneNumber, String password) {
        Donor donor = null;
        try {
            File file = new File("src/filemanagement/Signup.txt");
            BufferedReader bufferedReader = new BufferedReader(new java.io.FileReader(file));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] data = line.split("\t|");
                if (data[1].equals(phoneNumber) && data[6].equals(password)) {
                    donor = new Donor();
                    donor.setName(data[0]);
                    donor.setPhoneNumber(data[1]);
                    donor.setcity(data[2]);
                    donor.setArea(data[3]);
                    donor.setBloodGroup(data[4]);
                    donor.setNID(data[5]);
                    donor.setPassword(data[6]);
                    break;
                }
            }
            bufferedReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return donor;
    }
}