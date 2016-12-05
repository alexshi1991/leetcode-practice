/*
 * Problem: https://leetcode.com/problems/reverse-linked-list-ii/
 *
 * Idea:    1. deploy dummy node
 *          2. walk m steps, remember the last node
 *          3. reverse the m ~ n section
 *          4. connect the reversed sections with rest of the linked list properly
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
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || head.next == null || m >= n) return head;   
        
        // deploy dummy node
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy, node = head;
        
        // find the starting node
        for (int i = 1; i < m; i++) {
            prev = node;
            node = node.next;
        }
        ListNode startingNode = node;
        ListNode preStartingNode = prev;
         
        // reverse along the way
        ListNode tmp;
        prev = startingNode;
        node = startingNode.next;
        for (int i = m; i < n; i++) {
            tmp = node.next;
            node.next = prev;
            prev = node;
            node = tmp;
        }
        ListNode endNode = prev;
        ListNode postEndNode = node;
        
        // link properly
        preStartingNode.next = endNode;
        startingNode.next = postEndNode;
        
        return dummy.next;    
    }  
}
