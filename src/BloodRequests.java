import java.util.Scanner;

public class BloodRequests {
    public static void main(String[] args) {
        final String RED = "\033[31m";
        final String RESET = "\033[0m";


        System.out.println("==============================================================================================");
        System.out.println("                                    Blood Requests");
        System.out.println("                                    Blood Group: A+");
        System.out.println("==============================================================================================");
        System.out.println(RED + "[1]" + RESET + " Recipient Name: " + RED + "Recipient 1" + RESET + " | Location: " + RED + " Hospital name, Address" + RESET + " | Contact Number: " + RED + "01XXXXXXXXX" + RESET);
        System.out.println(RED + "[2]" + RESET + " Recipient Name: " + RED + "Recipient 2" + RESET + " | Location: " + RED + " Hospital name, Address" + RESET + " | Contact Number: " + RED + "01XXXXXXXXX" + RESET);
        System.out.println(RED + "[3]" + RESET + " Recipient Name: " + RED + "Recipient 3" + RESET + " | Location: " + RED + " Hospital name, Address" + RESET + " | Contact Number: " + RED + "01XXXXXXXXX" + RESET);
        System.out.println("==============================================================================================");
        System.out.println(RED + "[4]" + RESET + " Go Back ");
        System.out.println("Select an option: ");

        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                System.out.println("Accept request of Recipient 1...");
                break;
            case 2:
                System.out.println("Accept request of Recipient 2...");
                break;
            case 3:
                System.out.println("Accept request of Recipient 3...");
                break;
            case 4:
                Donor.main(args);
                break;
            default:
                System.out.println("Invalid choice. Please select 1, 2, or 3.");
        }


    }
}
