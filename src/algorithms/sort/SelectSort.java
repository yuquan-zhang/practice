package algorithms.sort;

public class SelectSort {
    private int[] ints = {12,3,56,9,5,11,45,32,2,90,33};

    public void selectSort(int[] source) {
        int loop = 0;
        for(int i = 0; i < source.length-1; i++) {
            int min = i;
            for(int j = i+1; j < source.length; j++) {
                loop++;
                if(source[min] > source[j]) min = j;
            }
            int temp = source[i];
            source[i] = source[min];
            source[min] = temp;
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
        SelectSort sort = new SelectSort();
        System.out.println(sort);
        sort.selectSort(sort.ints);
        System.out.println(sort);

    }
}
