package Leetcode._297_H_Serialize_And_Deserialize_Binary_Tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SerializeAndDeserializeBinaryTree_V3 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    //////////////////////////////////////////////
    // Your Codec object will be instantiated and called as such:
    // Codec codec = new Codec();
    // codec.deserialize(codec.serialize(root));
    // Encodes a tree to a single string.
    private StringBuffer serialzeHelper(TreeNode root, StringBuffer sb) {
        if (root == null) {
            sb.append("null,");
            return sb;
        }
        sb.append(root.val).append(",");
        serialzeHelper(root.left, sb);
        serialzeHelper(root.right, sb);
        return sb;
    }

    public String serialize(TreeNode root) {
        StringBuffer sb = new StringBuffer();
        sb = serialzeHelper(root, sb);
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
        String[] nodes = data.split(",");
        List<String> list = new LinkedList<>(Arrays.asList(nodes));
        return deserializeHelper(list);
    }


    //////////////////////////////////////////////
    public void unittest1() {
        TreeNode root = deserialize("1,2,3,null,null,4,5,null,null,");
        //TreeNode root = deserialize("1,2,null,3,");
        String treeStr = serialize(root);
        System.out.println(treeStr);
    }

    public static void main(String[] args) {
        String sPeriod = "12";
        String sResult = sPeriod.substring(0, Math.min(3, sPeriod.length()));

        SerializeAndDeserializeBinaryTree_V3 a = new SerializeAndDeserializeBinaryTree_V3();
        a.unittest1();
    }
}
