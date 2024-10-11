import java.util.Scanner;

class BloodRequest {
    private Recipient recipient;
    private String bloodGroup;
    private String region;
    private boolean isFulfilled;

    // Methods: postRequest, updateStatus, etc.

    public void postRequest() {
        // Implementation
    }

    public void updateStatus() {
        // Implementation
    }

    public static void main(String[] args) {
        final String RED = "\033[31m";
        final String RESET = "\033[0m";

        System.out.println("==============================================================================================");
        System.out.println("                                    Eligibile Donor List");
        System.out.println("==============================================================================================");
        System.out.println("                                  Blood Group: " + RED + "A+" + RESET);
        System.out.println("                                  Region: " + RED + "Dhaka" + RESET);
        System.out.println("==============================================================================================");
        System.out.println(RED + "[1]" + RESET + " Donor: " + RED + "Donor 1" + RESET + " | Phone: " + RED + "017XXXXXXXX" + RESET + " | Address: " + RED + "Dhanmondi" + RESET);
        System.out.println("==============================================================================================");
        System.out.println(RED + "[2]" + RESET + " Donor: " + RED + "Donor 2" + RESET + " | Phone: " + RED + "018XXXXXXXX" + RESET + " | Address: " + RED + "Gulshan" + RESET);
        System.out.println("==============================================================================================");
        System.out.println(RED + "[3]" + RESET + " Donor: " + RED + "Donor 3" + RESET + " | Phone: " + RED + "019XXXXXXXX" + RESET + " | Address: " + RED + "Banani" + RESET);
        System.out.println("==============================================================================================");
        System.out.println(RED + "[0]" + RESET + " Back");
        System.out.println("==============================================================================================");
        System.out.println("Select a donor to send a request: ");

        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                System.out.println("Sending request to Donor 1...");
                break;
            case 2:
                System.out.println("Sending request to Donor 2...");
                break;
            case 3:
                System.out.println("Sending request to Donor 3...");
                break;
            case 0:
                System.out.println("Going back...");
                break;
            default:
                System.out.println("Invalid choice. Please select 1, 2, 3, or 0.");
        }

    }
}