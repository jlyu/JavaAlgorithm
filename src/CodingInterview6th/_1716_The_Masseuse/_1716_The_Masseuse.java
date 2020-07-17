package CodingInterview6th._1716_The_Masseuse;
/*
A popular masseuse receives a sequence of back-to-back appointment requests and is debating which ones to accept. She needs a break between appointments and therefore she cannot accept any adjacent requests. Given a sequence of back-to-back appoint­ ment requests, find the optimal (highest total booked minutes) set the masseuse can honor. Return the number of minutes.

Note: This problem is slightly different from the original one in the book.

 

Example 1:

Input:  [1,2,3,1]
Output:  4
Explanation:  Accept request 1 and 3, total minutes = 1 + 3 = 4
Example 2:

Input:  [2,7,9,3,1]
Output:  12
Explanation:  Accept request 1, 3 and 5, total minutes = 2 + 9 + 1 = 12
Example 3:

Input:  [2,1,4,5,3,1,1,3]
Output:  12
Explanation:  Accept request 1, 3, 5 and 8, total minutes = 2 + 4 + 3 + 3 = 12


https://leetcode-cn.com/problems/the-masseuse-lcci

 */
public class _1716_The_Masseuse {
    public int massage(int[] nums) {
        int l = nums.length;
        if (l == 0) { return 0; }
        int[][] dp = new int[l][2];
        dp[0][0] = nums[0];

        for (int i = 1; i < l; i++) {
            dp[i][0] = Math.max(nums[i] + dp[i-1][1], dp[i-1][0]);
            dp[i][1] = Math.max(dp[i-1][0], dp[i-1][1]);
        }
        return Math.max(dp[l-1][0], dp[l-1][1]);
    }

    public void unittest1() {
        System.out.println(massage(new int[] {1,2,3,1}));
    }

    public void unittest2() {
        System.out.println(massage(new int[] {2,7,9,3,1}));
    }

    public void unittest3() {
        System.out.println(massage(new int[] {2,1,4,5,3,1,1,3}));
    }

    public static void main(String[] args) {
        _1716_The_Masseuse a = new _1716_The_Masseuse();
        a.unittest1();
        a.unittest2();
        a.unittest3();
    }
}
