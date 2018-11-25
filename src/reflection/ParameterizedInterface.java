package reflection;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

interface Brave<T> {
    Class<T> getEntityClass();
}

class BraveImpl<T> implements Brave<T> {
    Class<T> entityClass;

    public BraveImpl() {
        Type[] superInterfaces = getClass().getGenericInterfaces();
        Type superclass = superInterfaces[0];
        if (null != superclass && superclass instanceof ParameterizedType){
            Type[] arguments = ((ParameterizedType) superclass).getActualTypeArguments();
            if(arguments.length > 0 && arguments[0] instanceof TypeVariable) {
                TypeVariable tv = (TypeVariable) arguments[0];
                Type[] ts = tv.getBounds();
                if (ts != null && ts.length > 0){
                    if (ts[0] instanceof Class<?>) {
                        entityClass = (Class<T>) ts[0];
                    }
                }
            }
        }
    }

    public Class<T> getEntityClass() {
        return entityClass;
    }
}

public class ParameterizedInterface {
    public static void main(String[] args) {
        BraveImpl<String> brave = new BraveImpl<String>();
        System.out.println(brave.getEntityClass().getName());
    }
}
