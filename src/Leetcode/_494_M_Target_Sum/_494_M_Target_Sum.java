package Leetcode._494_M_Target_Sum;
/*
You are given a list of non-negative integers, a1, a2, ..., an, and a target, S.
Now you have 2 symbols + and -. For each integer, you should choose one from + and - as its new symbol.

Find out how many ways to assign symbols to make sum of integers equal to target S.

Example 1:
Input: nums is [1, 1, 1, 1, 1], S is 3.
Output: 5
Explanation:

-1+1+1+1+1 = 3
+1-1+1+1+1 = 3
+1+1-1+1+1 = 3
+1+1+1-1+1 = 3
+1+1+1+1-1 = 3

There are 5 ways to assign symbols to make the sum of nums be target 3.
Note:
The length of the given array is positive and will not exceed 20.
The sum of elements in the given array will not exceed 1000.
Your output answer is guaranteed to be fitted in a 32-bit integer.


https://leetcode-cn.com/problems/target-sum
 */

/*
用 dp[i][j] 表示用数组中的前 i 个元素，组成和为 j 的方案数。考虑第 i 个数 nums[i]，它可以被添加 + 或 -，因此状态转移方程如下：

dp[i][j] = dp[i - 1][j - nums[i]] + dp[i - 1][j + nums[i]]

也可以写成递推的形式：
dp[i][j + nums[i]] += dp[i - 1][j]
dp[i][j - nums[i]] += dp[i - 1][j]

 */
public class _494_M_Target_Sum {
    public int findTargetSumWays_DP(int[] nums, int S) {
        int[][] dp = new int[nums.length][2001];
        dp[0][ nums[0] + 1000]  = 1;
        dp[0][-nums[0] + 1000] += 1;
        for (int i = 1; i < nums.length; i++) {
            for (int sum = -1000; sum <= 1000; sum++) {
                if (dp[i - 1][sum + 1000] > 0) {
                    dp[i][sum + nums[i] + 1000] += dp[i - 1][sum + 1000];
                    dp[i][sum - nums[i] + 1000] += dp[i - 1][sum + 1000];
                }
            }
        }
        return S > 1000 ? 0 : dp[nums.length - 1][S + 1000];
    }

    public int findTargetSumWays_dfs(int[] nums, int S) {
        return findTargetSumWays_dfs(nums, 0, S);
    }
    private int findTargetSumWays_dfs(int[] nums, int start, int S) {
        if (start == nums.length) {
            return S == 0 ? 1 : 0;
        }
        return findTargetSumWays_dfs(nums, start + 1, S - nums[start])
             + findTargetSumWays_dfs(nums, start + 1, S + nums[start]);
    }

    public int findTargetSumWays_01(int[] nums, int S) {
        // same as 416
        int sum = 0;
        for (int num : nums) { sum += num; }
        if (sum < S || (sum + S) % 2 == 1) { return 0; }

        int target = (sum + S) / 2;
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int num: nums) {
            for (int i = target; i >= num; i--) {
                dp[i] += dp[i - num];
            }
        }
        return dp[target];
    }
}

