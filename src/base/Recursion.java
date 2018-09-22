package base;

import java.util.Stack;

public class Recursion {

    public static void hanoi(int disk, Stack<Integer> source, Stack<Integer> destination, Stack<Integer> aux) {
        if(disk == 1) {
            destination.push(source.pop());
        }else{
            hanoi(disk - 1,source,aux,destination);
            destination.push(source.pop());
            hanoi(disk-1,aux,destination,source);
        }
    }

    public static int fibonacci(int n) {
        if(n <= 0) return 0;
        if(n < 3) {
            return 1;
        }else{
            return fibonacci(n-2) + fibonacci(n-1);
        }
    }

    public static void main(String[] args) {
        System.out.println("Hanoi Problem Start:");
        Integer[] ints = {1,2,3,4,5,6,7,8,9,10};
        Stack<Integer> source = new Stack<>();
        for(Integer i : ints) {
            source.push(i);
        }
        Stack<Integer> dest = new Stack<>();
        Stack<Integer> aux = new Stack<>();
        System.out.println("Before moving:");
        System.out.println("source:" + source);
        System.out.println("dest:" + dest);
        System.out.println("aux:" + aux);
        hanoi(source.size(),source,dest,aux);
        System.out.println("After moving:");
        System.out.println("source:" + source);
        System.out.println("dest:" + dest);
        System.out.println("aux:" + aux);
        System.out.println("Hanoi Problem End.");

        System.out.println("Fibonacci Start:");
        for(int i = 1; i <= 10; i++) {
            System.out.print(fibonacci(i) + ",");
        }
    }
}
