package Code;

import external_Functions.PasswordCipher;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TopDonor {
    Donor donor = new Donor();

    public void showTopDonors(){

        final String RED = "\033[31m";
        final String RESET = "\033[0m";

        try{
            File file = new File("Donor.txt");
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            List<Donor> donorList = new ArrayList<>();
            PasswordCipher passwordCipher = new PasswordCipher();
            String line;
            System.out.println("==============================================================================================");
            System.out.println("                    Top Donor's");
            while ((line = bufferedReader.readLine()) != null) {
                String[] data = line.split(";");
                if(!data[8].equals("0")){
                    Donor donor = new Donor();
                    donor.loginDonor(data[1], passwordCipher.decryptPassword(data[6]));
                    donorList.add(donor);
                }
            }

            donorList = arrangeDonorByID(donorList);

            int i = 1;
            for(Donor donor: donorList){
                if (donor.getPoints() > 0){
                    System.out.println("==============================================================================================");
                    System.out.printf( RED + "%d. ", i++);
                    System.out.println(RESET + "Name: " + donor.getName());
                    System.out.println("Points: " + donor.getPoints());
                }
            }
        } catch (IOException ae) {
            ae.printStackTrace();
        }
    }

    public List<Donor> arrangeDonorByID(List<Donor> donorList){
        Collections.sort(donorList, Comparator.comparingInt(Donor::getPoints).reversed());
        return donorList;
    }
}
