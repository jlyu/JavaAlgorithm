package Leetcode._078_M_Subsets;

import java.util.ArrayList;
import java.util.List;

/*
Given a set of distinct integers, nums, return all possible subsets (the power set).

Note: The solution set must not contain duplicate subsets.

Example:

Input: nums = [1,2,3]
Output:
[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]


https://leetcode-cn.com/problems/subsets

 */
public class Subsets {
    private List<List<Integer>> lists = new ArrayList<List<Integer>>();

    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> list = new ArrayList<Integer>();
        if (nums.length == 0) { return lists; }
        backTrack(nums, 0, list);
        return lists;
    }

    private void backTrack(int[] candidates, int index, List<Integer> list) {
        lists.add(new ArrayList<Integer>(list));

        for (int i = index; i < candidates.length; i++) {
            list.add(candidates[i]);
            backTrack(candidates, i + 1, list);
            list.remove(list.size() - 1);
        }
    }

    public void unittest1() {
        List<List<Integer>> r = subsets(new int[] {1,2,3});
        for (int i = 0; i < r.size(); i++) {
            System.out.println(r.get(i).toString());
        }
    }

    public static void main(String[] args) {
        Subsets a = new Subsets();
        a.unittest1();
    }

}

