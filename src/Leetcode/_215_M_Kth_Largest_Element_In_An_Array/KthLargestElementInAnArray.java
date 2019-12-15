package Leetcode._215_M_Kth_Largest_Element_In_An_Array;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/*
Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order,
not the kth distinct element.

Example 1:

Input: [3,2,1,5,6,4] and k = 2
Output: 5
Example 2:

Input: [3,2,3,1,2,4,5,5,6] and k = 4
Output: 4


Note:
You may assume k is always valid, 1 ≤ k ≤ array's length.


https://leetcode-cn.com/problems/kth-largest-element-in-an-array

 */
public class KthLargestElementInAnArray {
    public class MinHeapPriorityQueueImpl {
        private PriorityQueue<Integer> minHeap;
        private int size;

        public MinHeapPriorityQueueImpl(int size) {
            this.size = size;
            this.minHeap = new PriorityQueue<Integer>(size, new Comparator<Integer>() {

                @Override
                public int compare(Integer o1, Integer o2) {
                    return o1.compareTo(o2);
                }
            });
        }

        public int size() { return minHeap.size(); }

        public void offer(int ele) {
            minHeap.offer(ele);
        }

        public Integer poll() { return minHeap.poll(); }

        public Integer peek() { return minHeap.peek(); }

        public ArrayList<Integer> toArray() {
            ArrayList<Integer> result = new ArrayList<Integer>();
            for (Integer integer : minHeap) {
                result.add(integer);
            }
            return result;
        }
    }

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(k + 1); // + 1 = keyPoint
        for (int n: nums) {
            minHeap.add(n);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        return minHeap.poll();
    }
    ////////////////////////////////////////////////////////////////
    public void unittest1() {
        System.out.println( findKthLargest(new int[] {3,2,1,5,6,4}, 2));
        System.out.println( findKthLargest(new int[] {3,2,3,1,2,4,5,5,6}, 4));
    }

    public static void main(String[] args) {
        KthLargestElementInAnArray a = new KthLargestElementInAnArray();
        a.unittest1();
    }
}
