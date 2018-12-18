package pattern;

interface Iterator<T>{
    boolean hasNext();
    T next();
}

interface Aggregate<T> {
    Iterator<T> iterator();
}

class IteratorList<T> implements Aggregate<T>{
    Object[] ts;
    int index;
    public IteratorList(int capacity) {
        ts = new Object[capacity];
    }

    public void add(T t) {
        if(index >= ts.length) return;
        ts[index++] = t;
    }


    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int i;
            @Override
            public boolean hasNext() {
                return i < index;
            }

            @Override
            @SuppressWarnings("unchecked")
            public T next() {
                return (T)ts[i++];
            }
        };
    }
}

public class IteratorPattern {
    public static void main(String[] args) {
        IteratorList<String> iteratorList = new IteratorList<>(5);
        iteratorList.add("first");
        iteratorList.add("second");
        iteratorList.add("third");
        iteratorList.add("four");
        iteratorList.add("five");
        iteratorList.add("six");

        Iterator iterator = iteratorList.iterator();
        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
