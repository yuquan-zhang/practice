package test;

import java.util.stream.Stream;

class GenericClass<X> {
    <T> GenericClass(T t) {
        System.out.println(t);
    }
}

public class GenericClassTest {
    public static void main(String[] args) {
        GenericClass<String> gc = new GenericClass<>("generic class");
        Stream.iterate(1, element->element+1)
                .filter(element->element%5==0)
                .limit(5)
                .forEach(System.out::println);
    }
}
