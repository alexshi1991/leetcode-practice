/*
 * Problem: https://leetcode.com/problems/linked-list-cycle-ii/
 *
 * Idea:    1. tortoise and hare algorithm
 *          2. after they meet, move fast ptr to head of list
 *          3. walk fast and slow one step at a time, they will meet at beginning of the loop
 *
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
    public ListNode detectCycle(ListNode head) {
        if (head == null) return null;
        ListNode fast = head, slow = head;
        do {
            if (fast.next == null || fast.next.next == null) {
                return null;
            }
            slow = slow.next;
            fast = fast.next.next;
        } while (fast != slow);
        
        // now fast and slow are at Kth node, where K is the loop size
        // move fast to head of the list, and walk both fast and slow 
        // one step at a time, they will meet at the beginning of the cycle
        fast = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }
}
