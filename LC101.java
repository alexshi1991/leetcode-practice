/*
 * Problem:  https://leetcode.com/problems/symmetric-tree/
 *
 * Idea:     1. recursive solution recursively compares two subtrees isSymmetric(left, right)
 *           2. iterative solution uses two queues for the left and right subtree of the root
 *           3. for left queue, add left child and then right child, the opposite for right queue
 *           4. both solutions run in O(n) time, and use O(n) space
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
    
    // iterative solution
    public boolean isSymmetric(TreeNode root) {
        if(root==null)  return true;
    	Queue<TreeNode> leftQueue = new LinkedList<TreeNode>();
    	Queue<TreeNode> rightQueue = new LinkedList<TreeNode>();
    	
        leftQueue.add(root.left);
        rightQueue.add(root.right);
        
        // BFS on leftQueue and rightQueue, notice the difference in
        // the order that childeren gets added to the queue
        while (!leftQueue.isEmpty() && !rightQueue.isEmpty()){
            
        	TreeNode node1 = leftQueue.poll();
        	TreeNode node2 = rightQueue.poll();
        	
        	if (node1 == null && node2 != null) return false;
        	if (node1 != null && node2 == null) return false;
                
            if (node1 != null) {
                if (node1.val != node2.val) return false;
                leftQueue.add(node1.left);
                leftQueue.add(node1.right);
                rightQueue.add(node2.right);
                rightQueue.add(node2.left);
            }
        }
        return true;
    }
    
    // recursive solution
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isSymmetricRecur(root.left, root.right);
    }
    
    private boolean isSymmetricRecur(TreeNode rootLeft, TreeNode rootRight) {
        if (rootLeft == null && rootRight == null) return true; 
        if (rootLeft == null || rootRight == null) return false;
        if (rootLeft.val != rootRight.val) return false;
        return isSymmetricRecur(rootLeft.left, rootRight.right) && isSymmetricRecur(rootLeft.right, rootRight.left);
    }
}
