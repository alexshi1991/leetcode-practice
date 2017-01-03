/*
 * Problem:  https://leetcode.com/problems/remove-linked-list-elements/
 *
 * Idea:     dummy node, prev pointer
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
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode curr = head, prev = dummy;
        while (curr != null) {
            if (curr.val == val) {
                prev.next = curr.next; // remove curr node, prev remain the same
            } else {
                prev = curr; // advance prev pointer
            }
            curr = curr.next; // advance curr pointer
        }
        return dummy.next;
    }
}
