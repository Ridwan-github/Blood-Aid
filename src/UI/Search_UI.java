package UI;

import Code.AuthorizationConstraintsValidator;
import Code.Donor;
import external_Functions.toLower;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Search_UI {
    final String RED = "\033[31m";
    final String RESET = "\033[0m";

    public void searchDonors(String bloodGroup, String city, String area, String donationType) {
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
                    System.out.println(RED + "Points: " + RESET + data[8]);
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
                    System.out.println(RED + "Points: " + RESET + data[8]);
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
                    System.out.println(RED + "Points: " + RESET + data[8]);
                }
            }
        } catch (IOException ae){
            ae.printStackTrace();
        }
    }

    public static void main(String phone, String password, String[] args) {
        AuthorizationConstraintsValidator validate = new AuthorizationConstraintsValidator();
        Donor donor = new Donor();
        String city, area, bloodGroup;
        Search_UI s = new Search_UI();
        Scanner scanner = new Scanner(System.in);
        toLower toLower = new toLower();

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

        switch (choice) {
            case 1:
                s.searchDonors(bloodGroup, city, area, "wbc");
                break;
            case 2:
                s.searchDonors(bloodGroup, city, area, "platelet");
                break;
            case 3:
                s.searchDonors(bloodGroup, city, area, "plasma");
                break;
            case 4:
                s.searchDonors(bloodGroup, city, area, "powerRed");
                break;
            case 0:
                consoleUtils.clearScreen();
                Recipient_UI.main(phone, password, args);
                break;
            default:
                System.out.println("Invalid choice. Please select 1, 2, 3, 4, or 0.");
        }

        System.out.println("==============================================================================================");
        System.out.println(RED + "[0]" + RESET + " Back");
        System.out.println("==============================================================================================");
        System.out.println(RED + "Enter your choice: " + RESET);
        int ch = scanner.nextInt();
        while (ch!=0){
            System.out.println("Input a valid option: ");
            ch = scanner.nextInt();
        }

        consoleUtils.clearScreen();
        Recipient_UI.main(phone, password, args);

    }
}
