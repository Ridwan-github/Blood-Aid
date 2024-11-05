package UI;
import Code.Recipient;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

class Recipient_UI  {

    public static void main(String phone, String password, String[] args) {
        String phoneNumber = phone;
        String pass = password;

        Recipient recipient = new Recipient();
        recipient.loginRecipient(phoneNumber, pass);

        final String RED = "\033[31m";
        final String RESET = "\033[0m";

        System.out.println("\n\n\n\n\n\n\n\n\n\n");
        System.out.println("==============================================================================================");
        System.out.println("                                    Dashboard");
        System.out.println("==============================================================================================");
        System.out.println("                                  Welcome," + RED + recipient.getName() + RESET + "!");
        System.out.println("==============================================================================================");
        System.out.println(RED + "[1]" + RESET + " Search for donors");
        System.out.println(RED + "[2]" + RESET + " View my requests");
        System.out.println(RED  + "[3]" + RESET + " View donation history");
        System.out.println(RED + "[4]" + RESET + " Logout");
        System.out.println("==============================================================================================");

        int choice;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your choice: ");
        choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                System.out.println("List of Donors: ");
                try{
                    File file = new File("src/filemanagement/Donor.txt");
                    BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
                    String line;
                    while ((line = bufferedReader.readLine()) != null) {
                        String[] data = line.split(";");
                        if(data[4].equals(recipient.getBloodGroup())){

                            System.out.println("Name: " + data[0]);
                            System.out.println("Phone Number: " + data[1]);
                            System.out.println("City: " + data[2]);
                            System.out.println("Area: " + data[3]);
                            System.out.println("Blood Group: " + data[4]);
                            System.out.println("Points: " + data[6]);
                            System.out.println("==============================================================================================");

                        }
                    }
                    bufferedReader.close();
                }

                catch (Exception e) {
                    System.out.println("An error occurred.");
                    e.printStackTrace();
                }


            case 2:
                // View requests
                break;
            case 3:
                // View donation history
                break;
            case 4:
                Login_UI.main(args);
                break;
            default:
                System.out.println("Invalid choice. Please select 1, 2, 3, or 4.");
        }


    }
}