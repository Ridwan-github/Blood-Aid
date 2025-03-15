package UI;

import Code.PasswordMasking;
import Code.User;
import Code.AuthorizationConstraintsValidator;
import external_Functions.toLower;

import java.util.Scanner;

public class Home {
    private static String getInput(Scanner scanner) {
        String input = scanner.nextLine();
        if ("0".equals(input)) {
            Home.RedirectClass.redirectMethod();
            System.exit(0);
        }
        return input;
    }

    private static int getIntInput(Scanner scanner) {
        int input = scanner.nextInt();
        if (input == 0) {
            Home.RedirectClass.redirectMethod();
            System.exit(0);
        }
        return input;
    }

    public class RedirectClass {
        public static void redirectMethod() {
            ConsoleUtils consoleUtils = new ConsoleUtils();
            consoleUtils.clearScreen();
            Home.main(new String[0]);
        }
    }

    public static void handleLogin(String[] args) {
        ConsoleUtils consoleUtils = new ConsoleUtils();
        consoleUtils.clearScreen();
        Scanner scanner = new Scanner(System.in);
        System.out.println("==========================================================================");
        final String RED = "\033[31m";
        final String RESET = "\033[0m";
        System.out.println(RED + "\t\t\t\tUser Login" + RESET);
        System.out.println("==========================================================================");
        System.out.println("Enter your phone number and password to login. (Enter " + RED + "[0]" + RESET + " to go back)");
        System.out.print(RED + "Phone number: " + RESET);
        String phoneNumber = getInput(scanner);
        System.out.print(RED + "Password: " + RESET);
        String password = getInput(scanner);
        User user1 = new User();
        if (user1.login(phoneNumber, password)) {
            consoleUtils.clearScreen();
            User_UI.main(phoneNumber, password, args);

        } else {
            System.out.println("Login failed! Please try again.");
            System.out.println("Press " + RED + "[0]" + RESET + " to go back to the main menu.");
            int choice = getIntInput(scanner);
            if (choice == 0) {
                Home.RedirectClass.redirectMethod();
            }
        }
    }

    public static void handleSignup(String[] args){
        ConsoleUtils consoleUtils = new ConsoleUtils();
        toLower toLower = new toLower();
        consoleUtils.clearScreen();
        Scanner scanner = new Scanner(System.in);
        System.out.println("==========================================================================");
        final String RED = "\033[31m";
        final String RESET = "\033[0m";
        System.out.println(RED + "\t\t\t\tUser Signup" + RESET);
        System.out.println("==========================================================================");
        System.out.println("Enter your credentials to signup. (Enter " + RED + "[0]" + RESET + " to go back)");
        System.out.print(RED + "Name: " + RESET);
        String name = getInput(scanner);
        System.out.print(RED + "Phone number: " + RESET);
        String phoneNumber = getInput(scanner);
        if (phoneNumber.length() == 14){
            if (phoneNumber.charAt(0) == '+' && phoneNumber.charAt(1) == '8' && phoneNumber.charAt(2) == '8') {
                String s = "";
                for (int i = 3; i < 14; i++) {
                    s += phoneNumber.charAt(i);
                }
                phoneNumber = s;
            } else {
                System.out.println("Please input valid phone number");
                System.out.printf(RED + " Phone Number: " + RESET);
                phoneNumber = scanner.nextLine();
            }
        }

        while (!AuthorizationConstraintsValidator.validatePhoneNumber(phoneNumber) || !AuthorizationConstraintsValidator.repeatPhoneNumber(phoneNumber)) {
            if (!AuthorizationConstraintsValidator.validatePhoneNumber(phoneNumber)) {
                System.out.println("Please input valid phone number");
                System.out.printf(RED + " Phone Number: " + RESET);
                phoneNumber = scanner.nextLine();
            } else if (!AuthorizationConstraintsValidator.repeatPhoneNumber(phoneNumber)) {
                System.out.println("Phone number already exists. Please enter a different phone number.");
                System.out.printf(RED + " Phone Number: " + RESET);
                phoneNumber = scanner.nextLine();
            }
        }
        System.out.println(RED + "Address - " + RESET);
        System.out.printf(RED + "City: " + RESET);
        String city = scanner.nextLine();
        while (!AuthorizationConstraintsValidator.validateCity(city)) {
            System.out.println("Please input 2-50 letters & only alphabetic letters");
            System.out.printf(RED + " City: " + RESET);
            city = scanner.nextLine();
        }
        city = toLower.toLower(city);
        while (!AuthorizationConstraintsValidator.validCity(city)) {
            System.out.println("Please input a valid city.");
            System.out.printf(RED + " City: " + RESET);
            city = scanner.nextLine();
            city = toLower.toLower(city);
        }

        System.out.printf(RED + "Area: " + RESET);
        String area = scanner.nextLine();
        while (!AuthorizationConstraintsValidator.validateArea(area)) {
            System.out.println("Please input at max 50 letters");
            System.out.printf(RED + " Area: " + RESET);
            area = scanner.nextLine();
        }

        System.out.printf(RED + "Blood group: " + RESET);
        String bloodGroup = scanner.nextLine();
        while (!AuthorizationConstraintsValidator.validateBloodGroup(bloodGroup)) {
            System.out.println("Invalid blood group. Please enter a valid blood group.");
            System.out.printf(RED + " Blood Group: " + RESET);
            bloodGroup = scanner.nextLine();
        }
        System.out.print(RED + "Password: " + RESET);
        String password = getInput(scanner);
        while (!AuthorizationConstraintsValidator.validatePassword(password)) {
            System.out.println("Please input 8-32 character");
            System.out.println("Please include at least one uppercase,lowercase,numeric and special character");
            System.out.printf(RED + " Password: " + RESET);
            password = scanner.nextLine();
        }
        User user = new User();
        user.setName(name);
        user.setPhoneNumber(phoneNumber);
        user.setPassword(password);
        user.setCity(city);
        user.setArea(area);
        user.setBloodGroup(bloodGroup);

        if (user.registerUser()){
            consoleUtils.clearScreen();
            User_UI.main(phoneNumber, password, args);
        } else {
            System.out.println("Signup failed! Please try again.");
            System.out.println("Press " + RED + "[0]" + RESET + " to go back to the main menu.");
            int choice = getIntInput(scanner);
            if (choice == 0) {
                Home.RedirectClass.redirectMethod();
            }
        }
    }

    public static void main(String[] args) {
        User user = new User();

        final String RED = "\033[31m";
        final String RESET = "\033[0m";
        PasswordMasking passwordMasking = new PasswordMasking();
        ConsoleUtils consoleUtils = new ConsoleUtils();
        Scanner scanner = new Scanner(System.in);

        System.out.println("==========================================================================");
        System.out.println(RED + "\t  ____    _                       _               _       _ ");
        System.out.println("\t |  _ \\  | |                     | |      /\\     (_)     | |");
        System.out.println("\t | |_) | | |   ___     ___     __| |     /  \\     _    __| |");
        System.out.println("\t |  _ <  | |  / _ \\   / _ \\   / _` |    / /\\ \\   | |  / _` |");
        System.out.println("\t | |_) | | | | (_) | | (_) | | (_| |   / ____ \\  | | | (_| |");
        System.out.println("\t |____/  |_|  \\___/   \\___/   \\__,_|  /_/    \\_\\ |_|  \\__,_|" + RESET);
        System.out.println("==========================================================================");

        System.out.println("\nPlease choose an option:");
        System.out.println(RED + "[1]" + RESET + " Login");
        System.out.println(RED + "[2]" + RESET + " Signup");
        System.out.println(RED + "[3]" + RESET + " Exit");
        System.out.println("==========================================================================");

        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        while (choice != 1 && choice != 2 && choice != 3) {
            System.out.println("Invalid choice! Please try again.");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();
        }

        switch (choice) {
            case 1:
                handleLogin(args);
                break;
            case 2:
                handleSignup(args);
                break;
            case 3:
                System.exit(0);
                break;
        }
    }
}
