package UI;

import Code.AuthorizationConstraintsValidator;
import Code.DonationManager;
import Code.Donor;
import Code.Recipient;
import external_Functions.MyVector;
import external_Functions.toLower;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Search_UI {
    final String RED = "\033[31m";
    final String RESET = "\033[0m";

    public void searchDonors(String bloodGroup, String city, String area, String donationType, MyVector donorData) {
        Donor donor = new Donor();

        try{
            File file = new File("Donor.txt");
            BufferedReader bufferedReader = new BufferedReader(new java.io.FileReader(file));
            String line;
            System.out.println("==============================================================================================");
            System.out.println("                    Donor's in your Area");
            while ((line = bufferedReader.readLine()) != null) {
                String[] data = line.split(";");
                if(data[4].equals(bloodGroup) && data[3].equals(area) && ((donationType == "wbc" && data[14].equals("true")) || (donationType == "platelet" && data[15].equals("true") || (donationType == "plasma" && data[16].equals("true")) || (donationType == "powerRed" && data[17].equals("true"))))){
                    System.out.println("==============================================================================================");
                    System.out.println(RED + "Name: " +RESET + data[0]);
                    System.out.println(RED + "Phone Number: " + RESET + data[1]);
                    System.out.println(RED + "City: " + RESET + data[2]);
                    System.out.println(RED + "Area: " + RESET + data[3]);
                    System.out.println(RED + "Blood Group: " + RESET + data[4]);
                    System.out.println(RED + "Donor ID: " + RESET + data[7]);
                    System.out.println(RED + "Points: " + RESET + data[8]);
                    donorData.add(data[7]);
                }
            }
        } catch (IOException ae){
            ae.printStackTrace();
        }

        try{
            File file = new File("Donor.txt");
            BufferedReader bufferedReader = new BufferedReader(new java.io.FileReader(file));
            String line;
            System.out.println("==============================================================================================");
            System.out.println("                    Donor's in your city");
            while ((line = bufferedReader.readLine()) != null) {
                String[] data = line.split(";");
                if(data[4].equals(bloodGroup) && data[2].equals(city) && !data[3].equals(area) && ((donationType == "wbc" && data[14].equals("true")) || (donationType == "platelet" && data[15].equals("true") || (donationType == "plasma" && data[16].equals("true")) || (donationType == "powerRed" && data[17].equals("true"))))){
                    System.out.println("==============================================================================================");
                    System.out.println(RED + "Name: " + RESET + data[0]);
                    System.out.println(RED + "Phone Number: " + RESET + data[1]);
                    System.out.println(RED + "City: " + RESET + data[2]);
                    System.out.println(RED + "Area: " + RESET + data[3]);
                    System.out.println(RED + "Blood Group: " + RESET + data[4]);
                    System.out.println(RED + "Donor ID: " + RESET + data[7]);
                    System.out.println(RED + "Points: " + RESET + data[8]);
                    donorData.add(data[7]);
                }
            }
        } catch (IOException ae){
            ae.printStackTrace();
        }

        try{
            File file = new File("Donor.txt");
            BufferedReader bufferedReader = new BufferedReader(new java.io.FileReader(file));
            String line;
            System.out.println("==============================================================================================");
            System.out.println("                    Donor's outside your city");
            while ((line = bufferedReader.readLine()) != null) {
                String[] data = line.split(";");
                if(data[4].equals(bloodGroup) && !data[2].equals(city) && !data[3].equals(area) && ((donationType == "wbc" && data[14].equals("true")) || (donationType == "platelet" && data[15].equals("true") || (donationType == "plasma" && data[16].equals("true")) || (donationType == "powerRed" && data[17].equals("true"))))){
                    System.out.println("==============================================================================================");
                    System.out.println(RED + "Name: " + RESET + data[0]);
                    System.out.println(RED + "Phone Number: " + RESET + data[1]);
                    System.out.println(RED + "City: " + RESET + data[2]);
                    System.out.println(RED + "Area: " + RESET + data[3]);
                    System.out.println(RED + "Blood Group: " + RESET + data[4]);
                    System.out.println(RED + "Donor ID: " + RESET + data[7]);
                    System.out.println(RED + "Points: " + RESET + data[8]);
                    donorData.add(data[7]);
                }
            }
        } catch (IOException ae){
            ae.printStackTrace();
        }
    }

    public static void main(String phone, String password, String[] args) {
        AuthorizationConstraintsValidator validate = new AuthorizationConstraintsValidator();
        Donor donor = new Donor();
        Recipient recipient = new Recipient();
        String city, area, bloodGroup;
        Search_UI s = new Search_UI();
        Scanner scanner = new Scanner(System.in);
        toLower toLower = new toLower();
        MyVector donorData = new MyVector();

        AuthorizationConstraintsValidator authorizationConstraintsValidator = new AuthorizationConstraintsValidator();

        final String RED = "\033[31m";
        final String RESET = "\033[0m";

        System.out.println("==============================================================================================");
        System.out.println("                                    Search Donors");
        System.out.println("==============================================================================================");
        System.out.printf(RED + "Enter the blood group you are looking for: " + RESET);
        bloodGroup = scanner.nextLine();
        while (!validate.validateBloodGroup(bloodGroup)){
            System.out.printf("Invalid blood group. " + RED +  "Enter again: " + RESET);
            bloodGroup = scanner.nextLine();
        }
        System.out.println(RED + "Enter your location: " + RESET);
        System.out.printf("City: ");
        city = scanner.nextLine();
        city = toLower.toLower(city);
        while (!authorizationConstraintsValidator.validCity(city)){
            System.out.printf("Invalid city. " + RED + "Enter again: " + RESET);
            city = scanner.nextLine();
            city = toLower.toLower(city);
        }
        System.out.printf("Area: ");
        area = scanner.nextLine();
        area = toLower.toLower(area);
        System.out.println("==============================================================================================");
        System.out.println(RED + "Which type of blood donation are you looking for?" + RESET);
        System.out.println(RED + "1." + RESET + " Whole Blood");
        System.out.println(RED + "2." + RESET + " Platelets");
        System.out.println(RED + "3." + RESET + " Plasma");
        System.out.println(RED + "4." + RESET + " Power Red");
        System.out.println(RED + "0." + RESET + " Back");
        System.out.println("==============================================================================================");
        System.out.println(RED + "Enter your choice: " + RESET);

        ConsoleUtils consoleUtils = new ConsoleUtils();
        int choice = scanner.nextInt();
        scanner.nextLine();

        while (choice != 1 && choice != 2 && choice != 3 && choice != 4 && choice != 0) {
            System.out.println("Invalid choice. Please select 1, 2, 3, 4, or 0.");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();
        }

        switch (choice) {
            case 1:
                consoleUtils.clearScreen();
                s.searchDonors(bloodGroup, city, area, "wbc", donorData);
                break;
            case 2:
                consoleUtils.clearScreen();
                s.searchDonors(bloodGroup, city, area, "platelet", donorData);
                break;
            case 3:
                consoleUtils.clearScreen();
                s.searchDonors(bloodGroup, city, area, "plasma", donorData);
                break;
            case 4:
                consoleUtils.clearScreen();
                s.searchDonors(bloodGroup, city, area, "powerRed", donorData);
                break;
            case 0:
                consoleUtils.clearScreen();
                Recipient_UI.main(phone, password, args);
                break;
            default:
                System.out.println("Invalid choice. Please select 1, 2, 3, 4, or 0.");
        }

        System.out.println("==============================================================================================");
        System.out.println("Enter the" + RED + " Donor ID" + RESET + " to view the donor's profile or press" + RED + " 0 " + RESET + "to go back.");
        System.out.println("==============================================================================================");
        System.out.println(RED + "Enter your choice: " + RESET);
        String donorID = scanner.nextLine();
        if (donorID.equals("0")){
            consoleUtils.clearScreen();
            Recipient_UI.main(phone, password, args);
        }
        while (!donorData.contains(donorID)){
            System.out.println("Invalid donor ID. Please enter again: ");
            donorID = scanner.nextLine();
            if (donorID.equals("0")){
                consoleUtils.clearScreen();
                Recipient_UI.main(phone, password, args);
            }
        }

        consoleUtils.clearScreen();
        donor.viewProfile(donorID);

        System.out.println("==============================================================================================");
        System.out.println(RED + "[0]" + RESET + " Back");
        System.out.println(RED + "[1]" + RESET + " Search for another donor");
        System.out.println(RED + "[2]" + RESET + " Request this donor");
        System.out.println("==============================================================================================");
        System.out.println(RED + "Enter your choice: " + RESET);
        int back = scanner.nextInt();
        scanner.nextLine();

        while (back != 0 && back != 1 && back != 2) {
            System.out.println("Invalid choice. Please select 0 or 1 or 2.");
            System.out.print("Enter your choice: ");
            back = scanner.nextInt();
            scanner.nextLine();
        }

        if (back == 0){
            consoleUtils.clearScreen();
            Recipient_UI.main(phone, password, args);
        }

        while (back == 1){
            switch (choice) {
                case 1:
                    consoleUtils.clearScreen();
                    s.searchDonors(bloodGroup, city, area, "wbc", donorData);
                    break;
                case 2:
                    consoleUtils.clearScreen();
                    s.searchDonors(bloodGroup, city, area, "platelet", donorData);
                    break;
                case 3:
                    consoleUtils.clearScreen();
                    s.searchDonors(bloodGroup, city, area, "plasma", donorData);
                    break;
                case 4:
                    consoleUtils.clearScreen();
                    s.searchDonors(bloodGroup, city, area, "powerRed", donorData);
                    break;
                case 0:
                    consoleUtils.clearScreen();
                    Recipient_UI.main(phone, password, args);
                    break;
                default:
                    System.out.println("Invalid choice. Please select 1, 2, 3, 4, or 0.");
            }

            System.out.println("==============================================================================================");
            System.out.println("Enter the" + RED + " Donor ID" + RESET + " to view the donor's profile or press" + RED + " 0 " + RESET + "to go back.");
            System.out.println("==============================================================================================");
            System.out.println(RED + "Enter your choice: " + RESET);
            donorID = scanner.nextLine();
            if (donorID.equals("0")){
                consoleUtils.clearScreen();
                Recipient_UI.main(phone, password, args);
            }
            while (!donorData.contains(donorID)){
                System.out.println("Invalid donor ID. Please enter again: ");
                donorID = scanner.nextLine();
                if (donorID.equals("0")){
                    consoleUtils.clearScreen();
                    Recipient_UI.main(phone, password, args);
                }
            }

            consoleUtils.clearScreen();
            donor.viewProfile(donorID);

            System.out.println("==============================================================================================");
            System.out.println(RED + "[0]" + RESET + " Back");
            System.out.println(RED + "[1]" + RESET + " Search for another donor");
            System.out.println("==============================================================================================");
            System.out.println(RED + "Enter your choice: " + RESET);
            back = scanner.nextInt();
            scanner.nextLine();

            while (back != 0 && back != 1) {
                System.out.println("Invalid choice. Please select 0.");
                System.out.print("Enter your choice: ");
                back = scanner.nextInt();
                scanner.nextLine();
            }

            if (back == 0){
                consoleUtils.clearScreen();
                Recipient_UI.main(phone, password, args);
            }
        }

        if(back == 2){
            DonationManager donationManager = new DonationManager(donorID, phone);
            donationManager.addRequest();
            System.out.println("Request sent to " +donorID);
            System.out.println("Returning to Dashboard");
            consoleUtils.holdTime();
            consoleUtils.clearScreen();
            Recipient_UI.main(phone, password, args);
        }

    }
}
