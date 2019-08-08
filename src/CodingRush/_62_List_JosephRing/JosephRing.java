package CodingRush._62_List_JosephRing;

import DataStructure.MyList;

public class JosephRing {

    public int lastRemaining_Math(int n, int m) {
        if (n < 1 || m < 1) { return -1; }

        int last = 0;
        for (int i = 2; i <= n; i++) {
            last = (last + m) % i;
        }
        return last;
    }

    public int lastRemaining_List(int n, int m) {
        int[] a = new int[n];
        for (int i = 0; i < n; i++) { a[i] = i; }

        MyList list = new MyList(a);
        MyList.ListNode head = list.getHead();
        MyList.ListNode node = head;

        while (node.next != null) { node = node.next; }
        node.next = head;
        node = head;

        int step = 0;
        int delCount = 0;
        while (delCount < n) {
            step += 1;

            if (step != 0 && step % m == 0) {
                // delete node
                MyList.ListNode nextNode = node.next;
                node.value = nextNode.value;
                node.next = nextNode.next;
                head = nextNode;
                delCount += 1;
                continue;
            }
            node = node.next;
        }
        return node.value;
    }

    void unitTest1() {
        final int n = 5;
        final int m = 3;
        System.out.println(lastRemaining_Math(n,m));
        System.out.println(lastRemaining_List(n,m));
    }

    public static void main(String[] args) {
        JosephRing j = new JosephRing();
        j.unitTest1();
    }
}
