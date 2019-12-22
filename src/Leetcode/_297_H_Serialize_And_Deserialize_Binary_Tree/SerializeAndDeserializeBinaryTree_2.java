package Leetcode._297_H_Serialize_And_Deserialize_Binary_Tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SerializeAndDeserializeBinaryTree_2 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    //////////////////////////////////////////////

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

    private TreeNode deserializeHelper(List<String> list) {
        if (list.isEmpty()) { return null; }
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
        String[] aNodes = data.split(",");
        List<String> list = new LinkedList<>(Arrays.asList(aNodes));
        return deserializeHelper(list);
    }


    public void unittest1() {
        TreeNode root = deserialize("1,2,3,null,null,4,5,null,null,");
        //TreeNode root = deserialize("1,2,null,3,");
        String treeStr = serialize(root);
        System.out.println(treeStr);
    }

    public static void main(String[] args) {
        String sPeriod = "12";
        String sResult = sPeriod.substring(0, Math.min(3, sPeriod.length()));

        SerializeAndDeserializeBinaryTree_2 a = new SerializeAndDeserializeBinaryTree_2();
        a.unittest1();
    }
}
