package concurrent.threadObjects;

/**
 * @author zhangyong created on 2019/9/26
 **/
public class HelloThread extends Thread {

    public void run() {
        System.out.println("Hello from a thread " + Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        (new HelloThread()).start();
    }
}
