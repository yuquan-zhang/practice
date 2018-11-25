package base;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.concurrent.atomic.AtomicReference;

public class AtomicDouble {
    public static void main(String[] args) {
        AtomicReference<Double> ad = new AtomicReference<>(0.0);
        System.out.println(ad.get());
        addDouble(ad);
        System.out.println(ad.get());
        BigDecimal bd = new BigDecimal(10.0);
        System.out.println(10.0/3);
        System.out.println(bd.divide(new BigDecimal(3),new MathContext(2,RoundingMode.HALF_EVEN)));
        System.out.println(new BigDecimal(1.22334354666534334343434).setScale(2,RoundingMode.HALF_EVEN).doubleValue());
    }

    public static void addDouble(AtomicReference<Double> ad) {
        ad.accumulateAndGet(2.0,(a, x) -> a + x);
    }
}
