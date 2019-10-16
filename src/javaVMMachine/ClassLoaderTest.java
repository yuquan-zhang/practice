package javaVMMachine;

import java.io.IOException;
import java.io.InputStream;

/**
 * 类加载器与instanceOf关键字演示
 *
 * @author zhangyong created on 2019/10/9
 **/
public class ClassLoaderTest {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        ClassLoader myLoader = new ClassLoader() {
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                String fileName = name.substring(name.lastIndexOf(".")) + ".class";
                InputStream is = getClass().getResourceAsStream(fileName);
                if (null == is) {
                    return super.loadClass(name);
                }
                try {
                    byte[] b = new byte[is.available()];
                    is.read(b);
                    return defineClass(name,b,0,b.length);
                } catch (IOException e) {
                    throw new ClassNotFoundException(name);
                }
            }
        };

        Object obj = myLoader.loadClass("javaVMMachine.ClassLoaderTest").newInstance();
        System.out.println(obj.getClass());
        System.out.println(obj instanceof javaVMMachine.ClassLoaderTest);
    }
}
