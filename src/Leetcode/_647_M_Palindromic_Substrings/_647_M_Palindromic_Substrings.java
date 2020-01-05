package Leetcode._647_M_Palindromic_Substrings;

import java.util.HashSet;
import java.util.Set;

/*
Given a string, your task is to count how many palindromic substrings in this string.

The substrings with different start indexes or end indexes are counted as different substrings even they consist of
same characters.

Example 1:

Input: "abc"
Output: 3
Explanation: Three palindromic strings: "a", "b", "c".
 

Example 2:

Input: "aaa"
Output: 6
Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
 

Note:

The input string length won't exceed 1000.


https://leetcode-cn.com/problems/palindromic-substrings
 */
public class _647_M_Palindromic_Substrings {
    private Set<String> set;

    private boolean isPalindromic(String s) {
        if (s.length() == 1) { return true; }
        if (set.contains(s)) { return true; }
        for (int i = 0, j = s.length() - 1; i <= j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        set.add(s);
        return true;
    }

    public int countSubstrings(String s) {
        set = new HashSet<String>();
        final int l = s.length();
        int dp[] = new int[l];
        dp[0] = 1;
        for (int j = 1; j < l; j++) {
            int tmp = 0;
            for (int i = j; i >= 0; i--) {
                String sub = s.substring(i, j + 1);
                int v = isPalindromic(sub) ? 1 : 0;
                tmp += v;
            }
            dp[j] = dp[j - 1] + tmp;
        }
        return dp[l-1];
    }
    ////////////////////////////////////////////////////////////////
    public void unittest1() {
        System.out.println(countSubstrings("abc"));
        System.out.println(countSubstrings("aaa"));
    }

    public static void main(String[] args) {
        _647_M_Palindromic_Substrings a = new _647_M_Palindromic_Substrings();
        a.unittest1();
    }
}
