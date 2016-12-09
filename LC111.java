/*
 * Problem: https://leetcode.com/problems/minimum-depth-of-binary-tree/
 *
 * Idea:    1. recursively calculate the minDepth of left and right subtree
 *          2. minDepth(root) = Math.min(minDepth(root.left), minDepth(root.right))
 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        
        int minLeft = minDepth(root.left);
        int minRight = minDepth(root.right);
        
        if (minLeft > 0 && minRight > 0) {
            return Math.min(minLeft, minRight) + 1;
        } else if (minLeft > 0) {
            return minLeft + 1;
        } else if (minRight > 0) {
            return minRight + 1;
        } else {
            return 1;
        }
    }
}

