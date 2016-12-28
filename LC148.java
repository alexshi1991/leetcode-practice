/*
 * Problem:  https://leetcode.com/problems/sort-list/
 *
 * Idea:     mergesort, recursively sort left and right half and merge them together
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
    
    public ListNode sortList(ListNode head) {
        
        // base case
        if (head == null || head.next == null) {
            return head;
        }
        
        // get the middle node
        ListNode mid = findMiddle(head);
        
        // recursively sort left and right
        ListNode right = sortList(mid.next);
        mid.next = null;
        ListNode left = sortList(head);
        
        // merge
        return merge(left, right);
    }
    
    // returns the middle node of a linked list
    private ListNode findMiddle(ListNode head) {
        ListNode fast = head.next; // important for base case
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
    
    
    // routine for merging two sorted list
    public ListNode merge(ListNode l1, ListNode l2) {

		if (l1 == null) { return l2;}
		if (l2 == null) { return l1;}

		// use two pointers to keep track of the progress
		ListNode p1 = l1, p2 = l2;
		ListNode dummy = new ListNode(-1);
		ListNode prev = dummy;

		// merge
		while (p1 != null || p2 != null) {
			if (p1 == null) {
				prev.next = p2;
				break;
			}
			if (p2 == null) {
				prev.next = p1;
				break;
			}
			if (p1.val < p2.val) {
				prev.next = p1;
				prev = p1;
				p1 = p1.next;
			} else {
				prev.next = p2;
				prev = p2;
				p2 = p2.next;
			}
		}

		return dummy.next;
    }
    
}
