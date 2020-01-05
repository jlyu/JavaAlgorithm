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
public class _543_E_Diameter_Of_Binary_Tree {
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
    private Pair<Integer, Integer> core_(TreeNode root, int path) {
        if (root == null) { return new Pair<>(-1, path - 1); }

        Pair<Integer, Integer> left  = core_(root.left, path + 1);
        Pair<Integer, Integer> right = core_(root.right, path + 1);

        int withRoot    = (left.getKey() + right.getKey() <= 0)     ? 0 : left.getKey() + right.getKey() + 2;
        int withoutRoot = (left.getValue() + right.getValue() <= 0) ? 1 : Math.max(left.getKey(), right.getKey());
        return new Pair<>(withRoot, withoutRoot);  // <with root, max path without root >
    }



    private int maxValue = 0;
    private Pair<Integer, Integer> core(TreeNode root) {
        if (root == null) { return new Pair<>(-1, -1); }

        Pair<Integer, Integer> left  = core(root.left);
        Pair<Integer, Integer> right = core(root.right);

        int withRoot = (left.getKey() + right.getKey() <= -2)        ? 0 : left.getValue() + right.getValue() + 2;
        int withoutRoot = (left.getValue() + right.getValue() <= -2) ? 0 : Math.max(left.getValue(), right.getValue()) + 1;
        maxValue = Math.max(Math.max(withRoot, withoutRoot), maxValue);
        return new Pair<>(withRoot, withoutRoot);  // <with root, max path without root >
    }

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) { return 0; }
        Pair<Integer, Integer> res = core(root);
        return maxValue; //Math.max(res.getKey(), res.getValue());
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
        _543_E_Diameter_Of_Binary_Tree a = new _543_E_Diameter_Of_Binary_Tree();
        //a.unittest0(); //1
        //a.unittest1(); //3
        //a.unittest2(); //3
        a.unittest3(); //2
    }
}
