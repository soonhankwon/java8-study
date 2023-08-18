package soon.java8study.date_and_time;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateTimeApp {

    public static void main(String[] args) {
        Instant instant = Instant.now();
        System.out.println(instant); // 기준시 UTC, GMT

        ZonedDateTime zonedDateTime = instant.atZone(ZoneId.systemDefault());
        System.out.println(zonedDateTime);
        System.out.println("=====================================");

        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);

        LocalDateTime birthDay = LocalDateTime.of(1988, Month.JANUARY, 2, 7, 7);
        ZonedDateTime nowInKorea = ZonedDateTime.now(ZoneId.of("Asia/Seoul"));
        System.out.println(birthDay);
        System.out.println(nowInKorea);
        System.out.println(Instant.now().atZone(ZoneId.of("Asia/Seoul")));
        System.out.println("=====================================");

        LocalDate today = LocalDate.now();
        LocalDate christMas = LocalDate.of(2023, Month.DECEMBER, 24);
        Period period = Period.between(today, christMas);
        System.out.println(period.get(ChronoUnit.DAYS));
        System.out.println(ChronoUnit.DAYS.between(today, christMas));

        Period until = today.until(christMas);
        System.out.println(until.getDays());

        Instant now1 = Instant.now();
        Instant plus = now1.plus(10, ChronoUnit.SECONDS);
        Duration between = Duration.between(now1, plus);
        System.out.println(between.getSeconds());

        System.out.println("=====================================");
        LocalDateTime now2 = LocalDateTime.now();
        DateTimeFormatter mmDDyyyy = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        System.out.println(now2.format(mmDDyyyy));
        System.out.println(now2.format(DateTimeFormatter.ISO_LOCAL_DATE));

        LocalDate parse = LocalDate.parse("01/02/1988", mmDDyyyy);
        System.out.println(parse);

        System.out.println("=====================================");
        Date date = new Date();
        Instant instant1 = date.toInstant();
        Date newDate = Date.from(instant1);


        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        LocalDateTime dateTime = gregorianCalendar.toInstant().atZone(ZoneId.systemDefault())
                .toLocalDateTime();
    }
}
