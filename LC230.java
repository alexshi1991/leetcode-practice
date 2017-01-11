/*
 * Problem: https://leetcode.com/problems/kth-smallest-element-in-a-bst/
 *
 * Idea:      Two ways to approach this problem:
 *          1) inorder traversal of BST gives ascending order
 *          2) binary search (preferred for this problem)  
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
    // method 1: inorder traversal (recursive)
    int count = 0;
    int result = Integer.MIN_VALUE;
    
    public int kthSmallest(TreeNode root, int k) {
        traverse(root, k);
        return result;
    }
    
    public void traverse(TreeNode root, int k) {
        if(root == null) return;
        traverse(root.left, k);
        count++;
        if(count == k) result = root.val;
        traverse(root.right, k);       
    }
    
    // method 2: inorder traversal (iterative)
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode p = root;
        int count = 0;
        
        while(!stack.isEmpty() || p != null) {
            if(p != null) {
                stack.push(p);  // Just like recursion
                p = p.left;   
            } else {
                TreeNode node = stack.pop();
                if(++count == k) return node.val; 
                p = node.right;
            }
        }
        return Integer.MIN_VALUE;
    }
    
    // method 3: binary search (Most Preferred)
    public int kthSmallest(TreeNode root, int k) {
        int count = countNodes(root.left);
        if (k <= count) {
            return kthSmallest(root.left, k);
        } else if (k > count + 1) {
            return kthSmallest(root.right, k-1-count);
        }
        return root.val; // k == count + 1, current node is the kth smallest
    }
    
    private int countNodes(TreeNode n) {
        if (n == null) return 0;
        return 1 + countNodes(n.left) + countNodes(n.right);
    }
}
