package Leetcode._019_M_Remove_Nth_Node_From_End_Of_List;

/*
Given a linked list, remove the n-th node from the end of list and return its head.

Example:

Given linked list: 1->2->3->4->5, and n = 2.

After removing the second node from the end, the linked list becomes 1->2->3->5.
Note:

Given n will always be valid.

Follow up: Could you do this in one pass?


https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list


 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

import DataStructure.MyList;

public class RemoveNthNodeFromEndOfList {
    public MyList.ListNode removeNthFromEnd(MyList.ListNode head, int n) {

        if (n == 1 && head.next == null) { return null; }

        MyList.ListNode first = head;
        MyList.ListNode toDelNode = head;
        MyList.ListNode last = null;

        int diff = n;
        int count = 1;
        while (first.next != null && count < diff) {
            first = first.next;
            count++;
        }

        while (first.next != null) {
            first = first.next;
            last = toDelNode;
            toDelNode = toDelNode.next;
        }

        if (toDelNode == head && last == null) {
            head = head.next;
            return head;
        }

        last.next = toDelNode.next;
        return  head;
    }



    public void unitTest1() {
        int a[] = {1,2,3,4,5};
        for (int k = 1; k <= a.length; k++) {
            MyList list = new MyList(a);
            MyList.ListNode header = removeNthFromEnd(list.getHead(), k);
            list.printFromNode(header);
            System.out.println();
        }
    }

    public void unitTest2() {
        int a[] = {1,2};
        MyList list = new MyList(a);
        MyList.ListNode header = removeNthFromEnd(list.getHead(), 1);
        list.printFromNode(header);  // 1 -> null
        System.out.println();
    }

    public void unitTest3() {
        int a[] = {1,2,3};
        MyList list = new MyList(a);
        MyList.ListNode header = removeNthFromEnd(list.getHead(), 2);
        list.printFromNode(header); // 1 -> 3 -> null
        System.out.println();
    }

    public static void main(String[] args) {
        RemoveNthNodeFromEndOfList f = new RemoveNthNodeFromEndOfList();
        //f.unitTest1();
        f.unitTest2();
        //f.unitTest3();
    }

}
