package Test;

import Code.DonationCount;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

class DonationCountTest {

    private DonationCount donationCount;

    @BeforeEach
    void setUp() {
        donationCount = new DonationCount();
        createTestFile();
    }

    @AfterEach
    void tearDown() {
        deleteTestFile();
    }

    private void createTestFile() {
        try {
            File file = new File("DonationCount_and_Badge.txt");
            FileWriter writer = new FileWriter(file);
            writer.write("10;1;1;1;1\n");
            writer.write("20;2;2;2;2\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void deleteTestFile() {
        new File("DonationCount_and_Badge.txt").delete();
    }

    private List<String> readFileLines() {
        try {
            return Files.readAllLines(Paths.get("DonationCount_and_Badge.txt"));
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    @Test
    void testIncreaseWBCCount() {
        donationCount.increaseWBCCount("10");
        List<String> lines = readFileLines();
        assertEquals("10;2;1;1;1", lines.get(0));
    }

    @Test
    void testIncreasePlateletCount() {
        donationCount.increasePlateletCount("10");
        List<String> lines = readFileLines();
        assertEquals("10;1;1;2;1", lines.get(0));
    }

    @Test
    void testIncreaseRBCCount() {
        donationCount.increaseRBCCount("10");
        List<String> lines = readFileLines();
        assertEquals("10;1;1;1;2", lines.get(0));
    }

    @Test
    void testIncreasePlasmaCount() {
        donationCount.increasePlasmaCount("10");
        List<String> lines = readFileLines();
        assertEquals("10;1;2;1;1", lines.get(0));
    }
}