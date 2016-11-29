/*
 * Problem: https://leetcode.com/problems/jump-game/
 *
 * Idea:    1. one approach is to use dynamic programming, but it runs in polynomial time
 *          2. greedy approach can solve the problem in linear time
 *          3. iterate through items in the array, keep track of max reachable index
 *          4. if the current index is greater than the max reachable index, then current index is not reachable
 *          5. if any one of the indices is not reachable, then the last index is not reachable
 */


public class Solution {
    
    // linear time greedy solution
    public boolean canJump(int[] nums) {
        int reachable = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > reachable) return false;
            reachable = Math.max(reachable, i + nums[i]); 
        }
        return true;
    }
    
    // polynomial time dynamic programming solution
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) { return false; }
        
        // initialize 1D dp array, 
        // dp[i] means whether its possible to jump from beginning of the array
        // to ith element of the array
        boolean[] dp = new boolean[nums.length];
        dp[0] = true;
        
        // dp routine 
        for (int i = 1; i < nums.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (dp[j] && nums[j] >= i - j) {
                    dp[i] = true;
                    break;
                }
            }
        }
        
        // whether or not jump can reach the last index
        return dp[nums.length-1];
    }
}
