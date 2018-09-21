package test;

import java.util.Scanner;

public class AssertTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your age");
        int value = scanner.nextInt();
        assert value >= 18 : "not valid";
        System.out.println("value is " + value);
    }
}
