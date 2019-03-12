package interviews.google;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class Feibonacci {

    // 递归 最次的 时间复杂度O(2^n) 空间复杂度O(1) 做了很多重复的事情，随着n的增加，所需时间成指数级增长，当n大于100，一般电脑就几乎无法完成计算。
    public static long feibonacci1(int n) {
        if(n < 1) return 0;
        if(n == 1 || n == 2) return n - 1;
        return feibonacci1(n - 1) + feibonacci1(n - 2);
    }

    // 递归加缓存 第五名 时间复杂度O(n) 空间复杂度O(n) 随着n的增大，递归越来越深，最终产生栈空间溢出；多使用了缓存，所以比第四名差一点。
    public static long feibonacci2(int n, Map<Integer, Long> map) {
        Long r;
        if(n < 1) return   0;
        if(n == 1 || n == 2) return   n - 1;
        r = map.get(n);
        if(r == null) r = feibonacci2(n - 1, map) + feibonacci2(n - 2, map);
        map.putIfAbsent(n,r);
        return r;
    }

    // 尾递归加biginteger 第四名 时间复杂度O(n) 空间复杂度O(1) 随着n的增大，递归越来越深，最终产生栈空间溢出。
    public static BigInteger feibonacci3(BigInteger first, BigInteger second, int n) {
        if(n < 1) return null;
        if(n == 1 || n == 2) return new BigInteger("" + (n - 1));
        if(n == 3) return first.add(second);
        return feibonacci3(second,first.add(second),n - 1);
    }

    // for循环加biginteger 最好的 时间复杂度O(n) 空间复杂度O(1);
    public static BigInteger feibonacci6(int n) {
        if(n < 1) return null;
        if(n < 3) return new BigInteger("" + (n - 1));
        BigInteger first = new BigInteger("0");
        BigInteger second = new BigInteger("1");
        BigInteger result = first.add(second);
        for(int i = 4; i <= n; i++) {
            first = second;
            second = result;
            result = first.add(second);
        }
        return result;
    }

    // for循环加缓存加biginteger 第三名 时间复杂度O(n) 空间复杂度O(n) 因为不清理缓存，随着n的增大，最终产生堆空间溢出。
    public static BigInteger feibonacci4(int n) {
        if(n < 1) return null;
        Map<Integer,BigInteger> map = new HashMap<>();
        for(int i = 1; i <= n; i++) {
            if(i == 1 || i == 2) map.putIfAbsent(i, new BigInteger("" + (i - 1)));
            else{
                map.putIfAbsent(i,map.get(i-1).add(map.get(i-2)));
            }
        }
        return map.get(n);
    }

    // for循环加缓存加biginteger 加缓存清理。第二名 时间复杂度O(n) 空间复杂度O(1), 因为有缓存的插入和移除操作，所以比第一名差一些。
    public static BigInteger feibonacci5(int n) {
        if(n < 1) return null;
        Map<Integer,BigInteger> map = new HashMap<>();
        for(int i = 1; i <= n; i++) {
            if(i == 1 || i == 2) map.putIfAbsent(i, new BigInteger("" + (i - 1)));
            else{
                map.putIfAbsent(i,map.get(i-1).add(map.get(i-2)));
                map.remove(i - 3);
            }
        }
        return map.get(n);
    }

    public static void main(String[] args) {
        long start = System.nanoTime();
        System.out.println(feibonacci1(9));
        System.out.println(System.nanoTime() - start);
        start = System.nanoTime();
        System.out.println(feibonacci2(10,new HashMap<>()));
        System.out.println(System.nanoTime() - start);
        start = System.nanoTime();
        System.out.println(feibonacci3(new BigInteger("0"),new BigInteger("1"),100));
        System.out.println(System.nanoTime() - start);
        start = System.nanoTime();
        System.out.println(feibonacci4(100000));
        System.out.println(System.nanoTime() - start);
        start = System.nanoTime();
        System.out.println(feibonacci5(1000000));
        System.out.println(System.nanoTime() - start);
        start = System.nanoTime();
        System.out.println(feibonacci6(1000000));
        System.out.println(System.nanoTime() - start);
    }
}
