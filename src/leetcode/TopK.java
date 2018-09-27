package leetcode;

import java.util.Arrays;

/**
 * 问题描述：从arr[1,n]这n个数中，找出最大的k个数。
*/
public class TopK {

    /**
     * 方法一，全部排序：将n个数排序之后，取出最大的k个数；时间复杂度：O(n*lg(n));
     * @param arr
     * @return
     */
    public static void sortAll(int[] arr) {
        int temp = 0;
        for(int i = 0; i < arr.length-1; i++) {
            for(int j = i+1; j < arr.length; j++){
                if(arr[i] < arr[j]) {
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    /**
     * 方法二，部分排序，只排序最大的k个数
     * @param arr
     * @param k
     */
    public static void sortPart(int[] arr, int k) {
        int temp = 0;
        for(int i = 0; i < arr.length-1; i++) {
            for(int j = i+1; j < arr.length; j++){
                if(arr[i] < arr[j]) {
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
            if(i == k) break;
        }
    }

    public static int[] topK(int[] arr, int k) {
//        sortAll(arr);
        sortPart(arr,k);
        return Arrays.copyOfRange(arr,0, k);
    }

    public static void main(String[] args) {
        int[] arr = {12, 4, 6, 2, 7, 45, 23, 98, 0, 54,123, 8};
        System.out.println(Arrays.toString(arr));
//        System.out.println(Arrays.toString(topK(arr,5)));
//        System.out.println(Arrays.toString(arr));
        new HeapSort(arr).sort();
        System.out.println(Arrays.toString(arr));
    }
}

/**
 * 堆通常用一维数组来实现，在数组起始位置为0的情形中：
 * 父节点i的左子节点在位置(2*i + 1);
 * 父节点i的右子节点在位置(2*i + 2);
 * 子节点i的父节点在位置floor((i - 1)/2);
 */
class HeapSort {
    private int[] arr;

    public HeapSort(int[] arr) {
        this.arr = arr;
    }

    /**
     * 堆排序的主要入口方法，共两步。
     */
    public void sort() {
        /**
         * 第一步：将数组堆化
         * rootIndex是第一个非叶子节点
         * 从第一个非叶子节点开始即可，无需从最后一个叶子节点开始。
         * 叶子节点可以看作已符合堆要求的节点，根节点就是它自己和自己以下节点中值最大的。
         */
        int len = arr.length - 1;
        int rootIndex = (len - 1) >> 1;
        for(int i = rootIndex; i >= 0; i--) {
            minHeapify(i, len);
        }
        /**
         * 第二步，对堆化数据排序
         * 每次都移出最顶层的根节点A[0]，与最尾部节点位置调换，同时遍历长度-1。
         * 然后重新整理被换到根节点的末尾元素，使其符合堆的特性。
         * 直至未排序的堆长度为0。
         */
        for(int i = len; i > 0; i--) {
            swap(0,i);
            minHeapify(0,i-1);
        }
    }

    private void swap(int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * 调整索引为index处的数据，使其符合堆的特性
     * @param index 需要堆化处理的数据的索引
     * @param len 未排序的堆（数组）的长度
     */
    private void minHeapify(int index, int len) {
        int li = (index << 1) + 1;  // 左子节点索引
        int ri = li + 1;            // 右子节点索引
        int min = li;               // 值最小的子节点索引，默认左子节点
        if(li > len) return;        // 左子节点索引超出计算范围，直接返回
        if(ri <= len && arr[ri] < arr[min]) { // 先判断左右子节点哪个比较小
            min = ri;
        }
        if(arr[min] < arr[index]) {
            swap(min, index);       // 如果父节点被子节点调换，
            minHeapify(min,len);    // 则需要继续判断换下去的父节点是否符合堆的特性。
        }
    }

    /**
     * 测试用例
     *
     * 输出：
     * [123, 98, 54, 45, 23, 12, 8, 7, 6, 4, 2, 0]
     * @param args
     */
    public static void main(String[] args) {
        int[] arr = {12, 4, 6, 2, 7, 45, 23, 98, 0, 54,123, 8};
        new HeapSort(arr).sort();
        System.out.println(Arrays.toString(arr));
    }
}
