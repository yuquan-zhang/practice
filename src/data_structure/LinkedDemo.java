package data_structure;

import java.util.LinkedList;

public class LinkedDemo<E> {

    private Link<E> first;

    public LinkedDemo(E e) {
        first = new Link<>(e);
    }

    public void add(E e) {
        Link<E> newFirst = new Link<>(e);
        newFirst.setNext(first);
        first = newFirst;
    }

    public E get() {
        return first.getElement();
    }

    public void remove() {
        first = first.next;
    }

    public String toString() {
        String result = "[";
        Link<E> temp = first;
        do{
            result += temp.getElement() + ",";
            temp = temp.next;
        }while(temp != null);
        result = result.substring(0,result.length() - 1);
        result += "]";
        return result;
    }

    private class Link<E> {
        private E element;
        private Link<E> next;

        Link(E e) {
            element = e;
            next = null;
        }

        void setNext(Link<E> eLink) {
            next = eLink;
        }

        E getElement() {
            return element;
        }
    }

    public static void main(String[] args) {
        LinkedDemo<String> demo = new LinkedDemo<>("first");
        demo.add("second");
        demo.add("third");
        System.out.println(demo);
        String a = demo.get();
        System.out.println(a);
        System.out.println(demo);
        demo.remove();
        System.out.println(demo);

        LinkedList<String> strings = new LinkedList<>();
    }


}
