/*
 * Problem: https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/
 *
 * Idea:    1. connect next level while iterating current level
 *          2. because the BST might not be perfect, need to keep track of 
 *             the last connected(non-null) node of the next level
 */


/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        TreeLinkNode head = null;// head of next level
        TreeLinkNode prev = null;// prev node (last connected node) on the next level 
        TreeLinkNode cur = root; // current node of current level
        
        while (cur != null) {
            // iterate on the current level
            while (cur != null) {
                // left child
                if (cur.left != null) {
                    if (prev != null) {
                        prev.next = cur.left;
                    } else {
                        head = cur.left;
                    }
                    prev = cur.left;
                }
                // right child
                if (cur.right != null) {
                    if (prev != null) {
                        prev.next = cur.right;
                    } else {
                        head = cur.right;
                    }
                    prev = cur.right;
                }
                // move to next node
                cur = cur.next;
            }
            
            // current level is exhausted, move on to next level
            cur = head;
            head = null;
            prev = null;
        }
    }
}
