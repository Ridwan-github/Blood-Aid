package UI;

import Code.PasswordMasking;
import Code.User;

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

    public static void handleLogin() {
        ConsoleUtils consoleUtils = new ConsoleUtils();
        consoleUtils.clearScreen();
        Scanner scanner = new Scanner(System.in);
        System.out.println("==============================================================================================");
        final String RED = "\033[31m";
        final String RESET = "\033[0m";
        System.out.println(RED + "\t\t\t\tUser Login" + RESET);
        System.out.println("==============================================================================================");
        System.out.println("Enter your phone number and password to login. (Enter " + RED + "[0]" + RESET + " to go back)");
        System.out.print("Enter your phone number: ");
        String phoneNumber = getInput(scanner);
        System.out.print("Enter your password: ");
        String password = getInput(scanner);
        User user1 = new User();
        if (user1.login(phoneNumber, password)) {
            consoleUtils.clearScreen();
            User_UI.main(phoneNumber, password, new String[0]);

        } else {
            System.out.println("Login failed! Please try again.");
            System.out.println("Press " + RED + "[0]" + RESET + " to go back to the main menu.");
            int choice = getIntInput(scanner);
            if (choice == 0) {
                Home.RedirectClass.redirectMethod();
            }
        }
    }

    public static void handleSignup(){
        ConsoleUtils consoleUtils = new ConsoleUtils();
        consoleUtils.clearScreen();
        Scanner scanner = new Scanner(System.in);
        System.out.println("==============================================================================================");
        final String RED = "\033[31m";
        final String RESET = "\033[0m";
        System.out.println(RED + "\t\t\t\tUser Signup" + RESET);
        System.out.println("==============================================================================================");
        System.out.println("Enter your name, phone number, and password to signup. (Enter " + RED + "[0]" + RESET + " to go back)");
        System.out.print("Enter your name: ");
        String name = getInput(scanner);
        System.out.print("Enter your phone number: ");
        String phoneNumber = getInput(scanner);
        System.out.print("Enter your password: ");
        String password = getInput(scanner);
        User user = new User();
        user.setName(name);
        user.setPhoneNumber(phoneNumber);
        user.setPassword(password);

        if (user.registerUser()){
            consoleUtils.clearScreen();
            User_UI.main(phoneNumber, password, new String[0]);
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

        System.out.println("==============================================================================================");
        System.out.println(RED + "\t\t\t\t  ____    _                       _               _       _ ");
        System.out.println("\t\t\t\t |  _ \\  | |                     | |      /\\     (_)     | |");
        System.out.println("\t\t\t\t | |_) | | |   ___     ___     __| |     /  \\     _    __| |");
        System.out.println("\t\t\t\t |  _ <  | |  / _ \\   / _ \\   / _` |    / /\\ \\   | |  / _` |");
        System.out.println("\t\t\t\t | |_) | | | | (_) | | (_) | | (_| |   / ____ \\  | | | (_| |");
        System.out.println("\t\t\t\t |____/  |_|  \\___/   \\___/   \\__,_|  /_/    \\_\\ |_|  \\__,_|" + RESET);
        System.out.println("==============================================================================================");

        System.out.println("\nPlease choose an option:");
        System.out.println(RED + "[1]" + RESET + " Login");
        System.out.println(RED + "[2]" + RESET + " Signup");
        System.out.println(RED + "[3]" + RESET + " Exit");
        System.out.println("==============================================================================================");

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
                handleLogin();
                break;
            case 2:
                handleSignup();
                break;
            case 3:
                System.exit(0);
                break;
        }
    }
}
