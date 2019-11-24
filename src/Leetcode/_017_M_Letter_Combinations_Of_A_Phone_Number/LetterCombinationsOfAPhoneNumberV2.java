package Leetcode._017_M_Letter_Combinations_Of_A_Phone_Number;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationsOfAPhoneNumberV2 {
    List<String> results = new ArrayList<>();
    HashMap<String, String> phones = new HashMap<String, String>() {{
        put("2", "abc");
        put("3", "def");
        put("4", "ghi");
        put("5", "jkl");
        put("6", "mno");
        put("7", "pqrs");
        put("8", "tuv");
        put("9", "wxyz");
    }};


    private void backtrack(String combine, String nextDigits) {
        if (nextDigits.length() == 0) {
            results.add(combine);
            return;
        }

        String digit = nextDigits.substring(0, 1);
        String letters = phones.get(digit);

        for (int i=0; i<letters.length(); i++) {
            String letter = String.valueOf(letters.charAt(i));
            backtrack(combine + letter, nextDigits.substring(1) );
        }

    }

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) { return results; }
        backtrack("", digits);
        return results;
    }

    public void unittest1() {
        List<String> r = letterCombinations("23");
    }

    public static void main(String[] args) {
        LetterCombinationsOfAPhoneNumber a = new LetterCombinationsOfAPhoneNumber();
        a.unittest1();
    }
}
