package reflection;

import java.lang.reflect.*;

class Cache<T> {
    private Class<T> tClass;

    public Cache() {
        try {
            Field[] fields = getClass().getDeclaredFields();
            Field field = fields[0];
            System.out.printf("getType = %s%n",field.getType().getName());
            System.out.printf("getGenericType = %s%n",field.getGenericType().getTypeName());
            Class<T> entryClass = ParameterizedTypePrac.getTypeParam(getClass(),0);
            System.out.printf("entryClass name is %s%n",entryClass.getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

public class ParameterizedTypePrac {
    public static void main(String[] args) {
        Cache<String> cache = new Cache<>();
        System.out.printf("String class name is %s%n", String.class.getName());
    }

    /**
     * 获取一个类的泛型参数数组，如果这个类没有泛型参数，返回 null
     */
    public static Type[] getTypeParams(Class<?> klass) {
        // TODO 这个实现会导致泛型丢失,只能取得申明类型
        if (klass == null || "java.lang.Object".equals(klass.getName()))
            return null;
        // 看看父类
        Type superclass = klass.getGenericSuperclass();
        if (null != superclass && superclass instanceof ParameterizedType)
            return ((ParameterizedType) superclass).getActualTypeArguments();

        // 看看接口
        Type[] interfaces = klass.getGenericInterfaces();
        for (Type inf : interfaces) {
            if (inf instanceof ParameterizedType) {
                return ((ParameterizedType) inf).getActualTypeArguments();
            }
        }
        return getTypeParams(klass.getSuperclass());
    }

    /**
     * 获取一个 Type 类型实际对应的Class
     *
     * @param type
     *            类型
     * @return 与Type类型实际对应的Class
     */
    @SuppressWarnings("rawtypes")
    public static Class<?> getTypeClass(Type type) {
        Class<?> clazz = null;
        if (type instanceof Class<?>) {
            clazz = (Class<?>) type;
        } else if (type instanceof ParameterizedType) {
            ParameterizedType pt = (ParameterizedType) type;
            clazz = (Class<?>) pt.getRawType();
        } else if (type instanceof GenericArrayType) {
            GenericArrayType gat = (GenericArrayType) type;
            Class<?> typeClass = getTypeClass(gat.getGenericComponentType());
            return Array.newInstance(typeClass, 0).getClass();
        } else if (type instanceof TypeVariable) {
            TypeVariable tv = (TypeVariable) type;
            Type[] ts = tv.getBounds();
            if (ts != null && ts.length > 0)
                return getTypeClass(ts[0]);
        } else if (type instanceof WildcardType) {
            WildcardType wt = (WildcardType) type;
            Type[] t_low = wt.getLowerBounds();// 取其下界
            if (t_low.length > 0)
                return getTypeClass(t_low[0]);
            Type[] t_up = wt.getUpperBounds(); // 没有下界?取其上界
            return getTypeClass(t_up[0]);// 最起码有Object作为上界
        }
        return clazz;
    }

    /**
     * 获取一个类的某个一个泛型参数
     *
     * @param klass
     *            类
     * @param index
     *            参数下标 （从 0 开始）
     * @return 泛型参数类型
     */
    @SuppressWarnings("unchecked")
    public static <T> Class<T> getTypeParam(Class<?> klass, int index) {
        Type[] types = getTypeParams(klass);
        if (types == null)
            return null;
        if (index >= 0 && index < types.length) {
            Type t = types[index];
            Class<T> clazz = (Class<T>) getTypeClass(t);
            if (clazz == null)
            return clazz;
        }
        return null;
    }
}
