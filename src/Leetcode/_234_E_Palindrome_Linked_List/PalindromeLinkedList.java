package Leetcode._234_E_Palindrome_Linked_List;
/*
Given a singly linked list, determine if it is a palindrome.

Example 1:

Input: 1->2
Output: false
Example 2:

Input: 1->2->2->1
Output: true
Follow up:
Could you do it in O(n) time and O(1) space?


https://leetcode-cn.com/problems/palindrome-linked-list
 */
public class PalindromeLinkedList {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public boolean isPalindrome(ListNode head) {
        ListNode slow = head, fast = head,  prev = null;

        //find middle node
        while (fast != null) {
            slow = slow.next;
            fast = (fast.next == null) ? null : fast.next.next;
        }

        //reverse half list
        while (slow != null) {
            ListNode p = slow.next;
            slow.next = prev;
            prev = slow;
            slow = p;
        }
        while (head != null && prev != null){//check
            if (head.val != prev.val){
                return false;
            }
            head = head.next;
            prev = prev.next;
        }
        return true;
    }
}
