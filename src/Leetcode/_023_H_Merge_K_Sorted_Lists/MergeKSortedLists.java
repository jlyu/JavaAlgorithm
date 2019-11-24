package Leetcode._023_H_Merge_K_Sorted_Lists;

public class MergeKSortedLists {
    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
 }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) { return null; }
        if (lists.length == 1) { return lists[0]; }
        if (lists.length == 2) { return mergeTwoLists(lists[0], lists[1]); }

        int mid = lists.length / 2;
        ListNode[] l1 = new ListNode[mid];
        for (int i = 0; i < mid; i++) {
            l1[i] = lists[i];
        }

        ListNode[] l2 = new ListNode[lists.length - mid];
        for (int i = mid, j = 0; i < lists.length; i++, j++) {
            l2[j] = lists[i];
        }

        return mergeTwoLists(mergeKLists(l1), mergeKLists(l2));
    }

    // public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    //     if (l1 == null)
    // }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) { return l2; }
        if (l2 == null) { return l1; }

        ListNode node = new ListNode(-999);
        ListNode head = node;

        while (l1 != null && l2 != null) {

            if (l1.val < l2.val) {
                node.next = new ListNode(l1.val);
                l1 = l1.next;
            } else {
                node.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            node = node.next;

        }

        if (l1 == null) {
            node.next = l2;

        }
        if (l2 == null) {
            node.next = l1;

        }

        return head.next;
    }
}
