/*
 * Problem: https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
 *
 * Idea:    1. use two stacks, one for current level , one for next level
 *          2. use a boolean to indicate the current order for adding child to the next level
 *          3. exchange two stacks after each iteration
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> levelorder = new ArrayList<>();
        if (root == null) return levelorder;
        
        Stack<TreeNode> currLevel = new Stack<>();
        Stack<TreeNode> nextLevel = new Stack<>();
        Stack<TreeNode> tmp;
        List<Integer> level = null;
        boolean reverseOrder = true;
        currLevel.push(root);
        while (!currLevel.isEmpty()) {
            level = new ArrayList<Integer>();
            while (!currLevel.isEmpty()) {
                TreeNode node = currLevel.pop();
                level.add(node.val);
                if (reverseOrder) {
                    // Last-In-First-Out, add left child first so right child
                    // gets popped off stack first
                    if (node.left != null) {
                        nextLevel.push(node.left);
                    }
                    if (node.right != null) {
                        nextLevel.push(node.right);
                    }
                } else {
                    // Last-In-First-Out, add right child first so left child
                    // gets popped off stack first
                    if (node.right != null) {
                        nextLevel.push(node.right);
                    }
                    if (node.left != null) {
                        nextLevel.push(node.left);
                    }
                }
            }
            levelorder.add(level);
            tmp = currLevel;
            currLevel = nextLevel;
            nextLevel = tmp;
            reverseOrder = !reverseOrder;
        }
        return levelorder;
    }
}
