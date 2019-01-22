package data_structure;

import java.util.Arrays;

public class ArrayQueue<T> {
    private Object[] items;
    private int len;
    private int head;
    private int tail;

    public ArrayQueue(int capacity) {
        items = new Object[capacity];
        len = capacity;
    }

    public boolean enqueue(T t) {
        if(tail == len){
            if(head == 0) return false;
            for(int i = head; i < tail; i++) {
                items[i-head] = items[i];
            }
            tail -= head;
            head = 0;
        }
        items[tail] = t;
        ++tail;
        return true;
    }

    @SuppressWarnings("unchecked")
    public T dequeue() {
        if(head == tail) return null;
        return (T)items[head++];
    }

    @Override
    public String toString() {
        return "ArrayQueue{" +
                "items=" + Arrays.toString(items) +
                ", len=" + len +
                ", head=" + head +
                ", tail=" + tail +
                '}';
    }

    public static void main(String[] args) {
        ArrayQueue<String> stringArrayQueue = new ArrayQueue<>(5);
        stringArrayQueue.enqueue("one");
        System.out.println(stringArrayQueue);
        stringArrayQueue.enqueue("two");
        System.out.println(stringArrayQueue);
        stringArrayQueue.enqueue("three");
        System.out.println(stringArrayQueue);
        stringArrayQueue.enqueue("four");
        System.out.println(stringArrayQueue);
        stringArrayQueue.enqueue("five");
        System.out.println(stringArrayQueue);
        System.out.println(stringArrayQueue.dequeue());
        System.out.println(stringArrayQueue);
        System.out.println(stringArrayQueue.dequeue());
        System.out.println(stringArrayQueue);
        stringArrayQueue.enqueue("six");
        System.out.println(stringArrayQueue);
        System.out.println(stringArrayQueue.dequeue());
        System.out.println(stringArrayQueue);
    }
}
