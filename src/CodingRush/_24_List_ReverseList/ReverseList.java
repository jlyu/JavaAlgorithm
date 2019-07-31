package CodingRush._24_List_ReverseList;

import DataStructure.MyList;

public class ReverseList {

    public MyList.ListNode reverseList(MyList.ListNode head) {
        MyList.ListNode reversedHead = null;
        MyList.ListNode previousNode = null;
        MyList.ListNode currentNode = head;

        while (currentNode != null) {
            MyList.ListNode nextNode = currentNode.next;
            if (nextNode == null) {
                reversedHead = currentNode;
            }
            currentNode.next = previousNode;
            previousNode = currentNode;
            currentNode = nextNode;
        }

        MyList.ListNode node = reversedHead;
        while (node != null) {
            System.out.print(node.value + " -> ");
            node = node.next;
        }
        System.out.print("null.");
        return reversedHead;
    }

    public void unitTest1() {
        int[] a = {1,2,3,4,5,6,7,8,9};
        MyList l = new MyList(a);
        reverseList(l.getHead());
    }


    public static void main(String[] args) {
        ReverseList r = new ReverseList();
        r.unitTest1();
    }
}
