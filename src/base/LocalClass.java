package base;

public class LocalClass {

    static String regularExpression = "[^0-9]";
    private static void validatePhoneNumber(String phoneNumber1, String phoneNumber2) {
        final int numberLength = 10;
        // Valid in JDK 8 or later:
        class PhoneNumber {
            String formattedPhoneNumber = null;

            private PhoneNumber(String phoneNumber) {
                String currentNumber = phoneNumber.replaceAll(regularExpression, "");
                if(currentNumber.length() == numberLength) {
                    formattedPhoneNumber = currentNumber;
                }else{
                    formattedPhoneNumber = null;
                }
            }

            private String getNumber() {
                return formattedPhoneNumber;
            }
        }

        PhoneNumber myNumber1 = new PhoneNumber(phoneNumber1);
        PhoneNumber myNumber2 = new PhoneNumber(phoneNumber2);

        if(myNumber1.getNumber() == null) {
            System.out.println("First number is invalid");
        }else{
            System.out.println("First number is " + myNumber1.getNumber());
        }

        if(myNumber2.getNumber() == null) {
            System.out.println("Second number is invalid");
        }else{
            System.out.println("Second number is " + myNumber2.getNumber());
        }

    }

    public static void main(String[] args) {
        validatePhoneNumber("123-456-7890","345-0989   ");
    }
}
