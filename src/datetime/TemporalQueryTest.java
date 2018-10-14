package datetime;

import java.time.*;
import java.time.temporal.TemporalQueries;
import java.time.temporal.TemporalQuery;

public class TemporalQueryTest {
    public static void main(String[] args) {
        TemporalQuery query = TemporalQueries.precision();
        System.out.printf("LocalDate precision is %s%n",
                LocalDate.now().query(query));
        System.out.printf("LocalDateTime precision is %s%n",
                LocalDateTime.now().query(query));
        System.out.printf("Year precision is %s%n",
                Year.now().query(query));
        System.out.printf("YearMonth precision is %s%n",
                YearMonth.now().query(query));
        System.out.printf("Instant precision is %s%n",
                Instant.now().query(query));
    }
}
