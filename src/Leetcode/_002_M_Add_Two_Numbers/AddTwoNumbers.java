package Leetcode._002_M_Add_Two_Numbers;

// https://leetcode-cn.com/problems/add-two-numbers/

/*
You are given two non-empty linked lists representing two non-negative integers.
The digits are stored in reverse order and each of their nodes contain a single digit.
Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example:

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
Explanation: 342 + 465 = 807.
 */

public class AddTwoNumbers {

    public class ListNode {
        int val;
        ListNode next;
        ListNode( ) {  }
        ListNode(int x) { val = x; }
        ListNode(int[] a) {
            final int n = a.length;
            if (n < 1) { return; }

            ListNode head = new ListNode();
            head.val = a[0];
            ListNode preNode = head;
            for (int i = 1; i < a.length; i++) {
                ListNode node = new ListNode(a[i]);
                preNode.next = node;
                preNode = node;
            }
        }
    }

    public AddTwoNumbers.ListNode head;

    public AddTwoNumbers() {
        this.head = new ListNode();
        head.next = null;
    }

    public AddTwoNumbers(int[] a) {
        final int n = a.length;
        if (n < 1) { return; }

        this.head = new ListNode();
        this.head.val = a[0];
        ListNode preNode = head;
        for (int i = 1; i < a.length; i++) {
            ListNode node = new ListNode(a[i]);
            preNode.next = node;
            preNode = node;
        }
    }


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) { return l2; }
        if (l2 == null) { return l1; }

        ListNode l0 = new ListNode(-1);
        ListNode h1 = l1;
        ListNode h2 = l2;
        ListNode h0 = l0;


        int a = 0;
        while (h1 != null && h2 != null) {
            int v = (h1.val + h2.val + a) % 10;
            a = (h1.val + h2.val + a) / 10;

            ListNode n = new ListNode(v);
            h0.next = n;
            h0 = n;

            h1 = h1.next;
            h2 = h2.next;
        }

        while (h1 != null) {
            int v = h1.val + a;
            h1.val = v % 10;
            a = v / 10;
            h0.next = h1;
            h0 = h0.next;
            h1 = h1.next;
        }
        while (h2 != null) {
            int v = h2.val + a;
            h2.val = v % 10;
            a = v / 10;
            h0.next = h2;
            h0 = h0.next;
            h2 = h2.next;
        }
        if (a != 0) {
            h0.next = new ListNode(a);
        }
        return l0.next;
    }

    public void unitTest1(ListNode l1, ListNode l2) {
        addTwoNumbers(l1, l2);
    }

    public static void main(String[] args) {
        AddTwoNumbers l1 = new AddTwoNumbers(new int[] {9,8});
        AddTwoNumbers l2 = new AddTwoNumbers(new int[] {1});
        l1.unitTest1(l1.head, l2.head);
    }
}


/*

[2,4,3]
[5,6,4]

[9,8]
[1]


 */