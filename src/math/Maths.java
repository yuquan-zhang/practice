package math;

public class Maths {
    public static double abs(double y) {
        return y >= 0 ? y : -y;
    }

    public static int round(double y) {
        return (int)y;
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

    public static double sqrt(double x, int p) {
        if(x < 0) return Double.NaN;
        if(x == 0) return 0;
        if(x == 1) return 1;
        int count = 0;
        double precision = 1;
        while(p > 0) {
            precision /= 10;
            p--;
        }
        double r = x / 2;
        double r2 = x / r;
        while (abs(r - r2) >= precision) {
            r = (r + r2)/2;
            r2 = x / r;
            count++;
            if(count > 1000) break;
        }
        System.out.println(count);
        if(x > 1 && round(r) * round(r) == x) return round(r);
        return r;
    }

    public static void main(String[] args) {
        System.out.println(pow(3,10));
        System.out.println(Math.sqrt(Double.MIN_VALUE));
        System.out.println(sqrt(Double.MIN_VALUE,10));
    }
}
