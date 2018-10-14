package datetime;

import java.time.LocalDateTime;
import java.time.chrono.MinguoDate;

public class NonISODateTest {
    public static void main(String[] args) {
        MinguoDate minguoDate = MinguoDate.from(LocalDateTime.now());
        System.out.printf("min guo date for now is %s%n", minguoDate);
    }
}
