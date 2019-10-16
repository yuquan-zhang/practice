package reflection;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * 行得通的方案
 * @param <T>
 */
class GenericType<T> {
    private Class<T> tClass;
    @SuppressWarnings("unchecked")
    public GenericType() {
        Type superclass = getClass().getGenericSuperclass();
        if (superclass instanceof ParameterizedType){
            Type[] arguments = ((ParameterizedType) superclass).getActualTypeArguments();
            if(arguments.length > 0 && arguments[0] instanceof Class<?>) {
                tClass = (Class<T>)arguments[0];
            }
        }

    }

    public void printClassName(){}

    public Class<T> getTClass() {
        return tClass;
    }
}

public class ParameterizedTypeTest {
    static GenericType<String> gt = new GenericType<String>(){};
    public static void main(String[] args) {
        GenericType<Long> gcl = new GenericType<Long>() {
            @Override
            public void printClassName() {
                System.out.println(getTClass().getName());
            }
        };
        gt.printClassName();
        gcl.printClassName();
    }
}
