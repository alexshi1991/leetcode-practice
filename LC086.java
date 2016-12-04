/*
 * Problem: https://leetcode.com/problems/partition-list/
 *
 * Idea:    1. use two linked lists
 *          2. put elements smaller than x in one list, put elements greater than x in another
 *          3. connect two linked lists together
 *          4. deploy two dummy nodes for the two lists
 *          5. it is important to make the last node of 'greater than x' list points to null
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
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) return head;
        
        ListNode dummySmaller = new ListNode(-1);
        ListNode dummyGreater = new ListNode(-1);
        ListNode tailSmaller = dummySmaller, tailGreater = dummyGreater;
        
        // walk linked list
        ListNode node = head;
        while (node != null) {
            if (node.val < x) {
                tailSmaller.next = node;
                tailSmaller = node;
            } else {
                tailGreater.next = node;
                tailGreater = node;
            }
            node = node.next;
        }
        
        // connect two lists together
        tailSmaller.next = dummyGreater.next;
        tailGreater.next = null;
        
        return dummySmaller.next;
    }
}
