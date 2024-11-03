package UI;
import Code.Recipient;

import java.util.Scanner;

class Recipient_UI  {

    public static void main(String[] args) {
        Recipient recipient = new Recipient();
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
        scanner.nextLine(); // Clear the newline character from input buffer

        switch (choice) {
            case 1:
                System.out.println("==============================================================================================");
                System.out.println("Search for donors");
                System.out.println("==============================================================================================");
                System.out.println("Blood Groups:" +
                        "\n" + RED + "1" + RESET + " A+" +
                        "\t" + RED + "2" + RESET + " A-" +
                        "\n" + RED + "3" + RESET + " B+" +
                        "\t" + RED + "4" + RESET + " B-" +
                        "\n" + RED + "5" + RESET + " AB+" +
                        "\t" + RED + "6" + RESET + " AB-" +
                        "\n" + RED + "7" + RESET + " O+" +
                        "\t" + RED + "8" + RESET + " O-");
                System.out.println("Select blood group: ");
                String bloodGroup = scanner.nextLine();

                // Display search results
                break;
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