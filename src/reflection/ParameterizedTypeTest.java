package reflection;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

abstract class GenericType<T> {
    private Class<T> tClass;
    @SuppressWarnings("unchecked")
    public GenericType() {
        Type superclass = getClass().getGenericSuperclass();
        if (null != superclass && superclass instanceof ParameterizedType){
            Type[] arguments = ((ParameterizedType) superclass).getActualTypeArguments();
            if(arguments.length > 0 && arguments[0] instanceof Class<?>) {
                tClass = (Class<T>)arguments[0];
            }
        }

    }

    abstract void printClassName();

    public Class<T> getTClass() {
        return tClass;
    }
}

public class ParameterizedTypeTest {
    static GenericType<String> gt = new GenericType<String>() {
        @Override
        void printClassName() {
            System.out.println(getTClass().getName());
        }
    };
    public static void main(String[] args) {
        GenericType<Long> gcl = new GenericType<Long>() {
            @Override
            void printClassName() {
                System.out.println(getTClass().getName());
            }
        };
        gt.printClassName();
        gcl.printClassName();
    }
}
