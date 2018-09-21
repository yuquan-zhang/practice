package test;

import java.util.ArrayList;
import java.util.List;

class MyGen<T> {
    T obj;
    public void add(T obj) {
        this.obj = obj;
    }
    public T get() {
        return this.obj;
    }
}

abstract class Shape {
    abstract void draw();
}

class Rectangle extends Shape {
    @Override
    public void draw() {
        System.out.println("drawing rectangle");
    }
}

class Circle extends Shape {
    @Override
    public void draw() {
        System.out.println("drawing circle");
    }
}

public class GenericsTest {
    public static <E> void printArray(E[] elements) {
        for (E el : elements) {
            System.out.println(el);
        }
    }

    public static void drawShapes(List<? extends Shape> list) {
        for(Shape shape : list) {
            shape.draw();
        }
    }

    public static void main(String[] args) {
        MyGen<String> m = new MyGen<>();
        m.add("generic type");
        System.out.println(m.get());
        printArray(new String[] {
                "this","is","a","test"
        });
        printArray(new Integer[] {
                1,2,3,4
        });
        List<Shape> shapes = new ArrayList<>();
        shapes.add(new Rectangle());
        shapes.add(new Circle());
        shapes.add(new Rectangle());
        drawShapes(shapes);
    }
}
