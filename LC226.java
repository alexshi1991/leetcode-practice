/*
 * Problem:  https://leetcode.com/problems/invert-binary-tree/
 *
 * Idea:     recursively 1)invert the left and right subtree
 *                       2)switch the two childs of the root
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
    public TreeNode invertTree(TreeNode root) {
        if (root != null) {
            TreeNode leftSubtree = invertTree(root.left);
            TreeNode rightSubtree = invertTree(root.right);
            root.left = rightSubtree;
            root.right = leftSubtree;
        }
        return root;
    }
}
