package math;

/**
 * @author zhangyong created on 2019/12/19
 **/
public class Addition {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        double sum = 0.0;
        for (int i = 0; i < 1000000000; i++) {
            sum += i;
        }
        System.out.println("sum := " + sum);
        System.out.println("time spent := " + (System.currentTimeMillis() - start));
    }
}
