package external_Functions;

public class CurrentDate {
    MyDate date = new MyDate("01/01/1970");
    private int hours, minutes, seconds;

    public CurrentDate() {
        long millisecondsSinceEpoch = System.currentTimeMillis();

        long millisecondsPerSecond = 1000;
        long secondsPerMinute = 60;
        long minutesPerHour = 60;
        long hoursPerDay = 24;
        long millisecondsPerDay = millisecondsPerSecond * secondsPerMinute * minutesPerHour * hoursPerDay;

        long totalDays = millisecondsSinceEpoch / millisecondsPerDay;
        long millisecondsOfDay = millisecondsSinceEpoch % millisecondsPerDay;

        int epochYear = 1970;
        int year = epochYear;
        while (totalDays >= daysInYear(year)) {
            totalDays -= daysInYear(year);
            year++;
        }

        int month = 1;
        int[] daysInMonth = { 31, isLeapYear(year) ? 29 : 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        while (totalDays >= daysInMonth[month - 1]) {
            totalDays -= daysInMonth[month - 1];
            month++;
        }

        int day = (int) totalDays + 1;

        date.setDay(day);
        date.setMonth(month);
        date.setYear(year);

        int utcHours = (int) (millisecondsOfDay / (millisecondsPerSecond * secondsPerMinute * minutesPerHour));
        millisecondsOfDay %= (millisecondsPerSecond * secondsPerMinute * minutesPerHour);

        int utcMinutes = (int) (millisecondsOfDay / (millisecondsPerSecond * secondsPerMinute));
        millisecondsOfDay %= (millisecondsPerSecond * secondsPerMinute);

        int utcSeconds = (int) (millisecondsOfDay / millisecondsPerSecond);

        hours = utcHours + 6;
        if (hours >= 24) {
            hours -= 24;
            incrementDate();
        }

        minutes = utcMinutes;
        seconds = utcSeconds;
    }

    private void incrementDate() {
        int[] daysInMonth = { 31, isLeapYear(date.getYear()) ? 29 : 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        date.setDay(date.getDay() + 1);
        if (date.getDay() > daysInMonth[date.getMonth() - 1]) {
            date.setDay(1);
            date.setMonth(date.getMonth() + 1);
            if (date.getMonth() > 12) {
                date.setMonth(1);
                date.setYear(date.getYear() + 1);
            }
        }
    }

    public void getDateTime() {
        System.out.println("Date (BDT): " + date.toString());
        System.out.printf("Time (BDT): %02d:%02d:%02d%n", hours, minutes, seconds);
    }

    public String getTimeAsString() {
        return String.format("%02d:%02d:%02d", hours, minutes, seconds);
    }

    public String getDateAsString() {
        return date.toString();
    }

    public static void main(String[] args) {
        CurrentDate currentDateTime = new CurrentDate();
        currentDateTime.getDateTime();
        MyDate date = new MyDate("28/11/2024");
        System.out.println(currentDateTime.isCurrentDate(date));
        System.out.println("Checking with current date: " + currentDateTime.date.toString());
    }

    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    public static int daysInYear(int year) {
        return isLeapYear(year) ? 366 : 365;
    }

    public boolean isCurrentDate(MyDate date) {
        if (this.date.getYear() == date.getYear() && this.date.getMonth() == date.getMonth() && this.date.getDay() == date.getDay()) {
            return true;
        }
        return false;
    }
}
