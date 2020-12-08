package algorithms.search;

/**
 * @author zhangyong created on 2020/6/29
 **/
public class MedianNumber {

    public static void main(String[] args) {
        System.out.println(new MedianNumber().findMedianSortedArrays(new int[]{2}, new int[]{1,3,4}));
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int total = nums1.length + nums2.length;
        if (total % 2 == 0) {
            int k = total / 2;
            return (findKthElement(nums1,nums2,k) + findKthElement(nums1,nums2,k+1)) / 2.0;
        } else {
            int k = total / 2 + 1;
            return findKthElement(nums1,nums2,k);
        }
    }

    public int findKthElement(int[] nums1, int[] nums2, int k) {
        int l1 = nums1.length, l2 = nums2.length;
        int index1 = 0, index2 = 0;

        while (true) {
            if (index1 == l1) {
                return nums2[index2 + k - 1];
            }
            if (index2 == l2) {
                return nums1[index1 + k - 1];
            }
            if (k == 1) {
                return Math.min(nums1[index1],nums2[index2]);
            }

            int half = k / 2;
            int newInd1 = Math.min(index1 + half, l1) - 1;
            int newInd2 = Math.min(index2 + half, l2) - 1;
            int pivot1 = nums1[newInd1], pivot2 = nums2[newInd2];
            if (pivot1 >= pivot2) {
                k -= newInd2 - index2 +1;
                index2 = newInd2 + 1;
            } else {
                k -= newInd1 - index1 +1;
                index1 = newInd1 + 1;
            }
        }
    }
}
