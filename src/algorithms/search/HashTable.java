package algorithms.search;

public class HashTable<E> {

    private DataItem[] items;
    private int count;

    public HashTable(int length) {
        if(length >= 0) items = new DataItem[length];
        else System.out.println("Invalid length: " + length);
    }

    @SuppressWarnings("unchecked")
    public void insert(int key, E item) {
        if(get(key) != null) {
            System.out.println("this key is already exist.");
            return;
        }
        if(count >= items.length) {
            System.out.println("Hash Table is full.");
            return;
        }
        int index = hash(key);
        while(items[index] != null) {
            index = hash(++index);
        }
        DataItem<E> dataItem = new DataItem<>(key,item);
        items[index] = dataItem;
        count++;
    }

    @SuppressWarnings("unchecked")
    public E get(int key) {
        int index = hash(key);
        int loop = 0;
        while(items[index] != null && items[index].key != key && loop < items.length) {
            index = hash(++index);
            loop++;
        }
        if(items[index] != null && items[index].key == key) {
            return (E) items[index].item;
        }
        return null;
    }

    public DataItem remove(int key) {
        DataItem item = null;
        int index = hash(key);
        int loop = 0;
        while(items[index] != null && items[index].key != key && loop < items.length) {
            index = hash(++index);
            loop++;
        }
        if(items[index] != null && items[index].key == key) {
            item = items[index];
            items[index] = null;
            count--;
        }
        return item;
    }

    public String toString() {
        String result = "{";
        for(DataItem item : items) {
            if(item != null)
                result += item.key + ":" + item.item + ",";
        }
        result = result.substring(0, result.length() - 1);
        result += "}";
        return result;
    }

    private int hash(int key) {
        return key % items.length;
    }

    private static class DataItem<E> {
        E item;
        int key;
        public DataItem(int key, E item) {
            this.item = item;
            this.key = key;
        }

        public String toString() {
            return "key:" + key + ",value:" + item;
        }
    }

    public static void main(String[] args) {
        HashTable<String> table = new HashTable<>(5);
        table.insert(12,"one");
        table.insert(43,"two");
        table.insert(98,"three");
        table.insert(23,"four");
        table.insert(87, "five");
        table.insert(33,"six");
        System.out.println(table);
        System.out.println(table.get(23));
        System.out.println(table.get(88));
        System.out.println(table.get(98));
        System.out.println(table.remove(87));
        System.out.println(table.remove(90));
        System.out.println(table);
        table.insert(44,"seven");
        System.out.println(table);
    }
}
