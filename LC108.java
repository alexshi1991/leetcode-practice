/*
 * Problem: https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
 *
 * Idea:    1. know that the sorted array can be interpreted as an inorder traversal
 *          2. inorder traversal -->   | left subtree | root | right subtree |
 *          3. for a balanced BST, choose item in the middle as the root
 *          4. recursively build left and right subtree using the same method
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
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        return recSortedArrayToBST(nums, 0, nums.length - 1);
    }
    
    // build BST using nodes from num[start...end]
    private TreeNode recSortedArrayToBST(int[] nums, int start, int end) {
        if (start > end) return null;
        int mid = start + (end - start) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = recSortedArrayToBST(nums, start, mid-1);
        node.right = recSortedArrayToBST(nums, mid + 1, end);
        return node;
    }
}

