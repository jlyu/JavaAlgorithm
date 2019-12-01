package Leetcode._034_M_Find_First_And_Last_Position_Of_Element_In_Sorted_Array;

/*
Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

Example 1:

Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]


Example 2:

Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]


https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array
 */


public class FindFirstAndLastPositionOfElementInSortedArray {
    public int[] searchRange(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        int mid = binarySearch(nums, start, end, target);
        // Found
        if (mid != -1) {
            int prev = mid, post = mid, lastPrev = prev, lastPost = post;
            while (prev != -1) {
                lastPrev = prev;
                prev = binarySearch(nums, start, prev - 1, target);
            }
            while (post != -1) {
                lastPost = post;
                post = binarySearch(nums, post + 1, end, target);
            }
            return new int[] {lastPrev, lastPost};
        }
        return new int[] {-1, -1};
    }

    private int binarySearch(int[] nums, int start, int end, int target) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return mid;
            }

            if (nums[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }
}
