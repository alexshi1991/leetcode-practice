/*
 * Problem:  https://leetcode.com/problems/binary-tree-right-side-view/
 *
 * Idea:     level order traversal of BST
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
    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> currLevel = new LinkedList<>();
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        currLevel.add(root);
        while (!currLevel.isEmpty()) {
            int size = currLevel.size();
            TreeNode node = currLevel.peek();
            while (size > 0) {
                node = currLevel.remove();
                if (node.left != null) currLevel.add(node.left);
                if (node.right != null) currLevel.add(node.right);
                size--;
            }
            result.add(node.val);
        }
        return result;
    }
}
