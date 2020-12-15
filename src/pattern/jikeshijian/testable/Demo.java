package pattern.jikeshijian.testable;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

/**
 * @author zhangyong created on 2020/12/14
 **/
public class Demo {
    public long calculateDelayDays(Date dueTime) {
        long currentTimestamp = System.currentTimeMillis();
        if (dueTime.getTime() >= currentTimestamp) {
            return 0;
        }
        long delayTime = currentTimestamp - dueTime.getTime();
        long delayDays = delayTime / 86400000;
        return delayDays;
    }
}

class DemoTest {

    public void testCalculateDelayDays() {
        Demo demo = new Demo();
        LocalDate localDate = LocalDate.now();
        long ans = demo.calculateDelayDays(fromLocalDate(localDate));
        System.out.println("ans == 0 --> " + (ans == 0));
        ans = demo.calculateDelayDays(fromLocalDate(localDate.plusDays(3)));
        System.out.println("ans == 0 --> " + (ans == 0));
        ans = demo.calculateDelayDays(fromLocalDate(localDate.minusDays(3)));
        System.out.println("ans == 3 --> " + (ans == 3));
    }

    private Date fromLocalDate(LocalDate localDate) {
        return Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
    }

    public static void main(String[] args) {
        DemoTest dt = new DemoTest();
        dt.testCalculateDelayDays();
    }
}
