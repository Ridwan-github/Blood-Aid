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
    public List<Donor> getListOfDonor(String bloodGroup, String city, String area, String donationType, String phoneNumber) {
        List<Donor> donorList = new ArrayList<>();
        try{
            File file = new File("Donor.txt");
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            PasswordCipher passwordCipher = new PasswordCipher();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] data = line.split(";");
                if(data[4].equals(bloodGroup) && data[23].equals("true") && data[3].equals(area) && !data[1].equals(phoneNumber) && ((donationType == "wbc" && data[14].equals("true")) || (donationType == "platelet" && data[15].equals("true") || (donationType == "plasma" && data[16].equals("true")) || (donationType == "powerRed" && data[17].equals("true"))))){
                    Donor donor = new Donor();
                    donor.loginDonor(data[1], passwordCipher.decryptPassword(data[6]));
                    donorList.add(donor);
                }
            }
        } catch (IOException ae){
            ae.printStackTrace();
        }
        return donorList;
    }

    public void searchDonors(String bloodGroup, String city, String area, String donationType, MyVector donorData, String phoneNumber) {

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
                if(data[4].equals(bloodGroup) && data[23].equals("true") && data[3].equals(area) && !data[1].equals(phoneNumber) && ((donationType == "wbc" && data[14].equals("true")) || (donationType == "platelet" && data[15].equals("true") || (donationType == "plasma" && data[16].equals("true")) || (donationType == "powerRed" && data[17].equals("true"))))){
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

                BadgeManagement badgeManagement = new BadgeManagement();
                badgeManagement.updateFrequentDonorBadge(d.getDonorID());
                badgeManagement.updateLifeSaverBadge(d.getDonorID());
                if (badgeManagement.checkForFirstDropBadge(d.getDonorID()) || badgeManagement.checkForFrequentDonorBadge(d.getDonorID()) || badgeManagement.checkForLifeSaverBadge(d.getDonorID()) || badgeManagement.checkForPioneerBadge(d.getDonorID()) || badgeManagement.checkForRareBloodHeroBadge(d.getDonorID())) {
                    System.out.println();
                    System.out.println(RED + "\t\t\t\tBadges: " + RESET);
                    if (badgeManagement.checkForFirstDropBadge(d.getDonorID())) {
                        System.out.printf("  |" + RED + "First Drop" + RESET);
                    }
                    if (badgeManagement.checkForFrequentDonorBadge(d.getDonorID())) {
                        System.out.printf("  |" + RED + "Frequent Donor" + RESET);
                    }
                    if (badgeManagement.checkForLifeSaverBadge(d.getDonorID())) {
                        System.out.printf("  |" + RED + "Life Saver" + RESET);
                    }
                    if (badgeManagement.checkForPioneerBadge(d.getDonorID())) {
                        System.out.printf("  |" + RED + "Pioneer" + RESET);
                    }
                    if (badgeManagement.checkForRareBloodHeroBadge(d.getDonorID())) {
                        System.out.printf("  |" + RED + "Rare Blood Hero" + RESET);
                    }
                    System.out.println("|");
                }
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
                if(data[4].equals(bloodGroup) && data[23].equals("true") && data[2].equals(city) && !data[3].equals(area) && !data[1].equals(phoneNumber) && ((donationType == "wbc" && data[14].equals("true")) || (donationType == "platelet" && data[15].equals("true") || (donationType == "plasma" && data[16].equals("true")) || (donationType == "powerRed" && data[17].equals("true"))))){
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

                BadgeManagement badgeManagement = new BadgeManagement();
                badgeManagement.updateFrequentDonorBadge(d.getDonorID());
                badgeManagement.updateLifeSaverBadge(d.getDonorID());
                if (badgeManagement.checkForFirstDropBadge(d.getDonorID()) || badgeManagement.checkForFrequentDonorBadge(d.getDonorID()) || badgeManagement.checkForLifeSaverBadge(d.getDonorID()) || badgeManagement.checkForPioneerBadge(d.getDonorID()) || badgeManagement.checkForRareBloodHeroBadge(d.getDonorID())) {
                    System.out.println();
                    System.out.println(RED + "\t\t\t\tBadges: " + RESET);
                    if (badgeManagement.checkForFirstDropBadge(d.getDonorID())) {
                        System.out.printf("  |" + RED + "First Drop" + RESET);
                    }
                    if (badgeManagement.checkForFrequentDonorBadge(d.getDonorID())) {
                        System.out.printf("  |" + RED + "Frequent Donor" + RESET);
                    }
                    if (badgeManagement.checkForLifeSaverBadge(d.getDonorID())) {
                        System.out.printf("  |" + RED + "Life Saver" + RESET);
                    }
                    if (badgeManagement.checkForPioneerBadge(d.getDonorID())) {
                        System.out.printf("  |" + RED + "Pioneer" + RESET);
                    }
                    if (badgeManagement.checkForRareBloodHeroBadge(d.getDonorID())) {
                        System.out.printf("  |" + RED + "Rare Blood Hero" + RESET);
                    }
                    System.out.println("|");
                }
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
                if(data[4].equals(bloodGroup) && data[23].equals("true") && !data[2].equals(city) && !data[3].equals(area) && !data[1].equals(phoneNumber) && (donationType.equals("wbc")  && data[14].equals("true")) || (donationType .equals("platelet")  && data[15].equals("true") || (donationType .equals("plasma") && data[16].equals("true")) || (donationType .equals("powerRed") && data[17].equals("true")))){
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

                BadgeManagement badgeManagement = new BadgeManagement();
                badgeManagement.updateFrequentDonorBadge(d.getDonorID());
                badgeManagement.updateLifeSaverBadge(d.getDonorID());
                if (badgeManagement.checkForFirstDropBadge(d.getDonorID()) || badgeManagement.checkForFrequentDonorBadge(d.getDonorID()) || badgeManagement.checkForLifeSaverBadge(d.getDonorID()) || badgeManagement.checkForPioneerBadge(d.getDonorID()) || badgeManagement.checkForRareBloodHeroBadge(d.getDonorID())) {
                    System.out.println();
                    System.out.println(RED + "\t\t\t\tBadges: " + RESET);
                    if (badgeManagement.checkForFirstDropBadge(d.getDonorID())) {
                        System.out.printf("  |" + RED + "First Drop" + RESET);
                    }
                    if (badgeManagement.checkForFrequentDonorBadge(d.getDonorID())) {
                        System.out.printf("  |" + RED + "Frequent Donor" + RESET);
                    }
                    if (badgeManagement.checkForLifeSaverBadge(d.getDonorID())) {
                        System.out.printf("  |" + RED + "Life Saver" + RESET);
                    }
                    if (badgeManagement.checkForPioneerBadge(d.getDonorID())) {
                        System.out.printf("  |" + RED + "Pioneer" + RESET);
                    }
                    if (badgeManagement.checkForRareBloodHeroBadge(d.getDonorID())) {
                        System.out.printf("  |" + RED + "Rare Blood Hero" + RESET);
                    }
                    System.out.println("|");
                }
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
