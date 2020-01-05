package Leetcode._560_M_Subarray_Sum_Equals_K;

import javafx.scene.effect.SepiaTone;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/*
Given an array of integers and an integer k, you need to find the total number of continuous subarrays whose sum equals to k.

Example 1:
Input:nums = [1,1,1], k = 2
Output: 2
Note:
The length of the array is in range [1, 20,000].
The range of numbers in the array is [-1000, 1000] and the range of the integer k is [-1e7, 1e7].


https://leetcode-cn.com/problems/subarray-sum-equals-k
 */
public class _560_M_Subarray_Sum_Equals_K {
    public int subarraySum_(int[] nums, int k) {
        int res = 0;
        HashMap<Integer, Set<Integer>> hm = new HashMap<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            if (k == nums[i]) { res++; }
            int target = k - nums[i];
            int index = i - 1;
            if (hm.containsKey(index)) {
                Set<Integer> sums = hm.getOrDefault(index, new HashSet<>());
                if (sums.contains(target)) { res++; }
            } else {
                Set<Integer> sums = new HashSet<>();
                int sum = 0;
                for (int j = i - 1; j >= 0; j--) {
                    sum += nums[j];
                    sums.add(sum);
                    if (sum == target) {
                        res++;
                    }
                }
                hm.put(index, sums);
            }
        }
        return res;
    }

    public int subarraySum(int[] nums, int k) {
        int count = 0, sum = 0;
        HashMap < Integer, Integer > map = new HashMap<>();
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k))
                count += map.get(sum - k);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
    //////////////////////////////////////////////////////////////
    public void unittest1() {
        //System.out.println(subarraySum(new int[]{1,1,1}, 2));
        System.out.println(subarraySum(new int[]{1,2,3}, 3));
    }

    public static void main(String[] args) {
        _560_M_Subarray_Sum_Equals_K a = new _560_M_Subarray_Sum_Equals_K();
        a.unittest1();
    }




}
