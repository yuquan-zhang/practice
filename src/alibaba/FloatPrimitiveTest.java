package alibaba;

public class FloatPrimitiveTest {
    public static void main(String[] args) {
        float a = 1.0f - 0.9f;
        System.out.println(Integer.toBinaryString(Float.floatToIntBits(a)));
        float b = 0.9f - 0.8f;
        System.out.println(Integer.toBinaryString(Float.floatToIntBits(b)));
        System.out.printf("a=%f, b=%f, a==b=%b%n",a,b,a==b);
    }
}
