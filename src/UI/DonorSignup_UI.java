package UI;
import Code.Donor;
import external_Functions.DateDifference;
import external_Functions.MyDate;
import external_Functions.validateUsername;
import external_Functions.ParseINT;

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
        System.out.printf(RED + "2." + RESET + " Username: ");
        String username = scanner.nextLine();
        validateUsername validateUsername = new validateUsername();
        while (!validateUsername.validate(username)) {
            System.out.println("Username already exists. Please enter a different username.");
            System.out.printf(RED + "2." + RESET + " Username: ");
            username = scanner.nextLine();
        }
        donor.setUsername(username);
        System.out.printf(RED + "3." + RESET + " Email: ");
        donor.setEmail(scanner.nextLine());
        System.out.printf(RED + "4." + RESET + " Age: ");
        int age = scanner.nextInt();
        while (age < 18) {
            System.out.println("You must be at least 18 years old to donate blood.");
            System.out.printf(RED + "4." + RESET + " Age: ");
            age = scanner.nextInt();
        }
        scanner.nextLine();
        ParseINT parseINT = new ParseINT();
        donor.setAge(parseINT.intTOString(age));
        System.out.printf(RED + "5." + RESET + " Phone Number: ");
        donor.setPhoneNumber(scanner.nextLine());
        System.out.println(RED + "6." + RESET + " Address: ");
        System.out.printf(RED + "City: ");
        donor.setcity(scanner.nextLine());
        System.out.printf(RED + "Area: ");
        donor.setArea(scanner.nextLine());
        System.out.printf(RED + "7." + RESET + " Zipcode: ");
        donor.setZipCode(scanner.nextLine());
        System.out.printf(RED + "8." + RESET + " Preferred area for donation: ");
        donor.setPreferedHospital(scanner.nextLine());

        System.out.printf(RED + "9." + RESET + " Blood Group: ");
        String bloodGroup = scanner.nextLine();
        while (!bloodGroup.equals("A+") && !bloodGroup.equals("A-") && !bloodGroup.equals("B+") &&
                !bloodGroup.equals("B-") && !bloodGroup.equals("AB+") && !bloodGroup.equals("AB-") &&
                !bloodGroup.equals("O+") && !bloodGroup.equals("O-")) {
            System.out.println("Invalid blood group. Please enter a valid blood group.");
            System.out.printf(RED + "9." + RESET + " Blood Group: ");
            bloodGroup = scanner.nextLine();
        }
        donor.setBloodGroup(bloodGroup);

        System.out.printf(RED + "10." + RESET + " NID Number: ");
        donor.setNID(scanner.nextLine());
        System.out.printf(RED + "11." + RESET + " Password: ");
        donor.setPassword(scanner.nextLine());
        System.out.println("==============================================================================================");
        System.out.println("Have you donated blood in the last 3 months?");
        System.out.println(RED + "[1]" + RESET + " Yes");
        System.out.println(RED + "[2]" + RESET + " No");
        System.out.println("==============================================================================================");
        int choice = scanner.nextInt();
        scanner.nextLine();
        while (choice != 1 && choice != 2) {
            System.out.println("Invalid choice. Please select 1 or 2.");
            System.out.println("==============================================================================================");
            System.out.println("Have you donated blood in the last 3 months?");
            System.out.println(RED + "[1]" + RESET + " Yes");
            System.out.println(RED + "[2]" + RESET + " No");
            System.out.println("==============================================================================================");
            choice = scanner.nextInt();
            scanner.nextLine();
        }
        if (choice == 1) {
            System.out.println("When did you donate blood last? (dd/mm/yyyy)");
            String date = scanner.nextLine();

            while (date.length() != 10) {
                System.out.println("Invalid date. Please enter a valid date.");
                System.out.println("When did you donate blood last? (dd/mm/yyyy)");
                date = scanner.nextLine();
            }

            MyDate myDate = new MyDate(date);
            while (!myDate.isValidDate()) {
                System.out.println("Invalid date. Please enter a valid date.");
                System.out.println("When did you donate blood last? (dd/mm/yyyy)");
                date = scanner.nextLine();
                myDate = new MyDate(date);
            }

            DateDifference dateDifference = new DateDifference(myDate);
            int difference = dateDifference.getDifference();

            while (dateDifference.isFutureDate()) {
                System.out.println("Invalid date. Please enter a valid date.");
                System.out.println("When did you donate blood last? (dd/mm/yyyy)");
                date = scanner.nextLine();
                myDate = new MyDate(date);
                dateDifference = new DateDifference(myDate);
                difference = dateDifference.getDifference();
            }

            if (difference < 90) {
                System.out.println("You are not eligible to donate blood for the next " + (90 - difference) + " days.");
                donor.setEligible(false);
            } else {
                System.out.println("You donated blood " + difference + " days ago.");
                System.out.println("You are eligible to donate blood.");
                donor.setEligible(true);
            }

            donor.setLastDonatedDate(date);
        } else {
            System.out.println("You are eligible to donate blood.");
            donor.setEligible(true);
        }

        System.out.println("==============================================================================================");
        System.out.println("By signing up you are agreeing to our " + RED + "Terms and Conditions ");
        System.out.println(RED + "[1]" + RESET + " Signup");
        System.out.println(RED + "[0]" + RESET + " Cancel and go back to login");
        System.out.println("==============================================================================================");

        int choice1 = scanner.nextInt();

        switch (choice1) {
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
