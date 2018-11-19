package collection;

import java.util.Arrays;

public class ArrayIndex {
    public static void main(String[] args) {
        int[] ints = {11,22,77,44,99,66};
        Arrays.stream(ints).forEachOrdered(System.out::println);

    }
}
