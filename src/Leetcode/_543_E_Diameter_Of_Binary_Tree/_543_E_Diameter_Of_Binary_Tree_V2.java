package Leetcode._543_E_Diameter_Of_Binary_Tree;

import javafx.util.Pair;

/*
Given a binary tree, you need to compute the length of the diameter of the tree.
The diameter of a binary tree is the length of the longest path between any two nodes in a tree.
This path may or may not pass through the root.

Example:
Given a binary tree
          1
         / \
        2   3
       / \
      4   5
Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].

Note: The length of path between two nodes is represented by the number of edges between them.


https://leetcode-cn.com/problems/diameter-of-binary-tree

 */
public class _543_E_Diameter_Of_Binary_Tree_V2 {
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

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private int maxValue = 1;
    private int deep(TreeNode root) {
         if (root == null) { return 0; }
         int L = deep(root.left);
         int R = deep(root.right);
         maxValue = Math.max(maxValue, L + R + 1);
         return Math.max(L, R) + 1;
    }

    public int diameterOfBinaryTree(TreeNode root) {
         deep(root);
         return maxValue - 1;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void unittest0() {
        TreeNode root = createBinaryTreeByArray(new int[] {1,2}, 0);
        System.out.println(diameterOfBinaryTree(root)); //1
    }
    public void unittest1() {
        TreeNode root = createBinaryTreeByArray(new int[] {1,2,3,4,5}, 0);
        System.out.println(diameterOfBinaryTree(root)); //3
    }

    public void unittest2() {
        TreeNode root = createBinaryTreeByArray(new int[] {4,1,Integer.MIN_VALUE,2,Integer.MIN_VALUE,Integer.MIN_VALUE,Integer.MIN_VALUE,3}, 0);
        System.out.println(diameterOfBinaryTree(root)); //3
    }

    public void unittest3() {
        TreeNode root = createBinaryTreeByArray(new int[] {4,2,Integer.MIN_VALUE,1,3}, 0);
        System.out.println(diameterOfBinaryTree(root)); //3
    }

    public static void main(String[] args) {
        _543_E_Diameter_Of_Binary_Tree_V2 a = new _543_E_Diameter_Of_Binary_Tree_V2();
        //a.unittest0(); //1
        //a.unittest1(); //3
        //a.unittest2(); //3
        a.unittest3(); //2
    }
}
