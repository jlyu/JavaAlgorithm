package Leetcode._102_M_Binary_Tree_Level_Order_Traversal;
/*
Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its level order traversal as:
[
  [3],
  [9,20],
  [15,7]
]


https://leetcode-cn.com/problems/binary-tree-level-order-traversal
 */
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {
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


    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        if (root == null) { return lists; }

        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        queue.add(root);

        int[] count =  new int[1024];
        int currLevel = 0;
        count[currLevel] = 1;

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            count[currLevel]--;
            list.add(node.val);

            if (node.left != null) {
                queue.add(node.left);
                count[currLevel + 1]++;
            }
            if (node.right != null) {
                queue.add(node.right);
                count[currLevel + 1]++;
            }

            if (count[currLevel] == 0) {
                List<Integer> listCopy = new ArrayList<Integer>();
                listCopy.addAll(list);
                lists.add(listCopy);
                list.clear();
                currLevel++;
            }

        }
        return lists;
    }

    public void unittest1() {
        TreeNode root = this.createBinaryTreeByArray(new int[] {1,2,3,4,5}, 0);
        List<List<Integer>> lists = levelOrder(root);

        for (List<Integer> list: lists) {
            System.out.println(list.toString());
        }
    }

    public void unittest2() {
        TreeNode root = this.createBinaryTreeByArray(new int[] {3,9,20,0x80000000,0x80000000,15,7}, 0);
        List<List<Integer>> lists = levelOrder(root);

        for (List<Integer> list: lists) {
            System.out.println(list.toString());
        }
    }

    public static void main(String[] args) {
        BinaryTreeLevelOrderTraversal a = new BinaryTreeLevelOrderTraversal();
        //a.unittest1();
        a.unittest2();
    }
}
