package data_structure;

public class QueueDemo<E> {
    private int front;
    private int rear;
    private final Object[] elements;
    private final int len;

    public QueueDemo(int length) {
        elements = new Object[length];
        len = length;
        rear = front = -1;
    }

    public void enQueue(E e) {
        if(!isFull()) {
            elements[++rear] = e;
            if(front == -1) front++;
        }else{
            System.out.println("Queue is full.");
        }
    }

    @SuppressWarnings("unchecked")
    public E deQueue() {
        if(!isEmpty()) {
            E e = (E) elements[front];
            if(front == rear) front = -1;
            rear--;
            int k = 0;
            while(k < len - 1) {
                elements[k] = elements[k+1];
                k++;
            }
            return e;
        }else{
            return null;
        }
    }

    public boolean isFull() {
        return rear >= len - 1;
    }

    public boolean isEmpty() {
        return front < 0;
    }

    @SuppressWarnings("unchecked")
    public E peek() {
        return (E) elements[front];
    }

    public static void main(String[] args) {
        QueueDemo<String> demo = new QueueDemo<>(3);
        demo.enQueue("first");
        demo.enQueue("second");
        demo.enQueue("third");
        demo.enQueue("fourth");
        System.out.println(demo.peek());
        System.out.println(demo.deQueue());
        System.out.println(demo.peek());
        System.out.println(demo.deQueue());
        System.out.println(demo.peek());
    }
}
