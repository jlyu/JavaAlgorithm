package Leetcode._337_M_House_Robber_III;

import javafx.util.Pair;



/*
The thief has found himself a new place for his thievery again. There is only one entrance to this area,
called the "root." Besides the root, each house has one and only one parent house. After a tour, the smart thief
realized that "all houses in this place forms a binary tree". It will automatically contact the police if
two directly-linked houses were broken into on the same night.

Determine the maximum amount of money the thief can rob tonight without alerting the police.

Example 1:

Input: [3,2,3,null,3,null,1]

     3
    / \
   2   3
    \   \
     3   1

Output: 7
Explanation: Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.
Example 2:

Input: [3,4,5,1,3,null,1]

     3
    / \
   4   5
  / \   \
 1   3   1

Output: 9
Explanation: Maximum amount of money the thief can rob = 4 + 5 = 9.


https://leetcode-cn.com/problems/house-robber-iii
*/
public class HouseRobberIII {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    private TreeNode createBinaryTreeByArray(int[] a, int index) {
        if (a.length == 0 || index >= a.length) { return null; }
        if (a[index] == Integer.MIN_VALUE) { return null; }
        TreeNode root = new TreeNode(a[index]);
        root.left = createBinaryTreeByArray(a, 2 * index + 1);
        root.right = createBinaryTreeByArray(a, 2 * index + 2);
        return root;
    }

    private int[] lvNodes;
    private int[][] dp;
    private int maxLevel;

    private void robHelper(TreeNode node, int level) {
        if (node == null) { return; }
        lvNodes[level] += node.val;
        maxLevel = Math.max(maxLevel, level);
        robHelper(node.left, level + 1);
        robHelper(node.right, level + 1);
    }

    public int rob_(TreeNode root) {
        maxLevel = 0;
        lvNodes = new int[1024];
        robHelper(root, 1);
        dp = new int[maxLevel + 1][2];

        for (int i = 1; i <= maxLevel; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + lvNodes[i]);
            dp[i][1] = dp[i - 1][0];
        }
        return Math.max(dp[maxLevel][0], dp[maxLevel][1]);
    }
    ///////////////////////////////////////////////////////////////////////////
    Pair<Integer, Integer> dfs(TreeNode root) {
        if (root == null) {
            return new Pair<>(0,0);
        }

        Pair<Integer, Integer> left  = dfs(root.left);
        Pair<Integer, Integer> right = dfs(root.right);

        return new Pair<> (
            root.val + left.getValue() + right.getValue(),
            Math.max(left.getKey(), left.getValue()) + Math.max(right.getKey(), right.getValue())
        );
    }

    public int rob(TreeNode root) {
        Pair<Integer, Integer> p = dfs(root);
        return Math.max(p.getKey(), p.getValue());
    }

    ///////////////////////////////////////////////////////////////////////////
    public void unittest1() {
        int[] nodes = new int[] {3,2,3,Integer.MIN_VALUE,3,Integer.MIN_VALUE,1};
        TreeNode root = createBinaryTreeByArray(nodes, 0);
        System.out.println(rob(root));
    }
    public void unittest2() {
        int[] nodes = new int[] {3,4,5,1,3,Integer.MIN_VALUE,1};
        TreeNode root = createBinaryTreeByArray(nodes, 0);
        System.out.println(rob(root));
    }
    public void unittest3() {
        int[] nodes = new int[] {4,1,Integer.MIN_VALUE,2,Integer.MIN_VALUE,Integer.MIN_VALUE,Integer.MIN_VALUE,3};
        TreeNode root = createBinaryTreeByArray(nodes, 0);
        System.out.println(rob(root));
    }


    public static void main(String[] args) {
        HouseRobberIII a = new HouseRobberIII();
        //a.unittest1(); //7
        a.unittest2(); //9
        //a.unittest3(); //7
    }
}
