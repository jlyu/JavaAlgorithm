package Leetcode._033_M_Search_In_Rotated_Sorted_Array;

/*
Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.

Your algorithm's runtime complexity must be in the order of O(log n).

Example 1:

Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4
Example 2:

Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1


https://leetcode-cn.com/problems/search-in-rotated-sorted-array

 */

public class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {

            int mid =  left + (right - left) / 2;

            if (nums[mid] == target) { return mid; }

            if (nums[left] <= nums[mid]) {
                if (target >= nums[left] && target <= nums[mid]) { right = mid - 1; }
                else { left = mid + 1; }
            } else {
                if (target >= nums[mid] && target <= nums[right]) { left = mid + 1; }
                else { right = mid - 1; }
            }

//            if (mid <= 0 || mid >= nums.length - 1) { return -1;}
//            if (nums[mid - 1] == target) { return mid - 1; }
//            if ( nums[mid + 1] == target) { return mid + 1; }
//
//            mins = Math.min(nums[left], nums[mid - 1]);
//            maxs = Math.max(nums[left], nums[mid - 1]);
//            if (mins <= target && maxs >= target) {
//                right = mid - 1;
//                continue;
//            }
//
//            mins = Math.min(nums[right], nums[mid + 1]);
//            maxs = Math.max(nums[right], nums[mid + 1]);
//            if (mins <= target && maxs >= target) {
//                left = mid + 1;
//                continue;
//            }
//            return -1;
        }
        return -1;
    }

    private void unittest1() {
        System.out.println(search(new int[] {4,5,6,7,0,1,2}, 0) == 4);
        System.out.println(search(new int[] {4,5,6,7,0,1,2}, 3) == -1);
        System.out.println(search(new int[] {4,5,6,7,0,1,2}, 6) == 2);
        System.out.println(search(new int[] {5,6,7,8,9,0,1,2,3,4}, 4) == 9);
        System.out.println(search(new int[] { }, 0) == -1);
        System.out.println(search(new int[] {1,3}, 0) == -1);
        System.out.println(search(new int[] {1,3}, 3) == 1);
    }
    private void unittest2() {
        int[] a = {5,6,7,8,9,0,1,2,3,4};
        for (int i = 0; i < a.length; i++) {
            System.out.println(search(a, i));
        }
        System.out.println();
    }

    public static void main(String[] args) {
        SearchInRotatedSortedArray a = new SearchInRotatedSortedArray();
        a.unittest1();
        a.unittest2();
    }
}
