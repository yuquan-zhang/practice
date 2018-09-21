package algorithms.search;

public class InterpolateSearch {
    private int[] sortedArray = {12,15,18,21,24,27,30,33,36,39,42};

    public int interpolateSearch(int target) {
        int index = -1;
        int low = 0;
        int high = sortedArray.length - 1;
        int count = 0;
        while(low <= high) {
            count++;
            if (sortedArray[high] - sortedArray[low] == 0) {
                if(sortedArray[low] == target) index = low;
                break;
            }
            int mid = low + ((high - low)/(sortedArray[high] - sortedArray[low])) * (target - sortedArray[low]);
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
        InterpolateSearch bs = new InterpolateSearch();
        System.out.println(bs.interpolateSearch(12));
        System.out.println(bs.interpolateSearch(42));
        System.out.println(bs.interpolateSearch(99));
    }
}
