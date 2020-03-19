package Leetcode._836_E_Rectangle_Overlap;
/*
A rectangle is represented as a list [x1, y1, x2, y2], where (x1, y1) are the coordinates of its bottom-left corner,
and (x2, y2) are the coordinates of its top-right corner.

Two rectangles overlap if the area of their intersection is positive.
To be clear, two rectangles that only touch at the corner or edges do not overlap.

Given two (axis-aligned) rectangles, return whether they overlap.

Example 1:

Input: rec1 = [0,0,2,2], rec2 = [1,1,3,3]
Output: true
Example 2:

Input: rec1 = [0,0,1,1], rec2 = [1,0,2,1]
Output: false
Notes:

Both rectangles rec1 and rec2 are lists of 4 integers.
All coordinates in rectangles will be between -10^9 and 10^9.

https://leetcode-cn.com/problems/rectangle-overlap/
 */
public class _836_E_Rectangle_Overlap {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        return !(rec1[2] <= rec2[0] ||   // left
                rec1[3] <= rec2[1] ||   // bottom
                rec1[0] >= rec2[2] ||   // right
                rec1[1] >= rec2[3]);    // top
    }

    private boolean isRectangle(int[] rec) {
        if (rec.length != 4) { return false; }
        if ((rec[0] == rec[2]) || (rec[1] == rec[3])) { return false; }
        return true;
    }


    private boolean isRectangleOverlapCore(int[] rec1, int[] rec2) {
        int counter = 0;
        counter = isPointInRectangle(rec1, rec2[0], rec2[1])
                + isPointInRectangle(rec1, rec2[2], rec2[1])
                + isPointInRectangle(rec1, rec2[0], rec2[3])
                + isPointInRectangle(rec1, rec2[2], rec2[3]);
        return (counter >= 1);
    }

    private int isPointInRectangle(int[] rec, int x, int y) {
        if ((x >= rec[2] || x <= rec[0]) || (y <= rec[1] || y >= rec[3])) {
            return 0;
        }
        return 1;
    }

    ////////////////////////////////////////////////////////////////////////
    public void unittest1() {
        int[] rec1 = {0,0,2,2};
        int[] rec2 = {1,1,3,3};
        System.out.println(isRectangleOverlap(rec1, rec2) == true);
    }

    public void unittest2() {
        int[] rec1 = {0,0,1,1};
        int[] rec2 = {1,0,2,1};
        System.out.println(isRectangleOverlap(rec1, rec2) == false);
    }

    public void unittest3() {
        int[] rec1 = {7,8,13,15};
        int[] rec2 = {10,8,12,20};
        System.out.println(isRectangleOverlap(rec1, rec2) == true);
    }

    public void unittest4() {
        int[] rec1 = {11,12,13,13};
        int[] rec2 = {17,1,17,19};
        System.out.println(isRectangleOverlap(rec1, rec2) == false);
    }

    public void unittest5() {
        int[] rec1 = {5,15,8,18};
        int[] rec2 = {0,3,7,9};
        System.out.println(isRectangleOverlap(rec1, rec2) == false);
    }

    public static void main(String[] args) {
        _836_E_Rectangle_Overlap a = new _836_E_Rectangle_Overlap();
        a.unittest1();
        a.unittest2();
        a.unittest3();
        a.unittest4();
        a.unittest5();
    }
}

