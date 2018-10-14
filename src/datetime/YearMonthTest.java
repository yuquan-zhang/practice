package datetime;

import java.time.Month;
import java.time.MonthDay;
import java.time.Year;
import java.time.YearMonth;

public class YearMonthTest {
    public static void main(String[] args) {
        YearMonth date = YearMonth.now();
        System.out.printf("%s: %d%n", date, date.lengthOfMonth());
        YearMonth date2 = YearMonth.of(2018,Month.FEBRUARY);
        System.out.printf("%s: %d%n", date2, date2.lengthOfMonth());

        MonthDay day = MonthDay.of(Month.FEBRUARY, 29);
        boolean validLeapYear = day.isValidYear(2018);
        System.out.printf("the month day is %s, 33 is a valid day? %s, 2018 is valid leap year? %s%n",
                day, date.isValidDay(33), validLeapYear);
        System.out.printf("2012 is a leap year? %s%n", Year.of(2012).isLeap());
    }
}
