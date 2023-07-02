package MyHello.JavaExperiment;
import java.util.Calendar;
import java.util.GregorianCalendar;
public class Experiment1 {
    public static void main(String[] args) {
        GregorianCalendar calendar = new GregorianCalendar();
        System.out.println(calendar.get(Calendar.YEAR) +
                "年" + (calendar.get(Calendar.MONTH) + 1) + "月" +
                calendar.get(Calendar.DATE) + "日");

        calendar.setTimeInMillis(1234567898765L);
        System.out.println(calendar.get(Calendar.YEAR) +
                "年" + (calendar.get(Calendar.MONTH) + 1) + "月" +
                calendar.get(Calendar.DAY_OF_MONTH) + "日");
    }
}

