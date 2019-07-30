package CodingRush._18_List_DeleteListNode;

import DataStructure.MyList;

public class DeleteListNode {

    private void deleteListNode(MyList.ListNode head, MyList.ListNode deleteNode) {
        if (head == null || deleteNode == null) { return; }

        // To be deleted is the middle part
        MyList.ListNode nextNode = deleteNode.next;
        if (nextNode != null) {
            deleteNode.value = nextNode.value;
            deleteNode.next = nextNode.next;
        } else if (head == deleteNode) {
            // To be deleted is the head.
            deleteNode = null;
            head = null;
        } else {
            // To be deleted is the tail
            MyList.ListNode preNode = head;
            while (preNode.next != deleteNode) {
                preNode = preNode.next;
            }
            preNode.next = null;
            deleteNode = null;
        }

        MyList.ListNode node = head;
        while (node != null) {
            System.out.print(node.value + " -> ");
            node = node.next;
        }
        System.out.print("null.");
    }

    // Unit Tests
    public void unitTest1() {
        int[] a = {1,2,3,4,5,6,7,8,9};
        MyList list = new MyList(a);

        MyList.ListNode head = list.getHead();
        MyList.ListNode toDeleteNode = list.findNode(4);

        deleteListNode(head, toDeleteNode);
        System.out.println();
    }

    public void unitTest2() {
        int[] a = {1,2,3,4,5,6,7,8,9};;
        MyList list = new MyList(a);

        MyList.ListNode head = list.getHead();
        MyList.ListNode toDeleteNode = list.findNode(1);

        deleteListNode(head, toDeleteNode);
        //list.printList();
        System.out.println();
    }

    public void unitTest3() {
        int[] a = {1,2,3,4,5,6,7,8,9};
        MyList list = new MyList(a);

        MyList.ListNode head = list.getHead();
        MyList.ListNode toDeleteNode = list.findNode(9);

        deleteListNode(head, toDeleteNode);
        System.out.println();
    }

    public void unitTest4() {
        int[] a = {2};
        MyList list = new MyList(a);

        MyList.ListNode head = list.getHead();
        MyList.ListNode toDeleteNode = list.findNode(2);

        deleteListNode(head, toDeleteNode);
        System.out.println();
    }

    public static void main(String[] args) {
        DeleteListNode d = new DeleteListNode();
        d.unitTest1();
        d.unitTest2();
        d.unitTest3();
        d.unitTest4();
    }
}
