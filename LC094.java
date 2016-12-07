/*
 * Problem: https://leetcode.com/problems/binary-tree-inorder-traversal/
 *
 * Idea:    1. recursive solution is trivial
 *          2. iterative solution uses a stack, for each node
 *             a) recursively add all left child in the subtree until hitting leaf
 *             b) pop node off stack, left subtree has been examined, add node.val to list
 *             c) begin to examine node's right subtree 
 *          3. time complexity O(n), space complexity O(n) 
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
    
    // iterative solution, based on using a stack
    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        TreeNode curr = root;
        while(curr != null || !stack.isEmpty()) {
            // recursively add left child to the stack until hitting null
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            // any time we pop node off stack, the node's left subtree has been examined
            curr = stack.pop();
            result.add(curr.val);
            // begin to examine right subtree
            curr = curr.right;
        }
        return result;
    }
    
    // recursive solution
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorderTraversal(root, result);
        return result;
    }
    
    // recursive function
    private void inorderTraversal(TreeNode root, List<Integer> result) {
        if (root == null) return;
        inorderTraversal(root.left, result);
        result.add(root.val);
        inorderTraversal(root.right, result);
    }
}
