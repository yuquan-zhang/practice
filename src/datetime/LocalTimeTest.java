package datetime;

import java.time.*;

public class LocalTimeTest {
    public static void main(String[] args) {
        LocalTime time = LocalTime.now();
        System.out.printf("the time for now is %d hours %d minutes %d seconds %d nanoseconds%n",
                time.getHour(), time.getMinute(), time.getSecond(), time.getNano());
        System.out.printf("now: %s%n", LocalDateTime.now());
        System.out.printf("October 08 2018 @ 13:57pm: %s%n",
                LocalDateTime.of(2018, Month.OCTOBER,8,13,57));
        System.out.printf("now (from Instant) : %s%n",
                LocalDateTime.ofInstant(Instant.now(),ZoneId.systemDefault()));
        System.out.printf("6 months from now: %s%n",LocalDateTime.now().plusMonths(6));
        System.out.printf("6 months ago: %s%n", LocalDateTime.now().minusMonths(6));
    }
}
