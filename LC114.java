/*
 * Problem: https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
 *
 * Idea:    1. recursively flatten left and right subtree
 *             a) flatten(root.left)
 *             b) flatten(root.right)
 *             c) save root.right
 *             d) root.right = root.left
 *             e) root.left = null
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
    public void flatten(TreeNode root) {
        if (root == null) return;
        
        // recursively flatten left and right subtree
        flatten(root.left);
        flatten(root.right);
        
        TreeNode right = root.right; 
        
        if (root.left != null) {
            // step 1: concatinate root with left flattened subtree
            root.right = root.left;
            root.left = null;
            // step 2: move to the end of new added flatten subtree
            while (root.right != null) {
                root = root.right;
            }
            // step 3: concatinate left flatten subtree with flatten right subtree
            root.right = right;
        }
    }
}

