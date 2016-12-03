/*
 * Problem:  https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/
 *
 * Idea:     1. walk through linked list, keep a prev pointer
 *           2. check if the curr node is a duplicate
 *           3. skip all the duplicates and directly connect prev to the next non-duplicate node
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
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy, curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            if (next == null || next.val != curr.val) {
                // no deletion required
                prev = curr;
                curr = curr.next;
            } else {
                // deletion required
                while (next != null && next.val == curr.val) {
                    next = next.next;
                }
                prev.next = next;
                curr = next;
            }
        }
        return dummy.next;
    }
}
