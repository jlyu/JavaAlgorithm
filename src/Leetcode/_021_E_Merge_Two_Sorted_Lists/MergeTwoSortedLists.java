package Leetcode._021_E_Merge_Two_Sorted_Lists;

import DataStructure.MyList;

/*
Merge two sorted linked lists and return it as a new list.
The new list should be made by splicing together the nodes of the first two lists.

Example:

Input: 1->2->4, 1->3->4
Output: 1->1->2->3->4->4


链接：https://leetcode-cn.com/problems/merge-two-sorted-lists

 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class MergeTwoSortedLists {



    public MyList.ListNode mergeTwoLists(MyList.ListNode l1, MyList.ListNode l2) {
        if (l1 == null) { return l2; }
        if (l2 == null) { return l1; }

        MyList.ListNode node = new MyList.ListNode();
        MyList.ListNode head = node;

        while (l1 != null && l2 != null) {

            if (l1.value < l2.value) {
                node.next = new MyList.ListNode(l1.value);
                l1 = l1.next;
            } else {
                node.next = new MyList.ListNode(l2.value);
                l2 = l2.next;
            }
            node = node.next;

        }

        if (l1 == null) { node.next = l2; }
        if (l2 == null) { node.next = l1; }

        return head.next;
    }

    public void unitTest1() {
        MyList l1 = new MyList(new int[] {-9, 3});
        MyList l2 = new MyList(new int[] {5, 7});
        MyList.ListNode header = mergeTwoLists(l1.getHead(), l2.getHead());
        l1.printFromNode(header);
        System.out.println();
    }

    public void unitTest2() {
        MyList l1 = new MyList(new int[] {1,3,5});
        MyList l2 = new MyList(new int[] {1,4,5,6});
        MyList.ListNode header = mergeTwoLists(l1.getHead(), l2.getHead());
        l1.printFromNode(header);
        System.out.println();
    }

    public static void main(String[] args) {
        MergeTwoSortedLists a = new MergeTwoSortedLists();
        a.unitTest1();
        a.unitTest2();
    }
}
