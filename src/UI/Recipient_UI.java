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
        ConsoleUtils consoleUtils = new ConsoleUtils();
        Recipient recipient = new Recipient();
        recipient.loginRecipient(phoneNumber, pass);

        final String RED = "\033[31m";
        final String RESET = "\033[0m";

        System.out.println("==============================================================================================");
        System.out.println("                                    Dashboard");
        System.out.println("==============================================================================================");
        System.out.println("                                  Welcome," + RED + recipient.getName() + RESET + "!");
        System.out.println("==============================================================================================");
        System.out.println(RED + "[1]" + RESET + " Search for donors");
        System.out.println(RED + "[2]" + RESET + " View my requests");
        System.out.println(RED  + "[3]" + RESET + " View blood received history");
        System.out.println(RED + "[4]" + RESET + " Chat");
        System.out.println(RED + "[5]" + RESET + " Donation Confirmation");
        System.out.println(RED + "[0]" + RESET + " Logout");
        System.out.println("==============================================================================================");

        int choice;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your choice: ");
        choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                consoleUtils.clearScreen();
                Search_UI.main(recipient.getName(), phone, password, args);
                main(phone, password, args);

            case 2:
                consoleUtils.clearScreen();
                RecipientBloodRequest_UI.main(phone, password, args);
                break;
            case 3:
                consoleUtils.clearScreen();
                System.out.println("==============================================================================================");
                System.out.println("Date of Donation: 1/11/2024");
                System.out.println("Blood Group: B+");
                System.out.println("Status: Received");
                System.out.println("Address: Uttara Hospital, Uttara, Dhaka");
                System.out.println("Donated by: ");
                System.out.println("Donor Name: John Doe");
                System.out.println("Donor Phone Number: 01712345678");
                System.out.println("Donor ID: 1234");
                System.out.println("==============================================================================================");
                System.out.println("Date of Donation: 28/10/2024");
                System.out.println("Blood Group: A+");
                System.out.println("Status: Received");
                System.out.println("Address: Apollo Hospital, Bashundhara, Dhaka");
                System.out.println("Donated by: ");
                System.out.println("Donor Name: Jane Doe");
                System.out.println("Donor Phone Number: 01787654321");
                System.out.println("Donor ID: 5678");
                System.out.println("==============================================================================================");
                System.out.println("Date of Donation: 15/10/2024");
                System.out.println("Blood Group: O+");
                System.out.println("Status: Received");
                System.out.println("Address: Square Hospital, Panthapath, Dhaka");
                System.out.println("Donated by: ");
                System.out.println("Donor Name: Ahmed Ali");
                System.out.println("Donor Phone Number: 01712345678");
                System.out.println("Donor ID: 1234");
                System.out.println("==============================================================================================");
                System.out.println("Date of Donation: 1/10/2024");
                System.out.println("Blood Group: AB+");
                System.out.println("Status: Received");
                System.out.println("Address: Labaid Hospital, Dhanmondi, Dhaka");
                System.out.println("Donated by: ");
                System.out.println("Donor Name: Sarah Ali");
                System.out.println("Donor Phone Number: 01787654321");
                System.out.println("Donor ID: 5678");
                System.out.println("==============================================================================================");
                System.out.println(RED + "[0]" + RESET + " Back");
                int chc = scanner.nextInt();
                while (chc!=0){
                    System.out.println("Input a valid option: ");
                    chc = scanner.nextInt();
                }
                main(phone, password, args);
                break;
            case 4:
                consoleUtils.clearScreen();
                Recipient_Chat_UI.main(phone, password, args);
                break;
            case 5:
                consoleUtils.clearScreen();
                Donation_Confirmation_UI.main(phone, password, args);
                break;
            case 0:
                System.out.println("Logging out...");
                consoleUtils.holdTime();
                consoleUtils.clearScreen();
                Login_UI.main(args);
                break;
            default:
                System.out.println("Invalid choice. Please select 1, 2, 3, or 4.");
        }
    }
}