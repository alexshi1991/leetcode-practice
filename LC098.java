/*
 * Problem: https://leetcode.com/problems/validate-binary-search-tree/
 *
 * Idea:    1. do a tree traversal to recursively check if a subtree is valid BST
 *          2. as we traverse the tree, we update a value range that the subtree nodes should satisfy
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
    public boolean isValidBST(TreeNode root) {
        return inRange(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
    // recursively check if a subtree is Valid BST
    private boolean inRange(TreeNode node, int lower, int upper) {
        // base case
        if (node == null) return true;
        // edge cases
        if (node.val == Integer.MAX_VALUE && node.right != null) {
            return false;
        }
        if (node.val == Integer.MIN_VALUE && node.left != null) {
            return false;
        }
        if (node.val <= upper && node.val >= lower) {
            return inRange(node.left, lower, node.val-1)
                && inRange(node.right, node.val+1, upper);
        }
        return false;
    }
    
}
