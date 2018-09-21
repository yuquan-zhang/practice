package test;

import java.util.Base64;

public class EncodeDecodeTest {
    public static void main(String[] args) {
        Base64.Encoder encoder = Base64.getUrlEncoder();
        String eStr = encoder.encodeToString("hello,\nwelcome to my world".getBytes());
        System.out.println(eStr);
        Base64.Decoder decoder = Base64.getUrlDecoder();
        String dStr = new String(decoder.decode(eStr));
        System.out.println(dStr);
    }
}
