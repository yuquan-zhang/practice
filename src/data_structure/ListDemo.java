package data_structure;

public class ListDemo<E> {

    private static final Object[] EMPTY = {};
    private Object[] elements;
    private int current;

    public ListDemo(int length) {
        if(length > 0)
            elements = new Object[length];
        else if(length == 0)
            elements = EMPTY;
        else
            throw new IllegalArgumentException("Invalid length " + length);
    }

    public void add(E item) {
        if(current < elements.length) elements[current++] = item;
    }

    public void delete() {
        if(current > 0) elements[--current] = null;
    }

    public void insert(int index, E item) {
        if(checkRange(index)) {
            int k = elements.length - 1;
            while(k > index) {
                elements[k] = elements[k-1];
                k--;
            }
            elements[index] = item;
            if(current < elements.length - 1) current++;
        }else{
            throw new ArrayIndexOutOfBoundsException("index " + index + " >= " + elements.length);
        }
    }

    public void remove(int index) {
        if(checkRange(index)) {
            int k = elements.length - 1;
            while(index < k) {
                elements[index] = elements[index+1];
                index++;
            }
            elements[k] = null;
            if(current > 0) current--;
        }
    }

    public void set(int index, String item) {
        if(checkRange(index))
            elements[index] = item;
    }

    @SuppressWarnings("unchecked")
    public E get(int index) {
        if(checkRange(index)) return (E) elements[index];
        else return null;
    }

    public boolean checkRange(int index) {
        return index >= 0 && index < elements.length;
    }

    public String toString() {
        String result = "[";
        for(int i = 0; i < elements.length; i++) {
            result += elements[i] + ",";
        }
        result = result.substring(0,result.length() - 1);
        result += "]";
        return result;
    }

    public static void main(String[] args) {
        ListDemo<String> group = new ListDemo<>(5);
        group.add("first");
        group.add("second");
        group.add("three");
        System.out.println(group);
        group.insert(2,"aaa");
        System.out.println(group);

        group.remove(2);
        System.out.println(group);

        group.delete();
        System.out.println(group);

        group.add("five");
        System.out.println(group);

        String c = group.get(1);
        System.out.println(c);
    }
}
