/*Medium 49. Group Anagrams   https://leetcode.com/problems/group-anagrams/
*
* Given an array of strings, group anagrams together.

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
The order of your output does not matter.*/



package Leetcode.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {
    public static int additiveHash(String key) {
        int[] prime = {29,31,37,41,43,47,53,59,61,67,71,73,79,83,89,97,101,103,107,109,113,127,131,137,139,149};
        int hashCode = key.length();
        for (int i = 0; i < key.length(); i++) {
            int v = key.charAt(i) - 96;
            hashCode *= ( v * prime[v - 1]) % 11113;
        }
        return hashCode;
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<List<String>>();
        Map<Integer, List<String>> map = new HashMap<Integer, List<String>>();

        for (String str:strs) {
            int hashCode =  additiveHash(str);
            List<String> list = map.get(hashCode);
            if (list == null) {
                list = new ArrayList<String>();
                list.add(str);
                map.put(hashCode, list);
            } else {
                list.add(str);
            }
        }


        for (List<String> values : map.values()) {
            result.add(values);
        }

        return result;
    }

    public static void main(String[] args) {
        GroupAnagrams ins = new GroupAnagrams();
        System.out.println( ins.groupAnagrams(new String[]{"duh","ill"})  );
        System.out.println( ins.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"})  );
        System.out.println( ins.groupAnagrams(new String[]{"cab","tin","pew","duh","may","ill","buy","bar","max","doc"})  );
        System.out.println( ins.groupAnagrams(new String[]{"mod","mop","pip","tug","hop","dog","met","zoe","axe","mug","fdr","for","fro","fdr","pap","ray","lop","nth","old","eva","ell","mci","wee","ind","but","all","her","lew","ken","awl","law","rim","zit","did","yam","not","ref","lao","gab","sax","cup","new","job","new","del","gap","win","pot","lam","mgm","yup","hon","khz","sop","has","era","ark"})  );
        System.out.println( ins.groupAnagrams(new String[]{"ivy","hop","dug","chi","tub","man","yak","pub","son","ohm","gut","hem","pub","gad","hew","bit","arm","vat","sop","nan","dot","fdr","tad","big","her","yea","sis"})  );
        System.out.println( ins.groupAnagrams(new String[]{"tub","sis"})  );
    }
}
