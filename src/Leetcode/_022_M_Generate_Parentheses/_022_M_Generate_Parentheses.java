package Leetcode._022_M_Generate_Parentheses;

import java.util.ArrayList;
import java.util.List;

/*
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]


https://leetcode-cn.com/problems/generate-parentheses
 */
public class _022_M_Generate_Parentheses {
    private List<String> res = new ArrayList<String>();
    public List<String> generateParenthesis(int n) {
        backTrack("", 0,0, n);
        return res;
    }

    private void backTrack(String cur, int open, int close, int max) {
        if (cur.length() == max * 2) {
            res.add(cur);
            return;
        }
        if (open < max) {
            backTrack(cur + "(", open + 1, close, max);
        }
        if (close < open) {
            backTrack(cur + ")", open, close + 1, max);
        }
    }
}
