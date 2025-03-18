package Test;

import Code.ChatSystem;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Vector;

import static org.junit.jupiter.api.Assertions.*;

class ChatSystemTest {

    private ChatSystem chatSystem;

    @BeforeEach
    void setUp() {
        chatSystem = new ChatSystem();
        createTestFiles();
    }

    @AfterEach
    void tearDown() {
        deleteTestFiles();
    }

    private void createTestFiles() {
        try {
            File chatFile = new File("Chat.txt");
            FileWriter chatWriter = new FileWriter(chatFile);
            chatWriter.write("1234567890;9876543210;Hello;01/01/2023;12:00\n");
            chatWriter.write("9876543210;1234567890;Hi;01/01/2023;12:01\n");
            chatWriter.close();

            File chatNotificationFile = new File("ChatNotification.txt");
            FileWriter chatNotificationWriter = new FileWriter(chatNotificationFile);
            chatNotificationWriter.write("1234567890;9876543210;true\n");
            chatNotificationWriter.close();

            File donationRequestHistoryFile = new File("DonationRequestHistory.txt");
            FileWriter donationRequestHistoryWriter = new FileWriter(donationRequestHistoryFile);
            donationRequestHistoryWriter.write("1234567890;request1;9876543210\n");
            donationRequestHistoryWriter.write("1234567890;request2;9876543211\n");
            donationRequestHistoryWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void deleteTestFiles() {
        new File("Chat.txt").delete();
        new File("ChatNotification.txt").delete();
        new File("DonationRequestHistory.txt").delete();
    }

    @Test
    void testSendMessageToRecipient() {
        chatSystem.sendMessageToRecipient("1234567890", "9876543210", "How are you?");
        // Add assertions to verify the message was sent correctly
    }

    @Test
    void testSendMessageToDonor() {
        chatSystem.sendMessageToDonor("9876543210", "1234567890", "I am fine.");
        // Add assertions to verify the message was sent correctly
    }

    @Test
    void testLoadMessagesForDonor() {
        chatSystem.loadMessagesForDonor("1234567890", "9876543210");
        // Add assertions to verify the messages were loaded correctly
    }

    @Test
    void testLoadMessageForRecipient() {
        chatSystem.loadMessageForRecipient("9876543210", "1234567890");
        // Add assertions to verify the messages were loaded correctly
    }

    @Test
    void testAvailableRecipientToChat() {
        Vector<String> recipients = chatSystem.availableRecipientToChat("1234567890");
        assertEquals(2, recipients.size());
        assertTrue(recipients.contains("9876543210"));
        assertTrue(recipients.contains("9876543211"));
    }

    @Test
    void testAvailableDonorToChat() {
        Vector<String> donors = chatSystem.availableDonorToChat("9876543210");
        assertEquals(1, donors.size());
        assertTrue(donors.contains("1234567890"));
    }

    @Test
    void testCheckChatForRecipient() {
        assertTrue(chatSystem.checkChatForRecipient("9876543210"));
    }
}