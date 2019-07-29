package data_structure;


public class Heap<E extends Comparable<E>>{

    private Object[] elements;
    private int capacity;
    private int count;

    public Heap(int capacity) {
        this.elements = new Object[capacity + 1];
        this.count = 0;
        this.capacity = capacity;
    }

    public void insert(E e) {
        if (count >= capacity) return;
        ++count;
        elements[count] = e;
        heapify(count, false);
    }

    @SuppressWarnings("unchecked")
    public E deleteTop() {
        if (count <= 0) return null;
        E top = (E)elements[1];
        elements[1] = elements[count];
        --count;
        heapify(1, true);
        return top;
    }

    @SuppressWarnings("unchecked")
    private void heapify(int index, boolean isUpToDown) {
        if (isUpToDown) {
            while (true) {
                int li = index * 2, ri = index * 2 + 1;
                if (li > count) break;
                E c = (E)elements[index], le = (E)elements[li];
                if (ri > count) {
                    if (le.compareTo(c) > 0) {
                        swap(index, li);
                        index = li;
                    } else break;
                } else {
                    E re = (E)elements[ri];
                    if (re.compareTo(le) > 0) {
                        if (re.compareTo(c) > 0) {
                            swap(index, ri);
                            index = ri;
                        } else break;
                    } else {
                        if (le.compareTo(c) > 0) {
                            swap(index, li);
                            index = li;
                        } else break;
                    }
                }

            }
        } else {
            while (index / 2 > 0) {
                E c = (E)elements[index];
                E p = (E)elements[index / 2];
                if (c.compareTo(p) > 0) {
                    swap(index, index / 2);
                }
                index = index / 2;
            }
        }
    }

    private void swap(int a, int b) {
        Object t = elements[a];
        elements[a] = elements[b];
        elements[b] = t;
    }

    public static void main(String[] args) {
        Heap<String> heap = new Heap<>(50);
        String[] ints = {"a","b","c","g","e","f"};
        for (String i : ints) {
            heap.insert(i);
        }
        System.out.println(heap.deleteTop());
    }

}
