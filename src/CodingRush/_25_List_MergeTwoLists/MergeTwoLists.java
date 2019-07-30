package CodingRush._25_List_MergeTwoLists;

import DataStructure.MyList;

public class MergeTwoLists {

    public MyList.ListNode merge(MyList.ListNode head1, MyList.ListNode head2) {
        //if (head1 == null && head2 == null) { return null; }
        if (head1 == null) { return head2; }
        if (head2 == null) { return head1; }

        MyList.ListNode mergedHead = null;
        if (head1.value < head2.value) {
            mergedHead = head1;
            mergedHead.next = merge(head1.next, head2);
        } else {
            mergedHead = head2;
            mergedHead.next = merge(head1, mergedHead.next);
        }

        return mergedHead;
    }

    void printList(MyList.ListNode head) {
        MyList.ListNode node = head;
        while (node != null) {
            System.out.print(node.value + " -> ");
            node = node.next;
        }
        System.out.print("null.");
        System.out.println();
    }

    void unitTest0() {
        MyList.ListNode mergedHead = merge(null, null);
        printList(mergedHead);
    }

    void unitTest1() {
        int[] a1 = {1,3,5,7,9};
        int[] a2 = {2,4,6,8,10};
        MyList list1 = new MyList(a1);
        MyList list2 = new MyList(a2);

        MyList.ListNode mergedHead = merge(list1.getHead(), list2.getHead());
        printList(mergedHead);
    }



    public static void main(String[] args) {
        MergeTwoLists m = new MergeTwoLists();
        m.unitTest0();
        m.unitTest1();
    }
}
