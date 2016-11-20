/*
 * Problem: https://leetcode.com/problems/jump-game-ii/
 *
 * Idea:    1. one way to solve the problem is using dynamic programming O(n*n)
 *          2. dp solution computes the minimum number of jumps needed to jump to each position
 *          3. there exists a faster algorithm that runs in O(n) time (see comments below)
 *         
 */


public class Solution {

    // O(n) time solution
    // 1. the main idea is based on greedy. 
    // 2. let's say the range of the current jump is [curBegin, curEnd]
    // 3. curFarthest is the farthest point that all points in [curBegin, curEnd] can reach.
    // 4. once the current point reaches curEnd, then trigger another jump, and set the new curEnd with curFarthest
    // 5. exit early if curEnd >= nums.length - 1
    public int jump(int[] nums) {
        int jumps = 0, curEnd = 0, curFarthest = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            curFarthest = Math.max(curEnd, i + nums[i]);
            if(i == curEnd) {
                // make another jump
                jumps++;
                curEnd = curFarthest;
                if (curEnd >= nums.length - 1) {
                    break;
                }
            } 
        }
        return jumps;
    }


    // dp solution, O(n*n) time complexity
    public int jump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        // dp[i] means the minimum number of jumps needed to jump to i from start
        int[] dp = new int[nums.length];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] < Integer.MAX_VALUE && nums[j] >= i - j) {
                    // dp[i] is optimal because all dp[j] are optimal 
                    dp[i] = dp[j] + 1; 
                    break;
                }
            }
        }
        
        return dp[nums.length-1];
    }
}
