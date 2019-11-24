package Leetcode._017_M_Letter_Combinations_Of_A_Phone_Number;

/*
Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.



Example:

Input: "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
Note:

Although the above answer is in lexicographical order, your answer could be in any order you want.


链接：https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number  */

import java.util.*;

public class LetterCombinationsOfAPhoneNumber {

    List<String> result = new ArrayList<>();
    Map<String, String> hm = new HashMap<String, String>() {{
        put("2", "abc");
        put("3", "def");
        put("4", "ghi");
        put("5", "jkl");
        put("6", "mno");
        put("7", "pqrs");
        put("8", "tuv");
        put("9", "wxyz");
    }};

    public void backtrack(String combination, String nextDigits) {
        if (nextDigits.length() == 0) {
            result.add(combination);
            return;
        }

        String digit = nextDigits.substring(0, 1);
        String letters = hm.get(digit);
        for (int i = 0; i < letters.length(); i++) {
            String letter = hm.get(digit).substring(i, i + 1);
            backtrack(combination + letter, nextDigits.substring(1));
        }
    }


    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) { return result; }
        backtrack("", digits);
        return result;
    }


    public void unittest1() {
        List<String> r = letterCombinations("23");
    }

    public static void main(String[] args) {
        LetterCombinationsOfAPhoneNumber a = new LetterCombinationsOfAPhoneNumber();
        a.unittest1();
    }
}
