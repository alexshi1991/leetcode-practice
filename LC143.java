/*
 * Problem: https://leetcode.com/problems/reorder-list/
 *
 * Idea:    1. find the middle list node that splits the linked list into two halves
 *          2. reverse the second half of the linked list
 *          3. merge the two halves to get the result
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
    public void reorderList(ListNode head) {
        
        if (head == null 
            || head.next == null 
            || head.next.next == null) {
            return;
        }
        
        ListNode mid = findMiddle(head);
        ListNode reverseHead = reverse(mid.next);
        mid.next = null;
        merge(head, reverseHead);
    }
    
    // helper -  find middle element of the linked list
	private ListNode findMiddle(ListNode head) {
    	ListNode fast = head.next;
    	ListNode slow = head;
    	while (fast != null && fast.next != null) {
    		fast = fast.next.next;
    		slow = slow.next;
    	}
    	return slow;
	}
	
	// helper - reverse a linked list
	private ListNode reverse(ListNode head) {
	    if (head == null || head.next == null) {
	        return head;
	    }
	    ListNode prev = null; // important!
	    while (head != null) {
	        ListNode tmp = head.next;
	        head.next = prev;
	        prev = head;
	        head = tmp;
	    }
	    return prev;
	}
	
	// helper - merge two list
	// pick one from l1 and one from l2, and back and forth
	private void merge(ListNode l1, ListNode l2) {
	    
	    // setup
	    ListNode prev = l1;
	    l1 = l1.next;
	    int idx = 1;
	    
	    // add one from each list, starting from l2
	    while (l1 != null && l2 != null) {
	        if (idx % 2 == 0) {
	            prev.next = l1;
	            l1 = l1.next;
	        } else {
	            prev.next = l2;
	            l2 = l2.next;
	        }
	        prev = prev.next;
	        idx++;
	    }
	    if (l1 != null) {
	        prev.next = l1;
	    } else {
	        prev.next = l2;
	    }
	}
}
