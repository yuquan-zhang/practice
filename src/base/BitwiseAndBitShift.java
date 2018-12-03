package base;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import static java.util.Calendar.MAY;

public class BitwiseAndBitShift {
    public static void main(String[] args) {

        int a = 3, b = -3;
        System.out.printf("binary string of 3 is %44s%n",Integer.toBinaryString(a));
        System.out.printf("binary string of 3 is %44s%n",Integer.toBinaryString(b));
        System.out.printf("3 bitwise and -3 equals %42s%n",Integer.toBinaryString(a & b));
        System.out.printf("3 bitwise exclusive OR -3 equals %33s%n",Integer.toBinaryString(a ^ b));
        System.out.printf("3 bitwise inclusive OR -3 equals %33s%n",Integer.toBinaryString(a | b));

        System.out.printf("%4$2s %3$2s %2$2s %1$2s%n","a","b","c","d");
        System.out.printf("e = %+8.3f%n", Math.E);
        System.out.printf("e = $%(,.2f%n", -Math.E*1000);
        Calendar c = new GregorianCalendar(1995, MAY, 23);
        Date d = new Date();
        String s = String.format("Duke's Birthday: %1$tm %1$te,%1$tY", d);
        System.out.println(s);
        System.out.printf("%4$s %3$s %2$s %1$s %4$s %3$s %2$s %1$s%n",
                "a", "b", "c", "d");
        System.out.printf("%2$s %s %<s %s", "a", "b", "c", "d");
    }
}
