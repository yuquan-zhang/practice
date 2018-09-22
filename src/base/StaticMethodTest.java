package base;

class Utils {
    public static String test;
    static {
//        test = "this is a test";
        setTest();
    }
    private static void setTest() {
        test = "this is a test more";
    }
}

public class StaticMethodTest {
    public static void main(String[] args) {
        System.out.println(Utils.test);
    }
}
