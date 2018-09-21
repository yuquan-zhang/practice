package algorithms.search;

public class LinearSearch {
    private String[] strings = new String[]{"one","two","three","four","five"};

    public int searchInArray(String target) {
        int index = -1;
        for(int i = 0; i < strings.length; i++) {
            if(strings[i].equals(target)) index = i;
        }
        return index;
    }

    public static void main(String[] args) {
        LinearSearch ls = new LinearSearch();
        System.out.println(ls.searchInArray("one"));
        System.out.println(ls.searchInArray("six"));
        System.out.println(ls.searchInArray("three"));
    }
}
