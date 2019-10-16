package reflection;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhangyong created on 2019/9/30
 **/
public class ClassCompare {
    public static void main(String[] args) {
        System.out.println(HashMap.class.equals(Map.class));
        try {
            System.out.println(HashMap.class.newInstance() instanceof Map);
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
