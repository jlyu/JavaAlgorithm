package CodingRush._07_Tree_RebuildTree;

import DataStructure.BinaryTree;

public class RebuildTree {

    private BinaryTree.Node rebuildTree(int[] preOrder, int pStart, int pEnd, int[] inOrder, int iStart, int iEnd) {
        if (pStart > pEnd || iStart > iEnd) { return null; }
        BinaryTree binaryTree = new BinaryTree(preOrder[pStart]);
        BinaryTree.Node root = binaryTree.getRoot();

        for (int i = iStart; i <= iEnd; i++) {
            if (inOrder[i] == preOrder[pStart]) {
                root.left = rebuildTree(preOrder, pStart + 1,         pStart + i - iStart, inOrder,  iStart,       i - 1 );
                root.right= rebuildTree(preOrder, pStart + i - iStart, pEnd,                      inOrder, i + 1, iEnd);
                break;
            }
        }
        return root;

    }
    public BinaryTree.Node rebuildTree(int[] preOrder, int[] inOrder) {
        return rebuildTree(preOrder, 0, preOrder.length - 1, inOrder, 0, inOrder.length - 1);
    }


}
