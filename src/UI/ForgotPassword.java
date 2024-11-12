package UI;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ForgotPassword {

    public void forgotDonorPassword(String email, String phoneNumber, String username){
        try{
            File file = new File("Donor.txt");
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] donor = line.split(";");
                if (donor.length > 12) {
                    if (donor[12].equals(username) && donor[1].equals(phoneNumber) && donor[2].equals(email)) {
                        System.out.println("Your password is: " + donor[13]);
                        return;
                    }
                }
            }
            System.out.println("Invalid credentials");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        System.out.println("==============================================================================================");
        System.out.println("                                    Forgot Password");
        System.out.println("==============================================================================================");
        System.out.println("Enter your email: ");
        System.out.println("Enter your Phone Number: ");
    }
}
