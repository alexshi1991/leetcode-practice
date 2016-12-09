/*
 * Problem:  https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
 *
 * Idea:     1. populate the next pointers level by level
 *           2. while walking through the next pointers in currLevel, populate the next pointers for next level
 *           3. update currLevel and nextLevel after each iteration
 *
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
        if (root == null) return;
        TreeLinkNode currLevel = root;
        TreeLinkNode nextLevel = root.left;
        while (currLevel.left != null) {
            // walk next pointer of the curr level
            // connect next pointer of the next level
            currLevel.left.next = currLevel.right;
            if (currLevel.next != null) {
                currLevel.right.next = currLevel.next.left;
                currLevel = currLevel.next;
            } else {
                currLevel.right.next = null; // last node in the row
                currLevel = nextLevel;  // exchange curr and next level
                nextLevel = nextLevel.left;
            }
        }
    }
}
