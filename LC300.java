/*
 * Problem:  https://leetcode.com/problems/longest-increasing-subsequence/
 *
 * Idea:     dynamic programming, when calculating longest increasing subsequence length for nums[i],
 *           we look at dp[0]...dp[j]..dp[i-1] (only when nums[j] < nums[i])
 */

public class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        // dynamic programming
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 0; i < n; i++) {
            int maxLen = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    maxLen = Math.max(maxLen, dp[j] + 1);
                }
            }
            dp[i] = maxLen;
        }
        
        // look for the max in dp[] array
        int max = 1;
        for (int len: dp) {
            max = Math.max(max, len);
        }
        return max;
    }
}