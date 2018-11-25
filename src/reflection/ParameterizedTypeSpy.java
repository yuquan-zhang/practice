package reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

abstract class Mirrror<T> {
    private Class<T> tClass;
    Mirrror(Class<T> tClass) {
        this.tClass = tClass;
    }

    public Class<T> getEntityClass() {
        return tClass;
    }

    abstract String getName();
}

public class ParameterizedTypeSpy {
    static Mirrror<Book> mirrror3 = new Mirrror<Book>(Book.class){
        @Override
        String getName() {
            return "test";
        }
    };
    public static void main(String[] args) {
        try {
            Mirrror<String> mirrror2 = new Mirrror<String>(String.class){
                @Override
                String getName() {
                    return "test";
                }
            };
            System.out.println(Mirrror.class.getName());
            System.out.println(mirrror2.getEntityClass().getName());
            System.out.println(mirrror2.getClass().getName());
            Mirrror<Integer> mirrror = new Mirrror<Integer>(Integer.class){
                @Override
                String getName() {
                    return "test";
                }
            };
            System.out.println(mirrror.getEntityClass().getName());
            System.out.println(mirrror.getClass().getName());
            System.out.println(mirrror3.getEntityClass().getName());
            System.out.println(mirrror3.getClass().getName());
            Class<?> clazz = Class.forName("reflection.ParameterizedTypeSpy$1");
            Constructor constructor = clazz.getDeclaredConstructors()[0];
            System.out.printf("constructor name is %s%n", constructor);
            Object o = constructor.newInstance(mirrror3.getEntityClass());
            Mirrror m = (Mirrror)o;
            System.out.println(m.getEntityClass());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
