package DataStructure;

public class MyList {
    // ListNode
    public static class ListNode {
        public int value;
        public ListNode next;

        public ListNode() {
            this.value = 0;
            this.next = null;
        }
        public ListNode(int v) {
            this.value = v;
            this.next = null;
        }

        public void setNull() {
            value = -1;
            next = null;
        }

    }

    // MyList Impl
    private ListNode head;

    public MyList() {
        this.head = new ListNode();
        head.next = null;
    }

    public MyList(int[] a) {
        final int n = a.length;
        if (n < 1) { return; }

        this.head = new ListNode();
        this.head.value = a[0];
        ListNode preNode = head;
        for (int i = 1; i < a.length; i++) {
            ListNode node = new ListNode(a[i]);
            preNode.next = node;
            preNode = node;
        }
    }

    public ListNode getHead() {
        return head;
    }

    public ListNode findNode(int v) {
        if (head == null) { return null; }
        ListNode node = head;
        while (node != null) {
            if (node.value == v) {
                return node;
            }
            node = node.next;
        }
        return null;
    }

    public void printList() {
        ListNode node = head;
        while (node != null) {
            System.out.print(node.value + " -> ");
            node = node.next;
        }
        System.out.print("null.");
    }

}
