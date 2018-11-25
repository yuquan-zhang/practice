package data_structure;

public class CycleQueue<T> {
    private Object[] items;
    private int len;
    private int head;
    private int tail;

    public CycleQueue(int len) {
        if(len < 0) throw new IllegalArgumentException("the length of queue can not be negative");
        this.items = new Object[len+1];
        this.len = len+1;
        this.head = 0;
        this.tail = 0;
    }

    public boolean inQueue(T t) {
        if(isFull()) return false;
        items[tail] = t;
        tail = (tail+1) % len;
        return true;
    }

    private boolean isFull() {
        return (tail + 1) % len == head;
    }

    @SuppressWarnings("unchecked")
    public T deQueue() {
        if(isEmpty()) return null;
        T t = (T)items[head];
        head = (head + 1) % len;
        return t;
    }

    private boolean isEmpty() {
        return head == tail;
    }

    public static void main(String[] args) {
        CycleQueue<String> cq = new CycleQueue<>(5);
        System.out.println(cq.inQueue("first"));
        System.out.println(cq.inQueue("second"));
        System.out.println(cq.inQueue("third"));
        System.out.println(cq.inQueue("four"));
        System.out.println(cq.inQueue("five"));
        System.out.println(cq.inQueue("six"));
        System.out.println(cq.deQueue());
        System.out.println(cq.deQueue());
        System.out.println(cq.deQueue());
        System.out.println(cq.deQueue());
        System.out.println(cq.deQueue());
        System.out.println(cq.deQueue());
    }
}
