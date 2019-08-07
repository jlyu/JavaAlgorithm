package CodingRush._52_List_FindFirstCommonNode;

import DataStructure.MyList;

public class FindFirstSameNode {

    private int getListLength(MyList.ListNode head) {
        int length = 0;
        MyList.ListNode node = head;
        while (node != null) {
            node = node.next;
            length += 1;
        }
        return length;
    }

    MyList.ListNode findFirstSameNode(MyList.ListNode head1, MyList.ListNode head2) {
        if (head1 == null || head2 == null) { return null; }

        int ln1 = getListLength(head1);
        int ln2 = getListLength(head2);

        MyList.ListNode node1 = head1;
        MyList.ListNode node2 = head2;

        int diff = 0;

        while (node1 != null ||  node2 != null) {

            diff += 1;

            if (ln1 > ln2 && diff < (ln1 - ln2)) {
                node1 = node1.next;
            }
            else if (ln2 > ln1 && diff < (ln1 - ln2)) {
                node2 = node2.next;
            }
            else {
                break;
            }
        }

        while (node1 != null ||  node2 != null) {
            if (node1.value == node2.value) {
                return node1;
            }
            node1 = node1.next;
            node2 = node2.next;
        }

        return null;
    }

    void unitTest1() {
        MyList l1 = new MyList(new int[] {1,2,3,5,6});
        MyList l2 = new MyList(new int[] {4,5,6});

        MyList.ListNode firstNode = findFirstSameNode(l1.getHead(), l2.getHead());
        System.out.println(firstNode.value);
    }

    public static void main(String[] args) {
        FindFirstSameNode f = new FindFirstSameNode();
        f.unitTest1();
    }
}
