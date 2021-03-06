package datetime;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;

public class LocalDateTest {
    public static void main(String[] args) {
        LocalDate date = LocalDate.of(2018, Month.AUGUST,19);
        LocalDate nextWed = date.with(TemporalAdjusters.next(date.getDayOfWeek()));
        System.out.printf("the date is %s; the nextWed is %s%n", date,nextWed);
        System.out.printf("localDateTime is %s",LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
    }
}
