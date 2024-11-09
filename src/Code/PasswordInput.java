package Code;

import java.io.Console;

public class PasswordInput {
    public static String getPassword() {
        Console console = System.console();

        if (console == null) {
            System.out.println("No console available");
            return null;
        }

        // Prompt the user for the password and return it
        char[] passwordArray = console.readPassword();
        return new String(passwordArray);
    }

    public static void main(String[] args) {
        String password = getPassword();
        if (password != null) {
            System.out.println("\nYour entered password is: " + password);
        }
    }
}
