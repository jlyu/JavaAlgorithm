package Leetcode._169_E_Majority_Element;
/*
Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.

You may assume that the array is non-empty and the majority element always exist in the array.

Example 1:

Input: [3,2,3]
Output: 3
Example 2:

Input: [2,2,1,1,1,2,2]
Output: 2


https://leetcode-cn.com/problems/majority-element



数组本身是无序的。如果要做排序的话，时间复杂度会上升到 O(n·logn) 那么这里肯定就不先考虑排序了，想想看如何通过一次遍历就拿到结果 O(n)
直觉就是弄一个散列表，数字作为key，出现次数作为value，再额外记录一下maxValue 这样遍历一遍下来就能拿到那个数了。 然后考虑一下是否能够不借助额外的数据结构（减少空间开销）
还是要从题目出发，要找的这个数字的出现次数占了整个数组长度的一半还要多，亦即，其他数字的个数加起来都没这个数多。用一个计数器记录当前数字出现的累计次数，
如果数字相同，则+1，如果数字不同，则-1，当计数器归零，则重新记录当前数字和计数器
 */
import java.util.HashMap;

public class MajorityElement {
    public int majorityElement(int[] nums) {
        int maxCount = 0;
        int target = -1;
        HashMap<Integer, Integer> hashmap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

                int c = hashmap.getOrDefault(nums[i], 0);
                hashmap.put(nums[i], c + 1);
                if (c + 1 > maxCount) {
                    maxCount = c + 1;
                    target = nums[i];
                }


        }
        return target;
    }

    public int majorityElement_V2(int[] nums) {
        int target = nums[0];
        int counter = 0;
        for (int i = 0; i < nums.length; i++) {
            if (counter == 0) {
                target = nums[i];
            }
            if (target == nums[i]) {
                counter++;
            } else {
                counter--;
            }
        }
        return target;
    }

    public void unittest1() {
        System.out.println(majorityElement_V2(new int[] {3,2,3}));
    }

    public static void main(String[] args) {
        MajorityElement a = new MajorityElement();
        a.unittest1();
    }
}
