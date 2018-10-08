package base;

import java.util.Random;

public class TrigonometricMethods {
    public static void main(String[] args) {
        double degrees = 45.0;
        double radians = Math.toRadians(degrees);
        System.out.printf("The value of pi is %.4f%n", Math.PI);
        System.out.printf("The sine of %.1f degrees is %.4f%n",
                degrees, Math.sin(radians));
        System.out.format("The cosine of %.1f degrees is %.4f%n",
                degrees, Math.cos(radians));
        System.out.printf("The tangent of %.1f degrees is %.4f%n",
                degrees, Math.tan(radians));
        System.out.format("The arcsine of %.4f " + "is %.4f degrees %n",
                Math.sin(radians),
                Math.toDegrees(Math.asin(Math.sin(radians))));

        System.out.format("The arccosine of %.4f " + "is %.4f degrees %n",
                Math.cos(radians),
                Math.toDegrees(Math.acos(Math.cos(radians))));

        System.out.format("The arctangent of %.4f " + "is %.4f degrees %n",
                Math.tan(radians),
                Math.toDegrees(Math.atan(Math.tan(radians))));

        System.out.printf("The random number is %.4f%n", Math.random());
        Random random = new Random(System.currentTimeMillis());
        System.out.printf("The second random number is %d%n", random.nextInt(2));
        System.out.printf("The max value of Integer is %d, The max value of Byte is %d%n",
                Integer.MAX_VALUE, Byte.MAX_VALUE);
        System.out.printf("The hexadecimal number of %d is %s%n",
                65,Integer.toHexString(65));
        System.out.printf("The decimal number of 230 which is a number of base 5 is %d%n",
                Integer.parseInt("230",5));
        System.out.printf("The number %s is Not a Number ? %s%n",
                "123.345", Double.isNaN(123.345));
        System.out.printf("The Integer 1 is equal to The Long 1 ? %s%n",
                Integer.valueOf(1).equals(Long.valueOf(1)));
        System.out.printf("The unicode for uppercase Greek omega character is %s%n",
                '\u03A9');
        System.out.printf("The formfeed is \f \b \f%n");
        System.out.printf("The string of null is %s%n",
                "" + null);
    }
}
