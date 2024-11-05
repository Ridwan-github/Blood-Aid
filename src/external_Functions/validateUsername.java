package external_Functions;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class validateUsername {
    public boolean validate(String username) {
        try{
            File file = new File("src/filemanagement/Donor.txt");
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] donor = line.split(";");
                if (donor.length > 12) {
                    if (donor[12].equals(username)) {
                        return false;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
    }
        return true;
    }

    public static void main(String[] args) {
        validateUsername validateUsername = new validateUsername();
        System.out.println(validateUsername.validate("user2"));
    }
}
