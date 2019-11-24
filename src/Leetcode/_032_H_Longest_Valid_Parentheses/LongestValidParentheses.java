package Leetcode._032_H_Longest_Valid_Parentheses;

/*
Given a string containing just the characters '(' and ')',
find the length of the longest valid (well-formed) parentheses substring.

Example 1:

Input: "(()"
Output: 2
Explanation: The longest valid parentheses substring is "()"


Example 2:

Input: ")()())"
Output: 4
Explanation: The longest valid parentheses substring is "()()"


链接：https://leetcode-cn.com/problems/longest-valid-parentheses
 */

public class LongestValidParentheses {
//    public int longestValidParentheses(String s) {
//        int maxPath = 0;
//        int[] dp = new int[s.length()];
//        for (int i = 1; i < s.length(); i++) {
//            if (s.charAt(i) == ')') {
//                if (s.charAt(i - 2) == '(') {
//                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
//                } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
//                    dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
//                }
//                maxPath = Math.max(maxPath, dp[i]);
//            }
//        }
//        return maxPath;
//    }

    public int longestValidParentheses(String s) {
        int left = 0, right = 0, maxValue = 0;

        // ->
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') { left++; }
            if (s.charAt(i) == ')') { right++; }

            if (left == right) { maxValue = Math.max(maxValue, 2 * right); }
            else if (right >= left) { left = right = 0; }
        }

        // <-
        left = right = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '(') { left++; }
            if (s.charAt(i) == ')') { right++; }

            if (left == right) { maxValue = Math.max(maxValue, 2 * left); }
            else if (left >= right) { left = right = 0; }
        }
        return maxValue;
    }
}


