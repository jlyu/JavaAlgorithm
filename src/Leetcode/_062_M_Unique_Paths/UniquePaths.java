package Leetcode._062_M_Unique_Paths;
/*
A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

How many possible unique paths are there?


Above is a 7 x 3 grid. How many possible unique paths are there?

Note: m and n will be at most 100.

Example 1:

Input: m = 3, n = 2
Output: 3
Explanation:
From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
1. Right -> Right -> Down
2. Right -> Down -> Right
3. Down -> Right -> Right
Example 2:

Input: m = 7, n = 3
Output: 28


https://leetcode-cn.com/problems/unique-paths

 */
public class UniquePaths {
    public int uniquePaths(int m, int n) {
        if (m <= 0 || n <= 0) { return 0; }
        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (i == 0 || j == 0) {
                    dp[i][j] = 1;
                    continue;
                }

                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m-1][n-1];
    }

    private boolean check (int rows, int cols, int row, int col, boolean[] isVisited) {
        if (row >= 0 && row < rows && col >= 0 && col < cols && !isVisited[row * cols + col]) {

                return true;

        }
        return false;
    }

    private int movingCountCore(int rows, int cols, int row, int col, boolean[] isVisited) {
        int count = 0;
//        if (check(rows, cols, row, col, isVisited)) {
//            isVisited[row * cols + col] = true;

            count = 1 + movingCountCore(rows, cols, row + 1, col, isVisited)
                      + movingCountCore(rows, cols, row, col + 1, isVisited);
//        }
        return count;
    }

    public int movingCount(int rows, int cols) {
        if (rows < 0 || cols < 0) { return 0;}

        boolean[] isVisited = new boolean[rows * cols];

        return movingCountCore(rows, cols, 0 , 0, isVisited);
    }

    void unitTest1() {

        System.out.println( uniquePaths(3,2) );
        System.out.println( uniquePaths(7,3) );
        System.out.println( uniquePaths(8,3) );
    }

    public static void main(String[] args) {
        UniquePaths m = new UniquePaths();
        m.unitTest1();
    }
}
