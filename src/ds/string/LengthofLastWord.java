/*Easy 58. Length of Last Word
 https://leetcode.com/problems/length-of-last-word/

Given a string s consists of upper/lower-case alphabets and empty space characters ' ',
return the length of last word in the string.

If the last word does not exist, return 0.

Note: A word is defined as a character sequence consists of non-space characters only.

Example:

    Input: "Hello World"
    Output: 5

*/
package ds.string;

public class LengthofLastWord {
    public int lengthOfLastWord(String s) {
        s = s.trim();
        int pos = s.lastIndexOf(" ");
        if (pos < 0) { return s.length(); }
        return s.substring(pos + 1).length();
    }

    public static void main(String[] args) {
        LengthofLastWord ins = new LengthofLastWord();
        System.out.println(ins.lengthOfLastWord("Hello World"));
        System.out.println(ins.lengthOfLastWord("Hello World Chain"));
        System.out.println(ins.lengthOfLastWord(" "));
        System.out.println(ins.lengthOfLastWord("a"));
        System.out.println(ins.lengthOfLastWord("ab "));
        System.out.println(ins.lengthOfLastWord("l o l"));
    }
}
