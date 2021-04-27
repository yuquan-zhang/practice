package math;

import java.math.BigDecimal;
import java.math.RoundingMode;

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
        int pc = p;
        while(pc > 0) {
            precision /= 10;
            pc--;
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
        return BigDecimal.valueOf(r).setScale(p,RoundingMode.FLOOR).doubleValue();
    }

    public static int maxCommonDivider(int m, int n) {
        int r = m % n;
        while (r != 0) {
            m = n;
            n = r;
            r = m % n;
        }
        return n;
    }

    public static void main(String[] args) {
        double d = 500.0 / 2400000;
        for (int i = 1; i < 500; i++) {
            d *= (double) (2400000 - i) / 2400000;
        }
        System.out.println(d);
        BigDecimal bd = BigDecimal.valueOf(123.4567);
        System.out.printf("人民币%.2f%n",bd);
        System.out.println(sqrt(2,5));
        System.out.println(pow(3,10));
        System.out.println(Math.sqrt(Double.MIN_VALUE));
        System.out.println(sqrt(900000,10));
        System.out.println(maxCommonDivider(119,544));
        int a = - Integer.MAX_VALUE;
        System.out.println(a);
        System.out.println(-1 - Integer.MAX_VALUE);
        System.out.println(byteToHexString((byte)127));
    }

    public static String byteToHexString(byte b) {
        int a = b & 0xff;
        return Integer.toHexString(b);
    }
}
