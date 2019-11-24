package Leetcode._049_M_Group_Anagrams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/*
Given an array of strings, group anagrams together.

Example:

Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
Output:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]
Note:

All inputs will be in lowercase.
The order of your output does not matter.


https://leetcode-cn.com/problems/group-anagrams

 */
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
//        List<List<String>> results = new ArrayList<>();
//        if (strs== null || strs.length == 0) { return results; }

        HashMap<Integer, List<String>> hm = new HashMap<>();

        int[] primes = {2,3,5,7,11,13,17,19,23,29,31,41,43,47,53,59,61,67,71,73,79,83,89,97,101,103};
                //{29,31,37,41,43,47,53,59,61,67,71,73,79,83,89,97,101,103,107,109,113,127,131,137,139,149};

        for (int i = 0; i < strs.length; i++) {
            String letter = strs[i];
            int hash = 1;//strs.length;
            for (int j = 0; j < letter.length(); j++) {
                hash *= (primes[ letter.charAt(j) - 97 ] * (letter.charAt(j) - 96)) % 1113;
            }
            if (hm.containsKey(hash)) {
                hm.get(hash).add(letter);
            } else {
                hm.put(hash, new ArrayList<String>(Arrays.asList(letter)));
            }
        }
        return new ArrayList<>(hm.values());
    }

    public void unittest1() {
        List<List<String>> l = groupAnagrams(new String[] {"eat", "tea", "tan", "ate", "nat", "bat"});
        for (int i = 0; i < l.size(); i++) {
            System.out.println(l.get(i));
        }
    }

    public void unittest2() {
        List<List<String>> l = groupAnagrams(new String[] {"has","rod","tom","hum","him","yon","met","dye"});
        for (int i = 0; i < l.size(); i++) {
            System.out.println(l.get(i));
        }
    }

    public void unittest3() {
        List<List<String>> l = groupAnagrams(new String[] {"paw","dad","bog","day","day","mig","len","rat"});
        for (int i = 0; i < l.size(); i++) {
            System.out.println(l.get(i));
        }
    }

    public void unittest4() {
        List<List<String>> l = groupAnagrams(new String[] {"ray","cod","abe","ned","arc","jar","owl","pop","paw","sky",
                "yup","fed","jul","woo","ado","why","ben","mys","den","dem","fat","you","eon","sui","oct","asp","ago",
                "lea","sow","hus","fee","yup","eve","red","flo","ids","tic","pup","hag","ito","zoo"});
        for (int i = 0; i < l.size(); i++) {
            System.out.println(l.get(i));
        }
    }


    public static void main(String[] args) {
        GroupAnagrams a = new GroupAnagrams();
        a.unittest1();
        a.unittest2();
        a.unittest3();
        a.unittest4();
    }
}
