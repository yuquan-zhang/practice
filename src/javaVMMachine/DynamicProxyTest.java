package javaVMMachine;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author zhangyong created on 2019/10/11
 **/
public class DynamicProxyTest {

    interface IHello {

        void sayHello();

        void sayHi();
    }

    static class Hello implements IHello {

        @Override
        public void sayHello() {
            System.out.println("Hello World");
        }

        @Override
        public void sayHi() {
            System.out.println("Hi Girl");
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
            return method.invoke(originalObj,args);
        }
    }

    public static void main(String[] args) {
        IHello hello = (IHello) new DynamicProxy().bind(new Hello());
        hello.sayHello();
        hello.sayHi();
    }
}
