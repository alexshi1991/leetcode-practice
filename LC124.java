/*
 * Problem:  https://leetcode.com/problems/binary-tree-maximum-path-sum/
 *
 * Idea:     1. recursively calculate maxPathSum for left and right subtree
 *           2. update global max sum by examining root.val + leftMax + rightMax
 *           3. when consider maxPathSum for a subtree rooted at root,
 *              only consider path root -> left and path root -> right，
 *              do not consider from left -> root -> right
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
    public int maxPathSum(TreeNode root) {
        int[] max = new int[1];
        max[0] = Integer.MIN_VALUE;
        maxPathSum(max, root);
        return max[0];
    }
    
    private int maxPathSum(int[] max, TreeNode root) {
        if (root == null) return 0;
        int leftMax = Math.max(0, maxPathSum(max, root.left));
        int rightMax = Math.max(0, maxPathSum(max, root.right));
        max[0] = Math.max(max[0], root.val + leftMax + rightMax);
        return root.val + Math.max(leftMax, rightMax);
    }
}

