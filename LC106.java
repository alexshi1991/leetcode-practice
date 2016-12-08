/*
 * Problem: https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
 *
 * Idea:     1. observe what the nodes distribution looks like for each array:
 *              a) postorder array ->  |leftsubtree | rightsubtree | root|
 *              b) inorder array  ->   |leftsubtree| root | rightsubtree| 
 *           2. we recursively do the following steps:
 *              a) use the root in postorder array to locate 
 *                 the left subtree section and right subtree section in inorder array
 *              b) build left subtree
 *              c) build right subtree
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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTreeRec(postorder.length-1, 0, inorder.length - 1, postorder, inorder);
    }
    
    private TreeNode buildTreeRec(int postStart, int inStart, int inEnd, int[] postorder, int[] inorder) {
        if (inStart > inEnd || postStart < 0) return null;
        TreeNode root = new TreeNode(postorder[postStart]);
        
        int inIndex = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == root.val) {
                inIndex = i;
                break;
            }
        }
    	root.left = buildTreeRec(postStart-(inEnd-inIndex)-1, inStart, inIndex-1, postorder, inorder);
    	root.right = buildTreeRec(postStart-1, inIndex+1, inEnd, postorder, inorder);
    	return root;
    }
}
