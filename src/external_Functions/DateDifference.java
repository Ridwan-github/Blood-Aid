package external_Functions;

public class DateDifference {
    MyDate date1;
    MyDate date2;
    CurrentDate date3 = new CurrentDate();

    public DateDifference(MyDate date1, MyDate date2){
        this.date1 = date1;
        this.date2 = date2;
    }

    public DateDifference(MyDate date1){
        this.date1 = date1;
        this.date2 = date3.date;
    }

    public int getDifference(){

        int difference = 0;
        if (date1.getMonth() < 1 || date1.getMonth() > 12 || date2.getMonth() < 1 || date2.getMonth() > 12) {
            return -1;
        }
        int daysInMonth[] = {31, date1.isLeapYear(date1.getYear()) ? 29 : 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        if(date1.getYear() == date2.getYear()){
            if(date1.getMonth() == date2.getMonth()){
                difference = date2.getDay() - date1.getDay();
            }
            else{
                difference = daysInMonth[date1.getMonth() - 1] - date1.getDay();
                for(int i = date1.getMonth(); i < date2.getMonth() - 1; i++){
                    difference += daysInMonth[i];
                }
                difference += date2.getDay();
            }
        }
        else{
            difference = daysInMonth[date1.getMonth() - 1] - date1.getDay();
            for(int i = date1.getMonth(); i < 12; i++){
                difference += daysInMonth[i];
            }
            for(int i = date1.getYear() + 1; i < date2.getYear(); i++){
                difference += date1.isLeapYear(i) ? 366 : 365;
            }
            for(int i = 0; i < date2.getMonth() - 1; i++){
                difference += daysInMonth[i];
            }
            difference += date2.getDay();
        }

        return difference;
    }

    public boolean isFutureDate(){
        if(date1.getYear() > date2.getYear()){
            return true;
        }
        else if(date1.getYear() == date2.getYear()){
            if(date1.getMonth() > date2.getMonth()){
                return true;
            }
            else if(date1.getMonth() == date2.getMonth()){
                if(date1.getDay() > date2.getDay()){
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        MyDate date1 = new MyDate("0/0/0");
        MyDate date2 = new MyDate("01/01/2021");
        DateDifference dateDifference = new DateDifference(date1);
        System.out.println(dateDifference.getDifference());
    }
}
