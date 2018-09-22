package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class Main {

    private static void arrayListTest() {
        List<String> list = new ArrayList<>(2);
        list.add("1");
        list.add("2");
        System.out.println(list.size());
        Iterator<String> iterator = list.iterator();
        synchronized (iterator){ // 多线程时在iterator对象上加锁
            while (iterator.hasNext()) {
                String item = iterator.next();
                if("2".equals(item)){
                    iterator.remove();
                }
            }
        }
        System.out.println(list.size());
    }

    private static void mapIteratorTest() {
        HashMap<String, String> map = new HashMap<>(2);
        map.put("one", "o my god");
        map.put("two", "yes baby");
        map.forEach((s, s2) -> System.out.println(s + "/" + s2));
    }


    public static void main(String[] args) {
        mapIteratorTest();
    }
}
