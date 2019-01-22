package algorithms.sort;

public class QuickSort {
    private int[] ints = {12,3,56,9,5,11,45,33,2,90,33};
    private int loops = 0;

    public void swap(int a, int b) {
        loops++;
        int temp = ints[a];
        ints[a] = ints[b];
        ints[b] = temp;
    }

    public int partition(int left, int right, int pivot) {
        int leftPointer = left - 1;
        int rightPointer = right;
        while(true) {

            while(ints[++leftPointer] < pivot) {
                // Do nothing.
            }
            while(rightPointer > 0 && ints[--rightPointer] > pivot) {
                // Do nothing.
            }
            if(leftPointer >= rightPointer) {
                break;
            }else{
                swap(leftPointer,rightPointer);
            }
        }
        swap(leftPointer,right);
        return leftPointer;
    }

    public void quickSort(int left, int right) {
        if(right-left <= 0) {
            return;
        } else {
            int pivot = ints[right];
            int partitionPoint = partition(left, right, pivot);
            quickSort(left,partitionPoint-1);
            quickSort(partitionPoint+1,right);
        }
    }

    public String toString() {
        String result = "[";
        for(int i : ints) result += i + ",";
        if(result.length() > 1) result = result.substring(0, result.length() - 1);
        result += "]";
        return result;
    }

    public static void main(String[] args) {
        QuickSort quick = new QuickSort();
        System.out.println(quick);
        quick.quickSort(0,quick.ints.length - 1);
        System.out.println(quick);
        System.out.println(quick.loops);
    }
}
