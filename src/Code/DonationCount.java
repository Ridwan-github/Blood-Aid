package Code;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DonationCount {
    public void increaseWBCCount(String donorID) {
        File file = new File("DonationCount_and_Badge.txt");
        List<String> lines = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;

            while ((line = reader.readLine()) != null) {
                String[] data = line.split(";");

                if (data.length >= 2 && data[0].equals(donorID)) {
                    try {
                        int WBCCount = Integer.parseInt(data[1]);
                        WBCCount++;
                        data[1] = String.valueOf(WBCCount);
                    } catch (NumberFormatException e) {
                        System.err.println("Invalid WBC count for donor ID: " + donorID);
                    }
                }

                lines.add(String.join(";", data));
            }
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            for (String updatedLine : lines) {
                writer.write(updatedLine);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void increasePlateletCount(String donorID){
        File file = new File("DonationCount_and_Badge.txt");
        List<String> lines = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;

            while ((line = reader.readLine()) != null) {
                String[] data = line.split(";");

                if (data.length >= 2 && data[0].equals(donorID)) {
                    try {
                        int WBCCount = Integer.parseInt(data[3]);
                        WBCCount++;
                        data[3] = String.valueOf(WBCCount);
                    } catch (NumberFormatException e) {
                        System.err.println("Invalid WBC count for donor ID: " + donorID);
                    }
                }

                lines.add(String.join(";", data));
            }
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            for (String updatedLine : lines) {
                writer.write(updatedLine);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void increaseRBCCount(String donorID){
        File file = new File("DonationCount_and_Badge.txt");
        List<String> lines = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;

            while ((line = reader.readLine()) != null) {
                String[] data = line.split(";");

                if (data.length >= 2 && data[0].equals(donorID)) {
                    try {
                        int WBCCount = Integer.parseInt(data[4]);
                        WBCCount++;
                        data[4] = String.valueOf(WBCCount);
                    } catch (NumberFormatException e) {
                        System.err.println("Invalid WBC count for donor ID: " + donorID);
                    }
                }

                lines.add(String.join(";", data));
            }
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            for (String updatedLine : lines) {
                writer.write(updatedLine);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void increasePlasmaCount(String donorID){
        File file = new File("DonationCount_and_Badge.txt");
        List<String> lines = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;

            while ((line = reader.readLine()) != null) {
                String[] data = line.split(";");

                if (data.length >= 2 && data[0].equals(donorID)) {
                    try {
                        int WBCCount = Integer.parseInt(data[2]);
                        WBCCount++;
                        data[2] = String.valueOf(WBCCount);
                    } catch (NumberFormatException e) {
                        System.err.println("Invalid WBC count for donor ID: " + donorID);
                    }
                }

                lines.add(String.join(";", data));
            }
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            for (String updatedLine : lines) {
                writer.write(updatedLine);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        DonationCount donationCount = new DonationCount();
        donationCount.increaseWBCCount("10");
        donationCount.increasePlateletCount("10");
        donationCount.increaseRBCCount("10");
        donationCount.increasePlasmaCount("10");
    }
}
