package Code;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BadgeManagement {
    public boolean checkForBadge(String donorID, String badgeType) {
        File file = new File("DonationCount_and_Badge.txt");

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(";");

                if (data.length >= 2 && data[0].equals(donorID)) {
                    if (badgeType.equals("firstDrop") && Boolean.parseBoolean(data[5])){
                        return true;
                    } else if (badgeType.equals("frequentDonor") && Boolean.parseBoolean(data[6])){
                        return true;
                    } else if (badgeType.equals("lifeSaver") && Boolean.parseBoolean(data[7])){
                        return true;
                    } else if (badgeType.equals("pioneer") && Boolean.parseBoolean(data[8])){
                        return true;
                    } else if (badgeType.equals("rareBloodHero") && Boolean.parseBoolean(data[9])){
                        return true;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void updateBadge(String donorID, String badgeType) {
        File file = new File("DonationCount_and_Badge.txt");
        List<String> fileContent = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(";");

                if (data.length >= 2 && data[0].equals(donorID)) {
                    if (badgeType.equals("firstDrop")) {
                        data[5] = "true";
                    } else if (badgeType.equals("frequentDonor")) {
                        data[6] = "true";
                    } else if (badgeType.equals("lifeSaver")) {
                        data[7] = "true";
                    } else if (badgeType.equals("pioneer")) {
                        data[8] = "true";
                    } else if (badgeType.equals("rareBloodHero")) {
                        data[9] = "true";
                    }
                    line = String.join(";", data);
                }
                fileContent.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            for (String line : fileContent) {
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int getDonationCount(String donorID, String donationType) {
        File file = new File("DonationCount_and_Badge.txt");

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(";");

                if (data.length >= 2 && data[0].equals(donorID)) {
                    if (donationType.equals("wholeBlood")) {
                        return Integer.parseInt(data[1]);
                    } else if (donationType.equals("platelet")) {
                        return Integer.parseInt(data[3]);
                    } else if (donationType.equals("plasma")) {
                        return Integer.parseInt(data[2]);
                    } else if (donationType.equals("powerRed")) {
                        return Integer.parseInt(data[4]);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int getTotalDonationCount(String donorID){
        int count = 0;
        count += getDonationCount(donorID, "wholeBlood");
        count += getDonationCount(donorID, "platelet");
        count += getDonationCount(donorID, "plasma");
        count += getDonationCount(donorID, "powerRed");
        return count;
    }

    public boolean checkForFirstDropBadge(String donorID) {
        return checkForBadge(donorID, "firstDrop");
    }

    public boolean checkForFrequentDonorBadge(String donorID) {
        return checkForBadge(donorID, "frequentDonor");
    }

    public boolean checkForLifeSaverBadge(String donorID) {
        return checkForBadge(donorID, "lifeSaver");
    }

    public boolean checkForPioneerBadge(String donorID) {
        return checkForBadge(donorID, "pioneer");
    }

    public boolean checkForRareBloodHeroBadge(String donorID) {
        return checkForBadge(donorID, "rareBloodHero");
    }

    public void updateFirstDropBadge(String donorID) {
        updateBadge(donorID, "firstDrop");
    }

    public void updateFrequentDonorBadge(String donorID) {
        if (getTotalDonationCount(donorID) >= 5) {
            updateBadge(donorID, "frequentDonor");
        }
    }

    public void updateLifeSaverBadge(String donorID) {
        if (getTotalDonationCount(donorID) >= 20) {
            updateBadge(donorID, "lifeSaver");
        }
    }

    public void updateRareBloodHeroBadge(String donorID) {
        updateBadge(donorID, "rareBloodHero");
    }

    public static void main(String[] args) {
        BadgeManagement badgeManagement = new BadgeManagement();
        System.out.println(badgeManagement.checkForBadge("1", "firstDrop"));
        System.out.println(badgeManagement.checkForBadge("1", "frequentDonor"));
        System.out.println(badgeManagement.checkForBadge("1", "lifeSaver"));
        System.out.println(badgeManagement.checkForBadge("1", "pioneer"));
        System.out.println(badgeManagement.checkForBadge("1", "rareBloodHero"));

    }

}
