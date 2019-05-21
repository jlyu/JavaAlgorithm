package ds.string;

/*  M 151. Reverse Words in a String
https://leetcode.com/problems/reverse-words-in-a-string/

Given an input string, reverse the string word by word.

Example 1:
        Input: "the sky is blue"
        Output: "blue is sky the"

Example 2:
        Input: "  hello world!  "
        Output: "world! hello"
        Explanation: Your reversed string should not contain leading or trailing spaces.

Example 3:

        Input: "a good   example"
        Output: "example good a"
        Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.


Note:
        A word is defined as a sequence of non-space characters.
        Input string may contain leading or trailing spaces. However, your reversed string should not contain leading or trailing spaces.
        You need to reduce multiple spaces between two words to a single space in the reversed string.


Follow up:
        For C programmers, try to solve it in-place in O(1) extra space.*/

import java.util.Arrays;

public class ReverseWords {
    public String reverseWords(String s) {
        String[] words = s.split("\\s+");

        StringBuffer sb = new StringBuffer("");
        final int wordLen = words.length;
        for (int i = wordLen - 1; i >=0; i--) {
            sb.append( (words[i].trim()) + ((i == 0) ? "" : " ") );
        }
        return sb.toString().trim();
    }

    public static void main(String[] args) {
        ReverseWords ins = new ReverseWords();
        System.out.println( ins.reverseWords("the sky is blue").equals("blue is sky the") );
        System.out.println( ins.reverseWords("  hello world!  ").equals("world! hello") );
        System.out.println( ins.reverseWords("a good   example").equals("example good a") );
        // -
        System.out.println( ins.reverseWords(" ").equals("") );
    }
}
