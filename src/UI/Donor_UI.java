package UI;
import Code.*;
import external_Functions.CurrentDate;
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
        CurrentDate currentDate = new CurrentDate();
        DateDifference dateDifference1, dateDifference2, dateDifference3, dateDifference4;
        ConsoleUtils consoleUtils = new ConsoleUtils();
        String phoneNumber = phone;
        String pass = password;
        DonationManager donationManager = new DonationManager();
        String wbcText = "";
        String plateletsText = "";
        String plasmaText = "";

        final String RED = "\033[31m";
        final String RESET = "\033[0m";

        donor = new Donor();
        donor.loginDonor(phoneNumber, pass);
        String donorID = donor.getDonorID();
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

        if (days2 > 14){
            donor.setEligibleForPlatelets(true);
        }

        if (days3 > 28){
            donor.setEligibleForPlasma(true);
        }

        if (days1 > 90){
            donor.setEligibleForWholeBlood(true);
        } else if ((days1 > 0 && days1 < 14) || currentDate.isCurrentDate(donor.getLastDonatedDateWholeBlood())){
            donor.setEligibleForWholeBlood(false);
            donor.setEligibleForPlatelets(false);
            donor.setEligibleForPlasma(false);
            if (days1 == 0){
                plateletsText = "Donated Whole Blood today";
                plasmaText = "Donated Whole Blood today";
            } else if (days1 == 1){
                plateletsText = "Donated Whole Blood yesterday";
                plasmaText = "Donated Whole Blood yesterday";

            } else {
                plasmaText = "Donated Whole Blood " + RED + days1 + RESET + " days ago";
                plateletsText = "Donated Whole Blood " + RED + days1 + RESET + " days ago";
            }

        } else if ((days1 > 0 && days1 < 28) || currentDate.isCurrentDate(donor.getLastDonatedDateWholeBlood())){
            donor.setEligibleForWholeBlood(false);
            donor.setEligibleForPlatelets(false);
            plateletsText = "Donated Whole Blood" + days1 + " days ago";
        }

        if (days4 > 112){
            donor.setEligibleForPowerRed(true);
        } else if ((days4 > 0 && days4 < 112) || currentDate.isCurrentDate(donor.getLastDonatedDatePowerRed())){
            donor.setEligibleForPowerRed(false);
            donor.setEligibleForWholeBlood(false);
            donor.setEligibleForPlatelets(false);
            donor.setEligibleForPlasma(false);
            if (days4 == 0){
                wbcText = "Donated Power Red today";
                plateletsText = "Donated Power Red today";
                plasmaText = "Donated Power Red today";
            } else if (days4 == 1){
                wbcText = "Donated Power Red yesterday";
                plateletsText = "Donated Power Red yesterday";
                plasmaText = "Donated Power Red yesterday";

            } else {
                wbcText = "Donated Power Red " + RED + days4 + RESET + " days ago";
                plateletsText = "Donated Power Red " + RED + days4 + RESET + " days ago";
                plasmaText = "Donated Power Red " + RED + days4 + RESET + " days ago";
            }
        }

        System.out.println("==============================================================================================");
        System.out.println("             Dashboard");
        System.out.println("==============================================================================================");
        System.out.println(RED + "Welcome, " + RESET + donor.getName());
        System.out.println(RED + "Donor ID: " + RESET + donor.getDonorID());
        System.out.println(RED + "Points: " + RESET  + donor.getPoints());

        if (donor.isAvailability() && (donor.isEligibleForWholeBlood() || donor.isEligibleForPlatelets() || donor.isEligibleForPlasma() || donor.isEligibleForPowerRed())){
            System.out.println(RED + "Availability: " + RESET + "Available");
        } else {
            System.out.println(RED + "Availability: " + RESET + "Not Available");
        }

        System.out.println("==============================================================================================");
        System.out.println("\t\t\t\tDonation Status");

        System.out.printf("Whole Blood Donation: ");
        if (donor.isEligibleForWholeBlood()){
            System.out.println(RED + "Eligible" + RESET);
        } else{
            System.out.printf(RED + "Not Eligible" + RESET);
            if (!wbcText.equals("")){
                System.out.println(" - " + wbcText);
            } else {
                System.out.println();
            }
        }

        System.out.printf("Platelets Donation: ");
        if (donor.isEligibleForPlatelets()){
            System.out.println(RED + "Eligible" + RESET);
        } else{
            System.out.printf(RED + "Not Eligible" + RESET);
            if (!plateletsText.equals("")){
                System.out.println(" - " + plateletsText);
            } else {
                System.out.println();
            }
        }

        System.out.printf("Plasma Donation: ");
        if (donor.isEligibleForPlasma()){
            System.out.println(RED + "Eligible" + RESET);
        } else{
            System.out.printf(RED + "Not Eligible" + RESET);
            if (!plasmaText.equals("")){
                System.out.println(" - " + plasmaText);
            } else {
                System.out.println();
            }
        }

        System.out.printf("Power Red Donation: ");
        if (donor.isEligibleForPowerRed()){
            System.out.println(RED + "Eligible" + RESET);
        } else{
            System.out.println(RED + "Not Eligible" + RESET);
        }

        BadgeManagement badgeManagement = new BadgeManagement();
        badgeManagement.updateFrequentDonorBadge(donorID);
        badgeManagement.updateLifeSaverBadge(donorID);
        if (badgeManagement.checkForFirstDropBadge(donorID) || badgeManagement.checkForFrequentDonorBadge(donorID) || badgeManagement.checkForLifeSaverBadge(donorID) || badgeManagement.checkForPioneerBadge(donorID) || badgeManagement.checkForRareBloodHeroBadge(donorID)){
            System.out.println("==============================================================================================");
            System.out.println("\t\t\t\tBadges");
            if (badgeManagement.checkForFirstDropBadge(donorID)){
                System.out.printf("|" + RED + "First Drop" + RESET);
            }
            if (badgeManagement.checkForFrequentDonorBadge(donorID)){
                System.out.printf("  |" + RED + "Frequent Donor" + RESET);
            }
            if (badgeManagement.checkForLifeSaverBadge(donorID)){
                System.out.printf("  |" + RED + "Life Saver" + RESET);
            }
            if (badgeManagement.checkForPioneerBadge(donorID)){
                System.out.printf("  |" + RED + "Pioneer" + RESET);
            }
            if (badgeManagement.checkForRareBloodHeroBadge(donorID)){
                System.out.printf("  |" + RED + "Rare Blood Hero" + RESET);
            }
            System.out.println("|");
        }

        System.out.println("==============================================================================================");
        System.out.println();
        System.out.println(RED + "[1]" + RESET + " View Donation History");
        System.out.printf(RED + "[2]" + RESET + " View Donation Requests");
        if (donor.isRequestNotification()){
            System.out.println(RED + " (New)" + RESET);
        } else {
            System.out.println();
        }
        System.out.println(RED + "[3]" + RESET + " View Profile");
        System.out.println(RED + "[4]" + RESET + " Refresh");
        System.out.printf(RED + "[5]" + RESET + " Chat");
        ChatSystem chatSystem = new ChatSystem();
        if (chatSystem.checkChatForDonor(donorID)){
            System.out.println(RED + " (New)" + RESET);
        } else {
            System.out.println();
        }
        System.out.println(RED + "[6]" + RESET + " Change Availability Status");
        System.out.println(RED + "[7]" + RESET + " Top Donors");
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
                donationManager.updateNotification(donor.getDonorID(), "false");
                DonorBloodRequest_UI.main(phoneNumber, pass, args);
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
                consoleUtils.clearScreen();
                Donor_Chat_UI.main(donorID, pass,phoneNumber, args);
                break;
            case 6:
                consoleUtils.clearScreen();
                ChangeAvailabilityStatus.main(phoneNumber, pass, args);
                break;
            case 7:
                consoleUtils.clearScreen();
                TopDonor_UI.main(phoneNumber, pass, args);
                break;
            case 0:
                System.out.printf("Logging out...");
                consoleUtils.holdTime();
                consoleUtils.clearScreen();
                HomePage.main(args);
                break;
            default:
                System.out.println("Invalid choice. Please select 1, 2, 3, or 4.");
        }
    }
}