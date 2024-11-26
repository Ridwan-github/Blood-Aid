package Code;

import external_Functions.CurrentDate;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.util.Vector;

public class ChatSystem {

    final String RED = "\033[31m";
    final String RESET = "\033[0m";
    final String BLUE = "\033[34m";

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
    }

    public void loadMessagesForDonor(String donorID, String recipientPhoneNumber){
        try{
            File file = new File("Chat.txt");
            BufferedReader reader = new BufferedReader(new java.io.FileReader(file));

            String line;
            while((line = reader.readLine()) != null){
                String[] data = line.split(";");
                if(data[0].equals(donorID) && data[1].equals(recipientPhoneNumber)){
                    System.out.println("(" + data[3] + " " + data[4] +  ")" + BLUE + " You: " + RESET + data[2]);
                } else if(data[0].equals(recipientPhoneNumber) && data[1].equals(donorID)){
                    System.out.println("(" + data[3] + " " + data[4] +  ")" + RED + " Recipient: " + RESET + data[2]);
                }
            }
            reader.close();
        } catch (Exception e){
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void loadMessageForRecipient(String recipientPhoneNumber, String donorID){
        try{
            File file = new File("Chat.txt");
            BufferedReader reader = new BufferedReader(new java.io.FileReader(file));

            String line;
            while((line = reader.readLine()) != null){
                String[] data = line.split(";");
                if(data[0].equals(recipientPhoneNumber) && data[1].equals(donorID)){
                    System.out.println("(" + data[3] + " " + data[4] +  ")" + BLUE + " You: " + RESET + data[2]);
                } else if(data[0].equals(donorID) && data[1].equals(recipientPhoneNumber)){
                    System.out.println("(" + data[3] + " " + data[4] +  ")" + RED + " Donor: " + RESET + data[2]);
                }
            }
            reader.close();
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

    public static void main(String[] args) {
        ChatSystem chatSystem = new ChatSystem();

        chatSystem.sendMessageToRecipient("1234567890", "9876543210", "Hello");
    }
}