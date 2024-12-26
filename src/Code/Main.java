package Code;
import UI.ConsoleUtils;
import UI.HomePage;

public class Main {
    public static void main(String[] args) {
        ConsoleUtils consoleUtils = new ConsoleUtils();
        consoleUtils.clearScreen();
        HomePage.main(args);
    }
}