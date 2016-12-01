/*
 * Problem: https://leetcode.com/problems/minimum-path-sum/
 *
 * Idea:    dynamic programming, keeping one row at memory
 */




public class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        // initialize
        int[] dp = new int[n];
        dp[0] = grid[0][0];
        for (int i = 1; i < n; i++) {
            dp[i] = grid[0][i] + dp[i-1];
        }
        
        // dynamic programming
        for (int row = 1; row < m; row++) {
            dp[0] = grid[row][0] + dp[0];
            for (int col = 1; col < n; col++) {
                dp[col] = Math.min(dp[col-1], dp[col]) + grid[row][col];
            }
        }
        
        return dp[n-1];
    }
}
