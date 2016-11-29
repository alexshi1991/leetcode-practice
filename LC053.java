/*
 * Problem:  https://leetcode.com/problems/maximum-subarray/
 *
 * Idea:    1. keep track of the max of subarray sum so far
 *          2. reset sum when it becomes negative, then start a new subarray sum,
 *             in other words, as long as the current subarray sum is positive,
 *             this subarray may be part of the max subarray
 *          3. greedy, linear time
 */



public class Solution {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) { return 0;}
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            max = Math.max(max, sum);
            sum = Math.max(sum, 0);
        }
        return max;
    }
}
