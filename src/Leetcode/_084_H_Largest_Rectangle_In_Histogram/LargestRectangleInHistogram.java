package Leetcode._084_H_Largest_Rectangle_In_Histogram;

import java.util.Stack;

/*
Given n non-negative integers representing the histogram's bar height where the width of each bar is 1,
find the area of largest rectangle in the histogram.

 
Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].


The largest rectangle is shown in the shaded area, which has area = 10 unit.

 
Example:

Input: [2,1,5,6,2,3]
Output: 10


https://leetcode-cn.com/problems/largest-rectangle-in-histogram

 */
public class LargestRectangleInHistogram {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int maxArea = 0;

        for (int i = 0; i < heights.length; ++i) {
            while (stack.peek() != -1 && heights[stack.peek()] >= heights[i]) {
                maxArea = Math.max(maxArea, heights[stack.pop()] * (i - stack.peek() - 1));
            }
            stack.push(i);
        }
        while (stack.peek() != -1) {
            maxArea = Math.max(maxArea, heights[stack.pop()] * (heights.length - stack.peek() - 1));
        }
        return maxArea;
    }

    public void unittest1() {
        System.out.println(largestRectangleArea(new int[] {2,1,5,6,2,3}));
    }

    public static void main(String[] args) {
        LargestRectangleInHistogram a = new LargestRectangleInHistogram();
        a.unittest1();
    }
}
