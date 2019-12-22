package Leetcode._312_H_Burst_Balloons;



import java.util.*;

public class BurstBalloons {
    private HashMap<String, Integer> hash = new HashMap<>();
    //private int[][] dp;

    private int backtrack(List<Integer> list) {
        if (hash.containsKey(list.toString())) { return hash.get(list.toString()); }
        if (list.size() == 1) { return list.get(0); }


        int maxValue = 0;
        for (int i = 0; i < list.size(); i++) {
            int prevValue = (i - 1 >= 0) ? list.get(i - 1) : 1;
            int currValue = list.get(i);
            int nextValue = (i + 1 < list.size()) ? list.get(i + 1) : 1;

            list.remove(i);
            int backCoins = backtrack(list);
            int currCoins = (prevValue * currValue * nextValue) + backCoins;
            hash.put(list.toString(), backCoins);
            list.add(i, currValue);

            maxValue = Math.max(maxValue, currCoins);
        }
        hash.put(list.toString(), maxValue);
        return maxValue;
    }

    private int dfs(int[][] memo, int[] list, int i, int j) {
        int ans = memo[i][j];
        if (ans > -1) { return ans; }
        if (i > j) { return 0; }
        for (int k = i; i <= j; i++) {
            ans = Math.max(ans, (list[i-1] * list[k] * list[j + 1]
                                + dfs(memo, list, i, k - 1)
                                + dfs(memo, list, k+1, j))
            );
        }
        return ans;
    }

    private int dpHelper(int[][] dp, int[] nums, int i, int j) {
        if (i > j) { return 0; }
        if (dp[i][j] > 0) { return dp[i][j]; }

        for (int k = i; k <= j; k++) {
            int left = dpHelper(dp, nums, i, k - 1);
            int right = dpHelper(dp, nums, k + 1, j);
            int value = nums[i - 1] * nums[k] * nums[j + 1];
            dp[i][j] = Math.max(dp[i][j], left + right + value);
        }
        return dp[i][j];
    }
    public int maxCoins(int[] nums) {
        final int N = nums.length;
        int[] A = new int[N + 2];
        A[0] = A[A.length - 1] = 1;
        for (int i = 1; i < N + 1; i++) { A[i] = nums[i - 1]; }
        int len = A.length;

        int[][] dp = new int[len][len];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                dp[i][j] = 0;
            }
        }
        return dpHelper(dp, A, 1, N);
    }

    public void unittest1() {
          //System.out.println(maxCoins(new int[] {3,8}));
//        System.out.println(maxCoins(new int[] {3,5}));
//        System.out.println(maxCoins(new int[] {5,8}));
//        System.out.println(maxCoins(new int[] {3,5,8}));
//        System.out.println(maxCoins(new int[] {}));
//        System.out.println(maxCoins(new int[] {8}));
        System.out.println(maxCoins(new int[] {3,1,5,8}));
        //System.out.println(maxCoins(new int[] {7,9,8,0,7,1,3,5,5,2,3,3}));
        System.out.println(maxCoins(new int[] {8,2,6,8,9,8,1,4,1,5,3,0,7,7,0,4,2,2}));

    }

    public static void main(String[] args) {
        BurstBalloons a = new BurstBalloons();
        a.unittest1();
    }
}
