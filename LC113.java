/*
 * Problem: https://leetcode.com/problems/path-sum-ii/
 *
 * Idea:    1. classic backtracking dfs problem
 *          2. for a tree data structure, its also called preorder traversal
 *          3. we will get the result after traverse the tree once
 *          4. time complexity O(n), space complexity O(n) because of recursion
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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        findPathSum(root, sum, new ArrayList<Integer>(), result);
        return result;
    }
    
    // dfs, backtracking
    private void findPathSum(TreeNode root, int sum, List<Integer> currList, List<List<Integer>> result) {
        // reaching leaf node, return point
        if (root.left == null && root.right == null) {
            if (root.val == sum) {
                currList.add(root.val);
                result.add(new ArrayList<Integer>(currList));
                currList.remove(currList.size() - 1);
                return;
            }
        }
        if (root.left != null) {
            currList.add(root.val);
            findPathSum(root.left, sum - root.val, currList, result);
            currList.remove(currList.size() - 1);
        }
        if (root.right != null) {
            currList.add(root.val);
            findPathSum(root.right,sum - root.val, currList, result);
            currList.remove(currList.size() - 1);
        }
    }
    
}
