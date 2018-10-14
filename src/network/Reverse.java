package network;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class Reverse {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String msg = "Hello World! 你好啊";
        String encMsg = URLEncoder.encode(msg,"UTF-8");
        String decMsg = URLDecoder.decode(encMsg, "UTF-8");
        System.out.printf("before encoding is %s%n after encoding is %s%n %s%n", msg, encMsg, decMsg);
    }
}
