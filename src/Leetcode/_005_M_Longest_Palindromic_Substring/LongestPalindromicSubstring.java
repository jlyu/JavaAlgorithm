package Leetcode._005_M_Longest_Palindromic_Substring;

/*
Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

Example 1:

Input: "babad"
Output: "bab"
Note: "aba" is also a valid answer.


Example 2:

Input: "cbbd"
Output: "bb"


https://leetcode-cn.com/problems/longest-palindromic-substring
 */

public class LongestPalindromicSubstring {

    public String stringExpand(String s, int start, int end) {
        while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            start--;
            end++;
        }
        return s.substring(start + 1, end);
    }


    public String longestPalindrome(String s) {
        final int sLen = s.length();
        if (sLen <= 1) { return s; }
        if (sLen > 1000) { return ""; }

        String longest = String.valueOf(s.charAt(0));
        for (int i = 0; i < sLen; i++) {



            String p1 = stringExpand(s, i, i);
            if (p1.length() > longest.length()) {
                longest = p1;
            }

            String p2 = stringExpand(s, i, i+1);
            if (p2.length() > longest.length()) {
                longest = p2;
            }

        }
        return longest;
    }

    public void unittest1() {
        //System.out.println(longestPalindrome(""));
        //System.out.println(longestPalindrome("babad"));
        //System.out.println(longestPalindrome("cbbd"));
        System.out.println(longestPalindrome("bb"));
    }

    public static void main(String[] args) {
        LongestPalindromicSubstring a = new LongestPalindromicSubstring();
        a.unittest1();
    }
}
