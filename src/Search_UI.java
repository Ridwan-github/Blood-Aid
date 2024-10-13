import java.util.Scanner;

public class Search_UI {
    public static void main(String[] args) {
        final String RED = "\033[31m";
        final String RESET = "\033[0m";


        System.out.println("==============================================================================================");
        System.out.println("                                    Search Donors");
        System.out.println("                                 Your Blood Group: A+");
        System.out.println("==============================================================================================");
        System.out.println(RED + "Enter your location: " + RESET);
        System.out.println("==============================================================================================");
        System.out.println(RED + "Which type of blood donation are you looking for?" + RESET);
        System.out.println(RED + "1." + RESET + " Whole Blood");
        System.out.println(RED + "2." + RESET + " Platelets");
        System.out.println(RED + "3." + RESET + " Plasma");
        System.out.println(RED + "4." + RESET + " Power Red");
        System.out.println(RED + "0." + RESET + " Back");
        System.out.println("==============================================================================================");
        System.out.println(RED + "Enter your choice: " + RESET);

        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                System.out.println("Searching for Whole Blood donors...");
                break;
            case 2:
                System.out.println("Searching for Platelets donors...");
                break;
            case 3:
                System.out.println("Searching for Plasma donors...");
                break;
            case 4:
                System.out.println("Searching for Power Red donors...");
                break;
            case 0:
                Recipient_UI.main(args);
                break;
            default:
                System.out.println("Invalid choice. Please select 1, 2, 3, 4, or 0.");
        }


    }
}
