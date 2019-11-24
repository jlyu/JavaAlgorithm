package Leetcode._011_M_Container_With_Most_Water;

/*
Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai).
n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines,
which together with x-axis forms a container, such that the container contains the most water.
Note: You may not slant the container and n is at least 2.


The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7].
In this case, the max area of water (blue section) the container can contain is 49.

 
Example:
Input: [1,8,6,2,5,4,8,3,7]
Output: 49


链接：https://leetcode-cn.com/problems/container-with-most-water
 */

public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxAreas = -1;

        while (left < right) {
            int h = Math.min(height[left], height[right]);
            int l = right - left;

            maxAreas = (h * l > maxAreas) ? (h * l) : maxAreas;

            if (height[left] <= height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxAreas;
    }

    public void unittest1() {
        System.out.println(maxArea(new int[] {1,8,6,72,5,4,8,3,7}));
        System.out.println(maxArea(new int[] {1}));
    }

    public static void main(String[] args) {
        ContainerWithMostWater a = new ContainerWithMostWater();
        a.unittest1();
    }
}
