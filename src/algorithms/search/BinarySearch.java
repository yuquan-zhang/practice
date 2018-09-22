package algorithms.search;

public class BinarySearch {
    private int[] sortedArray = {12,15,17,24,28,31,56,78,99};

    public int binarySearch(int target) {
        int index = -1;
        int low = 0;
        int high = sortedArray.length - 1;
        int count = 0;
        while(low <= high) {
            count++;
            int mid = low + (high - low)/2;
            if(sortedArray[mid] == target) {
                index = mid;
                break;
            }else if(sortedArray[mid] > target) {
                high = mid - 1;
            }else {
                low = mid + 1;
            }
        }
        System.out.println("count: " + count);
        return index;
    }

    public static void main(String[] args) {
        BinarySearch bs = new BinarySearch();
        System.out.println(bs.binarySearch(12));
        System.out.println(bs.binarySearch(43));
        System.out.println(bs.binarySearch(99));
    }
}
