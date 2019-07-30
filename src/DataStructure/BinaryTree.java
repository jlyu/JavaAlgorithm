package DataStructure;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
    public class Node {
        public int value;
        public Node left;
        public Node right;

        Node() {}
        Node(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    private Node root = null;

    public BinaryTree(){
        this.root = new Node(1);
    }

    public Node getRoot() {
        return root;
    }

    public void defaultInit() {
        Node a = new Node(2);
        Node b = new Node(3);
        Node c = new Node(4);
        Node d = new Node(5);
        Node e = new Node(6);
        root.left = a;
        root.right = b;
        a.left = c;
        a.right = d;
        b.left = e;
    }

    public void printFromTopToBottom(Node root) {
        if (root == null) { return; }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            System.out.print(node.value);
            if (node.left != null)  { queue.offer(node.left); }
            if (node.right != null) { queue.offer(node.right);}
        }
    }
    public void printFromTopToBottomV2(BinaryTree.Node root) {
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


}
