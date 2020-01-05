package Leetcode._448_E_Find_All_Numbers_Disappeared_In_An_Array;

import java.util.*;

/*
Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.

Find all the elements of [1, n] inclusive that do not appear in this array.

Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.

Example:

Input:
[4,3,2,7,8,2,3,1]

Output:
[5,6]


https://leetcode-cn.com/problems/find-all-numbers-disappeared-in-an-array

Hard Requirement
Time O(n)
Space O(1)
 */
public class _448_E_Find_All_Numbers_Disappeared_In_An_Array {
    public List<Integer> findDisappearedNumbers_(int[] nums) {
        List<Integer> res = new ArrayList<>();
        Set<Integer> set = new HashSet<Integer>();
        for (int num: nums) {
            set.add(num);
        }
        for (int i = 1; i <= nums.length; i++) {
            if (!set.contains(i)) {
                res.add(i);
            }
        }
        return res;
    }
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            nums[index] = Math.abs(nums[index]) * -1;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                res.add(i + 1);
            }
        }
        return res;
    }

    public void unittest1() {
        System.out.println(findDisappearedNumbers(new int[] { 4,3,2,7,8,2,3,1 }).toString());
    }

    public static void main(String[] args) {
        _448_E_Find_All_Numbers_Disappeared_In_An_Array a = new _448_E_Find_All_Numbers_Disappeared_In_An_Array();
        a.unittest1();
    }
}
