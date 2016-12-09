/*
 * Problem: https://leetcode.com/problems/balanced-binary-tree/
 *
 * Idea:    1. recursively calculate max depth of a binary tree
 *          2. maxDepth(root) = Math.max(maxDepth(root.left), maxDepth(root.right)) + 1
 *          3. use return val -1 to indicate that the tree is not balanced
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
    public boolean isBalanced(TreeNode root) {
        return maxDepth(root) != -1;
    }
    
    // max depth for the curr tree
    private int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        if (left == -1 || right == -1) return -1; // child tree not balanced
        if (Math.abs(left-right) > 1) return -1; // current tree not balanced
        return Math.max(left, right) + 1; 
    }

}
