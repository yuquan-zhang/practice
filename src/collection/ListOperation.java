package collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListOperation {
    public static void main(String[] args) {
        List<Long> longs = new ArrayList<>(Arrays.asList(1L,2L,3L));
        List<Long> longs2 = new ArrayList<>(Arrays.asList(4L,5L,6L,7L,8L,9L));
        List<Long> longs4 = new ArrayList<>(longs);
        longs4.retainAll(longs2);
        longs.removeAll(longs4);
        longs2.removeAll(longs4);
        System.out.printf("list of long 1 is: %s%n", Arrays.toString(longs.toArray()));
        System.out.printf("list of long 2 is: %s%n", Arrays.toString(longs2.toArray()));
        System.out.printf("list of long 4 is: %s%n", Arrays.toString(longs4.toArray()));
    }
}
