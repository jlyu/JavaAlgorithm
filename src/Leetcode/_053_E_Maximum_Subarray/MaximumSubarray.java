package Leetcode._053_E_Maximum_Subarray;
/*
Given an integer array nums, find the contiguous subarray (containing at least one number)
which has the largest sum and return its sum.

Example:

Input: [-2,1,-3,4,-1,2,1,-5,4],
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.

Follow up:

If you have figured out the O(n) solution,
try coding another solution using the divide and conquer approach, which is more subtle.


https://leetcode-cn.com/problems/maximum-subarray

 */
public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        if (nums.length == 1) { return nums[0]; }
        int maxValue = nums[0];
        for (int i = 1; i < nums.length; i++) {
            nums[i] = Math.max(nums[i] + nums[i - 1], nums[i]);
            maxValue = Math.max(nums[i], maxValue);
        }
        return maxValue;
    }

    public void unittest1() {
        System.out.println(maxSubArray(new int[] {-2,1,-3,4,-1,2,1,-5,4}));
        System.out.println(maxSubArray(new int[] {-2,9,-13,4,-1,2,1,-5,4}));
        System.out.println(maxSubArray(new int[] {-1,-2}));
    }

    public static void main(String[] args) {
        MaximumSubarray a = new MaximumSubarray();
        a.unittest1();
    }
}
