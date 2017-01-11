/*
 * Problem: https://leetcode.com/problems/palindrome-linked-list/
 *
 * Idea:    1) find the mid point of the linked list using fast/slow pointers
 *          2) reverse the second half the linked list
 *          3) compare the two halves
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    // reverse the second half of the linked list and compare it with the first half
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        if (fast != null) {
            slow = slow.next;
        }
        slow = reverseLinkedList(slow);
        while (slow != null && head.val == slow.val) {
            head = head.next;
            slow = slow.next;
        }
        return slow == null;
    }
    
    // reverse a linked list
    private ListNode reverseLinkedList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }
        return prev;
    }
}
