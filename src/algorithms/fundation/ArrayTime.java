package algorithms.fundation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

interface Task<T> {
    T execute(T t1, T t2);
}

public class ArrayTime {
    public static void main(String[] args) {
        List<Integer> a = new ArrayList<>(10000);
        for(int i = 0; i < 10000; i++) {
            a.add(i * i);
        }
        Integer sum = 0;
        long start1 = System.nanoTime();
        for(int j = 0; j < a.size(); j++) {
            sum += a.get(j);
        }
        System.out.printf("the time of get %s for loop: %d%n", sum, System.nanoTime() - start1);
        long start2 = System.nanoTime();
        sum = a.stream().reduce((x, b) -> x + b).get();
        System.out.printf("the time of get %s for loop: %d%n", sum, System.nanoTime() - start2);
        long start3 = System.nanoTime();
        sum = reduce(a,0,(s,t)->s + t);
        System.out.printf("the time of get %s for loop: %d%n", sum, System.nanoTime() - start3);
        sum = 0;
        long start4 = System.nanoTime();
        for(Integer i : a) {
            sum += i;
        }
        System.out.printf("the time of get %s for loop: %d%n", sum, System.nanoTime() - start4);
    }

    public static <T> T reduce(Collection<T> c, T sum, Task<T> tTask) {
        for(T t : c) {
            sum = tTask.execute(sum,t);
        }
        return sum;
    }
}
