package Leetcode._003_M_Longest_Substring_Without_Repeating_Characters;

/*
Given a string, find the length of the longest substring without repeating characters.

Example 1:

Input: "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:

Input: "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
             Note that the answer must be a substring, "pwke" is a subsequence and not a substring.

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
*/

/*
48.最长不重复字符的子字符串
    动态规划。
    使用26个长度的辅助数组，记录字符所在下标的位置
    字符没有重复下，长度+1
    字符重复，查表，如果2个重复字符之间的长度 > 当前子字符串长度，还可以继续+1，
          < 当前子字符串长度，说明在当前子字符串中出现了重复，要割掉重复的字符，也就是长度会减小，先记录maxValue，再更新当前字符串长度值
 */

public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        final int sLength = s.length();
        if (sLength < 2) {
            return sLength;
        }

        final int pLength = 256;
        int[] positions = new int[pLength];
        for (int i = 0; i < pLength; i++) {
            positions[i] = -1;
        }

        int maxValue = 0x80000000;
        int currLength = 0;
        for (int i = 0; i < sLength; i++) {

            int index = s.charAt(i);
            int pIndex = positions[index];

            int diff = i - pIndex;
            if (pIndex < 0 || diff > currLength) {
                currLength += 1;
            } else {
                maxValue = (currLength > maxValue) ? currLength : maxValue;
                currLength = diff;
            }

            positions[index] = i;
            maxValue = (currLength > maxValue) ? currLength : maxValue;

        }
        return maxValue;
    }


    /////////////////////////////////////////////////////////////////
    public void unittest1() {
        String s1 = "abcabcbb";
        System.out.println(s1 + ": " + lengthOfLongestSubstring(s1));
    }
    public void unittest2() {
        String s2 = "bbbbb";
        System.out.println(s2 + ": " + lengthOfLongestSubstring(s2));
    }
    public void unittest3() {
        String s3 = "pwwkew";
        System.out.println(s3 + ": " + lengthOfLongestSubstring(s3));
    }
    public void unittest4() {
        String s4 = "   ";
        System.out.println(s4 + ": " + lengthOfLongestSubstring(s4));
    }
    public void unittest5() {
        String s5 = "au";
        System.out.println(s5 + ": " + lengthOfLongestSubstring(s5));
    }



    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters a = new LongestSubstringWithoutRepeatingCharacters();
        a.unittest1();
        a.unittest2();
        a.unittest3();
        a.unittest4();
        a.unittest5();
    }
}
