package base;

public class BitwiseOperation {
    public static void main(String[] args) {
        int n = 10;
        System.out.println(n);
        n |= n >>> 3;
        System.out.println(n);
    }
}
