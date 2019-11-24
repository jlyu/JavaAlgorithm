package Leetcode._010_H_Regular_Expression_Matching;

/*
Given an input string (s) and a pattern (p), implement regular expression matching with support for '.' and '*'.

'.' Matches any single character.
'*' Matches zero or more of the preceding element.
The matching should cover the entire input string (not partial).

Note:

s could be empty and contains only lowercase letters a-z.
p could be empty and contains only lowercase letters a-z, and characters like . or *.

Example 1:
Input:
s = "aa"
p = "a"
Output: false
Explanation: "a" does not match the entire string "aa".

Example 2:
Input:
s = "aa"
p = "a*"
Output: true
Explanation: '*' means zero or more of the preceding element, 'a'. Therefore, by repeating 'a' once, it becomes "aa".

Example 3:
Input:
s = "ab"
p = ".*"
Output: true
Explanation: ".*" means "zero or more (*) of any character (.)".

Example 4:
Input:
s = "aab"
p = "c*a*b"
Output: true
Explanation: c can be repeated 0 times, a can be repeated 1 time. Therefore, it matches "aab".

Example 5:
Input:
s = "mississippi"
p = "mis*is*p*."
Output: false


链接：https://leetcode-cn.com/problems/regular-expression-matching */



public class RegularExpressionMatching {
    public boolean isMatch(String s, String p) {
        final int sl = s.length();
        final int pl = p.length();
        if (pl == 0) { return (sl == 0); }

        boolean first = (sl > 0) && (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.');

        if (pl >= 2 && p.charAt(1) == '*') {
            return isMatch(s, p.substring(2, pl)) || (first && isMatch(s.substring(1, sl), p));
        } else {
            return first && isMatch( s.substring(1, sl), p.substring(1, pl) );
        }
    }


    public void unittest1() {
        System.out.println(isMatch("aa", "a"));
        System.out.println(isMatch("aa", "a*"));
        System.out.println(isMatch("ab", ".*"));
        System.out.println(isMatch("aab", "c*a*b"));
        System.out.println(isMatch("mississippi", "mis*is*p*"));
    }

    public static void main(String[] args) {
        RegularExpressionMatching a = new RegularExpressionMatching();
        a.unittest1();
    }
}
