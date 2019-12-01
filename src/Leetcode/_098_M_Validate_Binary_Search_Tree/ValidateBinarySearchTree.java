package Leetcode._098_M_Validate_Binary_Search_Tree;
/*
Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
 

Example 1:

    2
   / \
  1   3

Input: [2,1,3]
Output: true
Example 2:

    5
   / \
  1   4
     / \
    3   6

Input: [5,1,4,null,null,3,6]
Output: false
Explanation: The root node's value is 5 but its right child's value is 4.


https://leetcode-cn.com/problems/validate-binary-search-tree
*/

import static java.lang.Integer.MIN_VALUE;

public class ValidateBinarySearchTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private double currValue = Double.MIN_VALUE;

    public boolean isValidBST(TreeNode root) {

        if (root == null) { return true; }

        boolean result =  isValidBST(root.left);

        if (currValue < root.val) {
            currValue = (double) root.val;
        } else {
            return false;
        }
        return result && isValidBST(root.right);
    }

    public void unittest1() {
        System.out.println(isValidBST(new TreeNode(-2147483648)));
    }

    public static void main(String[] args) {
        ValidateBinarySearchTree a = new ValidateBinarySearchTree();
        a.unittest1();
    }
}
