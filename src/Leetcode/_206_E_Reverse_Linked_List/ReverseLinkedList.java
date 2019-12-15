package Leetcode._206_E_Reverse_Linked_List;
/*
Reverse a singly linked list.

Example:

Input: 1->2->3->4->5->NULL
Output: 5->4->3->2->1->NULL
Follow up:

A linked list can be reversed either iteratively or recursively. Could you implement both?


https://leetcode-cn.com/problems/reverse-linked-list
 */
public class ReverseLinkedList {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode reverseList_iteratively(ListNode head) {
        ListNode reversedHead = null;
        ListNode previousNode = null;
        ListNode currentNode = head;

        while (currentNode != null) {
            ListNode nextNode = currentNode.next;
            if (nextNode == null) {
                reversedHead = currentNode;
            }
            currentNode.next = previousNode;
            previousNode = currentNode;
            currentNode = nextNode;
        }

        ListNode node = reversedHead;
        while (node != null) {
            node = node.next;
        }
        return reversedHead;
    }

    public ListNode reverseList_recursively(ListNode head) {
        if (head == null || head.next == null) { return head; }
        ListNode node = reverseList_recursively(head.next);
        head.next.next = head;
        head.next = null;
        return node;
    }
}
