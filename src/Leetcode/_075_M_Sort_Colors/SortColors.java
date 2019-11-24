package Leetcode._075_M_Sort_Colors;

import java.util.Arrays;

/*
Given an array with n objects colored red, white or blue, sort them in-place so that objects of the same color
are adjacent, with the colors in the order red, white and blue.

Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

Note: You are not suppose to use the library's sort function for this problem.

Example:

Input: [2,0,2,1,1,0]
Output: [0,0,1,1,2,2]
Follow up:

A rather straight forward solution is a two-pass algorithm using counting sort.
First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's,
then 1's and followed by 2's.
Could you come up with a one-pass algorithm using only constant space?


https://leetcode-cn.com/problems/sort-colors

 */
public class SortColors {
    public void sortColors(int[] nums) {
        // Arrays.sort(nums);
        int[] colors = new int[3];

        for (int i = 0; i < nums.length; i++) {
            colors[ nums[i] ] += 1;
        }

        int index = 0;
        for (int i = 0; i < colors.length; i++) {
            for (int j = 0; j < colors[i]; j++) {
                nums[index++] = i;
            }
        }
    }

    public void sortColors_V2(int[] nums) {
        int p0 = 0, curr = 0;
        int p2 = nums.length - 1;

        int tmp;
        while (curr <= p2) {
            if (nums[curr] == 0) {
                tmp = nums[p0];
                nums[p0++] = nums[curr];
                nums[curr++] = tmp;
            }

            if (nums[curr] == 2) {
                tmp = nums[curr];
                nums[curr] = nums[p2];
                nums[p2--] = tmp;
            }

            curr++;
        }
    }

    public void unittest1() {
        int[] nums = {2,0,2,1,1,0};
        sortColors_V2(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void main(String[] args) {
        SortColors a = new SortColors();
        a.unittest1();
    }
}
