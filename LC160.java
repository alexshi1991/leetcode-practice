/*
 * Problem: https://leetcode.com/problems/intersection-of-two-linked-lists/
 *
 * Idea:    1. first find the lengths of the two lists
 *          2. move the longer list (len2-len1) steps forward (now the two remainder lists have the same length)
 *          3. now walk both lists one step at a time, until they meet (or both reach null)
 *
 */


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // count the length of two linked list
        int len1 = 0, len2 = 0;
        ListNode node = headA;
        while (node != null) {
            len1++;
            node = node.next;
        }
        node = headB;
        while (node != null) {
            len2++;
            node = node.next;
        }
        
        // move the longer list Math.abs(len2-len1) steps forward
        ListNode nodeA = headA, nodeB = headB;
        if (len2 > len1) {
            for (int i = 0; i < len2 - len1; i++) {
                nodeB = nodeB.next;
            }
        }
        if (len1 > len2) {
            for (int i = 0; i < len1 - len2; i++) {
                nodeA = nodeA.next;
            }
        }
        
        // move both pointers one at a time, the remaining of the two
        // linked lists now have equal length
        while (nodeA != nodeB) {
            nodeA = nodeA.next;
            nodeB = nodeB.next;
        }
        
        return nodeA;        
    }
}
