package collection;

class SingleDirectionList<T> {

    private Node head;

    public SingleDirectionList() {
        head = new Node();
    }

    public SingleDirectionList<T> add(T t) {
        add(head,t);
        return this;
    }

    private void add(Node node, T t) {
        if(node.getValue() == null) {
            node.setValue(t);
            node.setNext(new Node());
        }else{
            add(node.getNext(),t);
        }
    }

    public Node getNode(T t) {
        Node other = head;
        while(other.getValue() != null) {
            if(other.getValue().equals(t)) return other;
            else other = other.getNext();
        }
        return null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Node other = head;
        while (other.getValue() != null) {
            sb.append(other.getValue());
            if(other.getNext().getValue() != null) sb.append(",");
            other = other.getNext();
        }
        sb.append("]");
        return sb.toString();
    }

    private class Node{
        private T value;
        private Node next;

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }
}

public class SingleDirectionListDemo {
    public static void main(String[] args) {
        SingleDirectionList<String> sdl = new SingleDirectionList<>();
        sdl.add("first").add("second").add("third");
        System.out.println(sdl.getNode("second"));
        System.out.println(sdl);
    }
}
