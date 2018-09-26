package lambda;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Calculator {

    interface IntegerMath {
        int operation(int a, int b);
    }

    public int operateBinary(int a, int b, IntegerMath op) {
        return op.operation(a, b);
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        IntegerMath addition = (a, b) -> a + b;
        IntegerMath subtraction = (a, b) -> a - b;
        System.out.println("40 + 2 = " + calculator.operateBinary(40, 2, addition));
        System.out.println("20 - 20 = " + calculator.operateBinary(20, 20, subtraction));
        ThreadPoolExecutor executor = new ThreadPoolExecutor(4, 10,
                100, TimeUnit.SECONDS, null, new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                return null;
            }
        });
    }
}
