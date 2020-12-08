package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhangyong created on 2020/6/11
 **/
public class ClaimStairs {

    private static final Map<String, Long> cache = new HashMap<>();

    private static void claim3WithoutContinue() {
        System.out.println(claim3WithoutContinue(1));
        System.out.println(claim3WithoutContinue(4));
        System.out.println(claim3WithoutContinue(5));
        System.out.println(claim3WithoutContinue(6));
        System.out.println(claim3WithoutContinue(7));
        System.out.println(claim3WithoutContinue(10));
        System.out.println(claim3WithoutContinue(900));
    }

    private static long claim3WithoutContinue(long l) {
        return claim3WithoutContinue(l, 0);
    }

    private static long claim3WithoutContinue(long l, int step) {
        String key = l + "=" + step;
        if (cache.get(key) != null) return cache.get(key);
        long rs = 0;
        if (l < 0) rs =  0;
        else if (l == 0) rs =  1;
        else if (step == 0) rs =  claim3WithoutContinue(l - 1, 1) + claim3WithoutContinue(l - 2,2) +
                claim3WithoutContinue(l - 3,3);
        else if (step == 1) rs =  claim3WithoutContinue(l - 2,2) + claim3WithoutContinue(l - 3,3);
        else if (step == 2) rs = claim3WithoutContinue(l - 1,1) + claim3WithoutContinue(l - 3,3);
        else if (step == 3) rs = claim3WithoutContinue(l - 1,1) + claim3WithoutContinue(l - 2,2);
        cache.put(key,rs);
        return rs;
    }

    public static void main(String[] args) {
        claim3WithoutContinue();
    }
}
