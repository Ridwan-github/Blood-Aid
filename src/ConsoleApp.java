import java.io.IOException;

public class ConsoleApp {

    public static void clearConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void showPageOne() {
        clearConsole();
        System.out.println("Page 1: Welcome to the Console Application");
        System.out.println("Press Enter to go to Page 2...");
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
        clearConsole();
        showPageTwo();
    }

    public static void showPageTwo() {
        clearConsole();
        System.out.println("Page 2: This is the second page");
        System.out.println("Press Enter to go back to Page 1...");
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
        showPageOne();
    }

    public static void main(String[] args) {
        showPageOne(); // Start with Page 1
    }
}
