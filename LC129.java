/*
 * Problem:  https://leetcode.com/problems/sum-root-to-leaf-numbers/
 *
 * Idea:     preorder traversal, 
 *           add a new root-to-leaf number everytime we hit leaf node
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
    public int sumNumbers(TreeNode root) {
        int[] sum = new int[1];
        sum[0] = 0;
        preorder(root, sum, 0);
        return sum[0];
    }
    
    // preorder traversal
    private void preorder(TreeNode root, int[] sum, int curr) {
        if (root == null) return;
        curr = curr * 10 + root.val;
        if (root.left == null && root.right == null) {
            // leaf node
            sum[0] += curr;
        } else {
            if (root.left != null) {
                preorder(root.left, sum, curr);
            }
            if (root.right != null) {
                preorder(root.right, sum, curr);
            }
        }
    }
}
