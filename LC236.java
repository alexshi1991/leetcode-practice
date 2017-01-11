/*
 * Problem:  https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
 *
 * Idea:     1. this is a generalization of LC235 (LowestCommonAncestor for BST)
 *           2. recursion, recursively returns target node (or LCA) found in the subtree
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
    // return LCA if both p and q are in the subtree, otherwise return whichever node found in the subtree
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);  
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null && right == null)  return null;
        else if (left != null && right != null) return root;
        else if (left != null) return left;
        else return right;
    }
}
