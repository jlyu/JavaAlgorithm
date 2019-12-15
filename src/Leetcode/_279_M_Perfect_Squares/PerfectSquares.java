package Leetcode._279_M_Perfect_Squares;

import java.util.LinkedList;

/*
Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...)
which sum to n.

Example 1:

Input: n = 12
Output: 3
Explanation: 12 = 4 + 4 + 4.
Example 2:

Input: n = 13
Output: 2
Explanation: 13 = 4 + 9.


https://leetcode-cn.com/problems/perfect-squares
 */
public class PerfectSquares {
    private LinkedList<Integer> squares;
    public static boolean isSquares(int value) {
        if (value < 0) {
            return false;
        }
        double sqrtValue = Math.sqrt(value * 1.0);
        int sqrtSimiValue = (int) sqrtValue;
        if ((sqrtSimiValue * sqrtSimiValue) == value) {
            return true;
        } else {
            return false;
        }
    }
    public int numSquares_(int n) {
        int divisor = Integer.MAX_VALUE;
        for (int i = 1; i < n; i++) {
            if (isSquares(i)) {
                squares.push(i);
            }
            if (n % (i * i) == 0) {
                divisor = Math.min(divisor, n / (i * i));
            }
        }
        return Math.min(numSquaresHelper(n), divisor);
    }
    private int numSquaresHelper(int n) {
        if (n <= 3) { return n; }
        int foundSqrtN = n;
        while (foundSqrtN >= 0) {
            if (isSquares(foundSqrtN)) {
                break;
            }
            foundSqrtN--;
        }
        return 1 + numSquaresHelper(n - foundSqrtN);
    }
    //////////////////////////////////////////////////

    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i] = i; // worst case
            for (int j = 1; i - j * j >=0; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }

    public void unittest1() {
        for (int i = 0; i < 100; i++) {
            System.out.println(String.valueOf(i) + ": " + String.valueOf(numSquares(i)));
        }
    }

    public static void main(String[] args) {
        PerfectSquares a = new PerfectSquares();
        a.unittest1();
    }
}
