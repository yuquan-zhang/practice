package datetime;

import java.time.*;
import java.time.temporal.ChronoUnit;

public class InstantTest {
    public static void main(String[] args) {
        Instant timestamp = Instant.now();
        System.out.printf("the timestamp is %s%n", timestamp);
        System.out.printf("one hour later is %s%n", timestamp.plus(1,ChronoUnit.HOURS));
        System.out.printf("Seconds from Epoch is %s%n",
                Instant.ofEpochSecond(0L).until(timestamp, ChronoUnit.SECONDS));
        LocalDateTime ldt = LocalDateTime.ofInstant(timestamp, ZoneId.systemDefault());
        System.out.printf("%s %d %d at %d:%d%n", ldt.getMonth(), ldt.getDayOfMonth(),
                ldt.getYear(), ldt.getHour(), ldt.getMinute());
        System.out.printf("The offset is %s%n",ZoneOffset.systemDefault());
        System.out.printf("The offset time is %s%n",
                OffsetTime.ofInstant(timestamp,ZoneOffset.systemDefault()));
    }
}
