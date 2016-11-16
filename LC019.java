/*
 * Problem: https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 *
 * Idea: 1. first use a front pointer to identify the Nth node from the start
 *       2. then move curr pointer and front pointer at the same time until front pointer hits null
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        
        ListNode front = head;
        for (int i = 0; i < n; i++) {
            front = front.next;
        }
        ListNode curr = head, prev = null;
        while (front != null) {
            front = front.next;
            prev = curr;
            curr = curr.next;
        }
        if (prev == null) {
            head = head.next;  // removing the head node
        } else {
            prev.next = curr.next;
        }

        return head;
    }
}
