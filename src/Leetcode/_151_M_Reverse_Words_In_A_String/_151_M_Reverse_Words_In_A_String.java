package Leetcode._151_M_Reverse_Words_In_A_String;
/*
Given an input string, reverse the string word by word.

 

Example 1:

Input: "the sky is blue"
Output: "blue is sky the"
Example 2:

Input: "  hello world!  "
Output: "world! hello"
Explanation: Your reversed string should not contain leading or trailing spaces.
Example 3:

Input: "a good   example"
Output: "example good a"
Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.
 

Note:

A word is defined as a sequence of non-space characters.
Input string may contain leading or trailing spaces. However, your reversed string should not contain leading or trailing spaces.
You need to reduce multiple spaces between two words to a single space in the reversed string.


https://leetcode-cn.com/problems/reverse-words-in-a-string
 */

public class _151_M_Reverse_Words_In_A_String {
    public String reverseWords(String s) {
        //String trimedS = s.trim();
        String[] words = s.split(" ");

        StringBuffer sb = new StringBuffer();
        for (int i = words.length - 1; i >= 0; i--) {
            String word = words[i].replaceAll("\\s+","");
            if (word.length() != 0) {

                sb.append(word).append(" ");
            }
        }

        String ans = sb.toString();
        if (ans.length() == 0) { return ""; }
        return (ans.charAt(ans.length() - 1) == ' ') ? ans.substring(0, ans.length() - 1) : ans;
    }

    public void unittest1() {
        //System.out.println(reverseWords("the sky is blue"));
        //System.out.println(reverseWords("  hello world!  "));
        //System.out.println(reverseWords("a good  example"));
    }

    public void unittest2() {
        System.out.println(reverseWords(""));
        System.out.println(reverseWords(" "));
    }

    public static void main(String[] args) {
        _151_M_Reverse_Words_In_A_String a = new _151_M_Reverse_Words_In_A_String();
        a.unittest2();
    }
}
