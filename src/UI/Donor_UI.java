package UI;
import Code.Donor;

import java.util.List;
import java.util.Scanner;

public class Donor_UI {

    private static Donor donor;

    public Donor_UI(Donor donor) {
        this.donor = donor;
    }

    public static void main(String[] args) {
        final String RED = "\033[31m";
        final String RESET = "\033[0m";

        System.out.println("==============================================================================================");
        System.out.println("             Dashboard");
        System.out.println("==============================================================================================");
        System.out.println("Welcome, " + donor.getName());
        System.out.println("Donor ID: " + donor.getDonorID());
        System.out.println("Points: " + donor.getPoints());
        if (donor.isEligible()) {
            System.out.println("You are eligible to donate blood.");
        } else {
            System.out.println("You are not eligible to donate blood.");
        }
        System.out.println("==============================================================================================");
        System.out.println();
        System.out.println(RED + "[1]" + RESET + " View Donation History");
        System.out.println(RED + "[2]" + RESET + " View Donation Requests");
        System.out.println(RED + "[3]" + RESET + " View Profile");
        System.out.println(RED + "[4]" + RESET + " Logout");
        System.out.println("==============================================================================================");
        System.out.println("Enter your choice: ");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                DonationHistory_UI.main(args);
                break;
            case 2:
                BloodRequests_UI.main(args);
                break;
            case 3:

                break;
            case 4:
                System.out.printf("Logging out...");
                Login_UI.main(args);
                break;
            default:
                System.out.println("Invalid choice. Please select 1, 2, 3, or 4.");
        }
    }
}