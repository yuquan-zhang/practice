package algorithms.sort;

public class MergeSort {
    private int[] a = {12,3,56,9,5,11,45,32,2,90,33};
    private int[] b = new int[11];
    private int loops = 0;

    public int[] mergeSort(int[] source) {
        if(source.length == 1) return source;
        int loop = 0;

        System.out.println("count:" + source.length + ",loop=" + loop);
        return merge(null,null);
    }

    public int[] merge(int[] left, int[] right) {
        int[] merge = new int[left.length + right.length];

        return merge;
    }

    public void merging(int low, int mid, int high) {
        int l1, l2, i;

        for(l1 = low, l2 = mid + 1, i = low; l1 <= mid && l2 <= high; i++) {
            loops++;
            if(a[l1] <= a[l2])
                b[i] = a[l1++];
            else
                b[i] = a[l2++];
        }

        while(l1 <= mid){
            b[i++] = a[l1++];loops++;
        }

        while(l2 <= high){
            b[i++] = a[l2++];loops++;
        }

        for(i = low; i <= high; i++){
            a[i] = b[i];loops++;
        }

    }

    public void sort(int low, int high) {
        int mid;

        if(low < high) {
            mid = (low + high) / 2;
            sort(low, mid);
            sort(mid+1, high);
            merging(low, mid, high);
        } else {
            return;
        }
    }

    public String toString() {
        String result = "[";
        for(int i : a) result += i + ",";
        if(result.length() > 1) result = result.substring(0, result.length() - 1);
        result += "]";
        return result;
    }

    public static void main(String[] args) {
        MergeSort sort = new MergeSort();
        System.out.println(sort);
        sort.sort(0,10);
        System.out.println("loops="+sort.loops);
        System.out.println(sort);
    }
}
