package Test;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.*;
import Code.AuthorizationConstraintsValidator;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

class AuthorizationConstraintsValidatorTest {

    @BeforeEach
    void setUp() {
        createTestFiles();
    }

    @AfterEach
    void tearDown() {
        deleteTestFiles();
    }

    private void createTestFiles() {
        try {
            File donorFile = new File("Donor.txt");
            FileWriter donorWriter = new FileWriter(donorFile);
            donorWriter.write("Full Name;01234567890;City;Area;A+;1234567890;password;12345;30;01/01/2023;Male;username;email@example.com;test@email.com;true;false;true;false;100;20;30;10;50;true\n");
            donorWriter.write("Another Name;01987654321;City;Area;B+;9876543210;password;54321;25;01/02/2023;Male;uniquename;email2@example.com;unique@email.com;false;true;false;true;90;15;25;5;40;true\n");
            donorWriter.close();

            File recipientFile = new File("Recipient.txt");
            FileWriter recipientWriter = new FileWriter(recipientFile);
            recipientWriter.write("Full Name;01712345678;City;Area;A+;1234567890;password;12345;30;01/01/2023;Male;username;email@example.com\n");
            recipientWriter.close();

            File addressFile = new File("Address.txt");
            FileWriter addressWriter = new FileWriter(addressFile);
            addressWriter.write("Dhaka\n");
            addressWriter.write("Chittagong\n");
            addressWriter.write("Rajshahi\n");
            addressWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void deleteTestFiles() {
        new File("Donor.txt").delete();
        new File("Recipient.txt").delete();
        new File("Address.txt").delete();
    }

    @Test
    void testValidateName() {
        assertTrue(AuthorizationConstraintsValidator.validateName("John Doe"));
        assertTrue(AuthorizationConstraintsValidator.validateName("AB"));
        assertTrue(AuthorizationConstraintsValidator.validateName("John Smith Doe"));

        assertFalse(AuthorizationConstraintsValidator.validateName("A"));
        assertFalse(AuthorizationConstraintsValidator.validateName("John123"));
        assertFalse(AuthorizationConstraintsValidator.validateName("John@Doe"));
        assertFalse(AuthorizationConstraintsValidator.validateName(null));
        assertFalse(AuthorizationConstraintsValidator.validateName(""));

        StringBuilder longName = new StringBuilder();
        for (int i = 0; i < 101; i++) {
            longName.append("a");
        }
        assertFalse(AuthorizationConstraintsValidator.validateName(longName.toString()));
    }

    @Test
    void testValidateFirstThreeDigits() {
        assertTrue(AuthorizationConstraintsValidator.validateFirstThreeDigits("01912345678"));
        assertTrue(AuthorizationConstraintsValidator.validateFirstThreeDigits("01712345678"));
        assertTrue(AuthorizationConstraintsValidator.validateFirstThreeDigits("01312345678"));
        assertTrue(AuthorizationConstraintsValidator.validateFirstThreeDigits("01412345678"));
        assertTrue(AuthorizationConstraintsValidator.validateFirstThreeDigits("01512345678"));
        assertTrue(AuthorizationConstraintsValidator.validateFirstThreeDigits("01612345678"));
        assertTrue(AuthorizationConstraintsValidator.validateFirstThreeDigits("01812345678"));

        assertFalse(AuthorizationConstraintsValidator.validateFirstThreeDigits("01012345678"));
        assertFalse(AuthorizationConstraintsValidator.validateFirstThreeDigits("02712345678"));
        assertFalse(AuthorizationConstraintsValidator.validateFirstThreeDigits("0171234567"));
        assertFalse(AuthorizationConstraintsValidator.validateFirstThreeDigits("017123456789"));
    }

    @Test
    void testRepeatPhoneNumber() {
        assertFalse(AuthorizationConstraintsValidator.repeatPhoneNumber("01234567890"));
        assertTrue(AuthorizationConstraintsValidator.repeatPhoneNumber("01555555555"));
    }

    @Test
    void testRecipientRepeatPhone() {
        assertFalse(AuthorizationConstraintsValidator.recipientRepeatPhone("01712345678"));
        assertTrue(AuthorizationConstraintsValidator.recipientRepeatPhone("01555555555"));
    }

    @Test
    void testValidatePhoneNumber() {
        assertTrue(AuthorizationConstraintsValidator.validatePhoneNumber("01712345678"));
        assertTrue(AuthorizationConstraintsValidator.validatePhoneNumber("01912345678"));
        assertTrue(AuthorizationConstraintsValidator.validatePhoneNumber("+8801712345678"));

        assertFalse(AuthorizationConstraintsValidator.validatePhoneNumber(null));
        assertFalse(AuthorizationConstraintsValidator.validatePhoneNumber("0171234567"));
        assertFalse(AuthorizationConstraintsValidator.validatePhoneNumber("017123456789"));
        assertFalse(AuthorizationConstraintsValidator.validatePhoneNumber("+88017123456"));
        assertFalse(AuthorizationConstraintsValidator.validatePhoneNumber("+8801012345678"));
        assertFalse(AuthorizationConstraintsValidator.validatePhoneNumber("01712345A78"));
        assertFalse(AuthorizationConstraintsValidator.validatePhoneNumber("+77017123456789"));
    }

    @Test
    void testRepeatEmail() {
        assertFalse(AuthorizationConstraintsValidator.repeatEmail("test@email.com"));
        assertTrue(AuthorizationConstraintsValidator.repeatEmail("new@email.com"));
    }

    @Test
    void testValidateEmail() {
        assertTrue(AuthorizationConstraintsValidator.validateEmail("test@example.com"));
        assertTrue(AuthorizationConstraintsValidator.validateEmail("user.name@domain.co.uk"));

        assertFalse(AuthorizationConstraintsValidator.validateEmail(null));
        assertFalse(AuthorizationConstraintsValidator.validateEmail("test"));
        assertFalse(AuthorizationConstraintsValidator.validateEmail("test@"));
        assertFalse(AuthorizationConstraintsValidator.validateEmail("@example.com"));
        assertFalse(AuthorizationConstraintsValidator.validateEmail("test@a."));
    }

    @Test
    void testValidateCity() {
        assertTrue(AuthorizationConstraintsValidator.validateCity("Dhaka"));
        assertTrue(AuthorizationConstraintsValidator.validateCity("NewYork"));

        assertFalse(AuthorizationConstraintsValidator.validateCity(null));
        assertFalse(AuthorizationConstraintsValidator.validateCity("A"));
        assertFalse(AuthorizationConstraintsValidator.validateCity("Dhaka123"));
        assertFalse(AuthorizationConstraintsValidator.validateCity("New York"));

        StringBuilder longCity = new StringBuilder();
        for (int i = 0; i < 51; i++) {
            longCity.append("a");
        }
        assertFalse(AuthorizationConstraintsValidator.validateCity(longCity.toString()));
    }

    @Test
    void testValidateArea() {
        assertTrue(AuthorizationConstraintsValidator.validateArea("Gulshan"));
        assertTrue(AuthorizationConstraintsValidator.validateArea("Dhanmondi"));
        assertTrue(AuthorizationConstraintsValidator.validateArea(""));

        assertFalse(AuthorizationConstraintsValidator.validateArea(null));

        StringBuilder longArea = new StringBuilder();
        for (int i = 0; i < 51; i++) {
            longArea.append("a");
        }
        assertFalse(AuthorizationConstraintsValidator.validateArea(longArea.toString()));
    }

    @Test
    void testRepeatNID() {
        assertFalse(AuthorizationConstraintsValidator.repeatNID("1234567890"));
        assertTrue(AuthorizationConstraintsValidator.repeatNID("9999999999"));
    }

    @Test
    void testValidateNID() {
        assertTrue(AuthorizationConstraintsValidator.validateNID("1234567890"));

        assertFalse(AuthorizationConstraintsValidator.validateNID(null));
        assertFalse(AuthorizationConstraintsValidator.validateNID("123456789"));
        assertFalse(AuthorizationConstraintsValidator.validateNID("12345678901"));
        assertFalse(AuthorizationConstraintsValidator.validateNID("123456789A"));
    }

    @Test
    void testValidatePassword() {
        assertTrue(AuthorizationConstraintsValidator.validatePassword("Pass123!"));
        assertTrue(AuthorizationConstraintsValidator.validatePassword("Abcd1234@#$%"));

        assertFalse(AuthorizationConstraintsValidator.validatePassword(null));
        assertFalse(AuthorizationConstraintsValidator.validatePassword("Pass123"));
        assertFalse(AuthorizationConstraintsValidator.validatePassword("pass123!"));
        assertFalse(AuthorizationConstraintsValidator.validatePassword("PASS123!"));
        assertFalse(AuthorizationConstraintsValidator.validatePassword("Password!"));
        assertFalse(AuthorizationConstraintsValidator.validatePassword("Pa1!"));
    }

    @Test
    void testValidateZipCode() {
        assertTrue(AuthorizationConstraintsValidator.validateZipCode("1234"));

        assertFalse(AuthorizationConstraintsValidator.validateZipCode(null));
        assertFalse(AuthorizationConstraintsValidator.validateZipCode("123"));
        assertFalse(AuthorizationConstraintsValidator.validateZipCode("12345"));
        assertFalse(AuthorizationConstraintsValidator.validateZipCode("123A"));
    }

    @Test
    void testRepeatUserName() {
        assertFalse(AuthorizationConstraintsValidator.repeatUserName("username"));
        assertTrue(AuthorizationConstraintsValidator.repeatUserName("newusername"));
    }

    @Test
    void testValidateUserName() {
        assertTrue(AuthorizationConstraintsValidator.validateUserName("username"));
        assertTrue(AuthorizationConstraintsValidator.validateUserName("user123"));
        assertTrue(AuthorizationConstraintsValidator.validateUserName("user_name"));
        assertTrue(AuthorizationConstraintsValidator.validateUserName("user-name"));

        assertFalse(AuthorizationConstraintsValidator.validateUserName(null));
        assertFalse(AuthorizationConstraintsValidator.validateUserName("user"));
        assertFalse(AuthorizationConstraintsValidator.validateUserName("user name"));
        assertFalse(AuthorizationConstraintsValidator.validateUserName("user@name"));

        assertFalse(AuthorizationConstraintsValidator.validateUserName("usernameusernameusernameusername1"));
    }

    @Test
    void testValidateLastDonationDate() {
        assertTrue(AuthorizationConstraintsValidator.validateLastDonationDate("01/01/2023"));
        assertTrue(AuthorizationConstraintsValidator.validateLastDonationDate("31/12/2022"));

        assertFalse(AuthorizationConstraintsValidator.validateLastDonationDate(null));
        assertFalse(AuthorizationConstraintsValidator.validateLastDonationDate("2023/01/01"));
        assertFalse(AuthorizationConstraintsValidator.validateLastDonationDate("01/01/20235"));
        assertFalse(AuthorizationConstraintsValidator.validateLastDonationDate("31/12/2025"));
    }

    @Test
    void testValidateAge() {
        assertTrue(AuthorizationConstraintsValidator.validateAge(18));
        assertTrue(AuthorizationConstraintsValidator.validateAge(30));
        assertTrue(AuthorizationConstraintsValidator.validateAge(65));

        assertFalse(AuthorizationConstraintsValidator.validateAge(17));
        assertFalse(AuthorizationConstraintsValidator.validateAge(66));
    }

}