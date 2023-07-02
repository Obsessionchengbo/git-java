package MyHello.JavaExperiment;
import java.util.GregorianCalendar;
public class Experiment3 {
    public static void main(String[] args) {
        MyDate date0 = new MyDate();
        MyDate date1 = new MyDate(34355555133101L);
        System.out.println(date0.year + "年" + (date0.month + 1) + "月" + date0.day + "日");
        System.out.println(date1.year + "年" + (date1.month + 1) + "月" + date1.day + "日");
    }
}


class MyDate {
    int year, month, day;

    public MyDate(){
        GregorianCalendar gc = new GregorianCalendar();
        year = gc.get(GregorianCalendar.YEAR);
        month = gc.get(GregorianCalendar.MONTH);
        day = gc.get(GregorianCalendar.DAY_OF_MONTH);
    }

    public MyDate(long l){
        GregorianCalendar gc = new GregorianCalendar();
        gc.setTimeInMillis(l);
        year = gc.get(GregorianCalendar.YEAR);
        month = gc.get(GregorianCalendar.MONTH);
        day = gc.get(GregorianCalendar.DAY_OF_MONTH);
    }
    public MyDate(int year, int month, int day){
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public void setDate(long elapsedTime){
        GregorianCalendar gc = new GregorianCalendar();
        gc.setTimeInMillis(elapsedTime + toCalender(year, month, day));
        year = gc.get(GregorianCalendar.YEAR);
        month = gc.get(GregorianCalendar.MONTH);
        day = gc.get(GregorianCalendar.DAY_OF_MONTH);
    }
    public long toCalender(int year, int month, int day){
        day += year * 365;
        switch (month){
            case 11: day += 31;
            case 10: day += 30;
            case 9: day += 31;
            case 8: day += 30;
            case 7: day += 31;
            case 6: day += 31;
            case 5: day += 30;
            case 4: day += 31;
            case 3: day += 30;
            case 2: day += 31;
            case 1: day += 28;
        }
        return (long) day * 24 * 60 * 60 * 1000;
    }
}
