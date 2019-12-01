package Leetcode._105_M_Construct_Binary_Tree_From_Preorder_And_Inorder_Traversal;
/*
Given preorder and inorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.

For example, given

preorder = [3,9,20,15,7]
inorder = [9,3,15,20,7]
Return the following binary tree:

    3
   / \
  9  20
    /  \
   15   7

https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal

Same as CodingRush._07_Tree_RebuildTree
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode buildTree(int[] preOrder, int pStart, int pEnd, int[] inOrder, int iStart, int iEnd) {
        if (pStart > pEnd || iStart > iEnd) { return null; }

        TreeNode root = new TreeNode(preOrder[pStart]);

        for (int i = iStart; i <= iEnd; i++) {
            if (inOrder[i] == preOrder[pStart]) {
                root.left  = buildTree(preOrder, pStart + 1, pStart + i - iStart, inOrder, iStart, i-1);
                root.right = buildTree(preOrder, pStart + i - iStart + 1, pEnd,              inOrder, i + 1, iEnd);
                break;
            }
        }
        return root;
    }
}


