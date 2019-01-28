package algorithms.search;

public class BinarySearch2 {

    public static int search(int[] sorted, int target) {
        int low = 0;
        int high = sorted.length-1;
        int mid;
        while(low <= high) {
            mid = low + ((high - low) >> 1);
            if(sorted[mid] == target) {
                return mid;
            }else if(sorted[mid] > target){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return -1;
    }

    /**
     * 查找第一个 值等于给定值的元素
     * @param sorted
     * @param target
     * @return
     */
    public static int searchFirst(int[] sorted, int target) {
        int low = 0;
        int high = sorted.length-1;
        int mid;
        while(low <= high) {
            mid = low + ((high - low) >> 1);
            if(sorted[mid] >= target){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        if(low < sorted.length && sorted[low] == target) return low;
        return -1;
    }

    public static int searchFirst2(int[] sorted, int target) {
        int low = 0;
        int high = sorted.length-1;
        int mid;
        while(low <= high) {
            mid = low + ((high - low) >> 1);
            if(sorted[mid] > target){
                high = mid - 1;
            }else if(sorted[mid] < target){
                low = mid + 1;
            }else{
                if(mid == 0 || sorted[mid-1] != target) return mid;
                else high = mid -1;
            }
        }
        return -1;
    }

    /**
     * 查找最后一个 值等于给定值的元素
     * @param sorted
     * @param target
     * @return
     */
    public static int searchLast(int[] sorted, int target) {
        int low = 0;
        int high = sorted.length-1;
        int mid;
        while(low <= high) {
            mid = low + ((high - low) >> 1);
            if(sorted[mid] > target){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        if(high < sorted.length && sorted[high] == target) return high;
        return -1;
    }

    public static int searchLast2(int[] sorted, int target) {
        int low = 0;
        int high = sorted.length-1;
        int mid;
        while(low <= high) {
            mid = low + ((high - low) >> 1);
            if(sorted[mid] > target){
                high = mid - 1;
            }else if(sorted[mid] < target){
                low = mid + 1;
            }else{
                if(mid == 0 || sorted[mid+1] != target) return mid;
                else low = mid + 1;
            }
        }
        return -1;
    }

    /**
     * 查找第一个 值大于等于给定值的元素
     * @param sorted
     * @param target
     * @return
     */
    public static int searchFirstGQ(int[] sorted, int target) {
        int low = 0;
        int high = sorted.length-1;
        int mid;
        while(low <= high) {
            mid = low + ((high - low) >> 1);
            if(sorted[mid] < target){
                low = mid - 1;
            }else{
                if(mid == 0 || sorted[mid-1] < target) return mid;
                else high = mid + 1;
            }
        }
        return -1;
    }

    /**
     * 查找最后一个 值小于等于给定值的元素
     * @param sorted
     * @param target
     * @return
     */
    public static int searchLastLQ(int[] sorted, int target) {
        int low = 0;
        int high = sorted.length-1;
        int mid;
        while(low <= high) {
            mid = low + ((high - low) >> 1);
            if(sorted[mid] > target){
                high = mid - 1;
            }else{
                if(mid == 0 || sorted[mid+1] > target) return mid;
                else low = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] sorted = {1,2,3,4,7,7,7,8,9,11,13,99};
        System.out.println(search(sorted,7));
        System.out.println(searchFirst(sorted,7));
        System.out.println(searchFirst2(sorted,7));
        System.out.println(searchLast(sorted,7));
        System.out.println(searchLast2(sorted,7));
        System.out.println(searchLastLQ(sorted,7));
        System.out.println(searchFirstGQ(sorted,7));
    }
}
