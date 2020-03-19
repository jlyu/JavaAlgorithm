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
public class FlattenBinaryTreeToLinkedList_V2 {
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

    public void flatten(TreeNode root) {
        if (root == null) { return; }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode preNode = null;

        while (!stack.isEmpty()) {
            TreeNode tmpNode = stack.pop();
            if (preNode != null) {
                preNode.right = tmpNode;
                preNode.left = null;
            }
            if (tmpNode.right != null) { stack.push(tmpNode.right); }
            if (tmpNode.left  != null) { stack.push(tmpNode.left); }

            preNode = tmpNode;
        }

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
        FlattenBinaryTreeToLinkedList_V2 a = new FlattenBinaryTreeToLinkedList_V2();
        a.unittest1();
    }
}
