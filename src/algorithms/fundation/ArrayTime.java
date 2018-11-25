package algorithms.fundation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayTime {
    public static void main(String[] args) {
        List<Integer> a = new ArrayList<>(100000);
        for(int i = 0; i < 100000; i++) {
            a.add(i * i);
        }

        long start1 = System.nanoTime();
        Integer sum = 0;
        for(int j = 0; j < a.size(); j++) {
            sum += a.get(0);
        }
        System.out.printf("the time of for loop: %d%n", System.nanoTime() - start1);
        long start2 = System.nanoTime();
        sum = a.stream().reduce((x, b) -> x + b).get();
        System.out.printf("the time of for each: %d%n", System.nanoTime() - start2);
    }
}
