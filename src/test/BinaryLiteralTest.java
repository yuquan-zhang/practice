package test;

public class BinaryLiteralTest {
    public static void main(String[] args) {
        String day = "tuesday";
        switch (day) {
            case "monday": case "thursday": case "friday":
                System.out.println("sunny");
                System.out.println("this is monday");
                break;

            case "tuesday": case "wednesday":
                System.out.println("rain");
                System.out.println("this is tuesday");
                break;

            default:
                System.out.println("this is another day");
        }
    }
}
