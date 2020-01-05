package Leetcode._394_M_Decode_String;

import java.util.Stack;

/*
Given an encoded string, return its decoded string.

The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated
exactly k times. Note that k is guaranteed to be a positive integer.

You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.

Furthermore, you may assume that the original data does not contain any digits and that digits are only for those
repeat numbers, k. For example, there won't be input like 3a or 2[4].

Examples:

s = "3[a]2[bc]", return "aaabcbc".
s = "3[a2[c]]", return "accaccacc".
s = "2[abc]3[cd]ef", return "abcabccdcdcdef".

https://leetcode-cn.com/problems/decode-string

 */
public class DecodeString {

    public String decodeString(String s) {
        String ans = "";
        for (int i = 0; i < s.length(); i++) {
            if ((s.charAt(i) >= 'a' && s.charAt(i) <= 'z') || (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z')) {
                ans += s.substring(i, i+1);
                continue;
            }

            int numIndex = i;
            while (s.charAt(i) >= '0' && s.charAt(i) <= '9') { i++; }
            String sNum = s.substring(numIndex, Math.min(i, s.length()));

            if (s.charAt(i) == '[') {
                int bracketIndex = i;
                Stack<Character> stack = new Stack<>();
                stack.push(s.charAt(i));
                for (int j = i + 1; j < s.length(); j++) {
                    if (s.charAt(j) == '[') { stack.push('['); }
                    if (s.charAt(j) == ']') {
                        if (!stack.empty()) {
                            stack.pop();
                            if (stack.empty()) {
                                String subString = s.substring(bracketIndex + 1, j);
                                String midString = decodeString(subString);


                                for (int k = 0; k < Integer.valueOf(sNum); k++) {
                                    ans += midString;
                                }
                                i = j;
                                break;
                            }
                        }
                    }
                }
            }
        }
        return ans;
    }

    public void unittest1() {
        System.out.println( decodeString("3[a]2[bc]"));
        System.out.println( decodeString("3[a2[c]]"));
        System.out.println( decodeString("3[a]2[b4[F]c]")); // aaabFFFFcbFFFFc
        System.out.println( decodeString("abc2[xyz3[mn]]"));


    }

    public static void main(String[] args) {
        DecodeString a = new DecodeString();
        a.unittest1();
    }
}
