package Leetcode._300_M_Longest_Increasing_Subsequence;
/*
Given an unsorted array of integers, find the length of longest increasing subsequence.

Example:

Input: [10,9,2,5,3,7,101,18]
Output: 4
Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
Note:

There may be more than one LIS combination, it is only necessary for you to return the length.
Your algorithm should run in O(n2) complexity.
Follow up: Could you improve it to O(n log n) time complexity?


https://leetcode-cn.com/problems/longest-increasing-subsequence

 */
public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        final int n = nums.length;
        if (n < 1) { return 0; }
        int[] dp = new int[n + 1];

        dp[0] = 1;
        int maxValue = 1;
        for (int i = 1; i < n; i++) {

            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                int curr = (nums[i] > nums[i - j - 1]) ? dp[i - j - 1] + 1  : 1;
                dp[i] = Math.max(dp[i], curr);
                maxValue = Math.max(maxValue, dp[i]);
            }
        }
        return maxValue;
    }

    public void unittest1() {
        System.out.println( lengthOfLIS(new int[] {10,9,2,5,3,7,101,18}));
        System.out.println( lengthOfLIS(new int[] {10,9,2,5,3,7,0,1,4,8}));
        System.out.println( lengthOfLIS(new int[] {-2,-1}));
    }

    public static void main(String[] args) {
        LongestIncreasingSubsequence a = new LongestIncreasingSubsequence();
        a.unittest1();
    }
}
