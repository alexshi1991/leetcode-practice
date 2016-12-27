/*
 * Problem: https://leetcode.com/problems/linked-list-cycle/
 *
 * Idea:    Tortoise and Hare algorithm: 
 *            a) Hare (fast ptr) runs two steps at a time
 *            b) Tortoise (slow ptr) runs one step at a time
 *            c) if ever hit null pointer, then there's no cycle
 *            d) if two ptrs ever meet, then there's a cycle
 */


/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    // Tortoise and Hare algorithm
    public boolean hasCycle(ListNode head) {
        if (head == null) return false;
        ListNode fast = head, slow = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) return true;
        }
        return false;
    }
}
