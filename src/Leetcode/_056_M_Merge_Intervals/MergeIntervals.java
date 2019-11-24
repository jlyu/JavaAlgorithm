package Leetcode._056_M_Merge_Intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/*
Given a collection of intervals, merge all overlapping intervals.

Example 1:

Input: [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
Example 2:

Input: [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.
NOTE: input types have been changed on April 15, 2019. Please reset to default code definition to get new method signature.


https://leetcode-cn.com/problems/merge-intervals
 */
public class MergeIntervals {

    public int[][] merge(int[][] intervals) {

        if (intervals.length <= 1) { return intervals; }

        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        List<int[]> list = new ArrayList<>();
        for (int i = 1; i < intervals.length; i++) {
            int[] one = intervals[i-1];
            int[] two = intervals[i];

            if (two[0] > one[1]) {
                list.add(one);
            } else if (two[0] <= one[1]) {
                two[0] = one[0];
                two[1] = Math.max(one[1], two[1]);
            }

            if (i == intervals.length - 1) {
                list.add(two);
            }
        }

        return list.toArray(new int[0][]);
    }

    public void printMarix(int[][] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.println(Arrays.toString(a[i]));
        }
    }

    public void unittest1() {
        printMarix(merge(new int[][] { {15,18}, {2, 6}, {1, 3}, {8,10} }));
        System.out.println();
        printMarix(merge(new int[][] { {1,4}, {4,5} }));
        System.out.println();
        printMarix(merge(new int[][] { {} }));
        printMarix(merge(new int[][] { {1,3} }));
        System.out.println();
        printMarix(merge(new int[][] { {1,9},{2,4},{2,3},{5,9},{4,5},{5,6},{9,10},{11,12},{7,9} }));
    }

    public static void main(String[] args) {
        MergeIntervals a = new MergeIntervals();
        a.unittest1();
    }


}
