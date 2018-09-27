package base;

import java.util.Comparator;

public class DefaultMethod {
    public static void main(String[] args) {
        Comparator.comparing((String::length));
    }
}
