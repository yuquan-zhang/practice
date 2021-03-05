package base;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author zhangyong created on 2020/3/26
 **/
public class DateUtil {

    public static void main(String[] args) {
        long day = 24 * 60 * 60 * 1000;

        System.out.println((int) (day * 3 - 1)/day);
        fmt(new Date());
        System.out.println(Long.parseLong("000123"));
    }

    public static void fmt(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(sdf.format(date));
    }
}
