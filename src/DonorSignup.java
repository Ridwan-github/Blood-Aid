import java.util.Scanner;

public class DonorSignup {
    public static void main(String[] args) {
        final String RED = "\033[31m";
        final String RESET = "\033[0m";

        System.out.println("==============================================================================================");
        System.out.println("                                    Donor Signup");
        System.out.println("==============================================================================================");
        System.out.println(RED + "1." + RESET + " Name: ");
        System.out.println(RED + "2." + RESET + " Phone Number: ");
        System.out.println(RED + "3." + RESET + " Address: ");
        System.out.println(RED + "4." + RESET + " Blood Group: ");
        System.out.println(RED + "5." + RESET + " NID Number: ");
        System.out.println(RED + "6." + RESET + " Email: ");
        System.out.println(RED + "7." + RESET + " Password: ");
        System.out.println(RED + "8." + RESET + " Do you agree to the term and conditions (" + RED + "Yes" + RESET + "/No)");
        System.out.println("==============================================================================================");
        System.out.println(RED + "[1]" + RESET + " Signup");
        System.out.println(RED + "[0]" + RESET + " Back");
        System.out.println("==============================================================================================");

        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                Donor.main(args);
                break;
            case 0:
                Login.main(args);
                break;
            default:
                System.out.println("Invalid choice. Please select 1 or 0.");
        }
    }
}
