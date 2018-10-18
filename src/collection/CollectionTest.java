package collection;

import java.util.*;
import java.util.stream.Collectors;

class Pet {
    String name;
    String age;

    Pet(String name, String age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}

class People {
    String name;
    String age;

    public String getName() {
        return name;
    }

    public People setName(String name) {
        this.name = name;
        return this;
    }

    public String getAge() {
        return age;
    }

    public People setAge(String age) {
        this.age = age;
        return this;
    }

    @Override
    public String toString() {
        return "People{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}

public class CollectionTest {
    public static void main(String[] args) {
        List<Pet> pets = new ArrayList<>();
        pets.add(new Pet("bobi","11"));
        pets.add(new Pet("lucy","4"));

        List<People> people = apply(pets, pet -> new People().setName(pet.getName()).setAge(pet.getAge()));

        System.out.printf("the number of people is %s%n", people.size());
        System.out.printf("the content of people list is : %s%n", Arrays.toString(people.toArray()));
    }

    public static <T, V> List<V> apply(Collection<T> c, Function<T, V> function) {
        List<V> vList = new ArrayList<>();
        for(T t : c) {
            vList.add(function.apply(t));
        }
        return vList;
    }
}

interface Function<T, V> {
    V apply(T t);
}
