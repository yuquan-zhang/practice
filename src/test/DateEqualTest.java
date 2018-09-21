package test;

import java.util.Date;

public class DateEqualTest {
    public static void main(String[] args) throws InterruptedException {
        Date date1 = new Date();
        Date date2 = date1;
        Thread.sleep(100);
        Date date3 = new Date();
        Date date4 = new Date(date1.getTime());
        System.out.println(date1.equals(date2));
        System.out.println(date1.equals(date3));
        System.out.println(date1.equals(date4));
    }
}
