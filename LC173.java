/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// O(1) time for hasNext()
// O(h) time and memory for next()
// O(h) time and memory for the constructor
public class BSTIterator {
    
    private Stack<TreeNode> stack;
    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        TreeNode cur = root;
        while(cur != null){
            stack.push(cur);
            if(cur.left != null)
                cur = cur.left;
            else
                break;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode node = stack.pop();
        TreeNode cur = node;
        // traversal right branch
        if(cur.right != null){
            cur = cur.right;
            while(cur != null){
                stack.push(cur);
                if(cur.left != null)
                    cur = cur.left;
                else
                    break;
            }
        }
        return node.val;
    }
}





// O(1) time for hasNext() and next(),
// O(n) time and O(n) memory for the inorder BST traversal and Queue<TreeNode>
public class BSTIterator {

    private Queue<TreeNode> queue;

    public BSTIterator(TreeNode root) {
        queue = new LinkedList<>();
        inorder(queue, root);
    }
    
    // recursive helper, inorder traversal of BST, put tree nodes in queue in sorted order
    private void inorder(Queue<TreeNode> queue, TreeNode root) {
        if (root != null) {
            inorder(queue, root.left);
            queue.offer(root);
            inorder(queue, root.right);
        }  
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !queue.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        return queue.remove().val;
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */
