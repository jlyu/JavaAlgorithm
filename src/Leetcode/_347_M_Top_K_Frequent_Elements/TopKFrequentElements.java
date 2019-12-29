package Leetcode._347_M_Top_K_Frequent_Elements;
/*
Given a non-empty array of integers, return the k most frequent elements.

Example 1:

Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]
Example 2:

Input: nums = [1], k = 1
Output: [1]
Note:

You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
Your algorithm's time complexity must be better than O(n log n), where n is the array's size.


https://leetcode-cn.com/problems/top-k-frequent-elements
 */
import java.util.*;

public class TopKFrequentElements {

    public List<Integer> topKFrequent(int[] nums, int k) {

        HashMap<Integer, Integer> hm = new HashMap<>(); // key - Frequent
        for (int i = 0; i < nums.length; i++) {
            hm.put(nums[i], hm.getOrDefault(nums[i], 0) + 1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((e1, e2) -> hm.get(e1) - hm.get(e2));
        for (Map.Entry<Integer, Integer> item : hm.entrySet()) {
            pq.offer(item.getKey());
            if (pq.size() > k) {
                pq.poll();
            }
        }

        List<Integer> list = new LinkedList<>();
        while (!pq.isEmpty()) {
            list.add(0, pq.poll());
        }

        return list;
    }



    public void unittest1() {
        List<Integer> list = topKFrequent(new int[]{1,1,1,2,2,3}, 2);
        System.out.println(list.toString());
    }
    public void unittest2() {
        List<Integer> list = topKFrequent(new int[]{1}, 1);
        System.out.println(list.toString());
    }

    public static void main(String[] args) {
        TopKFrequentElements a = new TopKFrequentElements();
        a.unittest1();
        a.unittest2();
    }
}
