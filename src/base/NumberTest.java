package base;

import java.util.Arrays;

public class NumberTest {
    public static void main(String[] args) {
        Long[] longs = new Long[]{123L,345L,567L};
        numeric(longs);
        System.out.println(Arrays.toString(longs));
    }

    private static void numeric(Number[] numbers) {
        for (Number n : numbers) {
            n = n.longValue() + 1;
        }
    }
}
