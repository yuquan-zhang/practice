package leetcode;

import java.util.List;

public class IntToRoman {
    public static String[] romans = {"I","V","X","L","C","D","M"};
    public static String intToRoman(int num) {
        if(num == 0) return "";
        int p = 0;
        int n = num % 10;
        String res = intToRoman(n,p);
        while(num > 0) {
            p++;
            num = num / 10;
            n = num % 10;
            res = intToRoman(n,p) + res;
        }
        return res;
    }

    public static String intToRoman(int n, int p) {
        if(n == 0) return "";
        String res = "";
        if(p >= 3) {
            int e = p - 3;
            int len = e == 0 ? n : intPow(e);
            while(len-- > 0) res += "M";
            return res;
        }
        p = p * 2;
        if(n <= 3 && p < 6) {
            int i = 0;
            while(i++ < n) {
                res += romans[p];
            }
        }else if(n == 4 && p < 6) {
            res = romans[p] + romans[p+1];
        }else if(n == 5 && p < 6){
            res = romans[p+1];
        }else if(n <= 8 && p < 6) {
            res = romans[p+1];
            int j = 0;
            while(j++ < n - 5){
                res += romans[p];
            }
        }else if(n == 9 && p < 6) {
            res = romans[p] + romans[p+2];
        }else if(p < 6){
            res = romans[p+2];
        }
        return res;
    }

    private static int intPow(int n) {
        if(n == 1) return 10;
        else{
            if(n % 2 == 0) {
                return intPow(n/2) * intPow(n/2);
            }else{
                return intPow(n/2) * intPow(n/2) * 10;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(intToRoman(12000));
        List<Integer> list = null;
    }
}
