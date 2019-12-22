package Leetcode._297_H_Serialize_And_Deserialize_Binary_Tree;

import java.util.*;

/*
Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored
in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or
another computer environment.

Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your
serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be serialized to
a string and this string can be deserialized to the original tree structure.

Example: 

You may serialize the following tree:

    1
   / \
  2   3
     / \
    4   5

as "[1,2,3,null,null,4,5]"
Clarification: The above format is the same as how LeetCode serializes a binary tree. You do not necessarily need
to follow this format, so please be creative and come up with different approaches yourself.

Note: Do not use class member/global/static variables to store states. Your serialize and deserialize algorithms
should be stateless.


https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree

 */
public class SerializeAndDeserializeBinaryTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    private void preOrderTraversal(TreeNode root, List<Integer> list) {
        if (root == null) {
            //list.add(Integer.MIN_VALUE);
            return;
        }

        list.add(root.val);
        preOrderTraversal(root.left, list);

        preOrderTraversal(root.right, list);
    }
    private void treeLevelTraversal(TreeNode root, List<Integer> list) {
        if (root == null) { return; }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            list.add(node.val); //System.out.print(node.value);
            if (node.left != null)  { queue.offer(node.left); }
            else { list.add(Integer.MIN_VALUE); }
            if (node.right != null) { queue.offer(node.right);}
            else { list.add(Integer.MIN_VALUE); }
        }
    }
    private TreeNode createBinaryTreeByArray(int[] a, int index) {
        if (a.length == 0 || index >= a.length) { return null; }
        if (a[index] == Integer.MIN_VALUE) { return null; }
        TreeNode root = new TreeNode(a[index]);
        root.left = createBinaryTreeByArray(a, 2 * index + 1);
        root.right = createBinaryTreeByArray(a, 2 * index + 2);
        return root;
    }

    private void serializeHelper(TreeNode node, StringBuffer sb) {
        if (node == null) {
            sb.append("null,");
            return;
        }
        sb.append(node.val).append(",");
        serializeHelper(node.left, sb);
        serializeHelper(node.right, sb);
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuffer sb = new StringBuffer();
        serializeHelper(root, sb);
        return sb.toString();
    }


    private TreeNode  deserializeHelper(List<String> list) {
        if (list.isEmpty()) {
            return null;
        }
        if (list.get(0).equals("null")) {
            list.remove(0);
            return null;
        }
        TreeNode root = new TreeNode(Integer.valueOf(list.get(0)));
        list.remove(0);
        root.left = deserializeHelper(list);
        root.right= deserializeHelper(list);
        return root;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] sNodes = data.split(",");
        List<String> list = new LinkedList<>(Arrays.asList(sNodes));
        return deserializeHelper(list);
    }


    public void unittest1() {
        TreeNode root = deserialize("1,2,3,null,null,4,5,null,null,");
        //TreeNode root = deserialize("1,2,null,3,");
        String treeStr = serialize(root);
        System.out.println(treeStr);
    }

    public static void main(String[] args) {
        SerializeAndDeserializeBinaryTree a = new SerializeAndDeserializeBinaryTree();
        a.unittest1();
    }
}
