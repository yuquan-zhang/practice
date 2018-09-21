package pattern;

class Singleton {
    private static Singleton singleton;
    private static int count = 0;
    private Singleton(){
        count++;
    }
    public static Singleton getInstance() {
        if(singleton == null) {
            synchronized (Singleton.class) {
                if(singleton == null) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }

    public void doSomething() {
        System.out.println("count: " + count);
    }
}

public class SingletonPattern {
    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance();
        singleton.doSomething();
        singleton = Singleton.getInstance();
        singleton.doSomething();
    }
}
