package soon.java8study.date_and_time;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class App {

    // Before Java 8 Problems
    public static void main(String[] args) throws InterruptedException {
        Date date = new Date(); // Weired Class name
        long time = date.getTime(); // EPOCK Time

        System.out.println(date);
        System.out.println(time);

        Thread.sleep(1000 * 3);
        Date after3Sec = new Date();
        System.out.println(after3Sec.getTime());
        after3Sec.setTime(time); // Mutable
        System.out.println(after3Sec.getTime());

        // no type safety
        Calendar myBirthDay = new GregorianCalendar(1988, -1, 2);
        System.out.println(myBirthDay.getTime());

    }
}
