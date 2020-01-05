package Leetcode._538_E_Convert_BST_To_Greater_Tree;
/*
Given a Binary Search Tree (BST), convert it to a Greater Tree such that every key of the original BST
is changed to the original key plus sum of all keys greater than the original key in BST.

Example:

Input: The root of a Binary Search Tree like this:
              5
            /   \
           2     13

Output: The root of a Greater Tree like this:
             18
            /   \
          20     13

https://leetcode-cn.com/problems/convert-bst-to-greater-tree
 */
public class _538_E_Convert_BST_To_Greater_Tree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private int convertBSTcore(TreeNode root, int preSum) {
        if (root == null) { return 0; }
        int right = convertBSTcore(root.right, preSum);
        int preVal = root.val;
        root.val += right + preSum;
        int left = convertBSTcore(root.left, root.val);
        return left + preVal + right;
    }
    public TreeNode convertBST_(TreeNode root) {
        convertBSTcore(root, 0);
        return root;
    }

    private int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        if (root == null) { return root; }
        convertBST(root.right);
        root.val += sum;
        sum = root.val;
        convertBST(root.left);
        return root;
    }
}
