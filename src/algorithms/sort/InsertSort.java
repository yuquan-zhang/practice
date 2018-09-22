package algorithms.sort;

public class InsertSort {
    private int[] ints = {12,3,56,9,5,11,45,32,2,90,33};

    public void insertSort(int[] source) {
        int loop = 0;
        int valueToInsert;
        int holePosition;
        for(int i = 1; i < source.length; i++) {
            valueToInsert = source[i];
            holePosition = i;
            while (holePosition > 0 && source[holePosition-1] > valueToInsert) {
                loop++;
                source[holePosition] = source[holePosition-1];
                holePosition--;
            }
            source[holePosition] = valueToInsert;
        }
        System.out.println("count:" + source.length + ",loop=" + loop);
    }

    public String toString() {
        String result = "[";
        for(int i : ints) result += i + ",";
        if(result.length() > 1) result = result.substring(0, result.length() - 1);
        result += "]";
        return result;
    }

    public static void main(String[] args) {
        InsertSort sort = new InsertSort();
        System.out.println(sort);
        sort.insertSort(sort.ints);
        System.out.println(sort);

    }
}
