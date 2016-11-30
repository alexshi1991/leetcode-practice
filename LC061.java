/*
 * Problem: https://leetcode.com/problems/rotate-list/
 *
 * Idea:   1. locate kth node from the end 
 *            a. first walk k steps from the head
 *            b. move two pointers at the same time until fast ptr hits null
 *         2. deploy dummy node
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
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k <= 0) {
            return head;
        }
        
        // n could be longer than the length of the linked list
        int length = getLength(head);
        int rotateLen = k % length;
        
        // deploy dummy node
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        
        // locate the kth node from the end
        ListNode fast = dummy;
        for (int i = 0; i < rotateLen; i++) {
            fast = fast.next;
        }
        ListNode tail = dummy;
        while (fast.next != null) {
            fast = fast.next;
            tail = tail.next;
        }
        
        // link properly
        fast.next = dummy.next;
        dummy.next = tail.next;
        tail.next = null;
        
        return dummy.next;
        
    }
    
    // get length of the linked list
    private int getLength(ListNode head) {
        ListNode node = head;
        int length = 0;
        while (node != null) {
            length++;
            node = node.next;
        }
        return length;
    }
}
