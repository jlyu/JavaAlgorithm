package Leetcode._406_M_Queue_Reconstruction_By_Height;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/*
Suppose you have a random list of people standing in a queue. Each person is described by a pair of integers (h, k),
where h is the height of the person and k is the number of people in front of this person who have a height greater
than or equal to h. Write an algorithm to reconstruct the queue.

Note:
The number of people is less than 1,100.

 
Example

Input:
[[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]

Output:
[[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]


https://leetcode-cn.com/problems/queue-reconstruction-by-height
 */
public class _406_M_Queue_Reconstruction_By_Height {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0];
            }
        });

        List<int[]> list = new LinkedList<>();
        for(int[] p : people) {
            list.add(p[1], p);
        }
        int n = people.length;
        return list.toArray(new int[n][2]);
    }

    public void unittest1() {
        reconstructQueue(new int[][] {{7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}});
    }

    public static void main(String[] args) {
        _406_M_Queue_Reconstruction_By_Height a = new _406_M_Queue_Reconstruction_By_Height();
        a.unittest1();
    }
}
