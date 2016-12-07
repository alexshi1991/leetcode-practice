/*
 * Problem: https://leetcode.com/problems/recover-binary-search-tree/
 *
 * Idea:    1. a in-order traversal of a valid BST will print out a sorted list of numbers
 *          2. consider the following output from a in-order traversal:
 *                                  6, 3, 4, 5, 2
 *             we know that 6 and 2 are out-of-order, we observer that:
 *             a) the first out-of-order element is always greater than its next node in traversal sequence
 *             b) the second out-of-order element is always less than its previous node in traversal sequence
 *          3. the algo: 
 *             a) perform in-order traversal, keep track of prev node in traversal sequence
 *             b) always compare curr node with its prev node
 *             c) find the two elements that are out-of-order
 *             d) swap their values
 *          4. this algorithm uses O(n) space since its a tree traversal,
 *             there exists a constans space solution called Morris Traversal   
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
    
    TreeNode firstElement = null;
    TreeNode secondElement = null;
    // used for always keep track of previous element during in-order traversal 
    TreeNode prevElement = new TreeNode(Integer.MIN_VALUE);
    
    public void recoverTree(TreeNode root) {
        // in-order traversal to find the two element
        traverse(root);
        
        // swap the values of the two nodes
        int temp = firstElement.val;
        firstElement.val = secondElement.val;
        secondElement.val = temp;
    }
    
    // in-order traversal, 
    // always compare curr node with its prev node in the in-order traversal
    private void traverse(TreeNode root) {
        if (root == null) return;
        traverse(root.left);
        // find first out-of-order node
        if (firstElement == null && prevElement.val >= root.val) {
            firstElement = prevElement;
        }
        // find second out-of-order node
        if (firstElement != null && prevElement.val >= root.val) {
            secondElement = root;
        }
        prevElement = root; 
        traverse(root.right);
    }
}
