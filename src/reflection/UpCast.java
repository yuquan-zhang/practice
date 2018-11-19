package reflection;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class UpCast {
    public static void main(String[] args) {
        toOther(new ArrayList<>());
        toOther(new HashMap<>());
        Class c = Boolean.TYPE;
        Class c2 = void.class;
        c2 = Void.TYPE;

        try {
            Field field = System.class.getField("out");
            System.out.printf("the field name is %s%n", field.getName());
        }catch (Exception e){

        }
    }

    public static void toOther(Object o) {

    }

    private static void copyProperties(Object origin, Object target) {
        if(origin instanceof Map) {

        }else if(origin instanceof Collection) {

        }else{
            Class clazz = origin.getClass();
        }
    }
}
