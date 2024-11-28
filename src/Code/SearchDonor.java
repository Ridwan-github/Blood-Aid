package Code;

import external_Functions.MyVector;
import external_Functions.PasswordCipher;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SearchDonor {
    public void searchDonors(String bloodGroup, String city, String area, String donationType, MyVector donorData) {

        final String RED = "\033[31m";
        final String RESET = "\033[0m";

        try{
            File file = new File("Donor.txt");
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            List<Donor> donorList = new ArrayList<>();
            PasswordCipher passwordCipher = new PasswordCipher();
            String line;
            System.out.println("==============================================================================================");
            System.out.println("                    Donor's in your Area");
            while ((line = bufferedReader.readLine()) != null) {
                String[] data = line.split(";");
                if(data[4].equals(bloodGroup) && data[3].equals(area) && ((donationType == "wbc" && data[14].equals("true")) || (donationType == "platelet" && data[15].equals("true") || (donationType == "plasma" && data[16].equals("true")) || (donationType == "powerRed" && data[17].equals("true"))))){
                    Donor donor = new Donor();
                    donor.loginDonor(data[1], passwordCipher.decryptPassword(data[6]));
                    donorList.add(donor);
                    donorData.add(data[7]);
                }
            }

            donorList = arrangeDonorByID(donorList);

            for(Donor d: donorList){
                System.out.println("==============================================================================================");
                System.out.println(RED + "Name: " + RESET + d.getName());
                System.out.println(RED + "Phone Number: " + RESET + d.getPhoneNumber());
                System.out.println(RED + "City: " + RESET + d.getCity());
                System.out.println(RED + "Area: " + RESET + d.getArea());
                System.out.println(RED + "Blood Group: " + RESET + d.getBloodGroup());
                System.out.println(RED + "Donor ID: " + RESET + d.getDonorID());
                System.out.println(RED + "Points: " + RESET + d.getPoints());
            }
        } catch (IOException ae){
            ae.printStackTrace();
        }

        try{
            File file = new File("Donor.txt");
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            List<Donor> donorList = new ArrayList<>();
            PasswordCipher passwordCipher = new PasswordCipher();
            String line;
            System.out.println("==============================================================================================");
            System.out.println("                    Donor's in your city");
            while ((line = bufferedReader.readLine()) != null) {
                String[] data = line.split(";");
                if(data[4].equals(bloodGroup) && data[2].equals(city) && !data[3].equals(area) && ((donationType == "wbc" && data[14].equals("true")) || (donationType == "platelet" && data[15].equals("true") || (donationType == "plasma" && data[16].equals("true")) || (donationType == "powerRed" && data[17].equals("true"))))){
                    Donor donor = new Donor();
                    donor.loginDonor(data[1], passwordCipher.decryptPassword(data[6]));
                    donorList.add(donor);
                    donorData.add(data[7]);
                }
            }

            donorList = arrangeDonorByID(donorList);

            for(Donor d: donorList){
                System.out.println("==============================================================================================");
                System.out.println(RED + "Name: " + RESET + d.getName());
                System.out.println(RED + "Phone Number: " + RESET + d.getPhoneNumber());
                System.out.println(RED + "City: " + RESET + d.getCity());
                System.out.println(RED + "Area: " + RESET + d.getArea());
                System.out.println(RED + "Blood Group: " + RESET + d.getBloodGroup());
                System.out.println(RED + "Donor ID: " + RESET + d.getDonorID());
                System.out.println(RED + "Points: " + RESET + d.getPoints());
            }
        } catch (IOException ae){
            ae.printStackTrace();
        }

        try{
            File file = new File("Donor.txt");
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            List<Donor> donorList = new ArrayList<>();
            PasswordCipher passwordCipher = new PasswordCipher();
            String line;
            System.out.println("==============================================================================================");
            System.out.println("                    Donor's outside your city");
            while ((line = bufferedReader.readLine()) != null) {
                String[] data = line.split(";");
                if(data[4].equals(bloodGroup) && !data[2].equals(city) && !data[3].equals(area) && ((donationType.equals("wbc")  && data[14].equals("true")) || (donationType .equals("platelet")  && data[15].equals("true") || (donationType .equals("plasma") && data[16].equals("true")) || (donationType .equals("powerRed") && data[17].equals("true"))))){
                    Donor donor = new Donor();
                    donor.loginDonor(data[1], passwordCipher.decryptPassword(data[6]));
                    donorList.add(donor);
                    donorData.add(data[7]);
                }
            }

            donorList = arrangeDonorByID(donorList);

            for(Donor d: donorList){
                System.out.println("==============================================================================================");
                System.out.println(RED + "Name: " + RESET + d.getName());
                System.out.println(RED + "Phone Number: " + RESET + d.getPhoneNumber());
                System.out.println(RED + "City: " + RESET + d.getCity());
                System.out.println(RED + "Area: " + RESET + d.getArea());
                System.out.println(RED + "Blood Group: " + RESET + d.getBloodGroup());
                System.out.println(RED + "Donor ID: " + RESET + d.getDonorID());
                System.out.println(RED + "Points: " + RESET + d.getPoints());
            }
        } catch (IOException ae){
            ae.printStackTrace();
        }
    }

    public List<Donor> arrangeDonorByID(List<Donor> donorList){
        Collections.sort(donorList, Comparator.comparingInt(Donor::getPoints).reversed());
        return donorList;
    }
}
