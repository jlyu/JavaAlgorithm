package Leetcode._001_E_Two_Sum;

//https://leetcode-cn.com/problems/two-sum/


import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public class TwoSum {


    public int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> hm = new LinkedHashMap<>();
        final int numLength = nums.length;
        for (int i = 0; i < numLength; i++) {
            hm.put(nums[i], i);
        }
        for (int i = 0; i < numLength; i++) {

            if (hm.containsKey(target - nums[i])) {
                int n = hm.get(target - nums[i]);
                if (n != i) {
                    return new int[] { i, n };
                }
            }

//            if(hm.get(target - nums[i]) != null && (hm.get(target - nums[i]) != i) ) {
//                return new int[] { i, hm.get(target - nums[i]) };
//            }
        }
        return new int[] {};
    }

    public void unitTest1() {
        int[] a = {3,3};
        System.out.println(Arrays.toString(twoSum(a, 6)));
    }

    public static void main(String[] args) {
        TwoSum a = new TwoSum();
        a.unitTest1();
    }
}
