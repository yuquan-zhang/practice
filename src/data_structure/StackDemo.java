package data_structure;

public class StackDemo<E> {
    private int top;
    private final int max;
    private Object[] elements;

    public StackDemo(int length) {
        elements = new Object[length];
        max = length;
        top = -1;
    }

    public boolean push(E e) {
        if(!isFull()) {
            elements[++top] = e;
            return true;
        }else{
            System.out.println("Stack is full.");
            return false;
        }

    }

    @SuppressWarnings("unchecked")
    public E pop() {
        if(peek() != null) {
            return (E) elements[top--];
        }else
            return null;
    }

    @SuppressWarnings("unchecked")
    public E peek() {
        if(!isEmpty()) return (E) elements[top];
        else return null;
    }

    public boolean isFull() {
        return top >= max - 1;
    }

    public boolean isEmpty() {
        return top < 0;
    }

    public static void main(String[] args) {
        StackDemo<String> demo = new StackDemo<>(5);
        demo.push("first");
        demo.push("second");
        demo.push("third");
        demo.push("fourth");
        demo.push("fifth");
        demo.push("sixth");
        System.out.println(demo.peek());
        System.out.println(demo.pop());
        System.out.println(demo.pop());
        System.out.println(demo.peek());
    }
}
