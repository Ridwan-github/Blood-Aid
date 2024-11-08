package external_Functions;

public class MyDate {
    private int day;
    private int month;
    private int year;

    public MyDate(String date) {
        String[] dateParts = date.split("/");
        this.day = Integer.parseInt(dateParts[0]);
        this.month = Integer.parseInt(dateParts[1]);
        this.year = Integer.parseInt(dateParts[2]);
    }

    public MyDate(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String toString() {
        return day + "/" + month + "/" + year;
    }

    public boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    public boolean isValidDate(){
        if(month < 1 || month > 12){
            return false;
        }
        if(day < 1 || day > 31){
            return false;
        }
        if(month == 2){
            if(isLeapYear(year)){
                if(day > 29){
                    return false;
                }
            }
            else{
                if(day > 28){
                    return false;
                }
            }
        }
        if(month == 4 || month == 6 || month == 9 || month == 11){
            if(day > 30){
                return false;
            }
        }
        return true;
    }

    public boolean isNull(){
        return day == 0 && month == 0 && year == 0;
    }

    public static void main(String[] args) {
        MyDate date = new MyDate("29/02/2020");
        System.out.println(date.isValidDate());

    }
}
