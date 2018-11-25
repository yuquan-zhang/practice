package collection;

import java.util.Arrays;

public class ArrayIndex {
    public static void main(String[] args) {
        int[] ints = {11,22,77,44,99,66};
        Arrays.stream(ints).forEachOrdered(System.out::println);
        System.out.println(Arrays.stream(ints).reduce(0,(a,b) -> a + b));
        String[] names = {"zhang","yong","yu","ling","tan","zeng"};
        System.out.println(Arrays.stream(names).reduce("",(a,b) -> a.length() != 0 ? a + "," + b : a + b));
    }
}
