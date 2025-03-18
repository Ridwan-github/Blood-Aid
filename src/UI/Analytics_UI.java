package UI;

import Code.AnalyticReport;

import java.util.Scanner;

public class Analytics_UI {
    public static void main(String phone, String password, String[] args) {
        final String RED = "\033[0;31m";
        final String RESET = "\033[0m";

        AnalyticReport analyticReport = new AnalyticReport();
        Scanner scanner = new Scanner(System.in);
        ConsoleUtils consoleUtils = new ConsoleUtils();

        System.out.println("==========================================================================");
        System.out.println(RED + "\t\tAnalytic's Report" + RESET);
        System.out.println("==========================================================================");
        System.out.println(RED + "\t\tDonor" + RESET);
        System.out.println("Total Donors: " + analyticReport.totalNoOfDonor());
        
        // Display blood group distribution as bar chart
        String[] bloodGroups = {"A+", "A-", "B+", "B-", "O+", "O-", "AB+", "AB-"};
        int[] donorCounts = {
            analyticReport.totalNoOfApositiveDonors(),
            analyticReport.totalNoOfAnegativeDonors(),
            analyticReport.totalNoOfBpositiveDonors(),
            analyticReport.totalNoOfBnegativeDonors(),
            analyticReport.totalNoOfOpositiveDonors(),
            analyticReport.totalNoOfOnegativeDonors(),
            analyticReport.totalNoOfABpositiveDonors(),
            analyticReport.totalNoOfABnegativeDonors()
        };
        ConsoleBarChart.drawBarChart("Blood Group Distribution", bloodGroups, donorCounts);
        System.out.println();
        System.out.println("==========================================================================");
        System.out.println(RED + "\t\tRecipient" + RESET);
        System.out.println("Total Recipients: " + analyticReport.totalNoOfRecipient());
        System.out.println();
        System.out.println("==========================================================================");
        System.out.println(RED + "\t\tDonations" + RESET);
        System.out.println("Total Requests: " + analyticReport.totalNoOfRequests());
        System.out.println("Total Donations: " + analyticReport.totalNoOfDonation());
        System.out.println("Total Pending Requests: " + analyticReport.totalPendingRequest());
        System.out.println("Total Requests to be Confirmed: " + analyticReport.totalNoOfRequestToBeConfirmed());
        System.out.println();
        System.out.println("==========================================================================");
        System.out.printf("Most Requested BloodGroup : ");
        analyticReport.maximumBloodGroupRequested();
        System.out.printf("Most Donated Bloodgroup : ");
        analyticReport.maximumBloodGroupDonated();
        System.out.println();
        System.out.println("==========================================================================");
        System.out.println("Press " + RED + "enter" + RESET + " to go back to the dashboard.");
        scanner.nextLine();

        consoleUtils.clearScreen();
        User_UI.main(phone, password, args);
    }
}
