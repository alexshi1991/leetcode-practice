/*
 * Problem: https://leetcode.com/problems/unique-paths/
 *
 * Idea:    1. dynamic programming, let p(i, j) = # of unique paths to (i, j)
 *             we have p(i, j) = p(i - 1, j) + p(i, j - 1)
 *          2. due to this relation, we only need to keep one row in memory at a time,
 *             thus convert the problem to a 1-D dynamic programming program
 */




public class Solution {
    public int uniquePaths(int m, int n) {
        if (m <= 0 || n <= 0) return 0;
        
        // initialize dp array
        int[] dp = new int[n];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = 1;
        }
        
        // dynamic programming, keep only one row in memory
        for (int row = 1; row < m; row++) {
            for (int col = 1; col < n; col++) {
                dp[col] = dp[col] + dp[col-1];
            }
        }
        
        // number of unique path to reach last row, last col (bottom right)
        return dp[n-1];
    }
}
