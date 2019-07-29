package alibaba;

public class FloatPrimitiveTest {
    public static void main(String[] args) {
        float a = 1.0f - 0.9f;
        System.out.println(Integer.toBinaryString(Float.floatToIntBits(a)));
        float b = 0.9f - 0.8f;
        System.out.println(Integer.toBinaryString(Float.floatToIntBits(b)));
        System.out.printf("a=%f, b=%f, a==b=%b%n",a,b,a==b);
        float[] floats = new float[20000000];
        float sum = 0.0f;
        for (int i = 0; i < 20000000; i++) {
            float x = floats[i] = 1.0f;
            sum += x;
        }
        System.out.println("sum is " + sum);
        kahanSummation(floats);
        System.out.println(neumaierSum(floats));
        floats = new float[]{1,1000000000,1,-1000000000};
        kahanSummation(floats);
        System.out.println(neumaierSum(floats));
        testDouble();
    }

    public static void kahanSummation(float[] floats) {
        float sum = 0.0f;
        float c = 0.0f;
        for (int i = 0, len = floats.length; i < len; ++i) {
            float x = floats[i];
            float y = x - c;
            float t = sum + y;
            c = (t-sum)-y;
            sum = t;
        }
        System.out.println("sum is " + sum);
    }

    public static float neumaierSum(float[] floats) {
        float sum = 0.0f;
        float c = 0.0f;
        for (int i = 0, len = floats.length; i < len; ++i) {
            float t = sum + floats[i];
            if (Math.abs(sum) > Math.abs(floats[i])) {
                c += (sum - t) + floats[i];
            } else {
                c += (floats[i] - t) + sum;
            }
            sum = t;
        }
        return sum + c;
    }

    private static void testDouble() {
        double sum = 0.0d;
        double a = Math.pow(2,52);
        System.out.println("a = " + a);
        sum = a + 1.0d;
        System.out.println("sum is " + sum);
    }
}

