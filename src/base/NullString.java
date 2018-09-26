package base;

public class NullString {
    public static void main(String[] args) {
        Object o = "12345";
        System.out.println(getString(null));
        FinalMethod finalMethod = new FinalMethod();
        FinalMethod fm = finalMethod.getFm();
        FinalMethod.StaticInnerClass staticInnerClass = new FinalMethod.StaticInnerClass();
        FinalMethod.InnerClass innerClass = fm.new InnerClass();

    }

    public static String getString(Object object) {
        return (String)object;
    }
}

class FinalMethod {
    private FinalMethod fm = init();

    private final FinalMethod init() {
        StaticInnerClass innerClass = new StaticInnerClass();
        InnerClass ic = new InnerClass();
        return new FinalMethod();
    }

    public FinalMethod getFm() {
        return fm;
    }

    public static class StaticInnerClass {
        private static int a;
    }

    public class InnerClass {
        private int b;
    }
}