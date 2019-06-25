package test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListVsMap {
    public static void main(String[] args) {
        List<Long> longList = new ArrayList<>(1000);
        for (long i = 1000; i < 1100; ++i) {
            longList.add(i);
        }
        Map<String, Long> longMap = new HashMap<>(longList.size());
        for (Long l : longList) {
            longMap.put("" + l, l);
        }
        long now = System.nanoTime();
        findOne(1055,longList);
        System.out.println(System.nanoTime() - now);
        now = System.nanoTime();
        longMap.get("" + 1055);
        System.out.println(System.nanoTime() - now);
        longMap.put(null + "_" + "中国",10938484L);
        System.out.println(longMap.get("null_中国"));
    }

    private static Long findOne(long target, List<Long> longList) {
        for (Long l : longList) {
            if (l.equals(target)) return l;
        }
        return null;
    }
}
