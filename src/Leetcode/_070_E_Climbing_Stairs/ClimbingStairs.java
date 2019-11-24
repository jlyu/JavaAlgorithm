package Leetcode._070_E_Climbing_Stairs;

/*
You are climbing a stair case. It takes n steps to reach to the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

Note: Given n will be a positive integer.

Example 1:

Input: 2
Output: 2
Explanation: There are two ways to climb to the top.
1. 1 step + 1 step
2. 2 steps
Example 2:

Input: 3
Output: 3
Explanation: There are three ways to climb to the top.
1. 1 step + 1 step + 1 step
2. 1 step + 2 steps
3. 2 steps + 1 step


https://leetcode-cn.com/problems/climbing-stairs
 */

public class ClimbingStairs {
    public int climbStairs(int n) {
        if (n < 0) { return 0; }
        if (n < 3) { return n; }

        int[] memo = new int[n + 1];

        memo[0] = 0;
        memo[1] = 1;
        memo[2] = 2;

        for (int i = 3; i <= n; i++) {
            memo[i] = memo[i-1] + memo[i-2];
        }

        return memo[n];
    }

    public void unittest1() {
        System.out.println(climbStairs(1));
        System.out.println(climbStairs(3));
    }

    public static void main(String[] args) {
        ClimbingStairs a = new ClimbingStairs();
        a.unittest1();
    }
}
