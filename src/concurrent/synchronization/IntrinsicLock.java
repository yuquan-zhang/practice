package concurrent.synchronization;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author zhangyong created on 2019/9/26
 **/
public class IntrinsicLock {

    private int c1;

    private int c2;

    private final Object lock1 = new Object();
    private final ReentrantLock lock2 = new ReentrantLock();

    public void incC1() {
        synchronized (lock1) {
            c1++;
        }
    }

    public void incC2() {
        synchronized (lock2) {
            c2++;
        }
    }
}
