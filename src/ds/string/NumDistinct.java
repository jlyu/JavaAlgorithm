/*H 115. Distinct Subsequences
https://leetcode.com/problems/distinct-subsequences/

Given a string S and a string T, count the number of distinct subsequences of S which equals T.

A subsequence of a string is a new string which is formed from the original string by deleting
some (can be none) of the characters without disturbing the relative positions of the remaining characters.
(ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).

Example 1:

        Input: S = "rabbbit", T = "rabbit"
        Output: 3


Example 2:

        Input: S = "babgbag", T = "bag"
        Output: 5
*/


package ds.string;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class NumDistinct {
    public int numDistinct(String s, String t) {
        //int result = 0;
        Set<Stack<Integer>> set = new HashSet<Stack<Integer>>();
        Stack<Integer> stack = new Stack<Integer>();
        final int slen = s.length();
        int prev = -1;
        for (int i = 0; i < slen; i++) {

            for (int j = i; j < slen; j++) {

                if (s.charAt(j) == t.charAt(stack.size())) {

                    if (prev != j) {

                        stack.push(j);
                        prev = j;
                    }

                    if (stack.size() == t.length()) {
                        System.out.println(stack);
                        set.add(stack);
                        //result++;
                        int last = stack.pop();
                        if (last == slen - 1) {
                            //stack.pop();
                            j = stack.pop() + 1;
                            continue;
                        }
                    }
                }
                if (j == slen - 1) {
                    if (!stack.isEmpty()) {
                        stack.pop();
                        //j = Math.min(stack.lastElement() + 1, j);
                        //continue;
                    }
                }

            }
            if (!stack.isEmpty()) { stack.pop(); }

        }

        System.out.println("----");
        System.out.println(set);
        return set.size();
    }

    public static void main(String[] args) {
        NumDistinct ins = new NumDistinct();
        System.out.println( ins.numDistinct("babgbag", "bag") ); //5
        System.out.println( ins.numDistinct("rabbbit", "rabbit") );  //3
    }
}
