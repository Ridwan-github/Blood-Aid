package UI;

public class ConsoleBarChart {
    private static final int MAX_BAR_HEIGHT = 8;
    private static final char BAR_CHAR = '█';
    private static final char AXIS_CHAR = '─';
    private static final char VERTICAL_CHAR = '│';

    public static void drawBarChart(String title, String[] labels, int[] values) {
        if (labels == null || values == null || labels.length != values.length || labels.length == 0) {
            return;
        }

        int maxValue = 0;
        for (int value : values) {
            maxValue = Math.max(maxValue, value);
        }

        double scale = maxValue > (MAX_BAR_HEIGHT * 5) ? (double) (MAX_BAR_HEIGHT * 5) / maxValue : 5;

        System.out.println("\n" + title);

        for (int i = MAX_BAR_HEIGHT; i > 0; i--) {
            System.out.printf("%3d %c ", i * 5, VERTICAL_CHAR);
            for (int value : values) {
                int scaledValue = (int)(value / scale);
                System.out.print(scaledValue >= i ? BAR_CHAR + "   " : "    ");
            }
            System.out.println();
        }

        System.out.print("    " + VERTICAL_CHAR);
        for (int i = 0; i < labels.length * 4; i++) {
            System.out.print(AXIS_CHAR);
        }
        System.out.println();

        System.out.print("    ");
        for (String label : labels) {
            System.out.printf("%-4s", label);
        }
        System.out.println();

        System.out.print("    ");
        for (int value : values) {
            System.out.printf("%-4d", value);
        }
        System.out.println();
    }
}