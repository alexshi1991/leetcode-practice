/*
 * Problem: https://leetcode.com/problems/remove-duplicates-from-sorted-list/
 *
 * Idea:    1. walk through linked list, 
 *          2. if curr.val = curr.next.val, curr.next = curr.next.next
 *          3. only move on to the next node, when curr and curr.next are not duplicates
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
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null)  return head;
        ListNode node = head;
        while (node.next != null) {
            if (node.val == node.next.val) {
                node.next = node.next.next;
            } else {
                node = node.next;
            }
        }
        return head;
    }
}
