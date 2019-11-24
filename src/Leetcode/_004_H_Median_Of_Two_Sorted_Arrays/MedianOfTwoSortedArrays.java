package Leetcode._004_H_Median_Of_Two_Sorted_Arrays;

/*
There are two sorted arrays nums1 and nums2 of size m and n respectively.

Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).

You may assume nums1 and nums2 cannot be both empty.

Example 1:

nums1 = [1, 3]
nums2 = [2]

The median is 2.0
Example 2:

nums1 = [1, 2]
nums2 = [3, 4]

The median is (2 + 3)/2 = 2.5


链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays
 */

public class MedianOfTwoSortedArrays {
    public int findKth(int[] n1, int i, int[] n2, int j, int k) {

        if( i >= n1.length) return n2[j + k - 1];
        if( j >= n2.length) return n1[i + k - 1];
        if (k == 1) { return Math.min(n1[0], n2[0]); }

        int mid1 = (i + k / 2 - 1 < n1.length) ? n1[i + k / 2 - 1] : Integer.MAX_VALUE;
        int mid2 = (j + k / 2 - 1 < n2.length) ? n2[j + k / 2 - 1] : Integer.MAX_VALUE;

        if (mid1 < mid2) {
            return findKth(n1, i + k / 2, n2, j, k - k / 2);
        } else {
            return findKth(n1, i, n2, j + k / 2, k - k / 2);
        }
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        final int left = (nums1.length + nums2.length + 1) / 2;
        final int right = (nums1.length + nums2.length + 2) / 2;

        return ( findKth(nums1, 0, nums2, 0, left) + findKth(nums1, 0, nums2, 0, right) ) / 2.0;
    }
}
