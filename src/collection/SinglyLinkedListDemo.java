package collection;

class SinglyLinkedList<T> {

    private Node head = null;

    public Node findByValue(T data) {
        Node p = head;
        while(p != null && !p.data.equals(data)) {
            p = p.next;
        }
        return p;
    }

    public Node findByIndex(int index) {
        Node p = head;
        int pos = 0;
        while(p != null && pos != index) {
            p = p.next;
            ++pos;
        }
        return p;
    }

    public void insertToHead(T t) {
        Node<T> newNode = new Node<>(t,null);
        insertToHead(newNode);
    }

    public void insertToHead(Node newNode) {
        if(head == null) {
            head = newNode;
        }else{
            newNode.next = head;
            head = newNode;
        }
    }

    public void insertToTail(T t) {
        Node<T> newNode = new Node<>(t,null);
        if(head == null) {
            head = newNode;
        }else{
            Node p = head;
            while(p.next != null) {
                p = p.next;
            }
            //newNode.next = p.next;//可省略
            p.next = newNode;
        }
    }

    public void insertAfter(Node p, T t) {
        Node<T> newNode = new Node<>(t,null);
        insertAfter(p,newNode);
    }

    public void insertAfter(Node p, Node newNode) {
        if(p == null) return;
        newNode.next = p.next;
        p.next = newNode;
    }

    public void insertBefore(Node p, T t) {
        Node<T> newNode = new Node<>(t,null);
        insertBefore(p,newNode);
    }

    public void insertBefore(Node p, Node newNode) {
        if(p == null) return;
        if(p == head) {
            insertToHead(newNode);
        }else{
            Node parent = head;
            while(parent != null && p != parent.next) {
                parent = parent.next;
            }
            if(parent == null) return;
            newNode.next = p;
            parent.next = newNode;
        }

    }

    public void deleteByNode(Node p) {
        if(p == null || head == null) return;
        if(p == head) {
            head = head.next;
        }else{
            Node q = head;
            while(q != null && p != q.next) {
                q = q.next;
            }
            if(q == null) return;
            q.next = q.next.next;
        }
    }

    public void deleteByValue(T t) {
        if(head == null) return;
        Node p = head;
        Node q = null;
        while(p != null && !p.getData().equals(t)) {
            q = p;
            p = p.next;
        }
        if(p == null) return;
        if(q == null) {
            head = head.next;
        }else{
            q.next = q.next.next;
        }
    }

    public void printAll() {
        Node p = head;
        while(p != null) {
            System.out.print(p.data + ",");
            p = p.next;
        }
        System.out.println();
    }

    /**
     * 链表反转
     */
    @SuppressWarnings("unchecked")
    public void reverse() {
        Node h = head;
        head = null;
        while(h != null) {
            insertToHead((T)h.getData());
            h = h.next;
        }
    }

    /**
     * 获取反转之后的新链表
     * @return 新链表
     */
    @SuppressWarnings("unchecked")
    public SinglyLinkedList<T> getReverse() {
        SinglyLinkedList<T> newList = new SinglyLinkedList();
        Node h = head;
        while(h != null) {
            newList.insertToHead((T)h.getData());
            h = h.next;
        }
        return newList;
    }

    /**
     * 判断是否为回文链表
     * @return 是/否
     */
    public boolean isPalindromic() {
        Node h = head;
        Node r = getReverse().head;
        while(h != null && r != null) {
            if(h.getData().equals(r.getData())) {
                h = h.next;
                r = r.next;
            }else{
                return false;
            }
        }
        return true;
    }

    public static class Node<T> {
        private T data;
        private Node next;

        public Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }

        public T  getData() {
            return data;
        }
    }
}

public class SinglyLinkedListDemo {
    public static void main(String[] args) {
        SinglyLinkedList<String> linkedList = new SinglyLinkedList<>();
        linkedList.printAll();
        linkedList.insertToTail("first");
        linkedList.printAll();
        System.out.printf("is palindromic ? %s%n",linkedList.isPalindromic());
        linkedList.insertToTail("second");
        linkedList.printAll();
        linkedList.insertToHead("third");
        linkedList.printAll();
        linkedList.insertToHead("four");
        linkedList.printAll();
        linkedList.insertToTail("five");
        System.out.printf("is palindromic ? %s%n",linkedList.isPalindromic());
        linkedList.printAll();
        linkedList.reverse();
        linkedList.printAll();
        linkedList.deleteByValue("second");
        linkedList.printAll();

        linkedList.deleteByNode(linkedList.findByValue("five"));
        linkedList.printAll();
        linkedList.deleteByNode(linkedList.findByIndex(0));
        linkedList.printAll();
        linkedList.deleteByNode(linkedList.findByIndex(5));
        linkedList.printAll();
    }
}
