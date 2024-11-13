package UI;

import external_Functions.PasswordCipher;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ForgotPassword {

    public void forgotDonorPassword(String email, String phoneNumber, String username){
        PasswordCipher pc = new PasswordCipher();
        ConsoleUtils consoleUtils = new ConsoleUtils();
        try{
            File file = new File("Donor.txt");
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] donor = line.split(";");
                if (donor.length > 12) {
                    if (donor[11].equals(username) && donor[1].equals(phoneNumber) && donor[13].equals(email)) {
                        String password = pc.decryptPassword(donor[6]);
                        System.out.println("Your password is: " + password);
                        System.out.println("logging you in...");
                        consoleUtils.holdTime();
                        consoleUtils.clearScreen();
                        Donor_UI.main(phoneNumber, password, null);
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
