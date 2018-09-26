package agreement;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.LongAdder;

public class TimerUtils {

    ScheduledExecutorService scheduledExecutorService = null;

    CountDownLatch countDownLatch = null;

    ThreadLocalRandom random = ThreadLocalRandom.current();

    public static void main(String[] args) {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        System.out.println(random.nextInt(10));

        LongAdder longAdder = new LongAdder();
        longAdder.add(10L);
        System.out.println(longAdder.intValue());
    }

}
