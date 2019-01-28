package algorithms.sort;

import java.util.Arrays;

public class FindTopK {

    public static int find(int[] arr, int k) {
        return quickSort(arr,0,arr.length-1,k);
    }

    private static int quickSort(int[] arr, int li, int ri, int k) {
        if(li > ri || k < 1 || k > ri+1) return Integer.MIN_VALUE;
        int q = partition(arr, li, ri);
        if(k == q+1) return arr[q];
        if(k < q+1) return quickSort(arr,li, q-1,k);
        if(k > q+1) return quickSort(arr, q + 1, ri,k);
        return Integer.MIN_VALUE;
    }

    private static int partition(int[] arr, int li, int ri) {
        int pivot = arr[ri];
        int lp = li;
        int rp = ri-1;
        while(true) {
            while(arr[lp] > pivot) {
                lp++;
            }
            while(rp > 0 && arr[rp] <= pivot) {
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
//        quickSort(ints,0,ints.length-1);
        System.out.println(Arrays.toString(ints));
        System.out.println(find(ints,1));
    }
}
