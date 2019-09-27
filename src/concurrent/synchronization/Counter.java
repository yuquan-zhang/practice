package concurrent.synchronization;

/**
 * @author zhangyong created on 2019/9/26
 **/
public class Counter {

    private int count = 0;

    public void increment() {
        count++;
    }

    public void decrement() {
        count--;
    }

    public int value() {
        return count;
    }

    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();
        while (counter.value() == 0) {
            Thread inc = new Thread(() -> counter.increment());
            Thread dec = new Thread(() -> counter.decrement());
            inc.start();
            dec.start();
            inc.join();
            dec.join();
        }
        System.out.println(counter.value());
    }
}
