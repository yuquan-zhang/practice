package collection;

import java.util.*;

public class MapList {
    public static void main(String[] args) {
        Map<String,Object> map = new HashMap<>();
        List<String> strings = new ArrayList<>();
        strings.add("first");
        strings.add("second");
        map.putIfAbsent("stringList",strings);
        Map<Long,List<String>> longStringMap = new HashMap<>();
        longStringMap.putIfAbsent(101L,strings);
        longStringMap.putIfAbsent(102L,new ArrayList<>());
        map.putIfAbsent("longString",longStringMap);
        List<String> stringList = (List<String>)map.get("stringList");
        System.out.println(stringList);
        Map<Long,String> longStringMap1 = (Map<Long,String>)map.get("longString");
        System.out.println(longStringMap1);
    }
}
