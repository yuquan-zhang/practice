package test;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

class Calculate {
    int add(int a, int b) {
        return a+b;
    }

    int mul(int a, int b) {
        return a * b;
    }
}

public class MethodParameterTest {
    public static void main(String[] args) {
        Calculate calculate = new Calculate();
        Class clazz = calculate.getClass();
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println(method.getName());
            Parameter[] parameters = method.getParameters();
            for (Parameter parameter : parameters) {
                System.out.println(parameter.getParameterizedType());
                System.out.println(parameter.getName());
            }
            System.out.println();
        }
    }
}
