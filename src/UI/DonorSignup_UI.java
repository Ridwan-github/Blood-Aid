package UI;
import Code.Donor;

import java.util.Scanner;

public class DonorSignup_UI {
    public static void main(String[] args) {
        final String RED = "\033[31m";
        final String RESET = "\033[0m";
        Donor donor = new Donor();
        Scanner scanner = new Scanner(System.in);


        System.out.println("==============================================================================================");
        System.out.println("                                    Donor Signup");
        System.out.println("==============================================================================================");
        System.out.printf(RED + "1." + RESET + " Name: ");
        donor.setName(scanner.nextLine());
        System.out.printf(RED + "2." + RESET + " Phone Number: ");
        donor.setPhoneNumber(scanner.nextLine());
        System.out.println(RED + "3." + RESET + " Address: ");
        System.out.printf(RED + "City: ");
        donor.setcity(scanner.nextLine());
        System.out.printf(RED + "Area: ");
        donor.setArea(scanner.nextLine());

        System.out.printf(RED + "4." + RESET + " Blood Group: ");
        String bloodGroup = scanner.nextLine();
        while (!bloodGroup.equals("A+") && !bloodGroup.equals("A-") && !bloodGroup.equals("B+") &&
                !bloodGroup.equals("B-") && !bloodGroup.equals("AB+") && !bloodGroup.equals("AB-") &&
                !bloodGroup.equals("O+") && !bloodGroup.equals("O-")) {
            System.out.println("Invalid blood group. Please enter a valid blood group.");
            System.out.printf(RED + "4." + RESET + " Blood Group: ");
            bloodGroup = scanner.nextLine();
        }
        donor.setBloodGroup(bloodGroup);

        System.out.printf(RED + "5." + RESET + " NID Number: ");
        donor.setNID(scanner.nextLine());
        System.out.printf(RED + "6." + RESET + " Password: ");
        donor.setPassword(scanner.nextLine());
        System.out.printf(RED + "7." + RESET + " Do you agree to the term and conditions (" + RED + "Yes" + RESET + "/No)");
        System.out.println("==============================================================================================");
        System.out.println(RED + "[1]" + RESET + " Signup");
        System.out.println(RED + "[0]" + RESET + " Back");
        System.out.println("==============================================================================================");

        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                donor.registerDonor();
                Login_UI.main(args);
                break;
            case 0:
                Login_UI.main(args);
                break;
            default:
                System.out.println("Invalid choice. Please select 1 or 0.");
        }
    }
}
