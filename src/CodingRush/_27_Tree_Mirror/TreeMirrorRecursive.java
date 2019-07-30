package CodingRush._27_Tree_Mirror;

import DataStructure.BinaryTree;

public class TreeMirrorRecursive {


    public void treeMirrorRecursive(BinaryTree.Node node) {
        if (node == null) { return; }
        if (node.left == null && node.right == null) { return; }

        // swap left and right child
        BinaryTree.Node temp = node.left;
        node.left = node.right;
        node.right = temp;

        if (node.left != null) {
            treeMirrorRecursive(node.left);
        }

        if (node.right != null) {
            treeMirrorRecursive(node.right);
        }
    }
}
