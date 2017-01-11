/*
 * Problem:  https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
 *
 * Idea:     1. walk down the BST as long as TreeNode p and q are on the same subtree
 *           2. if not then we found the LCA!
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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode node = root;
        while ((node.val - p.val) * (node.val - q.val) > 0) {
            if (p.val < node.val) {
                node = node.left;
            } else {
                node = node.right;
            }
        }
        return node;
    }
}
