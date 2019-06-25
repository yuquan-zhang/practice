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

    public static int divide(int dividend, int divisor) {
        if (dividend == 0) return 0;
        boolean isMinDvd = dividend == Integer.MIN_VALUE;
        if (divisor == Integer.MIN_VALUE) {
            return isMinDvd ? 1 : 0;
        }
        if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
        boolean needMinus = false;
        if (divisor < 0) {
            needMinus = true;
            divisor = - divisor;
        }
        if (dividend < 0) {
            needMinus = !needMinus;
            dividend = isMinDvd ? Integer.MAX_VALUE : -dividend;
        }
        int result = 0;
        int bn = 1, tdvs = divisor;
        while (dividend - divisor >= divisor) {
            while (dividend - tdvs >= tdvs) {
                tdvs <<= 1;
                bn <<= 1;
            }
            dividend -= tdvs;
            tdvs = divisor;
            result += bn;
            bn = 1;
        }
        while (dividend >= divisor) {
            dividend -= divisor;
            result++;
            if (isMinDvd) {
                dividend++;
                isMinDvd = false;
            }
        }
        return needMinus ? -result : result;
    }

    public static int multiply(int ma, int mb) {
        if (ma == 0 || mb == 0) return 0;
        int result = 0;
        boolean needMinus = false;
        if (ma < 0) {
            ma = -ma;
            needMinus = true;
        }
        if (mb < 0) {
            mb = -mb;
            needMinus = !needMinus;
        }
        if (ma == 1)  result = mb;
        if (mb == 1)  result = ma;
        if (ma != 1 || mb != 1) {
            int bt = 1, tb = mb;
            while (ma > 0) {
                while (ma - bt >= bt) {
                    tb += tb;
                    bt <<= 1;
                }
                result += tb;
                ma -= bt;
                tb = mb;
                bt = 1;
            }
        }
        return needMinus ? -result :result;
    }

    public static void main(String[] args) {
        System.out.println(isMatch2("abbabaaabbabbaababbabbbbbabbbabbbabaaaaababababbbabababaabbababaabbbbbbaaaabababbbaabbbbaabbbbababababbaabbaababaabbbababababbbbaaabbbbbabaaaabbababbbbaababaabbababbbbbababbbabaaaaaaaabbbbbaabaaababaaaabb"
                ,"**aa*****ba*a*bb**aa*ab****a*aaaaaa***a*aaaa**bbabb*b*b**aaaaaaaaa*a********ba*bbb***a*ba*bb*bb**a*b*bb"));
    }

    public static boolean isMatch(String s, String p) {
        return isMatch(s,p,0,0,s.length(),p.length());
    }

    public static boolean isMatch(String s, String p, int si, int pj,int sl, int pl) {
        if (si == sl && pj == pl) return true;
        if (pj >= pl) return false;
        char c = p.charAt(pj);
        if (c == '?') {
            return isMatch(s,p,si+1,pj+1,sl,pl);
        }
        if (c == '*') {
            while (pj + 1 < pl && p.charAt(pj+1) == '*') {
                pj++;
            }
            for (int i = si; i <= s.length(); ++i) {
                if (isMatch(s,p,i,pj+1,sl,pl)) return true;
            }
            return false;
        }
        if (si >= sl) return false;
        return c == s.charAt(si) && isMatch(s,p,si+1,pj+1,sl,pl);
    }

    public static boolean isMatch2(String str, String pattern) {
        int s = 0, p = 0, match = 0, starIdx = -1;
        while (s < str.length()){
            // advancing both pointers
            if (p < pattern.length()  && (pattern.charAt(p) == '?' || str.charAt(s) == pattern.charAt(p))){
                s++;
                p++;
            }
            // * found, only advancing pattern pointer
            else if (p < pattern.length() && pattern.charAt(p) == '*'){
                starIdx = p;
                match = s;
                p++;
            }
            // last pattern pointer was *, advancing string pointer
            else if (starIdx != -1){
                p = starIdx + 1;
                match++;
                s = match;
            }
            //current pattern pointer is not star, last patter pointer was not *
            //characters do not match
            else return false;
        }

        //check for remaining characters in pattern
        while (p < pattern.length() && pattern.charAt(p) == '*')
            p++;

        return p == pattern.length();
    }
}
