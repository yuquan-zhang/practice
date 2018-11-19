package base;

import java.util.concurrent.atomic.AtomicLong;

public class LongWrapper {
    public static void main(String[] args) {
        AtomicLong atomicLong = new AtomicLong();
        System.out.println(atomicLong.get());
        addLong(atomicLong);
        addLong(atomicLong);
        System.out.println(atomicLong.get());
    }

    public static void addLong(AtomicLong total) {
        total.incrementAndGet();
    }
}
