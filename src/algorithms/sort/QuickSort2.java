package algorithms.sort;

import java.util.Arrays;

public class QuickSort2 {

    public static void sort(int[] arr) {
        quickSort(arr,0, arr.length-1);
    }

    private static void quickSort(int[] arr, int li, int ri) {
        if(li >= ri) return;
        int q = partition(arr, li, ri);
        quickSort(arr,li, q-1);
        quickSort(arr, q + 1, ri);
    }

    private static int partition(int[] arr, int li, int ri) {
        int pivot = arr[ri];
        int lp = li;
        int rp = ri-1;
        while(true) {
            while(arr[lp] < pivot) {
                lp++;
            }
            while(rp > 0 && arr[rp] >= pivot) {
                rp--;
            }
            if(lp >= rp) break;
            swap(arr,lp,rp);
        }
        if(lp < ri) swap(arr,lp,ri);
        return lp;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] ints = {12,3,56,9,5,11,45,33,2,90,33};
        sort(ints);
        System.out.println(Arrays.toString(ints));
    }
}
