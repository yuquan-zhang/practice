package data_structure;

public class Group {
    private String[] array;
    private int current;

    public Group(int length) {
        array = new String[length];
    }

    public void add(String item) {
        if(current < array.length) array[current++] = item;
    }

    public void insert(int index, String item) {
        if(index < array.length && index >= 0) {
            int k = array.length - 1;
            while(k > index) {
                array[k] = array[k-1];
                k--;
            }
            array[index] = item;
            if(current < array.length - 1) current++;
        }else{
            throw new ArrayIndexOutOfBoundsException("index " + index + " >= " + array.length);
        }
    }

    public void remove(int index) {
        if(index < array.length && index >= 0) {
            int k = array.length - 1;
            while(index < k) {
                array[index] = array[index+1];
                index++;
            }
            array[k] = null;
            if(current > 0) current--;
        }
    }

    public void set(int index, String item) {
        if(index >= 0 && index < array.length)
            array[index] = item;
    }

    public String get(int index) {
        if(index < array.length && index >= 0) return array[index];
        else return null;
    }

    public void delete() {
        if(current > 0) array[--current] = null;
    }



    public String toString() {
        String result = "[";
        for(int i = 0; i < array.length; i++) {
            result += array[i] + ",";
        }
        result = result.substring(0,result.length() - 1);
        result += "]";
        return result;
    }

    public static void main(String[] args) {
        Group group = new Group(5);
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
    }
}
