/*
 * Problem: https://leetcode.com/problems/binary-tree-level-order-traversal-ii/
 *
 * Idea:    1. BFS using a queue data structure
 *          2. add a new level to the front of result list instead of back
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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> levelorder = new ArrayList<>();
        if (root == null) return levelorder;
        
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.remove();
                level.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            levelorder.add(0, level); // add to front 
        }
        
        return levelorder;        
    }
}

