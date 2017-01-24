/*
 * Problem:  https://leetcode.com/problems/range-sum-query-mutable/
 *
 * Idea:     1. use augmented tree node to store range and sum information
 *           2. recursively build a segment tree where:
 *                  a) its left child responsible for [start, mid]
 *                  b) its right child responsible for [mid+1, end]
 *           3. update operation needs to update all the SegTree nodes whose range contains the index
 *           4. range sum operation recursively adds up sum value if its children based on overlapping situation
 *           5. update and range sum are both log(n) operations
 */

public class NumArray {

    class SegTreeNode {
        int start, end;
        SegTreeNode left, right;
        int sum;  // sum for range [start:end]

        public SegTreeNode(int start, int end) {
            this.start = start;
            this.end = end;
            this.left = null;
            this.right = null;
            this.sum = 0;
        }
    }
      
    SegTreeNode root = null;

    public NumArray(int[] nums) {
        root = buildTree(nums, 0, nums.length-1);
    }
    
    // recursively build tree for range [start:end]
    private SegTreeNode buildTree(int[] nums, int start, int end) {
        if (start > end) return null;
        SegTreeNode node = new SegTreeNode(start, end);
        if (start == end) {
            node.sum = nums[start];
        } else {
            int mid = start + (end - start) / 2;
            node.left = buildTree(nums, start, mid);
            node.right = buildTree(nums, mid+1, end);
            node.sum = node.left.sum + node.right.sum;
        }
        return node;
    }
    
    public void update(int i, int val) {
        update(root, i, val);
    }
    
    // recursively update all SegTree node whose range contains pos
    private void update(SegTreeNode root, int pos, int val) {
        if (root.start == root.end) {
            root.sum = val;
        } else {
            int mid = root.start + (root.end - root.start) / 2;
            if (pos <= mid) {
                update(root.left, pos, val);
            } else {
                update(root.right, pos, val);
            }
            root.sum = root.left.sum + root.right.sum;
        }
    }
    
    public int sumRange(int i, int j) {
        return sumRange(root, i, j);
    }
    
    // recursively sum ranges
    private int sumRange(SegTreeNode root, int start, int end) {
        if (root.end == end && root.start == start) {
            return root.sum;
        } else {
            int mid = root.start + (root.end - root.start) / 2;
            if (end <= mid) {
                return sumRange(root.left, start, end);
            } else if (start >= mid+1) {
                return sumRange(root.right, start, end);
            }  else {    
                return sumRange(root.right, mid+1, end) + sumRange(root.left, start, mid);
            }
        }
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(i,val);
 * int param_2 = obj.sumRange(i,j);
 */

