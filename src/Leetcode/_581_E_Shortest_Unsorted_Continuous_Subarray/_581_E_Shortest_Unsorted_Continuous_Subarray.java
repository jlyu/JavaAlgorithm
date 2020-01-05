package Leetcode._581_E_Shortest_Unsorted_Continuous_Subarray;

import java.util.Arrays;

/*
Given an integer array, you need to find one continuous subarray that if you only sort this subarray in ascending order,
then the whole array will be sorted in ascending order, too.

You need to find the shortest such subarray and output its length.

Example 1:
Input: [2, 6, 4, 8, 10, 9, 15]
Output: 5
Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the whole array sorted in ascending order.
Note:
Then length of the input array is in range [1, 10,000].
The input array may contain duplicates, so ascending order here means <=.


https://leetcode-cn.com/problems/shortest-unsorted-continuous-subarray

 */
public class _581_E_Shortest_Unsorted_Continuous_Subarray {
    public int findUnsortedSubarray_(int[] nums) {
        int[] copy = Arrays.copyOf(nums, nums.length);
        Arrays.sort(copy);
        int start = -1, end = nums.length;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != copy[i]) {
                start = i;
                break;
            }
        }
        for (int j = nums.length - 1; j >= 0; j--) {
            if (nums[j] != copy[j]) {
                end = j;
                break;
            }
        }

        int distance = end - start + 1;
        return (start < 0 && end >= nums.length) ? 0 : distance;
    }
    public int findUnsortedSubarray(int[] nums) {
        int[] copy = nums.clone();
        Arrays.sort(copy);
        int start = nums.length, end = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != copy[i]) {
                start = Math.min(start, i);
                end = Math.max(end, i);
            }
        }
        return (end - start < 0) ? 0 : end - start + 1;
    }

    public void unittest1() {
        int res = findUnsortedSubarray(new int[] {2,6,4,8,10,9,15});
        System.out.println(res);
    }

    public static void main(String[] args) {
        _581_E_Shortest_Unsorted_Continuous_Subarray a = new _581_E_Shortest_Unsorted_Continuous_Subarray();
        a.unittest1();
    }
}
