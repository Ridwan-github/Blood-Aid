package UI;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ChangeAvailabilityStatus {
    public void changeStatus(String phone) {
        File file = new File("Donor.txt");
        List<String> lines = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;

            while ((line = reader.readLine()) != null) {
                String[] data = line.split(";");
                if (data.length > 0) {
                    String phoneNumber = data[1];

                    if (phoneNumber.equals(phone)) {
                        if (data[23].equals("true")) {
                            data[23] = "false";
                        } else {
                            data[23] = "true";
                        }
                        lines.add(data[0] + ";" + data[1] + ";" + data[2] + ";" + data[3] + ";" + data[4] + ";" + data[5] + ";" + data[6] + ";" + data[7] + ";" + data[8] + ";" + data[9] + ";" + data[10] + ";" + data[11] + ";" + data[12] + ";" + data[13] + ";" + data[14] + ";" + data[15] + ";" + data[16] + ";" + data[17] + ";" + data[18] + ";" + data[19] + ";" + data[20] + ";" + data[21] + ";" + data[22] +";" + data[23]);
                    } else {
                        lines.add(line);
                    }
                }
            }

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, false))) {
                for (String updatedLine : lines) {
                    writer.write(updatedLine);
                    writer.newLine();
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String phone, String pass, String[] args) {
        final String RED = "\033[0;31m";
        final String RESET = "\033[0m";
        Scanner  scanner = new Scanner(System.in);
        ConsoleUtils consoleUtils = new ConsoleUtils();

        ChangeAvailabilityStatus changeAvailabilityStatus = new ChangeAvailabilityStatus();
        System.out.println("Do you want to change your availability status? ");
        System.out.println(RED + "[1]" + RESET + " Yes");
        System.out.println(RED + "[2]" + RESET + " No");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine();
        if (choice == 1) {
            changeAvailabilityStatus.changeStatus(phone);
            System.out.println("Your availability status has been changed successfully.");
            System.out.println("Going back to the dashboard...");
            consoleUtils.holdTime();
            consoleUtils.clearScreen();
            Donor_UI.main(phone, pass, args);
        } else {
            System.out.println("Your availability status has not been changed.");
            System.out.println("Going back to the dashboard...");
            consoleUtils.holdTime();
            consoleUtils.clearScreen();
            Donor_UI.main(phone, pass, args);
        }
    }
}
