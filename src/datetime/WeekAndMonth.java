package datetime;

import java.io.Console;
import java.time.DayOfWeek;
import java.time.Month;
import java.time.format.TextStyle;
import java.util.Locale;

public class WeekAndMonth {
    public static void main(String[] args) {
        System.out.printf("%s%n", DayOfWeek.MONDAY.plus(3));
        DayOfWeek dow = DayOfWeek.MONDAY;
        Locale locale = Locale.getDefault();
        System.out.println(dow.getDisplayName(TextStyle.FULL,locale));
        System.out.println(dow.getDisplayName(TextStyle.NARROW,locale));
        System.out.println(dow.getDisplayName(TextStyle.SHORT,locale));

        System.out.printf("%d%n", Month.FEBRUARY.maxLength());
        Month month = Month.AUGUST;
        System.out.println(month.getDisplayName(TextStyle.FULL, locale));
        System.out.println(month.getDisplayName(TextStyle.NARROW, locale));
        System.out.println(month.getDisplayName(TextStyle.SHORT, locale));
    }
}
