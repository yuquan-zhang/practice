package alibaba;

public class FloatWrapperTest {
    public static void main(String[] args) {
        Float a = Float.valueOf(1.0f - 0.9f);
        Float b = Float.valueOf(0.9f - 0.8f);
        System.out.printf("a=%f, b=%f, a==b=%b",a,b,a.equals(b));
    }
}
