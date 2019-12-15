package Leetcode._124_H_Binary_Tree_Maximum_Path_Sum;
/*
Given a non-empty binary tree, find the maximum path sum.

For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The path must contain at least one node and does not need to go through the root.

Example 1:

Input: [1,2,3]

       1
      / \
     2   3

Output: 6
Example 2:

Input: [-10,9,20,null,null,15,7]

   -10
   / \
  9  20
    /  \
   15   7

Output: 42


https://leetcode-cn.com/problems/binary-tree-maximum-path-sum

 */
public class BinaryTreeMaximumPathSum {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public TreeNode createBinaryTreeByArray(int[] a, int index) {
        if (a.length == 0 || index >= a.length) { return null; }
        if (a[index] == Integer.MIN_VALUE) { return null; }
        TreeNode root = new TreeNode(a[index]);
        root.left = createBinaryTreeByArray(a, 2 * index + 1);
        root.right = createBinaryTreeByArray(a, 2 * index + 2);
        return root;
    }
    /////////////////////////////////////////////////////////////////////
    private int maxPath = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        getMaxPath(root);
        return maxPath;
    }

    private int getMaxPath(TreeNode node) {
        if (node == null) { return 0; }
        int left = Math.max(0, getMaxPath(node.left));
        int right= Math.max(0, getMaxPath(node.right));
        maxPath = Math.max(maxPath, node.val + left + right);
        return Math.max(left, right) + node.val;
    }
    /////////////////////////////////////////////////////////////////////]
    public void unittest1() {
        TreeNode root = createBinaryTreeByArray(new int[] {-10,9,20,Integer.MIN_VALUE,Integer.MIN_VALUE,15,7}, 0);
        System.out.println(maxPathSum(root));
    }

    public static void main(String[] args) {
        BinaryTreeMaximumPathSum a = new BinaryTreeMaximumPathSum();
        a.unittest1();
    }
}
