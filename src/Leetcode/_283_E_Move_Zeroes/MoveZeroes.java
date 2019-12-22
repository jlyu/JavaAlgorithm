package Leetcode._283_E_Move_Zeroes;
/*
Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of
the non-zero elements.

Example:

Input: [0,1,0,3,12]
Output: [1,3,12,0,0]
Note:

You must do this in-place without making a copy of the array.
Minimize the total number of operations.


https://leetcode-cn.com/problems/move-zeroes

 */
public class MoveZeroes {
    private void swap(int[] nums, int left, int right) {
        int tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
    }
    public void moveZeroes(int[] nums) {
        final int n = nums.length;
        int p0 = 0, p1 = 0;

        while (p1 == p0 && p1 < n) {
            while (p0 < n && nums[p0] != 0) {
                p0++;
            }
            p1 = p0;
            while (p1 < n && nums[p1] == 0) {
                p1++;
            }

            if (p1 < n && p0 < n && p0 < p1) {
                swap(nums, p0, p1);
                p1 = p0 + 1;
                p0 = p0 + 1;
            }
        }
    }

    // V2
    public void moveZeros_V2(int[] nums) {
        int index = 0;
        for (int num: nums) {
            if (num != 0) {
                nums[index++] = num;
            }
        }
        while (index < nums.length) {
            nums[index++] = 0;
        }
    }

    public void unittest1() {
       // moveZeroes(new int[] {0,1,0,3,12});
       // moveZeroes(new int[] {0,1,0,3,4,5,0,0,9,0,0,0,0,0});
        moveZeroes(new int[] {1});
        moveZeroes(new int[] {0});
        moveZeroes(new int[] {0,1});
        moveZeroes(new int[] {1,0});
        moveZeroes(new int[] {1,0,1});
        System.out.println("end");
    }

    public static void main(String[] args) {
        MoveZeroes a = new MoveZeroes();
        a.unittest1();
    }

}

/*
class Solution {
    private void swap(int[] nums, int left, int right) {
        int tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
    }
    public void moveZeroes(int[] nums) {
        final int n = nums.length;
        int p0 = 0, p1 = 0;

        while (p1 == p0 && p0 < n) {
            while (p0 < n && nums[p0] != 0) {
                p0++;
            }
            while (p1 < n && nums[p1] == 0) {
                p1++;
            }

            if (p1 < n && p0 < n && p0 < p1) {
                swap(nums, p0, p1);
                p1 = p0 + 1;
                p0 = p0 + 1;
            }
        }
    }
}
 */