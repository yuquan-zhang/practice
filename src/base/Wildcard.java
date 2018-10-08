package base;

import java.util.ArrayList;
import java.util.List;

public class Wildcard {
    public static void main(String[] args) {
        List<?> list = new ArrayList<>();
        list.add(null);
        List<Integer> objects = new ArrayList<>();
        objects.add(1);
        objects.add(null);
        System.out.printf("The List<Integer> is a subtype of List<?> ? %s%n",
                objects instanceof List<?>);
        System.out.printf("The type of List<?> is %s%n",list.getClass().getName());
    }
}
