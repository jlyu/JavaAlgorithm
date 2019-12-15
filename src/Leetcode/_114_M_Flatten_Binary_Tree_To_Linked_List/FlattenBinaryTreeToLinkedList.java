package Leetcode._114_M_Flatten_Binary_Tree_To_Linked_List;

import java.util.Stack;

/*
Given a binary tree, flatten it to a linked list in-place.

For example, given the following tree:

    1
   / \
  2   5
 / \   \
3   4   6
The flattened tree should look like:

1
 \
  2
   \
    3
     \
      4
       \
        5
         \
          6


https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list

 */
public class FlattenBinaryTreeToLinkedList {
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

    /////////////////////////////////////////////////////////////////
    private TreeNode flattenHelper(TreeNode root) {
        if (root == null) { return root; }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode newRoot = root;
        TreeNode resRoot = root;

        while (root != null) {
            TreeNode flattenNode = flattenHelper(root.right);
            if (flattenNode != null) { stack.push(flattenNode); }
            if (root.left != null) {
                newRoot.right = new TreeNode(root.left.val);
                newRoot = newRoot.right;
            }
            root = root.left;
        }

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            newRoot.right = node;
            while (newRoot.right != null) {
                newRoot = newRoot.right;
            }
        }
        resRoot.left = null;
        return resRoot;
    }

    public void flatten(TreeNode root) {
        if (root == null) { return; }
        TreeNode newRoot = flattenHelper(root);
        root = newRoot;
        root.left = null;
    }


    /////////////////////////////////////////////////////////////////
    public void unittest1() {
        //TreeNode root = createBinaryTreeByArray(new int[] {1,2,5,3,4,0x80000000,6,0x80000000,0x80000000,7}, 0);
        TreeNode root = createBinaryTreeByArray(new int[] {1,0x80000000,2,3,4}, 0);
        flatten(root);
        while(root != null) {
            System.out.print(root.val + " -> ");
            root = root.right;
        }
    }

    public static void main(String[] args) {
        FlattenBinaryTreeToLinkedList a = new FlattenBinaryTreeToLinkedList();
        a.unittest1();
    }
}
