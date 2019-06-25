package datetime;

import java.util.Calendar;
import java.util.Date;

public class CalendarTest {
    public static void main(String[] args) {
        Calendar c = Calendar.getInstance();
        System.out.println(c.getTime());
        Calendar c2 = Calendar.getInstance();
        c2.set(2018,Calendar.FEBRUARY,1);
        System.out.println(calcMonthDifference(201812,201912));
        System.out.println(addMonth(201809,-21));
        System.out.println(minusMonth(201809,-9));

    }

    public static long calcMonthDifference(long startMonth,long endMonth) {
        return 12 * (endMonth / 100 - startMonth / 100) + (endMonth % 100 - startMonth % 100);
    }

    public static long addMonth(long month, long n) {
        long m = month % 100;
        long s = m + n;
        long e = s % 12;
        boolean isZero = e == 0;
        return (month - m) + (s / 12 - (isZero ? 1 : 0)) * 100 + (isZero ? 12 : e);
    }

    public static long minusMonth(long month, long n) {
        long m = month % 100;
        long s = m - n;
        int i = 0;
        while(s <= 0) {
            s += 12;
            i++;
        }
        while(s > 12) {
            s -= 12;
            i--;
        }
        return (month - m) - i * 100 + s;
    }
}
