package algorithms.sort;

import java.util.Arrays;

public class MergeSort2 {

    public static void mergeSort(int[] arr) {
        mergeSortImpl(arr, 0, arr.length-1);
    }

    private static void mergeSortImpl(int[] arr, int fi, int li) {
        if(fi >= li) return;
        int mi = (fi + li) / 2;
        mergeSortImpl(arr, fi, mi);
        mergeSortImpl(arr, mi+1, li);
        merge(arr,fi,mi,li);
    }

    private static void merge(int[] arr, int fi, int mi, int li) {
        int[] temp = new int[li-fi+1];
        int ti = 0;
        int i,j;
        for(i = fi, j = mi+1; i <= mi && j <= li;) {
            if(arr[i] <= arr[j]) {
                temp[ti++] = arr[i++];
            }else{
                temp[ti++] = arr[j++];
            }
        }
        if(i <= mi) {
            for(; i <= mi; i++) {
                temp[ti++] = arr[i];
            }
        }
        if(j <= li) {
            for(; j <= li; j++) {
                temp[ti++] = arr[j];
            }
        }
        for(int k = fi; k <= li; k++) {
            arr[k] = temp[k-fi];
        }
    }

    public static void main(String[] args) {
        int[] ints = {3,2,5,7,1,9,8,4,0,6};
        mergeSort(ints);
        System.out.println(Arrays.toString(ints));
    }
}
