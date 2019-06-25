package base;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class AtomicDouble {
    public static void main(String[] args) {
        testAtomicInMap();
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
        ad.set(233.0);
    }

    @SuppressWarnings("unchecked")
    public static void testAtomicInMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("totalCount",new AtomicInteger(0));
        map.put("totalMoney",new AtomicReference<>(0.0));
        AtomicInteger totalCount = (AtomicInteger)map.get("totalCount");
        AtomicReference<Double> totalMoney = (AtomicReference<Double>)map.get("totalMoney");
        System.out.println("before");
        System.out.println("totalCount=" + totalCount.get());
        System.out.println("totalMoney=" + totalMoney.get());
        changeMap(map);
        System.out.println("after");
        System.out.println("totalCount=" + totalCount.get());
        System.out.println("totalMoney=" + totalMoney.get());
    }

    @SuppressWarnings("unchecked")
    public static void changeMap(Map<String, Object> map) {
        AtomicInteger totalCount = (AtomicInteger)map.get("totalCount");
        totalCount.incrementAndGet();
        AtomicReference<Double> totalMoney = (AtomicReference<Double>)map.get("totalMoney");
        totalMoney.set(33.0);
    }
}
