/*
 * Problem:  https://leetcode.com/problems/delete-node-in-a-linked-list/
 *
 * Idea:     copy list node value forward
 *
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
    public void deleteNode(ListNode node) {
        if (node != null && node.next != null) { // not the last node
            ListNode prev = node;
            ListNode curr = node.next;
            while (curr != null) {
                prev.val = curr.val;
                if (curr.next == null) {
                    prev.next = null;  // last node
                    break;
                } 
                prev = curr;
                curr = curr.next;
            }
        }
    }
}
