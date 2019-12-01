package Leetcode._104_E_Maximum_Depth_Of_Binary_Tree;
/*
Given a binary tree, find its maximum depth.

The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

Note: A leaf is a node with no children.

Example:

Given binary tree [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
return its depth = 3.

https://leetcode-cn.com/problems/maximum-depth-of-binary-tree

 */
public class MaximumDepthOfBinaryTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode createBinaryTreeByArray(int[] a, int index) {
        if (a.length == 0 || index >= a.length) { return null; }
        if (a[index] == 0x80000000) { return null; }
        TreeNode root = new TreeNode(a[index]);
        root.left = createBinaryTreeByArray(a, 2 * index + 1);
        root.right = createBinaryTreeByArray(a, 2 * index + 2);
        return root;
    }

    private int maxDepthHelper(TreeNode node, int level) {
        if (node == null) { return level; }
        level++;
        return Math.max(maxDepthHelper(node.left, level), maxDepthHelper(node.right, level));
    }

    public int maxDepth(TreeNode root) {
        return maxDepthHelper(root, 0);
    }

    public void unittest1() {
        TreeNode root = createBinaryTreeByArray(new int[] {1,2}, 0);
        System.out.println(maxDepth(root));
    }

    public static void main(String[] args) {
        MaximumDepthOfBinaryTree a = new MaximumDepthOfBinaryTree();
        a.unittest1();
    }
}
