package Leetcode._015_M_3sum;

/*
Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0?
Find all unique triplets in the array which gives the sum of zero.

Note:
The solution set must not contain duplicate triplets.

Example:
Given array nums = [-1, 0, 1, 2, -1, -4],

A solution set is:
[
  [-1, 0, 1],
  [-1, -1, 2]
]


链接：https://leetcode-cn.com/problems/3sum  */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        int nlength = nums.length;
        if (nums == null || (nlength < 3)) { return results; }

        Arrays.sort(nums);


        for (int i = 0; i < nlength; i++) {
            if (nums[i] > 0) { break; }
            if (i > 0 && nums[i] == nums[i - 1]) { continue; }

            int L = i + 1;
            int R = nlength - 1;

            while (L < R) {

                //if (L >= R || nums[i] * nums[R] > 0) { break; }
                int result = nums[i] + nums[L] + nums[R];
                if (result == 0) {
                    results.add(Arrays.asList(nums[i], nums[L], nums[R]));
                    while (L < R && nums[L] == nums[L + 1]) { L++; }
                    while (L < R && nums[R] == nums[R - 1]) { R--; }
                    L++;
                    R--;
                }
                else if (result < 0) { L++; }
                else if (result > 0) { R--; }
            }
        }
        return results;
    }

    public void unittest1() {
        List<List<Integer>> results = threeSum(new int[] {-1, 0, 1, 2, -1, -4});
        results = threeSum(new int[] {0,0,0});
    }

    public static void main(String[] args) {
        ThreeSum a = new ThreeSum();
        a.unittest1();
    }
}
