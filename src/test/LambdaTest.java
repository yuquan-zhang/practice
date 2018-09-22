package test;

public class LambdaTest {
    public static void main(String[] args) {
        Addable ad = (a,b) -> (a + b);
        System.out.println(ad.add(10,4));
        System.out.println(ad.multiply(10,4));
        System.out.println(Addable.divide(10,4));
    }
}

@FunctionalInterface
interface Addable {
    int add(int a, int b);

    default int multiply(int a, int b) {
        return a * b;
    }
    static double divide(double a, double b) {
        return a/b;
    }
}
