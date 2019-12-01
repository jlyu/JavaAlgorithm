package Leetcode._076_H_Minimum_Window_Substring;
/*
Given a string S and a string T, find the minimum window in S which will contain all the characters in T
in complexity O(n).

Example:

Input: S = "ADOBECODEBANC", T = "ABC"
Output: "BANC"

Note:

If there is no such window in S that covers all characters in T, return the empty string "".
If there is such window, you are guaranteed that there will always be only one unique minimum window in S.


https://leetcode-cn.com/problems/minimum-window-substring
 */


public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        if (s.length() == 0 || t.length() == 0) { return ""; }

        String results = "";
        int minLength = s.length();

        char[] charS = s.toCharArray();
        char[] charT = t.toCharArray();
        int[] hash = new int[256];
        for(char chr: charT) {
            hash[chr - '0']++;
        }

        int l = 0;
        int count = charT.length;
        for(int r = 0; r < charS.length; r++) {



            hash[ charS[r] - '0' ]--;



            if(hash[ charS[r] - '0' ] >= 0) {
                count--;
            }


            while (l < r && hash[ charS[l] - '0'] < 0) {
                hash[ charS[l] - '0' ]++;
                l++;
            }
            if (count == 0 && minLength >= r - l + 1) {
                minLength = r - l + 1;
                results = s.substring(l, r + 1);
            }

        }

        return results;
    }

    public void unittest1() {
        System.out.println(minWindow("ADOBECODEBANC", "ABC"));
    }

    public static void main(String[] args) {
        MinimumWindowSubstring a = new MinimumWindowSubstring();
        a.unittest1();
    }
}

