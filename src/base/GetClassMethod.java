package base;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

class Creature {
    private String name;

    public Creature() {

    }

    public Creature(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

public class GetClassMethod {
    public static void main(String[] args) throws InstantiationException,
            IllegalAccessException, InvocationTargetException {
        Creature creature = new Creature("Cat");
        Class clazz = creature.getClass();
        System.out.println(clazz.getSimpleName());
        Constructor[] constructors = clazz.getConstructors();
        System.out.println(constructors.length);
        Creature creature1 = (Creature)constructors[1].newInstance("rabbit");
        System.out.println(creature1.getName());
        System.out.println(clazz.isInstance(creature));
        System.out.println(clazz.isMemberClass());
        System.out.format("this is a integer i = %d%n", 123);
        System.getProperties().list(System.out);
        System.getSecurityManager();
    }
}
