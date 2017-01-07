/*
 * Problem:  https://leetcode.com/problems/count-complete-tree-nodes/
 *
 * Idea:     1. recursively examine whether left or right subtree is a complete binary tree
 *           2. if height(root.right) = height(root) - 1   ==> left subtree is complete
 *           3. otherwise, right subtree is complete
 *           4. # of nodes in a complete binary tree is 2^h  
 *
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
    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        int h = height(root);
        if (height(root.right) == h-1) { // right subtree is complete  
            return (1 << h) + countNodes(root.right);
        }
        return (1 << h-1) + countNodes(root.left); // left subtree is complete
    }
    
    private int height(TreeNode root) {
        return root == null ? -1 : height(root.left) + 1;
    }
}
