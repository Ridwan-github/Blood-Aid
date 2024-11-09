package UI;

public class ConsoleUtils {

    public static void clearScreen() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception e) {
            System.out.println("Error clearing the console.");
        }
    }

    public static void main(String[] args) {
        System.out.println("Welcome to Page 1");
        System.out.println("Press Enter to go to the next page...");
        try {
            System.in.read();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Clear the screen and display Page 2 content
        clearScreen();
        System.out.println("Welcome to Page 2");
    }
}
