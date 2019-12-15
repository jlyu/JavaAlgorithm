package Leetcode._148_M_Sort_List;

import java.util.Arrays;

/*
Sort a linked list in O(n log n) time using constant space complexity.

Example 1:

Input: 4->2->1->3
Output: 1->2->3->4
Example 2:

Input: -1->5->3->4->0
Output: -1->0->3->4->5


https://leetcode-cn.com/problems/sort-list

 */
public class SortList {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode createList(int[] a) {
        ListNode node = new ListNode(-1);
        ListNode head = node;
        for (int i = 0; i < a.length; i++) {
            node.next = new ListNode(a[i]);
            node = node.next;
        }
        return head.next;
    }
    ////////////////////////////////////////////////////////////
    public ListNode sortList(ListNode head) {
        ListNode node = head;
        int listLen = 0;
        while (node != null) {
            listLen++;
            node = node.next;
        }

        int[] a = new int[listLen];
        int index = 0;
        node = head;
        while (node != null) {
            a[index] = node.val;
            index++;
            node = node.next;
        }

        Arrays.sort(a);
        ListNode sortedNode = new ListNode(-1);
        ListNode sortedHead = sortedNode;
        for (int i = 0; i < a.length; i++) {
            sortedNode.next = new ListNode(a[i]);
            sortedNode = sortedNode.next;
        }
        return sortedHead.next;
    }

    public ListNode mergeSort(ListNode head) {
        if (head == null || head.next == null) { return head; }

        // finde middle node
        ListNode slow = head;
        ListNode fast = head.next.next;
        ListNode left;
        ListNode right;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        right = mergeSort(slow.next);
        slow.next = null;
        left = mergeSort(head);
        return mergeList(left, right);
    }

    private ListNode mergeList(ListNode l, ListNode r) {
        ListNode tmpHead = new ListNode(-1);
        ListNode p = tmpHead;
        while (l != null && r != null) {
            if (l.val < r.val) {
                p.next = l;
                l = l.next;
            }else {
                p.next = r;
                r = r.next;
            }
            p = p.next;
        }
        p.next = (l==null) ? r : l;
        return tmpHead.next;
    }


    public void unittest1() {
        ListNode head = createList(new int[] {4,2,1,3});
        ListNode sortedHead = sortList(head);
    }

    public static void main(String[] args) {
        SortList a = new SortList();
        a.unittest1();
    }


}
