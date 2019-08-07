package CodingRush._54_Tree_KthBSTNode;

import DataStructure.BinaryTree;

public class KthBSTNode {
    private BinaryTree.Node getKthNodeCore(BinaryTree.Node root, int k) {
        BinaryTree.Node target = null;

        if (root.left != null) {
            target = getKthNodeCore(root.left, k);
        }

        if (target == null) {
            if (k==1) { target = root; }
            k--;
        }

        if (root.right != null) {
            target = getKthNodeCore(root.right, k);
        }

        return target;
    }

    BinaryTree.Node getKthNode(BinaryTree.Node root, int k) {
        if (root == null || k < 0) { return null;}

        return getKthNodeCore(root, k);
    }
}
