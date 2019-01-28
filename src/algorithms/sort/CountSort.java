package algorithms.sort;

import java.util.Arrays;
import java.util.Random;

/**
 * 计数排序
 */
public class CountSort {

    public static void sort(int[] arr) {
        int len = arr.length;
        int max = arr[0];
        for(int i = 1; i < len; i++) {
            if(arr[i] > max) max = arr[i];
        }
        int[] c = new int[max+1];

        for(int i = 0; i < len; i++) {
            c[arr[i]]++;
        }

        for(int i = 1; i < c.length; i++) {
            c[i] = c[i] + c[i-1];
        }

        int[] r = new int[len];

        for(int i = 0; i < len; i++) {
            int index = c[arr[i]] -1;
            r[index] = arr[i];
            c[arr[i]]--;
        }

        for(int i = 0; i < len; i++) {
            arr[i] = r[i];
        }
    }

    public static void main(String[] args) {
        int[] ints = new int[100];
        Random random = new Random(System.nanoTime());
        for(int i = 0; i < 100; i++) {
            ints[i] = random.nextInt(100);
        }
        System.out.println(Arrays.toString(ints));
        sort(ints);
        System.out.println(Arrays.toString(ints));
    }

}
