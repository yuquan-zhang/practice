package algorithms.sort;

public class BubbleSort {
    private int[] ints = {12,3,56,9,5,11,45,32,2,90,33};

    public void bubbleSort(int[] source) {
        int loop = 0;
        for(int i = 0; i < source.length; i++) {
            for (int j = i + 1; j < source.length; j++) {
                loop++;
                if(source[i] > source[j]) {
                    int temp = source[i];
                    source[i] = source[j];
                    source[j] = temp;
                }
            }
        }
        System.out.println("count:" + source.length + ",loop=" + loop);
        System.out.println("the complexity is O(n^2): (n*n - n)/2 ");
    }

    public String toString() {
        String result = "[";
        for(int i : ints) result += i + ",";
        if(result.length() > 1) result = result.substring(0, result.length() - 1);
        result += "]";
        return result;
    }

    public static void main(String[] args) {
        BubbleSort sort = new BubbleSort();
        System.out.println(sort);
        sort.bubbleSort(sort.ints);
        System.out.println(sort);

    }
}
