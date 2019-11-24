package Leetcode._020_E_Valid_Parentheses;

import java.util.HashMap;
import java.util.Stack;

/*
Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Note that an empty string is also considered valid.

Example 1:
Input: "()"
Output: true

Example 2:
Input: "()[]{}"
Output: true

Example 3:
Input: "(]"
Output: false

Example 4:
Input: "([)]"
Output: false

Example 5:
Input: "{[]}"
Output: true


链接：https://leetcode-cn.com/problems/valid-parentheses


 */
public class ValidParentheses {
    public boolean isValid(String s) {
        if (s.length() == 0) { return true; }
        if (s.length() % 2 != 0) { return false; }

        Stack<Character> stack = new Stack<>();
        HashMap<String, Character> hm = new HashMap<String, Character>() {{
            put(")", '(');
            put("]", '[');
            put("}", '{');
        }};

        for (int i = 0; i < s.length(); i++) {
            char chr = s.charAt(i);
            String str = s.substring(i, i+1);

            if (")]}".contains(str)) {
                if (stack.isEmpty()) { return false; }

                if( stack.peek() == hm.get(str)) { stack.pop(); }
                else { return false; }

            } else { stack.push(chr); }
        }
        return stack.isEmpty();
    }


    public void unittest1() {
        System.out.println(isValid("()"));
        System.out.println(isValid("()[]{}"));
        System.out.println(!isValid("(}"));
        System.out.println(!isValid("([)]"));
        System.out.println(isValid("{[]}"));
    }

    public static void main(String[] args) {
        ValidParentheses a = new ValidParentheses();
        a.unittest1();
    }
}
