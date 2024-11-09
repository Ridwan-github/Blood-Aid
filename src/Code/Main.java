package Code;
import UI.ConsoleUtils;
import UI.Login_UI;

public class Main {
    public static void main(String[] args) {
        ConsoleUtils consoleUtils = new ConsoleUtils();
        consoleUtils.clearScreen();
        Login_UI.main(args);
    }
}