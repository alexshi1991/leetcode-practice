/*
 * Problem:  https://leetcode.com/problems/binary-tree-paths/
 * 
 * Idea:     backtracking / preorder traversal
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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        StringBuilder currPath = new StringBuilder();
        if (root == null) return result;
        preorder(root, result, currPath);
        return result;
    }
    
    // visits a TreeNode before recursively visiting its child nodes
    private void preorder(TreeNode root, List<String> result, StringBuilder currPath) {
        int prevSize = currPath.length();
        currPath.append(root.val + "->");  // visit node
        if (root.left == null && root.right == null) {
            // leaf node
            result.add(currPath.substring(0, currPath.length()-2));  // remove the last "->"
        }
        if (root.left != null) preorder(root.left, result, currPath);
        if (root.right != null) preorder(root.right, result, currPath);
        currPath.delete(prevSize, currPath.length());  // unvisit the node
    }
}
