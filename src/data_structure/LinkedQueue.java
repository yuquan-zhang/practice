package data_structure;

public class LinkedQueue<T> {

    private Node<T> head;
    private Node<T> tail;

    public boolean enqueue(T t) {
        Node<T> tNode = new Node<>();
        tNode.setData(t);
        if(tail == null){
            tail = tNode;
        }
        else{
            tail.setNext(tNode);
            tail = tail.next;
        }
        if(head == null) head = tNode;
        return true;
    }

    public T dequeue() {
        if(head == null) return null;
        T t = head.getData();
        head = head.getNext();
        return t;
    }

    public static class Node<T> {
        private T data;
        private Node<T> next;

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }
    }

    public static void main(String[] args) {
        LinkedQueue<String> linkedQueue = new LinkedQueue<>();
        System.out.println(linkedQueue.dequeue());
        linkedQueue.enqueue("one");
        linkedQueue.enqueue("two");
        linkedQueue.enqueue("three");
        linkedQueue.enqueue("four");
        System.out.println(linkedQueue.dequeue());
        System.out.println(linkedQueue.dequeue());
        System.out.println(linkedQueue.dequeue());
        System.out.println(linkedQueue.dequeue());
        System.out.println(linkedQueue.dequeue());
        linkedQueue.enqueue("five");
        linkedQueue.enqueue("six");
        System.out.println(linkedQueue.dequeue());
        System.out.println(linkedQueue.dequeue());
        linkedQueue.enqueue("seven");
        System.out.println(linkedQueue.dequeue());
        linkedQueue.enqueue("eight");
        System.out.println(linkedQueue.dequeue());
        System.out.println(linkedQueue.dequeue());
    }
}
