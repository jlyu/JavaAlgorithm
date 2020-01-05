package Leetcode._438_M_Find_All_Anagrams_In_A_String;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.

Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.

The order of output does not matter.

Example 1:

Input:
s: "cbaebabacd" p: "abc"

Output:
[0, 6]

Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".
Example 2:

Input:
s: "abab" p: "ab"

Output:
[0, 1, 2]

Explanation:
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab".


https://leetcode-cn.com/problems/find-all-anagrams-in-a-string
 */
public class FindAllAnagramsInAString {




    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if(s == null || s.length() == 0) { return res; }
        int[] needs = new int[26];
        int[] window = new int[26];
        int left = 0, right = 0, windowSize = p.length();

        for(char ch : p.toCharArray()) {
            needs[ch - 'a'] ++;
        }

        while (right < s.length()) {
            char ch = s.charAt(right);
            if (needs[ch - 'a'] > 0) {
                window[ch - 'a'] ++;
                if (window[ch - 'a'] <= needs[ch - 'a']) {
                    windowSize --;
                }
            }
            while (windowSize == 0) {
                if( right - left + 1 == p.length() ) {
                    res.add(left);
                }
                char chl = s.charAt(left);
                if(needs[chl - 'a'] > 0) {
                    window[chl - 'a'] --;
                    if(window[chl - 'a'] < needs[chl - 'a']) {
                        windowSize ++;
                    }
                }
                left ++;
            }
            right ++;
        }
        return res;
    }
}

/*
int l = 0, r = 0;
while (r < s.size()) {
    window.add(s[r]);
    r++;
    while(Valid) {
        window.remove(s[l]);
        l++;
    }
}
 */
