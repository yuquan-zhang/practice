package concurrent.synchronization;

/**
 * @author zhangyong created on 2019/9/26
 **/
public class SynchronizedCounter {

    private int count = 0;

    public synchronized void increment() {
        count++;
    }

    public synchronized void decrement() {
        count--;
    }

    public synchronized int value() {
        return count;
    }

    public static void main(String[] args) throws InterruptedException {
        SynchronizedCounter counter = new SynchronizedCounter();
        while (counter.value() == 0) {
            Thread inc = new Thread(() -> counter.increment());
            Thread dec = new Thread(() -> counter.decrement());
            inc.start();
            dec.start();
            inc.join();
            dec.join();
        }
        // 永远到不了这里
        System.out.println(counter.value());
    }
}
