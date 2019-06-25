package leetcode;

import java.util.concurrent.atomic.AtomicBoolean;

public class RegularExpressionMatching {
    public static void main(String[] args) {
        System.out.println(isMatch("aaa","a*a"));
        System.out.println(isMatch("aaa","a*"));
        System.out.println(isMatch("abddddddssseee","a.*"));
        System.out.println(isMatch("aaabbb","aaa*b*"));
        System.out.println(isMatch("*abc","\\*\\**abc*"));
        System.out.println(isMatch("aab","c*a*b"));
        System.out.println(isMatch("ab",".*c"));
    }

    public static boolean isMatch(String s, String p) {
        memo = new Boolean[s.length() + 1][p.length() + 1];
        return dynamicMatch(0,0,s,p);
    }

    public static boolean isMatch2(String text, String pattern) {
        if(pattern.isEmpty()) return text.isEmpty();
        boolean first_match = (!text.isEmpty() && (pattern.charAt(0) == text.charAt(0) || pattern.charAt(0) == '.'));
        if (pattern.length() >= 2 && pattern.charAt(1) == '*') {
            return isMatch2(text,pattern.substring(2)) || (first_match && isMatch2(text.substring(1),pattern));
        } else {
            return first_match;
        }
    }

    public static Boolean[][] memo;

    public static boolean dynamicMatch(int i, int j, String t, String p) {
        if(memo[i][j] != null) {
            return memo[i][j];
        }
        boolean ans;
        if (j == p.length()) {
            ans = i == t.length();
        } else {
            boolean firstMatch = i < t.length() && (p.charAt(j) == '.' || p.charAt(j) == t.charAt(i));
            if(j + 1 < p.length() && p.charAt(j + 1) == '*') {
                ans = dynamicMatch(i, j + 2, t, p) || (firstMatch && dynamicMatch(i + 1, j, t, p));
            } else {
                ans = firstMatch && dynamicMatch(i + 1, j + 1, t, p);
            }
        }
        memo[i][j] = ans;
        return ans;
    }

    public static char findTheDifference(String s, String t) {
        int r = 0;
        for(int i = 0; i < s.length(); i++) {
            r += t.charAt(i) - s.charAt(i);
        }
        r += t.charAt(t.length() -1 );
        return (char)r;
    }

    public static int singleNumber(int[] nums) {
        int a = 0;
        for (int i : nums) {
            a ^= i;
        }
        return a;
    }
}
