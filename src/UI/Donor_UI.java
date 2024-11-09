package UI;
import Code.Donor;
import Code.DonorViewProfile;
<<<<<<< Updated upstream
=======
import external_Functions.DateDifference;
import external_Functions.MyDate;

import java.util.List;
>>>>>>> Stashed changes
import java.util.Scanner;

public class Donor_UI {

    private static Donor donor;

    public Donor_UI(Donor donor) {
        this.donor = donor;
    }

    public static void main(String phone, String password, String[] args) {
        MyDate date;
        DateDifference dateDifference;
        String phoneNumber = phone;
        String pass = password;

        donor = new Donor();
        donor.loginDonor(phoneNumber, pass);

        date = new MyDate(donor.getLastDonatedDate().getDay(), donor.getLastDonatedDate().getMonth(), donor.getLastDonatedDate().getYear());
        dateDifference = new DateDifference(date);
        int days = dateDifference.getDifference();

        final String RED = "\033[31m";
        final String RESET = "\033[0m";

        System.out.println("==============================================================================================");
        System.out.println("             Dashboard");
        System.out.println("==============================================================================================");
        System.out.println(RED + "Welcome, " + RESET + donor.getName());
        System.out.println(RED + "Donor ID: " + RESET + donor.getDonorID());
        System.out.println(RED + "Points: " + RESET  + donor.getPoints());
        if (donor.getLastDonatedDate().isNull()){
            System.out.println(RED + "Last Donated:" + RESET + " Never donated blood before.");
        } else {
            System.out.println(RED + "Last Donated: " + RESET  + donor.getLastDonatedDate().toString());
        }
        if (donor.isEligible()) {
            System.out.println("You are eligible to donate blood.");
        } else {
            System.out.println("Days left before next donation: " + RED + (90 - days) + RESET);
            System.out.println("You are not eligible to donate blood for now.");
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
                DonationHistory_UI.main(phoneNumber, pass, args);
                break;
            case 2:
                BloodRequests_UI.main(phoneNumber, pass, args);
                break;
            case 3:
                DonorViewProfile donorViewProfile = new DonorViewProfile(phoneNumber, pass);
                DonorViewProfile_UI.main(donorViewProfile, args);
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