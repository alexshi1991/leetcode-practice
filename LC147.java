/*
 * Problem: https://leetcode.com/problems/insertion-sort-list/
 *
 * Idea:    1. use the definition of insertion sort
 *          2. examine the list nodes one by one, maintain a sorted sublist
 *          3. for each list node, we search through the sorted sublist to find the insertion point
 *          4. insertion sort algorithm runs in O(N*N) time
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
    public ListNode insertionSortList(ListNode head) {
        ListNode sorted = new ListNode(0); // sorted part so far
        while (head != null) {
            ListNode node = sorted;
            // find the insertion point
            while (node.next != null && node.next.val < head.val) {
                node = node.next;
            }
            // insert the node
            ListNode temp = head.next;
            head.next = node.next;
            node.next = head;
            head = temp;
        }
        return sorted.next;
    }
}
