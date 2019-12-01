package Leetcode._101_E_Symmetric_Tree;

/*
Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

For example, this binary tree [1,2,2,3,4,4,3] is symmetric:

    1
   / \
  2   2
 / \ / \
3  4 4  3
 

But the following [1,2,2,null,3,null,3] is not:

    1
   / \
  2   2
   \   \
   3    3
 

Note:
Bonus points if you could solve it both recursively and iteratively.

https://leetcode-cn.com/problems/symmetric-tree
 */
public class SymmetricTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private boolean isSymmetricHelper(TreeNode leftNode, TreeNode rightNode) {
        if (leftNode == null && rightNode == null) {
            return true;
        }

        if (leftNode != null && rightNode != null) {
            if (leftNode.val != rightNode.val) {
                return false;
            }
        } else if ((leftNode == null && rightNode != null) || (leftNode != null && rightNode == null)) {
            return false;
        }


        return isSymmetricHelper(leftNode.left, rightNode.right)
                && isSymmetricHelper(leftNode.right, rightNode.left);
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) { return true; }
        return isSymmetricHelper(root.left, root.right);
    }

}
