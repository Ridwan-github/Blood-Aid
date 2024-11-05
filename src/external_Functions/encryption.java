package external_Functions;

import java.util.Scanner;

public class encryption {

    private static final int SHIFT = 3;

    public static String encryptPassword(String password) {
        StringBuilder encrypted = new StringBuilder();

        for (char c : password.toCharArray()) {
            encrypted.append((char) (c + SHIFT));
        }

        return encrypted.toString();
    }

    public static String decryptPassword(String encryptedPassword) {
        StringBuilder decrypted = new StringBuilder();

        for (char c : encryptedPassword.toCharArray()) {
            decrypted.append((char) (c - SHIFT));
        }

        return decrypted.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String password = scanner.nextLine();
        String encryptedPassword = encryptPassword(password);
        System.out.println("Original Password: " + password);
        System.out.println("Encrypted Password: " + encryptedPassword);

        String decryptedPassword = decryptPassword(encryptedPassword);
        System.out.println("Decrypted Password: " + decryptedPassword);
    }
}
