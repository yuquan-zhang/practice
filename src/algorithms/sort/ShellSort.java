package algorithms.sort;

public class ShellSort {
    private int[] ints = {12,3,56,9,5,11,45,32,2,90,33};

    public void shellSort(int[] source) {
        int loop = 0;
        int interval = 0;
        int valueToInsert;
        while(interval < source.length/3) {
            interval = interval * 3 + 1;
        }
        while (interval > 0) {
            for(int outer = interval; outer < source.length; outer++) {
                valueToInsert = source[outer];
                int inner = outer;
                while (inner > interval - 1 && source[inner - interval] >= valueToInsert) {
                    source[inner] = source[inner - interval];
                    inner = inner - interval;
                }
                loop++;
                source[inner] = valueToInsert;
            }
            interval = (interval - 1)/3;
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
        ShellSort sort = new ShellSort();
        System.out.println(sort);
        sort.shellSort(sort.ints);
        System.out.println(sort);

    }
}
