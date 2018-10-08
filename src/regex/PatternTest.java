package regex;

import java.util.regex.Pattern;

public class PatternTest {
    public static void main(String[] args) {
        Pattern p = Pattern.compile("\\d*abc\\Q\\d\\E");
        System.out.printf("The pattern's toString() is %s%n", p);
        System.out.printf("The literal string is %s%n ", Pattern.quote("\\d\\w\\s"));
        System.out.printf("The pattern is ? %s%n", Pattern.matches("\\d*","123"));

        System.out.printf("东 and \\u6771 is match ? %s%n", Pattern.matches("\\u6771", "东"));
    }
}
