package UI;

import Code.DonorViewProfile;
import java.util.Scanner;

public class DonorViewProfile_UI {

    public static void main(DonorViewProfile donorViewProfile, String[] args) {
        final String RED = "\033[31m";
        final String RESET = "\033[0m";
        ConsoleUtils consoleUtils = new ConsoleUtils();
        Scanner scanner = new Scanner(System.in);

        System.out.println("==========================================================================");
        System.out.println("                             Donor Profile");
        System.out.println("==========================================================================");

        donorViewProfile.viewProfile();

        System.out.println("==========================================================================");
        System.out.println(RED + "[1]" + RESET + " Update City");
        System.out.println(RED + "[2]" + RESET + " Update Area");
        System.out.println(RED + "[3]" + RESET + " Update Email");
        System.out.println(RED + "[0]" + RESET + " Back");
        System.out.println("==========================================================================");

        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                System.out.print("Enter new city: ");
                String newCity = scanner.nextLine();
                donorViewProfile.updateProfile("city", newCity);
                consoleUtils.clearScreen();
                main(donorViewProfile, args);
                break;
            case 2:
                System.out.print("Enter new area: ");
                String newArea = scanner.nextLine();
                donorViewProfile.updateProfile("area", newArea);
                consoleUtils.clearScreen();
                main(donorViewProfile, args);
                break;
            case 3:
                System.out.print("Enter new email: ");
                String newEmail = scanner.nextLine();
                donorViewProfile.updateProfile("email", newEmail);
                consoleUtils.clearScreen();
                main(donorViewProfile, args);
                break;
            case 0:
                consoleUtils.clearScreen();
                Donor_UI.main(donorViewProfile.getPhoneNumber(), donorViewProfile.getPassword(), args);
                break;
            default:
                System.out.println("Invalid choice. Please select 0-3.");
                break;
        }

        scanner.close();
    }
}
