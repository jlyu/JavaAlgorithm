package CodingRush._26_Tree_IsSubTree;

import DataStructure.BinaryTree;

public class IsSubTree {

    private boolean hasSubTree(BinaryTree.Node root1, BinaryTree.Node root2) {

        // 第一步，先判断是否有相同根节点
        boolean result = false;
        if (root1 == null || root2 == null) { return false; }

        if (root1.value == root2.value) {
            // 第二步，再判断子树结构是否相同
            result = isSameSubTree(root1, root2);

        }
        if (!result) {
            result = hasSubTree(root1.left, root2);
        }
        if (!result) {
            result = hasSubTree(root1.right, root2);
        }

        return result;
    }



    private boolean isSameSubTree(BinaryTree.Node root1, BinaryTree.Node root2) {
        if (root2 == null) { return true; }
        if (root1 == null) { return false; }
        if (root1.value != root2.value) { return false; }

        return isSameSubTree(root1.left, root2.left) && isSameSubTree(root1.right, root2.right);
    }
}
