package interviews.google;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class ReverseStatement {

    public static String reverse(String s) {
        char[] chars = s.toCharArray();
        int len = chars.length;
        for(int i = 0; i < len/2; i++) {
            char c = chars[i];
            chars[i] = chars[len - i - 1];
            chars[len - i - 1] = c;
        }
        return new String(chars);
    }

    public static String reverseStatement(String statement) {
        statement = reverse(statement);
        String[] words = statement.split(" ");
        for(int i = 0; i < words.length; i++) {
            words[i] = reverse(words[i]);
        }
        return Arrays.stream(words).reduce("",(s,i) -> {
            if(s.length() == 0) return s + i;
            else return  s + " " + i;
        });
    }

    public static String reverseStatement(char[] chars) {
        int len = chars.length;
        for(int i = 0; i < len/2; i++) {
            char c = chars[i];
            chars[i] = chars[len - i - 1];
            chars[len - i - 1] = c;
        }
        int p = 0, b = 0;
        while (b <= len) {
            if( b == len || chars[b] == ' ') {
                for(int i = 0; i < (b-p)/2; i++) {
                    char c = chars[i+p];
                    chars[i+p] = chars[b - i - 1];
                    chars[b - i - 1] = c;
                }
                p = b + 1;
            }
            b++;
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        System.out.println("fir该st");
        System.out.println(reverse("fir该st"));
        long start = System.nanoTime();
        System.out.println(reverseStatement("I'm you are".toCharArray()));
        System.out.println(System.nanoTime() - start);
        long start2 = System.nanoTime();
        System.out.println(reverseStatement("I'm you are"));
        System.out.println(System.nanoTime() - start2);
        System.out.println(System.nanoTime());
        System.out.println(System.nanoTime());
        System.out.println(System.currentTimeMillis());
        System.out.println(getSysIdLocal());
        System.out.println(getSysIdLocal());
    }

    public static String getSysIdLocal() {
        try {
            Thread.sleep(20);
        } catch (Exception e) {
        }
        return new SimpleDateFormat("yyyyMMddHHmmssSSSS").format(new Date());
    }
}
