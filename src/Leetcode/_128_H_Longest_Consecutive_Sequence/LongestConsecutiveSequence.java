package Leetcode._128_H_Longest_Consecutive_Sequence;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Set;

/*
Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

Your algorithm should run in O(n) complexity.

Example:

Input: [100, 4, 200, 1, 3, 2]
Output: 4
Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.


https://leetcode-cn.com/problems/longest-consecutive-sequence
 */
public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        HashMap<Integer, Integer> hm = new LinkedHashMap<>(); // <num, currentLength>
        int maxLength = 0;
        for (int num: nums) {
            if (hm.containsKey(num)) { continue; }

            int left = hm.containsKey(num - 1) ? hm.get(num - 1) : 0;
            int right= hm.containsKey(num + 1) ? hm.get(num + 1) : 0;

            int currLength = 1 + left + right;
            maxLength = Math.max(maxLength, currLength);

            hm.put(num, currLength);
            hm.put(num - left, currLength);
            hm.put(num + right, currLength);
        }
        return maxLength;
    }

    public void unittest1() {
        System.out.println(longestConsecutive(new int[] {100,4,200,1,3,2}));
    }

    public static void main(String[] args) {
        LongestConsecutiveSequence a = new LongestConsecutiveSequence();
        a.unittest1();
    }
}
