/*
 * Problem: https://leetcode.com/problems/maximum-depth-of-binary-tree/
 *
 * Idea:    recursion
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
    public int maxDepth(TreeNode root) {
        if (root == null) return 0; //recursion base
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
