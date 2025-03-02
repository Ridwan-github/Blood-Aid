package UI;

import Code.AnalyticReport;

public class Analytics_UI {
    public static void main(String[] args) {
        final String RED = "\033[0;31m";
        final String RESET = "\033[0m";

        AnalyticReport analyticReport = new AnalyticReport();

        System.out.println("==============================================================================================");
        System.out.println(RED + "\t\t\t\tAnalytic's Report" + RESET);
        System.out.println("==============================================================================================");
        System.out.println(RED + "\t\t\t\tDonor" + RESET);
        System.out.println("Total Donors: " + analyticReport.totalNoOfDonor());
        System.out.println("A+ : " + analyticReport.totalNoOfApositiveDonors() + "\t\tA- : " + analyticReport.totalNoOfAnegativeDonors());
        System.out.println("B+ : " + analyticReport.totalNoOfBpositiveDonors() + "\t\tB- : " + analyticReport.totalNoOfBnegativeDonors());
        System.out.println("O+ : " + analyticReport.totalNoOfOpositiveDonors() + "\t\tO- : " + analyticReport.totalNoOfOnegativeDonors());
        System.out.println("AB+ : " + analyticReport.totalNoOfABpositiveDonors() + "\t\tAB- : " + analyticReport.totalNoOfABnegativeDonors());
        System.out.println();
        System.out.println("==============================================================================================");
        System.out.println(RED + "\t\t\t\tRecipient" + RESET);
        System.out.println("Total Recipients: " + analyticReport.totalNoOfRecipient());
        System.out.println();
        System.out.println("==============================================================================================");
        System.out.println(RED + "\t\t\t\tDonations" + RESET);
        System.out.println("Total donation requests: " + analyticReport.totalNoOfRequests());
        System.out.println("Donated: " + analyticReport.totalNoOfDonation());
        System.out.println("Pending donations: " + analyticReport.totalPendingRequest());
        System.out.println("To be confirmed: " + analyticReport.totalNoOfRequestToBeConfirmed());
        System.out.println();
        System.out.println("==============================================================================================");
        System.out.printf("Most Requested BloodGroup : ");
        analyticReport.maximumBloodGroupRequested();
        System.out.printf("Most Donated Bloodgroup : ");
        analyticReport.maximumBloodGroupDonated();
        System.out.println();
        System.out.println("==============================================================================================");


    }
}
