package external_Functions;

public class CurrentDate{
    MyDate date = new MyDate("01/01/1970");

    public CurrentDate(){
        long millisecondsSinceEpoch = System.currentTimeMillis();

        long millisecondsPerSecond = 1000;
        long secondsPerMinute = 60;
        long minutesPerHour = 60;
        long hoursPerDay = 24;
        long daysPerYear = 365;
        long daysPerLeapYear = 366;
        int epochYear = 1970;

        long millisecondsPerDay = millisecondsPerSecond * secondsPerMinute * minutesPerHour * hoursPerDay;

        long totalDays = millisecondsSinceEpoch / millisecondsPerDay;

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
    }

    public void getDate(){
        System.out.println(date.toString());
    }

    public String getDateAsString(){
        return date.toString();
    }

    public static void main(String[] args) {
        CurrentDate currentDate = new CurrentDate();
        System.out.println(currentDate.date.toString());
    }

    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    public static int daysInYear(int year) {
        return isLeapYear(year) ? 366 : 365;
    }

}
