package Code;
import UI.ConsoleUtils;
import UI.Home;

public class Main {
    public static void main(String[] args) {
        ConsoleUtils consoleUtils = new ConsoleUtils();
        consoleUtils.clearScreen();
        Home.main(args);
    }
}