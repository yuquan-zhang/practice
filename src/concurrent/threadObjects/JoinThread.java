package concurrent.threadObjects;

/**
 * @author zhangyong created on 2019/9/26
 **/
public class JoinThread {

    static class Other extends Thread {

        public void run() {
            try {
                Thread.sleep(4000);
                System.out.println("Other thread finished");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Other other = new Other();
        other.start();
        try {
            other.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("main thread finished");
    }
}
