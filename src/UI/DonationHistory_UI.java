package UI;

class DonationHistory_UI {
    private Donor_UI donor;
    private String donationType;

    public boolean checkCooldown() {
        // Implementation
        return false;
    }

    public void updateHistory() {
        // Implementation
    }

    public static void main(String[] args) {
        DonationHistory_UI donationHistory = new DonationHistory_UI();
        donationHistory.donor = new Donor_UI();
        donationHistory.donationType = "Whole Blood";
        final String RED = "\033[31m";
        final String RESET = "\033[0m";


        System.out.println("==============================================================================================");
        System.out.println("                                    Donation History");
        System.out.println("==============================================================================================");
        System.out.println("\n" + RED + "1. Donation ID:" + RESET + " D001");
        System.out.println(RED + "Date:" + RESET + " 01/01/2021");
        System.out.println(RED + "Location:" + RESET + " Hospital name, Address");
        System.out.println("\n" + RED + "2. Donation ID:" + RESET + " D002");
        System.out.println(RED + "Date:" + RESET + " 01/02/2021");
        System.out.println(RED + "Location:" + RESET + " Hospital name, Address");
        System.out.println("\n" + RED + "3. Donation ID:" + RESET + " D003");
        System.out.println(RED + "Date:" + RESET + " 01/03/2021");
        System.out.println(RED + "Location:" + RESET + " Hospital name, Address");
        System.out.println("\n" + RED + "0. Back" + RESET);

        System.out.println("==============================================================================================");
    }
}