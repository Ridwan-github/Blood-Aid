package UI;
import Code.Donor;
import Code.DonorViewProfile;
import external_Functions.DateDifference;
import external_Functions.MyDate;
import java.util.Scanner;

public class Donor_UI {

    private static Donor donor;

    public Donor_UI(Donor donor) {
        this.donor = donor;
    }

    public static void main(String phone, String password, String[] args) {
        MyDate lastWholeBloodDonationDate, lastPlateletsDonationDate, lastPlasmaDonationDate, lastPowerRedDonationDate;
        DateDifference dateDifference1, dateDifference2, dateDifference3, dateDifference4;
        ConsoleUtils consoleUtils = new ConsoleUtils();
        String phoneNumber = phone;
        String pass = password;

        donor = new Donor();
        donor.loginDonor(phoneNumber, pass);
        int  days1, days2, days3, days4;

        lastWholeBloodDonationDate = new MyDate(donor.getLastDonatedDateWholeBlood().getDay(), donor.getLastDonatedDateWholeBlood().getMonth(), donor.getLastDonatedDateWholeBlood().getYear());
        if (lastWholeBloodDonationDate.isNull()){
            days1 = 0;
        } else {
            dateDifference1 = new DateDifference(lastWholeBloodDonationDate);
            days1 = dateDifference1.getDifference();
        }

        lastPlateletsDonationDate = new MyDate(donor.getLastDonatedDatePlatelets().getDay(), donor.getLastDonatedDatePlatelets().getMonth(), donor.getLastDonatedDatePlatelets().getYear());
        if (lastPlateletsDonationDate.isNull()){
            days2 = 0;
        } else {
            dateDifference2 = new DateDifference(lastPlateletsDonationDate);
            days2 = dateDifference2.getDifference();
        }

        lastPlasmaDonationDate = new MyDate(donor.getLastDonatedDatePlasma().getDay(), donor.getLastDonatedDatePlasma().getMonth(), donor.getLastDonatedDatePlasma().getYear());
        if (lastPlasmaDonationDate.isNull()){
            days3 = 0;
        } else {
            dateDifference3 = new DateDifference(lastPlasmaDonationDate);
            days3 = dateDifference3.getDifference();
        }

        lastPowerRedDonationDate = new MyDate(donor.getLastDonatedDatePowerRed().getDay(), donor.getLastDonatedDatePowerRed().getMonth(), donor.getLastDonatedDatePowerRed().getYear());
        if (lastPowerRedDonationDate.isNull()){
            days4 = 0;
        } else {
            dateDifference4 = new DateDifference(lastPowerRedDonationDate);
            days4 = dateDifference4.getDifference();
        }

        if (days1 > 90){
            donor.setEligibleForWholeBlood(true);
        }

        if (days2 > 14){
            donor.setEligibleForPlatelets(true);
        }

        if (days3 > 28){
            donor.setEligibleForPlasma(true);
        }

        if (days4 > 112){
            donor.setEligibleForPowerRed(true);
        }

        final String RED = "\033[31m";
        final String RESET = "\033[0m";

        System.out.println("==============================================================================================");
        System.out.println("             Dashboard");
        System.out.println("==============================================================================================");
        System.out.println(RED + "Welcome, " + RESET + donor.getName());
        System.out.println(RED + "Donor ID: " + RESET + donor.getDonorID());
        System.out.println(RED + "Points: " + RESET  + donor.getPoints());

        System.out.println("==============================================================================================");
        System.out.println("Donation Status");

        if (donor.getLastDonatedDatePlasma().isNull() && donor.getLastDonatedDatePlatelets().isNull() && donor.getLastDonatedDatePowerRed().isNull() && donor.getLastDonatedDateWholeBlood().isNull()){
            System.out.println(RED + "Last Donated Blood: " + RESET + " Never donated blood before.");
        }

        if (!donor.isEligibleForWholeBlood() && !donor.getLastDonatedDateWholeBlood().isNull()){
            System.out.println(RED + "Last Donated Whole Blood: " + RESET + donor.getLastDonatedDateWholeBlood().toString());
            System.out.println("Days left before next donation: " + RED + (90 - days1) + RESET);
            System.out.println("You are not eligible to donate whole blood for now.");
            System.out.println(" ");
        }

        if (!donor.isEligibleForPlatelets() && !donor.getLastDonatedDatePlatelets().isNull()){
            System.out.println(RED + "Last Donated Platelets: " + RESET + donor.getLastDonatedDatePlatelets().toString());
            System.out.println("Days left before next donation: " + RED + (14 - days2) + RESET);
            System.out.println("You are not eligible to donate platelets for now.");
            System.out.println(" ");
        }

        if (!donor.isEligibleForPlasma() && !donor.getLastDonatedDatePlasma().isNull()){
            System.out.println(RED + "Last Donated Plasma: " + RESET + donor.getLastDonatedDatePlasma().toString());
            System.out.println("Days left before next donation: " + RED + (28 - days3) + RESET);
            System.out.println("You are not eligible to donate plasma for now.");
            System.out.println(" ");
        }

        if (!donor.isEligibleForPowerRed() && !donor.getLastDonatedDatePowerRed().isNull()){
            System.out.println(RED + "Last Donated Power Red: " + RESET + donor.getLastDonatedDatePowerRed().toString());
            System.out.println("Days left before next donation: " + RED + (112 - days4) + RESET);
            System.out.println("You are not eligible to donate power red for now.");
            System.out.println(" ");
        }

        if (donor.isEligibleForPowerRed() && donor.isEligibleForPlasma() && donor.isEligibleForPlatelets() && donor.isEligibleForWholeBlood()){
            System.out.println("You are eligible to donate all types of blood.");
        } else if (!donor.isEligibleForPowerRed() && !donor.isEligibleForPlasma() && !donor.isEligibleForPlatelets() && !donor.isEligibleForWholeBlood()){
            System.out.println("You are not eligible to donate any type of blood for now.");
        } else {
            System.out.println(RED + "Eligible for donating:" + RESET);
            if (donor.isEligibleForWholeBlood()){
                System.out.println("Whole Blood");
            }
            if (donor.isEligibleForPlatelets()){
                System.out.println("Platelets");
            }
            if (donor.isEligibleForPlasma()){
                System.out.println("Plasma");
            }
            if (donor.isEligibleForPowerRed()){
                System.out.println("Power Red");
            }
            System.out.println("\n");
        }

        System.out.println("==============================================================================================");
        System.out.println();
        System.out.println(RED + "[1]" + RESET + " View Donation History");
        System.out.println(RED + "[2]" + RESET + " View Donation Requests");
        System.out.println(RED + "[3]" + RESET + " View Profile");
        System.out.println(RED + "[4]" + RESET + " Refresh");
        System.out.println(RED + "[0]" + RESET + " Logout");
        System.out.println("==============================================================================================");
        System.out.println("Enter your choice: ");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                consoleUtils.clearScreen();
                DonationHistory_UI.main(phoneNumber, pass, args);
                break;
            case 2:
                consoleUtils.clearScreen();
                BloodRequests_UI.main(phoneNumber, pass, args);
                break;
            case 3:
                consoleUtils.clearScreen();
                DonorViewProfile donorViewProfile = new DonorViewProfile(phoneNumber, pass);
                DonorViewProfile_UI.main(donorViewProfile, args);
                break;
            case 4:
                consoleUtils.clearScreen();
                Donor_UI.main(phoneNumber, pass, args);
                break;
            case 5:
                System.out.printf("Logging out...");
                consoleUtils.holdTime();
                consoleUtils.clearScreen();
                Login_UI.main(args);
                break;
            default:
                System.out.println("Invalid choice. Please select 1, 2, 3, or 4.");
        }
    }
}