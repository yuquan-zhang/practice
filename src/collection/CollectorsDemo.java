package collection;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author zhangyong created on 2019/10/4
 **/
public class CollectorsDemo {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        List<String> list2 = list.stream().filter(v -> v.equals("one")).collect(Collectors.toList());
    }
}
