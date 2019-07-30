package CodingRush._32_Tree_PrintFromTop2Bottom;

import DataStructure.BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class PrintTreeTop2Bottom {

    public void printFromTopToBottom(BinaryTree.Node root) {
        if (root == null) { return; }
        Queue<BinaryTree.Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            BinaryTree.Node node = queue.poll();
            System.out.print(node.value);
            if (node.left != null)  { queue.offer(node.left); }
            if (node.right != null) { queue.offer(node.right);}
        }
    }

    private void printFromTopToBottomV2(BinaryTree.Node root) {
        if (root == null) { return; }
        Queue<BinaryTree.Node> queue = new LinkedList<>();
        queue.offer(root);

        int nextLevelNodeSize = 0;
        int toPrintedNodeSize = 1;

        while (!queue.isEmpty()) {
            BinaryTree.Node node = queue.poll();
            toPrintedNodeSize -= 1;

            System.out.print(node.value);

            if (node.left != null)  {
                queue.offer(node.left);
                nextLevelNodeSize += 1;
            }

            if (node.right != null) {
                queue.offer(node.right);
                nextLevelNodeSize += 1;
            }

            if (toPrintedNodeSize == 0) {
                toPrintedNodeSize = nextLevelNodeSize;
                nextLevelNodeSize = 0;
                System.out.println();
            }

        }
    }


    void unitTest1() {
        BinaryTree bt = new BinaryTree();
        bt.defaultInit();
        printFromTopToBottom(bt.getRoot());
        System.out.println();
        printFromTopToBottomV2(bt.getRoot());
    }

    public static void main(String[] args) {
        PrintTreeTop2Bottom p = new PrintTreeTop2Bottom();
        p.unitTest1();
    }
}
