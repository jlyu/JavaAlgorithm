package CodingRush._55_Tree_GetDepth;

import DataStructure.BinaryTree;

public class TreeDepth {
    public int getDepth(BinaryTree.Node root) {
        if (root == null) { return 0; }

        int left = getDepth(root.left);
        int right = getDepth(root.right);

        return (left > right) ? (left + 1) : (right + 1);
    }

    public boolean isBalance(BinaryTree.Node root) {
        if (root == null) { return true; }

        int left = getDepth(root.left);
        int right = getDepth(root.right);

        if (Math.abs(left - right) > 1) { return false; }

        return isBalance(root.left) && isBalance(root.right);
    }
}
