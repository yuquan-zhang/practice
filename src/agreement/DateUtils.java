package agreement;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class DateUtils {
    public static final ThreadLocal<DateFormat> df =
            ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyy-MM-dd"));
    public static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public static void main(String[] args) {
        String date = df.get().format(new Date());
        System.out.println(date);
        System.out.println(Instant.now());
        System.out.println(dtf.format(LocalDate.now()));
        LocalDate.parse("1991-09-05",dtf);
    }
}
