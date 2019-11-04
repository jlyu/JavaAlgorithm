package DataStructure.Tree;


public class BinarySearchTree<AnyType extends Comparable<? super AnyType>> {

    private static class BinaryNode<AnyType> {
        BinaryNode(AnyType element) { this(element, null, null); }

        BinaryNode(AnyType element, BinaryNode<AnyType> left, BinaryNode<AnyType> right) {
            this.element = element;
            this.left = left;
            this.right = right;
        }

        AnyType element;
        BinaryNode<AnyType> left;
        BinaryNode<AnyType> right;
    }

    private BinaryNode<AnyType> root;


    public BinarySearchTree() { this.root = null; }

    public void makeEmpty() { root = null; }

    public boolean isEmpty() { return root == null; }

    public boolean isContains(AnyType x) { return isContains(x, root); }

    public AnyType findMin() {
        if (isEmpty()) {
            try {
                throw new Exception("Underflow");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return findMin(root).element;
    }

    public AnyType findMax() {
        if (isEmpty()) {
            try {
                throw new Exception("Underflow");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return findMax(root).element;
    }

    public void insert(AnyType x) { root = insert(x, root); }
    public void remove(AnyType x) { root = remove(x, root); }

    public void printTree() {}
    

    private boolean isContains(AnyType x, BinaryNode<AnyType> node) {
        if (node == null) { return false; }
        int compareResult = x.compareTo(node.element);

        if (compareResult == 0) { return true; }

        if (compareResult < 0) {
            return isContains(x, node.left);
        } else {
            return isContains(x, node.right);
        }
    }

    private BinaryNode<AnyType> findMin(BinaryNode<AnyType> node) {
        if (node == null) { return null; }
        if (node.left == null) { return node; }
        else {
            return findMin(node.left);
        }
    }

    private BinaryNode<AnyType> findMax(BinaryNode<AnyType> node) {
        if (node != null) {
            while (node.right != null) {
                node = node.right;
            }
        }
        return node;
    }

    private BinaryNode<AnyType> insert(AnyType x, BinaryNode<AnyType> node) {
        if (node == null) {
            return new BinaryNode<AnyType>(x);
        }

        int compareResult = x.compareTo(node.element);
        if (compareResult == 0) { return node; }

        if (compareResult < 0) { node = insert(x, node.left); }
        else/*(compareResult > 0) */ { node = insert(x, node.right); }
        return node;
    }
    private BinaryNode<AnyType> remove(AnyType x, BinaryNode<AnyType> node) {
        if (node == null) {
            return new BinaryNode<AnyType>(x);
        }

        int compareResult = x.compareTo(node.element);

        if (compareResult < 0) { node = remove(x, node.left); }
        else if (compareResult > 0) { node = remove(x, node.right); }

        // Found node.
        else if (node.left != null && node.right != null) { // 2 children
            node.element = findMin(node.right).element;
            node.right = remove(node.element, node.right);
        } else { // 1 child
            node = (node.left != null) ? node.left : node.right;
        }
        return node;
    }

    private void print(BinaryNode<AnyType> node) {}
}
