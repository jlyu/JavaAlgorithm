package Leetcode._039_M_Combination_Sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Given a set of candidate numbers (candidates) (without duplicates) and a target number (target),
find all unique combinations in candidates where the candidate numbers sums to target.

The same repeated number may be chosen from candidates unlimited number of times.

Note:

All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
Example 1:

Input: candidates = [2,3,6,7], target = 7,
A solution set is:
[
  [7],
  [2,2,3]
]

Example 2:

Input: candidates = [2,3,5], target = 8,
A solution set is:
[
  [2,2,2,2],
  [2,3,3],
  [3,5]
]


https://leetcode-cn.com/problems/combination-sum

 */
public class CombinationSum {
    private List<List<Integer>> lists = new ArrayList<List<Integer>>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if(candidates == null || candidates.length == 0) { return lists; }

        List<Integer> list = new ArrayList<Integer>();
        Arrays.sort(candidates);

        backTrack(candidates, target, 0, list);
        return lists;
    }

    private void backTrack(int[] candidates, int target, int index, List<Integer> list) {

        if (target == 0) {
            lists.add(new ArrayList<Integer>(list));
            return;
        }
        for (int i = index; i < candidates.length && target >= candidates[i]; i++) {

            list.add(candidates[i]);

            backTrack(candidates, target - candidates[i], i, list);
            list.remove(list.size() - 1);
        }

    }
}
