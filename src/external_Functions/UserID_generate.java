package external_Functions;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class UserID_generate {

    public static String generateUserID() {
        ParseINT parseINT = new ParseINT();
        String donorID = "0";

        try {
            File file = new File("src/filemanagement/Donor.txt");
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] donor = line.split(";");
                if (donor.length > 7) {
                    donorID = donor[7];
                }
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        int id = parseINT.stringToInt(donorID);
        id += 1;
        return parseINT.intTOString(id);
    }

    public static void main(String[] args) {
        // Test generateUserID function
        System.out.println("Generated User ID: " + generateUserID() );
    }
}
