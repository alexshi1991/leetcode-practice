/*
 * Problem:  https://leetcode.com/problems/binary-tree-postorder-traversal/
 *
 * Idea:     1. iterative solution uses a stack
 *           2. use extra variable(TreeNode) to remember 
 *              where the traverse is comming from (prev visited node)
 *              a) when curr node is a child of prev node, it means current traverse direction is down
 *                 put curr.left and curr.right on stack
 *              b) when curr node is parent and prev node is left child, it means the current traverse 
 *                 direction is up, put curr.right on stack (left subtree of curr has been examined)
 *              c) when curr node is parent and prev node is right child, it means the current traverse
 *                 direction is up, whole subtree has been examined, visit node itself
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
    
    // iterative version, using a stack
    public List<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode prev = null; // previously traversed node
        TreeNode curr = root;
    
        if (root == null) return result;
    
        stack.push(root);
        while (!stack.empty()) {
            curr = stack.peek();
            if (prev == null || prev.left == curr || prev.right == curr) { // traverse down the tree
                if (curr.left != null) {
                    stack.push(curr.left);
                } else if (curr.right != null) {
                    stack.push(curr.right);
                }
            } else if (curr.left == prev) { // traverse up the tree from the left
                if (curr.right != null) {
                    stack.push(curr.right);
                }
            } else { // traverse up the tree from the right
                result.add(curr.val);
                stack.pop();
            }
            prev = curr;
        }
    
        return result;
    }
    
    // recursive solution
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        postOrder(root, result);
        return result;
    }
    
    private void postOrder(TreeNode root, List<Integer> result) {
        if (root == null) return;
        postOrder(root.left, result);
        postOrder(root.right, result);
        result.add(root.val);
    }
}
