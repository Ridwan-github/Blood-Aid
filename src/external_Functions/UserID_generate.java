package external_Functions;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class UserID_generate {

    public static String generateUserID() {
        ParseINT parseINT = new ParseINT();
        String donorID = "0"; // Initialize with "0" to handle empty file or missing data

        try {
            File file = new File("src/filemanagement/Donor.txt");
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] donor = line.split("\t");
                if (donor.length > 7) {
                    donorID = donor[7]; // Get the donorID from the 8th column
                }
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Convert donorID to int and increment, then return as String
        int id = parseINT.stringToInt(donorID);
        id += 1;
        return parseINT.intTOString(id);
    }

    public static void main(String[] args) {
        // Test generateUserID function
        System.out.println("Generated User ID: " + generateUserID() );
    }
}
