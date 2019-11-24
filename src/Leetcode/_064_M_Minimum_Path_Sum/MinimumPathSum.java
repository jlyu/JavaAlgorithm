package Leetcode._064_M_Minimum_Path_Sum;

import CodingRush._59_Queue_MaxInWindows.MaxInWindows;
import Leetcode._062_M_Unique_Paths.UniquePaths;

/*
Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.

Example:

Input:
[
  [1,3,1],
  [1,5,1],
  [4,2,1]
]
Output: 7
Explanation: Because the path 1→3→1→1→1 minimizes the sum.


https://leetcode-cn.com/problems/minimum-path-sum
 */
public class MinimumPathSum {
    public int minPathSum(int[][] grid) {
        final int m = grid.length;
        final int n = grid[0].length;
        if (m <= 0 || n <= 0) { return 0; }

        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < n; i++) { dp[0][i] = grid[0][i] + dp[0][i-1]; }
        for (int i = 1; i < m; i++) { dp[i][0] = grid[i][0] + dp[i-1][0]; }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {

                dp[i][j] = grid[i][j] + Math.min(dp[i-1][j], dp[i][j-1]);
            }
        }
        return dp[m-1][n-1];
    }

    public int minPathSum_v2(int[][] grid) {
        final int m = grid.length;
        final int n = grid[0].length;
        if (m <= 0 || n <= 0) { return 0; }

        for (int i = 1; i < n; i++) { grid[0][i] += grid[0][i-1]; }
        for (int i = 1; i < m; i++) { grid[i][0] += grid[i-1][0]; }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {

                grid[i][j] = grid[i][j] + Math.min(grid[i-1][j], grid[i][j-1]);
            }
        }
        return grid[m-1][n-1];
    }

    void unitTest1() {

        System.out.println( minPathSum_v2( new int[][] {{1,3,1}, {1,5,1}, {4,2,1}} ));
        System.out.println( minPathSum_v2( new int[][] {{1,3,1}} ));
        System.out.println( minPathSum_v2( new int[][] {{1},{3},{1}} ));
        //System.out.println( minPathSum(7,3) );
        //System.out.println( minPathSum(8,3) );
    }

    public static void main(String[] args) {
        MinimumPathSum m = new MinimumPathSum();
        m.unitTest1();
    }
}
