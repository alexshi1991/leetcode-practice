/*
 * Problem:  https://leetcode.com/problems/unique-binary-search-trees-ii/
 *
 * Idea:     1. 1..n is the in-order traversal for any BST with nodes 1 to n,
 *              so if i-th node is used as root, the left subtree will contain elements 1 to (i-1), 
 *              and the right subtree will contain elements (i+1) to n
 *           2. Use recursive calls to get back all possible trees for left and right subtrees 
 *              and combine them in all possible ways with the root.
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
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {return new ArrayList<TreeNode>();}
        return recGenerateTrees(1, n);
    }
    
    // recursively generate unique BSTs for range (start...end)
    public List<TreeNode> recGenerateTrees(int start, int end) {
        List<TreeNode> list = new ArrayList<>();
        if (start > end) {
            list.add(null);
            return list;
        }
        if (start == end) {
            list.add(new TreeNode(start));
            return list;
        }
        List<TreeNode> left, right;
        for (int i = start; i <= end; i++) {
            // all unique BSTs with i as root
            left = recGenerateTrees(start, i-1);
            right = recGenerateTrees(i+1, end);
            for (TreeNode lNode: left) {
                for (TreeNode rNode: right) {
                    TreeNode root = new TreeNode(i);
                    root.left = lNode;
                    root.right = rNode;
                    list.add(root);
                }
            }
        }
        
        return list;
    }
}
