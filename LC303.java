/*
 * Problem:  https://leetcode.com/problems/range-sum-query-immutable/
 *
 * Idea:     1. computes cumulative sum in constructor function O(N)
 *           2. sumRange() will be O(1)
 *
 */

public class NumArray {
    
    private int[] sum;  // cumulative sum from sum[i] = num[0] + num[1] + ... num[i]

    public NumArray(int[] nums) {
        if (nums != null && nums.length > 0) {
            sum  = new int[nums.length];
            sum[0] = nums[0];
            for (int i = 1; i < nums.length; i++) {
                sum[i] = nums[i] + sum[i-1];
            }
        }
    }

    public int sumRange(int i, int j) {
        if (i == 0)  return sum[j];
        return sum[j] - sum[i-1];
    }
}


// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.sumRange(1, 2);
