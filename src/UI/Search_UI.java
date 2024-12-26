package UI;

import Code.*;
import external_Functions.MyVector;
import external_Functions.toLower;
import java.util.Scanner;
import java.util.Vector;

public class Search_UI {
    final String RED = "\033[31m";
    final String RESET = "\033[0m";

    public static void main(String name, String phone, String password, String[] args) {
        AuthorizationConstraintsValidator validate = new AuthorizationConstraintsValidator();
        Donor donor = new Donor();
        Recipient recipient = new Recipient();
        String city, area, bloodGroup;
        SearchDonor s = new SearchDonor();
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
        String donationType = "";
        if(choice == 1){
            donationType = "Whole Blood";
        } else if (choice == 2) {
            donationType = "Platelets";
        } else if (choice == 3) {
            donationType = "Plasma";
        } else if (choice == 4) {
            donationType = "Power Red";
        }
        switch (choice) {
            case 1:
                consoleUtils.clearScreen();
                s.searchDonors(bloodGroup, city, area, "wbc", donorData, phone);
                break;
            case 2:
                consoleUtils.clearScreen();
                s.searchDonors(bloodGroup, city, area, "platelet", donorData, phone);
                break;
            case 3:
                consoleUtils.clearScreen();
                s.searchDonors(bloodGroup, city, area, "plasma", donorData, phone);
                break;
            case 4:
                consoleUtils.clearScreen();
                s.searchDonors(bloodGroup, city, area, "powerRed", donorData, phone);
                break;
            case 0:
                consoleUtils.clearScreen();
                Recipient_UI.main(phone, password, args);
                break;
            default:
                System.out.println("Invalid choice. Please select 1, 2, 3, 4, or 0.");
        }

        System.out.println("==============================================================================================");
        System.out.println("Enter the" + RED + " Donor ID" + RESET + " to view the donor's profile or \n" +
                " press" + RED + " 0 " + RESET + "to go back. \n" +
                " press" + RED + " 00 " + RESET + "to request to all available donor's. " );
        System.out.println("==============================================================================================");
        System.out.println(RED + "Enter your choice: " + RESET);
        String donorID = scanner.nextLine();
        if (donorID.equals("0")){
            consoleUtils.clearScreen();
            Recipient_UI.main(phone, password, args);
        } else if (donorID.equals("00")){
            for (int i = 0; i < donorData.size(); i++){
                DonationManager donationManager = new DonationManager(donorData.get(i), name, phone, donationType, bloodGroup);
                donationManager.addRequest();
            }
            System.out.println("Request sent to all available donors.");
            System.out.println("==============================================================================================");
            System.out.println("Enter " + RED + "[0]" + RESET + " to go back to dashboard.");
            System.out.println("==============================================================================================");

            System.out.println(RED + "Enter your choice: " + RESET);
            int chat = scanner.nextInt();
            scanner.nextLine();

            while (chat != 0) {
                System.out.println("Invalid choice. Please select 0 or 1.");
                System.out.print("Enter your choice: ");
                chat = scanner.nextInt();
                scanner.nextLine();
            }

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
                    s.searchDonors(bloodGroup, city, area, "wbc", donorData, phone);
                    break;
                case 2:
                    consoleUtils.clearScreen();
                    s.searchDonors(bloodGroup, city, area, "platelet", donorData, phone);
                    break;
                case 3:
                    consoleUtils.clearScreen();
                    s.searchDonors(bloodGroup, city, area, "plasma", donorData, phone);
                    break;
                case 4:
                    consoleUtils.clearScreen();
                    s.searchDonors(bloodGroup, city, area, "powerRed", donorData, phone);
                    break;
                case 0:
                    consoleUtils.clearScreen();
                    Recipient_UI.main(phone, password, args);
                    break;
                default:
                    System.out.println("Invalid choice. Please select 1, 2, 3, 4, or 0.");
            }

            System.out.println("==============================================================================================");
            System.out.println("Enter the" + RED + " Donor ID" + RESET + " to view the donor's profile or \n" +
                    " press" + RED + " 0 " + RESET + "to go back. \n" +
                    " press" + RED + " 00 " + RESET + "to request to all available donor's. " );
            System.out.println("==============================================================================================");
            System.out.println(RED + "Enter your choice: " + RESET);
            donorID = scanner.nextLine();
            if (donorID.equals("0")){
                consoleUtils.clearScreen();
                Recipient_UI.main(phone, password, args);
            } else if (donorID.equals("00")){
                for (int i = 0; i < donorData.size(); i++){
                    DonationManager donationManager = new DonationManager(donorData.get(i), name, phone, donationType, bloodGroup);
                    donationManager.addRequest();
                }
                System.out.println("Request sent to all available donors.");
                System.out.println("==============================================================================================");
                System.out.println("Enter " + RED + "[0]" + RESET + " to go back to dashboard.");
                System.out.println("==============================================================================================");

                System.out.println(RED + "Enter your choice: " + RESET);
                int chat = scanner.nextInt();
                scanner.nextLine();

                while (chat != 0) {
                    System.out.println("Invalid choice. Please select 0 or 1.");
                    System.out.print("Enter your choice: ");
                    chat = scanner.nextInt();
                    scanner.nextLine();
                }

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
            DonationManager donationManager = new DonationManager(donorID, name, phone, donationType, bloodGroup);
            donationManager.addRequest();
            System.out.println("Request sent to " +donorID);

            System.out.println("==============================================================================================");
            System.out.println("Enter " + RED + "[0]" + RESET + " to go back to dashboard.");
            System.out.println(RED + "[1]" + RESET + " to chat with the donor.");
            System.out.println("==============================================================================================");

            System.out.println(RED + "Enter your choice: " + RESET);
            int chat = scanner.nextInt();
            scanner.nextLine();

            while (chat != 0 && chat != 1) {
                System.out.println("Invalid choice. Please select 0 or 1.");
                System.out.print("Enter your choice: ");
                chat = scanner.nextInt();
                scanner.nextLine();
            }

            if (chat == 0){
                consoleUtils.clearScreen();
                Recipient_UI.main(phone, password, args);
            } else if (chat == 1){
                consoleUtils.clearScreen();
                ChatSystem chatSystem = new ChatSystem();
                Vector<String> list = chatSystem.availableDonorToChat(phone);
                int c = list.indexOf(donorID) + 1;
                Recipient_Chat_UI_2.main(phone, password, list, c, args);
            }
        }

    }
}
