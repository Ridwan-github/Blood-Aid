package Code;

import external_Functions.CurrentDate;

import java.io.*;
import java.util.Vector;
import java.util.ArrayList;
import java.util.List;

public class ChatSystem {

    final String RED = "\033[31m";
    final String RESET = "\033[0m";
    final String BLUE = "\033[34m";

    public void clearChat(String userID, String otherUserID) {
        try {
            File file = new File("ClearedChats.txt");
            BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));
            CurrentDate currentDate = new CurrentDate();
            String date = currentDate.getDateAsString();
            String time = currentDate.getTimeAsString();
            writer.write(userID + ";" + otherUserID + ";" + date + ";" + time);
            writer.newLine();
            writer.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private String getClearTime(String userID, String otherUserID) {
        try {
            File file = new File("ClearedChats.txt");
            if (!file.exists()) return null;
            
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            String latestClearTime = null;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(";");
                if (data.length >= 4 && data[0].equals(userID) && data[1].equals(otherUserID)) {
                    latestClearTime = data[2] + " " + data[3];
                }
            }
            reader.close();
            return latestClearTime;
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return null;
    }

    public void sendMessageToRecipient(String donorID, String recipientPhoneNumber, String message){
        try{
            File file = new File("Chat.txt");
            BufferedWriter writer = new BufferedWriter(new java.io.FileWriter(file, true));
            CurrentDate currentDate = new CurrentDate();
            String date = currentDate.getDateAsString();
            String time = currentDate.getTimeAsString();

            writer.write(donorID + ";" + recipientPhoneNumber + ";" + message + ";" + date + ";" + time);
            writer.newLine();
            writer.close();
        } catch (Exception e){
            System.out.println("Error: " + e.getMessage());
        }

        try{
            File file = new File("ChatNotification.txt");
            BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));

            writer.write(donorID + ";" + recipientPhoneNumber + ";" + "true");
            writer.newLine();
            writer.close();
        } catch (Exception e){
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void sendMessageToDonor(String recipientPhoneNumber, String donorID, String message){
        try{
            File file = new File("Chat.txt");
            BufferedWriter writer = new BufferedWriter(new java.io.FileWriter(file, true));
            CurrentDate currentDate = new CurrentDate();
            String date = currentDate.getDateAsString();
            String time = currentDate.getTimeAsString();

            writer.write(recipientPhoneNumber + ";" + donorID + ";" + message + ";" + date + ";" + time);
            writer.newLine();
            writer.close();
        } catch (Exception e){
            System.out.println("Error: " + e.getMessage());
        }

        try{
            File file = new File("ChatNotification.txt");
            BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));

            writer.write(recipientPhoneNumber + ";" + donorID + ";" + "true");
            writer.newLine();
            writer.close();
        } catch (Exception e){
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void loadMessagesForDonor(String donorID, String recipientPhoneNumber){
        try{
            File file = new File("Chat.txt");
            BufferedReader reader = new BufferedReader(new java.io.FileReader(file));

            String line;
            boolean hasMessages = false;
            while((line = reader.readLine()) != null){
                String[] data = line.split(";");
                String clearTime = getClearTime(donorID, recipientPhoneNumber);
                String messageTime = data[3] + " " + data[4];
                if(clearTime == null || messageTime.compareTo(clearTime) > 0) {
                    if(data[0].equals(donorID) && data[1].equals(recipientPhoneNumber)){
                        System.out.println("(" + data[3] + " " + data[4] +  ")" + BLUE + " You: " + RESET + data[2]);
                        hasMessages = true;
                    } else if(data[0].equals(recipientPhoneNumber) && data[1].equals(donorID)){
                        System.out.println("(" + data[3] + " " + data[4] +  ")" + RED + " Recipient: " + RESET + data[2]);
                        hasMessages = true;
                    }
                }
            }
            if (!hasMessages) {
                System.out.println("No messages to display.");
            }
            reader.close();
        } catch (Exception e){
            System.out.println("Error: " + e.getMessage());
        }

        try{
            File file = new File("ChatNotification.txt");
            List<String> lines = new ArrayList<>();

            try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    String[] requestData = line.split(";");
                    if (requestData[1].trim().equals(donorID.trim()) &&
                            requestData[0].trim().equals(recipientPhoneNumber.trim()) &&
                            requestData[2].trim().equals("true")
                    ) {
                        requestData[2] = "false";
                        line = String.join(";", requestData);
                    }
                    lines.add(line);
                }
            }

            try (BufferedWriter bufferedWriter = new BufferedWriter(new java.io.FileWriter(file, false))) {
                for (String line : lines) {
                    bufferedWriter.write(line);
                    bufferedWriter.newLine();
                }
            }
        } catch (Exception e){
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void loadMessageForRecipient(String recipientPhoneNumber, String donorID){
        try{
            File file = new File("Chat.txt");
            BufferedReader reader = new BufferedReader(new java.io.FileReader(file));

            String line;
            boolean hasMessages = false;
            while((line = reader.readLine()) != null){
                String[] data = line.split(";");
                String clearTime = getClearTime(recipientPhoneNumber, donorID);
                String messageTime = data[3] + " " + data[4];
                if(clearTime == null || messageTime.compareTo(clearTime) > 0) {
                    if(data[0].equals(recipientPhoneNumber) && data[1].equals(donorID)){
                        System.out.println("(" + data[3] + " " + data[4] +  ")" + BLUE + " You: " + RESET + data[2]);
                        hasMessages = true;
                    } else if(data[0].equals(donorID) && data[1].equals(recipientPhoneNumber)){
                        System.out.println("(" + data[3] + " " + data[4] +  ")" + RED + " Donor: " + RESET + data[2]);
                        hasMessages = true;
                    }
                }
            }
            if (!hasMessages) {
                System.out.println("No messages to display.");
            }
            reader.close();
        } catch (Exception e){
            System.out.println("Error: " + e.getMessage());
        }

        try{
            File file = new File("ChatNotification.txt");
            List<String> lines = new ArrayList<>();

            try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    String[] requestData = line.split(";");
                    if (requestData[1].trim().equals(recipientPhoneNumber.trim()) &&
                            requestData[0].trim().equals(donorID.trim()) &&
                            requestData[2].trim().equals("true")
                    ) {
                        requestData[2] = "false";
                        line = String.join(";", requestData);
                    }
                    lines.add(line);
                }
            }

            try (BufferedWriter bufferedWriter = new BufferedWriter(new java.io.FileWriter(file, false))) {
                for (String line : lines) {
                    bufferedWriter.write(line);
                    bufferedWriter.newLine();
                }
            }
        } catch (Exception e){
            System.out.println("Error: " + e.getMessage());
        }
    }

    public Vector<String> availableRecipientToChat(String donorID){
        Vector<String> recipientList = new Vector<>();
        try{
            File file = new File("DonationRequestHistory.txt");
            BufferedReader reader = new BufferedReader(new java.io.FileReader(file));

            String line;
            while((line = reader.readLine()) != null){
                String[] data = line.split(";");
                if(data[0].equals(donorID) && !recipientList.contains(data[2])){
                    recipientList.add(data[2]);
                }
            }
            reader.close();
        } catch (Exception e){
            System.out.println("Error: " + e.getMessage());
        }
        return recipientList;
    }

    public Vector<String> availableDonorToChat(String recipientPhoneNumber){
        Vector<String> donorList = new Vector<>();
        try{
            File file = new File("DonationRequestHistory.txt");
            BufferedReader reader = new BufferedReader(new java.io.FileReader(file));

            String line;
            while((line = reader.readLine()) != null){
                String[] data = line.split(";");
                if(data[2].equals(recipientPhoneNumber) && !donorList.contains(data[0])){
                    donorList.add(data[0]);
                }
            }
            reader.close();
        } catch (Exception e){
            System.out.println("Error: " + e.getMessage());
        }
        return donorList;
    }

    public boolean checkChatNotificationForDonor(String phoneNumber, String donorID){
        try{
            File file = new File("ChatNotification.txt");
            BufferedReader reader = new BufferedReader(new java.io.FileReader(file));

            String line;
            while((line = reader.readLine()) != null){
                String[] data = line.split(";");
                if(data[0].trim().equals(phoneNumber) && data[1].trim().equals(donorID) && data[2].trim().equals("true")){
                    return true;
                }
            }
            reader.close();
        } catch (Exception e){
            System.out.println("Error: " + e.getMessage());
        }
        return false;
    }

    public boolean checkChatNotificationForRecipient(String phoneNumber, String donorID){
        try{
            File file = new File("ChatNotification.txt");
            BufferedReader reader = new BufferedReader(new java.io.FileReader(file));

            String line;
            while((line = reader.readLine()) != null){
                String[] data = line.split(";");
                if(data[0].trim().equals(donorID) && data[1].trim().equals(phoneNumber) && data[2].trim().equals("true")){
                    return true;
                }
            }
            reader.close();
        } catch (Exception e){
            System.out.println("Error: " + e.getMessage());
        }
        return false;
    }

    public boolean checkChatForDonor(String donorID){
        Vector<String> recipientList = availableRecipientToChat(donorID);

        for (String recipientPhoneNumber : recipientList){
            if (checkChatNotificationForDonor(recipientPhoneNumber, donorID)){
                return true;
            }
        }

        return false;
    }

    public boolean checkChatForRecipient(String recipientPhoneNumber){
        Vector<String> donorList = availableDonorToChat(recipientPhoneNumber);

        for (String donorID : donorList){
            if (checkChatNotificationForRecipient(recipientPhoneNumber, donorID)){
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        ChatSystem chatSystem = new ChatSystem();

        chatSystem.sendMessageToRecipient("1234567890", "9876543210", "Hello");
    }
}