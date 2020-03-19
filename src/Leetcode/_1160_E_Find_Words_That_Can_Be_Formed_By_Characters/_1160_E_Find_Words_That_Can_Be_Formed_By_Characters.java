package Leetcode._1160_E_Find_Words_That_Can_Be_Formed_By_Characters;

import java.util.Arrays;

/*
You are given an array of strings words and a string chars.

A string is good if it can be formed by characters from chars (each character can only be used once).

Return the sum of lengths of all good strings in words.

 

Example 1:

Input: words = ["cat","bt","hat","tree"], chars = "atach"
Output: 6
Explanation:
The strings that can be formed are "cat" and "hat" so the answer is 3 + 3 = 6.
Example 2:

Input: words = ["hello","world","leetcode"], chars = "welldonehoneyr"
Output: 10
Explanation:
The strings that can be formed are "hello" and "world" so the answer is 5 + 5 = 10.
 

Note:

1 <= words.length <= 1000
1 <= words[i].length, chars.length <= 100
All strings contain lowercase English letters only.


https://leetcode-cn.com/problems/find-words-that-can-be-formed-by-characters
 */
public class _1160_E_Find_Words_That_Can_Be_Formed_By_Characters {
    public int countCharacters(String[] words, String chars) {
        if (words.length <= 0 || chars.length() <= 0) { return 0; }

        final int N = 26;
        int ans = 0;
        char[] dict = new char[N];
        for (int i = 0; i < chars.length(); i++) {
            dict[ chars.charAt(i) - 'a' ] += 1;
        }

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (word.length() > chars.length()) {
                continue;
            }
            //char[] copyDict = Arrays.copyOf(dict, dict.length);
            char[] chWord = new char[N];
            for (int j = 0; j < word.length(); j++) {
                chWord[word.charAt(j) - 'a'] += 1;
            }

            for (int k = 0; k < N && chWord[k] <= dict[k]; k++) {
                if (k == N - 1) {
                    ans += word.length();;
                }
            }
        }
        return ans;
    }

    public void unittest1() {
        String[] words = new String[] { "cat","bt","hat","tree" };
        String chars = "atach";
        System.out.println(countCharacters(words, chars));
    }

    public void unittest2() {
        String[] words = new String[] { "hello","world","leetcode" };
        String chars = "welldonehoneyr";
        System.out.println(countCharacters(words, chars));
    }

    public static void main(String[] args) {
        _1160_E_Find_Words_That_Can_Be_Formed_By_Characters a = new _1160_E_Find_Words_That_Can_Be_Formed_By_Characters();
        a.unittest1();
        a.unittest2();
    }
}
