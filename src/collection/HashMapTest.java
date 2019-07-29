package collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HashMapTest {
    public static void main(String[] args) {
        Map<String,List<String>> map = new HashMap<>();
        System.out.println(map.get("one"));
        List<String> list = map.computeIfAbsent("one",k -> new ArrayList<>());
        System.out.println(list);
        Class clazz = String.class;
        System.out.println(String.class == clazz);
        System.out.println(Double.TYPE == clazz);
        assert false : "not safe at all";
    }
}
