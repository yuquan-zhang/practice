package timer;

import java.util.Date;
import java.util.Timer;
import java.util.concurrent.atomic.AtomicLong;

public class TimerUtil {
    private static Timer timer;
    private static AtomicLong count = new AtomicLong(0);
    public static final long second = 1000;
    public static final long minute = 60*second;
    public static final long hour = 60*minute;
    public static final long day = 24 * hour;
    public static final long week = 7*day;
    public static final long month = 30*day;
    public static final long year = 365*day;

    public static Timer getTimer() {
        synchronized (TimerUtil.class) {
            if(null == timer) {
                timer = new Timer("自动审批定时器");
            }
            return timer;
        }
    }

    public static void schedule(TimerTask task, long delay) {
        getTimer().schedule(task,delay);
        System.out.printf("count is : %d%n",count.incrementAndGet());
    }

    public static void schedule(TimerTask task, Date time) {
        getTimer().schedule(task, time);
    }

    public static void schedule(TimerTask task, long delay, long period) {
        getTimer().schedule(task, delay, period);
    }

    public static void schedule(TimerTask task, Date firstTime, long period) {
        getTimer().schedule(task, firstTime, period);
    }

    public static void scheduleAtFixedRate(TimerTask task, long delay, long period) {
        getTimer().scheduleAtFixedRate(task, delay, period);
    }

    public static void scheduleAtFixedRate(TimerTask task, Date firstTime, long period) {
        getTimer().scheduleAtFixedRate(task, firstTime, period);
    }

    public static void minus(){
        System.out.printf("count is : %d%n",count.decrementAndGet());
    }

    public static boolean isEmpty() {
        return count.get() <= 0;
    }

    public static void cancel() {
        getTimer().cancel();
        System.out.println(getTimer());
        timer = null;
    }

    public abstract static class TimerTask extends java.util.TimerTask {

        public abstract void execute();

        @Override
        public void run() {
            execute();
            TimerUtil.minus();
            if(TimerUtil.isEmpty()) TimerUtil.cancel();
        }
    }
}
