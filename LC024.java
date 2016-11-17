/*
 * Problem: https://leetcode.com/problems/swap-nodes-in-pairs/
 *
 * Idea: 1. use of dummy node
 *       2. advance curr node by two steps each while-loop iteration
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
    public ListNode swapPairs(ListNode head) {
        // deploy dummy node that points to head node
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        
        ListNode curr = head, prev = dummy;
        while (curr != null && curr.next != null) {
            ListNode tmp = curr.next.next;
            curr.next.next = curr;
            prev.next = curr.next;
            curr.next = tmp;
            prev = curr;
            curr = tmp;
        }
        return dummy.next;
    }
}