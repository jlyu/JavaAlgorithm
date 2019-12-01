package Leetcode._094_M_Binary_Tree_Inorder_Traversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
Given a binary tree, return the inorder traversal of its nodes' values.

Example:

Input: [1,null,2,3]
   1
    \
     2
    /
   3

Output: [1,3,2]
Follow up: Recursive solution is trivial, could you do it iteratively?


https://leetcode-cn.com/problems/binary-tree-inorder-traversal
 */
public class BinaryTreeInorderTraversal {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }

    private List<Integer> inorder = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) { return inorder; }

        inorderTraversal(root.left);
        inorder.add(root.val);
        inorderTraversal(root.right);

        return inorder;
    }

    public List<Integer> inorderTraversal_V2(TreeNode root) {

        List<Integer> inorder = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            inorder.add(node.val);
            node = node.right;
        }

        return inorder;
    }
}
