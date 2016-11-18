/*
 * Problem: https://leetcode.com/problems/reverse-nodes-in-k-group/
 *
 * Idea: 1. computes how many groups need to be reversed
 *       2. reverse one group (size k) at a time
 *       3. use dummy node to simplify code
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
    
    public ListNode reverseKGroup(ListNode head, int k) {

        int listLength = getLength(head);
        int groupsRemain = listLength / k;
        if (groupsRemain == 0) { return head; }

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode res = null, curr = head, prevGroup = dummy;;

        // reverse one group at a time
        while (groupsRemain > 0) {
            ListNode node = nextGroup(curr, k);
            ListNode reverseHead = reverse(curr, k);
            prevGroup.next = reverseHead;
            prevGroup = curr;
            curr = node;
            groupsRemain--;
        }
        prevGroup.next = curr; // remaining nodes left as is
        return dummy.next;
    }

    // get length of linked list
    private int getLength(ListNode head) {
        int len = 0;
        ListNode curr = head;
        while (curr != null) {
            len++;
            curr = curr.next;
        }
        return len;
    }

    // reverse the first k nodes of a linked list
    private ListNode reverse(ListNode curr, int k) {
        ListNode prev = null, tmp = null;
        // k - 1 iterations
        while (k > 1 && curr != null) {
            tmp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = tmp;
            k--;
        }
        curr.next = prev;
        return curr;
    }

    // returns the k+1's node in the linked list
    private ListNode nextGroup(ListNode head, int k) {
        ListNode curr = head;
        while (k > 0) {
            curr = curr.next;
            k--;
        }
        return curr;
    }
    
}