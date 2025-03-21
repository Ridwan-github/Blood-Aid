package UI;

import Code.Donor;
import Code.Recipient;
import Code.User;

import java.util.Scanner;

public class User_UI {
    public static void main(String phone, String password, String[] args) {
        User user = new User();
        user.login(phone, password);

        Donor donor = new Donor();
        Recipient recipient = new Recipient();
        ConsoleUtils consoleUtils = new ConsoleUtils();

        final String RED = "\033[31m";
        final String RESET = "\033[0m";

        Scanner scanner = new Scanner(System.in);

        System.out.println("==========================================================================");
        System.out.println("             Dashboard");
        System.out.println("==========================================================================");
        System.out.println(RED + "Welcome, " + RESET + user.getName());
        System.out.println("==========================================================================");
        System.out.println(RED + "[1]" + RESET + " Donate Blood");
        System.out.println(RED + "[2]" + RESET + " Request Blood");
        System.out.println(RED + "[3]" + RESET + " Show Top Donors");
        System.out.println(RED + "[4]" + RESET + " Analytics");
        System.out.println(RED + "[0]" + RESET + " Logout");

        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        while (choice != 1 && choice != 2 && choice != 3 && choice != 4 && choice != 0) {
            System.out.println("Invalid choice! Please try again.");
            choice = scanner.nextInt();
            scanner.nextLine();
        }

        switch (choice) {
            case 1:
                if (!donor.findDonor(phone, password)){
                    System.out.println("You are not a donor. Please sign up as a donor.");
                    consoleUtils.holdTime();
                    consoleUtils.clearScreen();
                    DonorSignup_UI.main(user.getName(), user.getPhoneNumber(), user.getPassword(), user.getCity(), user.getArea(), user.getBloodGroup(), args);
                } else {
                    consoleUtils.clearScreen();
                    Donor_UI.main(phone, password, args);
                }
                break;
            case 2:
                consoleUtils.clearScreen();
                Recipient_UI.main(phone, password, args);
            case 3:
                consoleUtils.clearScreen();
                TopDonor_UI.main(phone, password, args);
            case 4:
                consoleUtils.clearScreen();
                Analytics_UI.main(phone, password, args);
                break;
            case 0:
                consoleUtils.clearScreen();
                Home.main(args);
                break;
            default:
                System.out.println("Invalid choice! Please try again.");
                System.out.println("Press " + RED + "[0]" + RESET + " to go back to the main menu.");
                int choice1 = scanner.nextInt();
                if (choice1 == 0) {
                    Home.handleLogin(args);
                }
        }
    }
}
