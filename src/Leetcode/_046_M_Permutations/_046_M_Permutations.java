package Leetcode._046_M_Permutations;

import com.sun.org.apache.bcel.internal.generic.ACONST_NULL;

import java.util.ArrayList;
import java.util.List;

/*
Given a collection of distinct integers, return all possible permutations.

Example:

Input: [1,2,3]
Output:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]

https://leetcode-cn.com/problems/permutations
 */
public class _046_M_Permutations {
    private List<List<Integer>> lists = new ArrayList<List<Integer>>();
    public List<List<Integer>> permute(int[] nums) {

        if (nums == null || nums.length == 0) { return lists; }
        List<Integer> list = new ArrayList<>();
        int[] visited = new int[nums.length];
        backTrack(nums, visited, list);
        return lists;
    }

    private void backTrack(int[] nums, int[] visited, List<Integer> list) {
        if (list.size() == nums.length) {
            lists.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i] == 1) { continue; }
            visited[i] = 1;
            list.add(nums[i]);
            backTrack(nums, visited, list);
            visited[i] = 0;
            list.remove(list.size() - 1);
        }
    }

    public void unittest1() {
        permute(new int[] {1,2,3});
    }

    public static void main(String[] args) {
        _046_M_Permutations a = new _046_M_Permutations();
        a.unittest1();
    }
}
