package leetcode;

public class MyMath {

    public static int mySqrt(int x) {
        if(x < 1) return 0;
        if(x < 4) return 1;
        int low = 1, high = x;
        int d = (low + high) / 2;
        while(true) {
            if(x / d == d || (x / d > d && x / (d+1) < (d+1))) return d;
            if(x / d < d) {
                high = d;
            }else{
                low = d;
            }
            d = (low + high) / 2;
        }
    }

    public static double mySqrt(double y, int d) {
        if(y == 0) return 0;
        System.out.println(0.01 / 0.1);
        double low = 0, high = y;
        double m = (low + high) / 2;
        String decimal = "";
        while(decimal.length() < d) {
            if(y / toInt(m) == toInt(m)) return toInt(m);
            if(y / m == m) return m;
            if(y / m > m) {
                low = m;
            }else{
                high = m;
            }
            m = (low + high) / 2;
            decimal = "" + m;
            decimal = decimal.substring(decimal.lastIndexOf(".")+1, decimal.length());
        }
        return m;
    }

    public static int toInt(double d) {
        int n = (int)d;
        if(d - n >= 0.5) return n + 1;
        return n;
    }

    public static void main(String[] args) {
        System.out.println(mySqrt(1,9));
    }
}
