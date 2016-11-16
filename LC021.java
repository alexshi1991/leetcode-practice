/*
 * Problem: https://leetcode.com/problems/merge-two-sorted-lists/
 *
 * Idea: 1. construct new linked list from the two sorted list
 *       2. use to pointers to traverse both linked list
 *       3. always append node with smaller value to the end of result linked list
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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null)  return null;
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode head = null, tail = null;
        ListNode curr1 = l1, curr2 = l2;
        if (l1.val <= l2.val) {
            head = l1;
            curr1 = curr1.next;
        } else {
            head = l2;
            curr2 = curr2.next;
        }
        tail = head;
        while (curr1 != null || curr2 != null) {
            if ((curr1 != null && curr2 != null && curr1.val <= curr2.val) 
                || curr2 == null) {
                tail.next = curr1;
                tail = curr1;
                curr1 = curr1.next;
            } else if ((curr1 != null && curr2 != null && curr1.val > curr2.val) 
                || curr1 == null) {
                tail.next = curr2;
                tail = curr2;
                curr2 = curr2.next;                
            }
        }
        return head;
    }
}
