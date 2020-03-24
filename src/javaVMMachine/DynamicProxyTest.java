package javaVMMachine;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * @author zhangyong created on 2019/10/11
 **/
public class DynamicProxyTest {

    interface IHello {

        void sayHello(String msg);

//        void sayHi();
    }

    interface IHi {
        void sayHi(String msg);
    }

    static class Hello implements IHello, IHi {

        @Override
        public void sayHello(String msg) {
            System.out.println("Hello World=" + msg);
        }

        @Override
        public void sayHi(String msg) {
            System.out.println("Hi Girl=" + msg);
        }


    }

    static class DynamicProxy implements InvocationHandler {

        Object originalObj;

        Object bind(Object originalObj) {
            this.originalObj = originalObj;
            return Proxy.newProxyInstance(originalObj.getClass().getClassLoader(),originalObj.getClass().getInterfaces(),this);
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("Welcome");
            System.out.println(proxy.getClass().getName());
            System.out.println(method.getName());
            System.out.println(method.getDeclaringClass().getName());
            System.out.println(Arrays.toString(args));
            return method.invoke(originalObj,args);
        }
    }

    public static void main(String[] args) {
        Object proxy = new DynamicProxy().bind(new Hello());
        IHello hello = (IHello) proxy;
        hello.sayHello("zhang");
        IHi iHi = (IHi) proxy;
        iHi.sayHi("yong");
    }
}
