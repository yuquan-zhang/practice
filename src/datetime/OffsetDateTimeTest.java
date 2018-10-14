package datetime;

import java.time.*;
import java.time.temporal.TemporalAdjusters;

public class OffsetDateTimeTest {
    public static void main(String[] args) {
        LocalDateTime localDate = LocalDateTime.of(2017, Month.OCTOBER,20,19,30);
        ZoneOffset offset = ZoneOffset.of("-08:00");
        OffsetDateTime offsetDate = OffsetDateTime.of(localDate,offset);
        OffsetDateTime lastThursday =
                offsetDate.with(TemporalAdjusters.lastInMonth(DayOfWeek.THURSDAY));
            System.out.printf("The last Thursday in July 2017 is the %sth %n.",
                lastThursday.getDayOfMonth());
    }
}
