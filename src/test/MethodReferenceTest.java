package test;

import java.util.function.BiFunction;

interface Sayable {
    void say();
}

class Arithmetic {
    public static int add(int a, int b) {
        return a + b;
    }
}

public class MethodReferenceTest {

    public static void main(String[] args) {
        BiFunction<Integer,Integer,Integer> bif = Arithmetic::add;
        int result = bif.apply(12,23);
        System.out.println(result);
    }
}
