package reflection;

import java.lang.reflect.Field;

/**
 * @author zhangyong created on 2020/9/9
 **/
public class IntegerCacheTest {

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Class cache = Integer.class.getDeclaredClasses()[0];
        Field myCache = cache.getDeclaredField("cache");
        myCache.setAccessible(true);

        Integer[] newCache = (Integer[])myCache.get(cache);
        newCache[132] = newCache[133];

        int a = 2;
        int b = a + a;
        System.out.printf("%d + %d = %d", a, a, b);
        Integer c = 100, d = 100;
        Integer e = 1000, f = 1000;
        System.out.println(c == d);
        System.out.println(e == f);
    }
}
