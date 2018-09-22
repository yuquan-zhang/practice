package algorithm;

public class Maths {
    public static double sqrt(double y) {
        return 0;
    }

    public static double pow(double x, int p) {
        if(p == 0) return 1;
        if(p == 1) return x;
        if(p % 2 == 0) {
            return pow(x, p/2) * pow(x, p/2);
        }else {
            return pow(x, p/2) * pow(x, p/2) * x;
        }
    }

    public static void main(String[] args) {
        System.out.println(pow(3,4));
    }
}
