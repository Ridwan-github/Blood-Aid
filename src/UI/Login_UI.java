package UI;

import java.util.Scanner;

public class Login_UI {

    public static void main(String[] args) {
        final String RED = "\033[31m";
        final String RESET = "\033[0m";

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            // Display the full UI, including placeholders for username and password inputs
            System.out.println("==============================================================================================");
            System.out.println(RED + "\t\t\t\t  ____    _                       _               _       _ ");
            System.out.println("\t\t\t\t |  _ \\  | |                     | |      /\\     (_)     | |");
            System.out.println("\t\t\t\t | |_) | | |   ___     ___     __| |     /  \\     _    __| |");
            System.out.println("\t\t\t\t |  _ <  | |  / _ \\   / _ \\   / _` |    / /\\ \\   | |  / _` |");
            System.out.println("\t\t\t\t | |_) | | | | (_) | | (_) | | (_| |   / ____ \\  | | | (_| |");
            System.out.println("\t\t\t\t |____/  |_|  \\___/   \\___/   \\__,_|  /_/    \\_\\ |_|  \\__,_|" + RESET);
            System.out.println("==============================================================================================");

            // Display options for the user, already visible in the initial print
            System.out.println("\nPlease choose an option:");
            System.out.println(RED + "[1]" + RESET + " Login");
            System.out.println(RED + "[2]" + RESET + " Signup");
            System.out.println(RED + "[3]" + RESET + " Exit");
            System.out.println("==============================================================================================");

            // Prompt for option input
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Clear the newline character from input buffer

            // Handle menu options
            switch (choice) {
                case 1:
                    System.out.printf("Username: ");
                    String username = scanner.nextLine();
                    System.out.printf("Password: ");
                    String password = scanner.nextLine();
                    System.out.println("Logging in ");
                    running = false;

                    Donor_UI.main(args);

                    break;
                case 2:
                    System.out.println("==============================================================================================");
                    System.out.println(RED + "[1]" + RESET + " Donor");
                    System.out.println(RED + "[2]" + RESET + " Recipient");
                    System.out.println("==============================================================================================");
                    System.out.print("Enter your choice: ");
                    int userType = scanner.nextInt();
                    scanner.nextLine(); 

                    switch (userType) {
                        case 1:
                            DonorSignup_UI.main(args);
                            break;
                        case 2:
                            RecipientSignup_UI.main(args);
                            break;
                        default:
                            System.out.println("Invalid choice. Please select 1 or 2.");
                    }
                    break;
                case 3:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please select 1, 2, or 3.");
            }

            System.out.println("==============================================================================================");

            System.out.print("\033[H\033[2J");
            System.out.flush();
        }

        scanner.close();
    }
}
