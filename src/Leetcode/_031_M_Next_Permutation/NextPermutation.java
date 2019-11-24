package Leetcode._031_M_Next_Permutation;

/*
Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

The replacement must be in-place and use only constant extra memory.

Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.

1,2,3 → 1,3,2
3,2,1 → 1,2,3
1,1,5 → 1,5,1

链接：https://leetcode-cn.com/problems/next-permutation

 */

public class NextPermutation {
    public void nextPermutation(int[] nums) {
        int right = nums.length - 2;
        while (right >= 0 && nums[right + 1] <= nums[right]) {
            right--;
        }

        if (right >= 0) {
            int left = nums.length - 1;
            while (left >= 0 && nums[left] <= nums[right]) {
                left--;
            }
            swap(nums, right, left);
        }
        reverse(nums, right + 1);
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void reverse(int[] nums, int start) {
        int i = start;
        int j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }
}
