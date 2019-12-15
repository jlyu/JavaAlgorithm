package Leetcode._152_M_Maximum_Product_Subarray;
/*
Given an integer array nums, find the contiguous subarray within an array (containing at least one number) which has the largest product.

Example 1:

Input: [2,3,-2,4]
Output: 6
Explanation: [2,3] has the largest product 6.
Example 2:

Input: [-2,0,-1]
Output: 0
Explanation: The result cannot be 2, because [-2,-1] is not a subarray.


https://leetcode-cn.com/problems/maximum-product-subarray

 */
public class MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        if (nums.length == 1) { return nums[0]; }
        int maxValue = nums[0];
        int minValue = nums[0];
        int[][] dp = new int[nums.length][2];
        dp[0][0] = nums[0];
        dp[0][1] = nums[0];
        for (int i = 1; i < nums.length; i++) {

            dp[i][0] = Math.max(dp[i - 1][0] * nums[i], Math.max(dp[i - 1][1] * nums[i], nums[i]));
            dp[i][1] = Math.min(dp[i - 1][0] * nums[i], Math.min(dp[i - 1][1] * nums[i], nums[i]));


            maxValue = Math.max(dp[i][0], maxValue);
        }
        return maxValue;
    }

    public void unittest1() {
        System.out.println(maxProduct(new int[] {2,-5,-2,-4,3}));
    }

    public static void main(String[] args) {
        MaximumProductSubarray a = new MaximumProductSubarray();
        a.unittest1();
    }
}
