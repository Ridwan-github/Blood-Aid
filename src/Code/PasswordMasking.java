package Code;

import java.io.Console;
import java.io.IOException;

public class PasswordMasking {
    public static String getPassword() {
        Console console = System.console();

        if (console != null) {
            return new String(console.readPassword());
        } else {
            return readPasswordFromStdin();
        }
    }

    private static String readPasswordFromStdin() {
        StringBuilder password = new StringBuilder();
        try {
            while (true) {
                char ch = (char) System.in.read();
                if (ch == '\n' || ch == '\r') {
                    System.out.println();
                    break;
                } else if (ch == '\b' || ch == 127) {
                    if (password.length() > 0) {
                        password.deleteCharAt(password.length() - 1);
                        System.out.print("\b \b");
                    }
                } else {
                    password.append(ch);
                    System.out.print("*");
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading password: " + e.getMessage());
        }

        return password.toString();
    }
}
