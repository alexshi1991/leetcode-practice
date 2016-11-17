/*
 * Problem: https://leetcode.com/problems/merge-k-sorted-lists/
 *
 * Idea:  1. Maintain a size-k heap, storing the front of each list
 *        2. Continuously remove min node from heap and append it to result list
 *        3. Whenever a node is removed from the heap, add next node in that list to the heap
 *        4. Know how to use a custom comparator
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
    
    // custom comparator
    private static class ByNodeValue implements Comparator<ListNode> {
		public int compare(ListNode node1, ListNode node2) {
			return node1.val - node2.val;
		}
	}
    
    private static final Comparator<ListNode> ListNodeComparator = new ByNodeValue();
    
    public ListNode mergeKLists(ListNode[] lists) {
        
        // sanity check
        if (lists == null || lists.length == 0) {
            return null;
        }
        
        // construct priority queue
        PriorityQueue<ListNode> heap = new PriorityQueue<ListNode>(lists.length, ListNodeComparator);
        for (int i = 0; i < lists.length; i++) {
            ListNode firstInList = lists[i];
            if (firstInList != null) {
                heap.add(firstInList);
            }
        }
        
        ListNode head = null;
        ListNode tail = head;
        
        while (!heap.isEmpty()) {
            ListNode node = heap.poll(); // remove min
            if (tail == null) {
                head = node;
                tail = node;
            } else {
                tail.next = node;
                tail = node;
            }
            if (node.next != null) {
                heap.add(node.next);  // add the next element of that list to the heap
            }
        }
        
        return head;
        
    }
}
