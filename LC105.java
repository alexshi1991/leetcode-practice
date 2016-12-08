/*
 * Problem:  https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 *
 * Idea:     1. observe what the nodes distribution looks like for each array:
 *              a) preorder array ->   |root | leftsubtree | rightsubtree|
 *              b) inorder array  ->   |leftsubtree| root | rightsubtree|
 *           2. we recursively do the following steps:
 *              a) use the root in preorder array to locate 
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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTreeRec(0, 0, inorder.length - 1, preorder, inorder);
    }
    
    
    /*
     * arguments:
     *     preStart: the start index in preorder array for curr subtree
     *     inStart: the start index in inorder array for curr subtree
     *     inEnd: the end index in inorder array for curr subtree
     */
    private TreeNode buildTreeRec(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder) {
        if (preStart > preorder.length - 1 || inStart > inEnd) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preStart]);
        // locate index of the root in inorder array
        int inIndex = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == root.val) {
                inIndex = i;
            }
        }
        // recursively build left subtree
        root.left = buildTreeRec(preStart+1, inStart, inIndex-1, preorder, inorder);
        // recursively build right subtree
        root.right = buildTreeRec(preStart+inIndex-inStart+1, inIndex+1, inEnd, preorder, inorder);
        return root;
    }
}
