package pattern;

import java.util.HashMap;

interface Shape {
    void draw();
}

class Circle implements Shape {
    private String color;
    private int x;
    private int y;
    private int radius;

    public Circle(String color) {
        this.color = color;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public void draw() {
        System.out.println("this circle is : [" + color + "," + x + "," + y + "," + radius + "]");
    }
}

class ShapeFactory {
    private static final HashMap<String,Circle> circleMap = new HashMap<>();

    public static Shape getCircle(String color) {
        Circle circle = circleMap.get(color);
        if(circle == null) {
            circle = new Circle(color);
            circleMap.put(color,circle);
            System.out.println("Creating circle of color " + color);
        }
        return circle;
    }
}

public class FlyweightPattern {
    private static final String[] colors = new String[]{"green","black","white","blue","red"};

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            Circle circle = (Circle)ShapeFactory.getCircle(getRandomColor());
            circle.setRadius(100);
            circle.setX(getRandomNo());
            circle.setY(getRandomNo());
            circle.draw();
        }
    }

    public static String getRandomColor() {
        int i = (int)(Math.random() * 5);
        return colors[i];
    }

    public static int getRandomNo() {
        return (int)(Math.random() * 100);
    }

}
