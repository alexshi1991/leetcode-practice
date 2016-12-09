/*
 * Problem:  https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/
 *
 * Idea:    1. sorted list can be viewed as an inorder traversal of the BST
 *          2. inorder traversal -->   | left subtree | root | right subtree |
 *          3. for a balanced BST, choose item in the middle as the root
 *          4. recursively build left and right subtree using the same method
 *          5. use fast, slow pointers to find mid node 
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
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
    
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        return toBST(head, null);
    }
    
    private TreeNode toBST(ListNode head, ListNode tail) {
        if (head == tail) return null;
        // find middle node
        ListNode slow = head;
        ListNode fast = head;
        while (fast != tail && fast.next != tail) {
            fast = fast.next.next;
            slow = slow.next;
        }
        // use mid node as root to achieve balance
        TreeNode root = new TreeNode(slow.val);
        // recursively build left and right subtree
        root.left = toBST(head, slow);
        root.right = toBST(slow.next, tail);
        return root;
    }
}
