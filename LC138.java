/*
 * Problem:  https://leetcode.com/problems/copy-list-with-random-pointer/
 *
 * Idea:    1. Two passes to finish the deep copy, similar to Clone Graph problem
 *          2. first pass copies the next pointer and constructs a hashtable
 *          3. second pass copies the random pointer with hashtable lookup
 */

/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) return null;
        
        RandomListNode headCopy = new RandomListNode(head.label);
        Map<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
        
        // first pass copies the next pointer and constructs a hashtable
        RandomListNode currCopyNode = headCopy;
        RandomListNode currNode = head;
        map.put(head, headCopy);
        while (currNode.next != null) {
            RandomListNode node = new RandomListNode(currNode.next.label);
            currCopyNode.next = node;
            map.put(currNode.next, node);
            currNode = currNode.next;
            currCopyNode = currCopyNode.next;
        }
        
        // second pass copies the random pointer with hashtable lookup
        currCopyNode = headCopy;
        currNode = head;
        while (currNode != null) {
            if (currNode.random != null) {
                currCopyNode.random = map.get(currNode.random); 
            }
            currNode = currNode.next;
            currCopyNode = currCopyNode.next;
        }
        
        return headCopy;
    }
}
