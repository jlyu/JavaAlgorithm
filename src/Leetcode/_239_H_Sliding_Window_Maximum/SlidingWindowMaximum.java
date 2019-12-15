package Leetcode._239_H_Sliding_Window_Maximum;

import java.util.*;

/*
Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the
very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.
Return the max sliding window.

Example:

Input: nums = [1,3,-1,-3,5,3,6,7], and k = 3
Output: [3,3,5,5,6,7]
Explanation:

Window position                Max
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7
Note:
You may assume k is always valid, 1 ≤ k ≤ input array's size for non-empty array.

Follow up:
Could you solve it in linear time?


https://leetcode-cn.com/problems/sliding-window-maximum

 */
public class SlidingWindowMaximum {
    public class DequeWithMax<T extends Comparable> {
        private Deque<T> dataQ;
        private Deque<T> maxQ;

        public DequeWithMax() {
            this.dataQ = new LinkedList<T>();
            this.maxQ = new LinkedList<T>();
        }


        public void pushBack(T v) {
            while ((!maxQ.isEmpty()) && maxQ.getLast().compareTo(v) < 0) {
                maxQ.pollLast();
            }

            dataQ.offerLast(v);
            maxQ.offerLast(v);

        }

        public void popFront() {
            if (maxQ.isEmpty()) {
                try {
                    throw new Exception("Deque is empty.");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            if (maxQ.getFirst() == dataQ.getFirst()) {
                maxQ.pollFirst();
            }
            dataQ.pollFirst();
        }

        public T getMax() {
            if (maxQ.isEmpty()) {
                try {
                    throw new Exception("Deque is empty.");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            return maxQ.getFirst();
        }
    }
    public int[] maxSlidingWindow(int[] nums, int k) {
        LinkedList<Integer> maxInWindows = new LinkedList<>();
        if (k < 1 || nums.length < k) { return new int[]{}; }
        DequeWithMax<Integer> dq = new DequeWithMax<Integer>();
        for (int i = 0; i < k; i++) {
            dq.pushBack(nums[i]);
        }
        maxInWindows.add( dq.getMax() );

        for (int i = k; i < nums.length; i++) {
            dq.pushBack(nums[i]);
            dq.popFront();
            maxInWindows.add( dq.getMax() );
        }
        return maxInWindows.stream().mapToInt(Integer::valueOf).toArray();
    }

    public void unittest1() {
        System.out.println(maxSlidingWindow(new int[] { }, 3));
    }

    public static void main(String[] args) {
        SlidingWindowMaximum a = new SlidingWindowMaximum();
        a.unittest1();
    }
}


