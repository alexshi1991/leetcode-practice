/*
 * Problem: https://leetcode.com/problems/unique-paths-ii/
 *
 * Idea:    1. same as uniquePath 1, use dynamic programming and keep only one row in memory
 *          2. when obstacleGrid[i][j] = 0, then # of unique paths to get to (i, j) equals zero
 *          3. for first row, if an obstacle is encountered, rest of the p(i, j) = 0
 *             same for first column
 */




public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        
        if (obstacleGrid == null || obstacleGrid[0] == null) return 0;
        
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        
        if (m <= 0 || n <= 0) return 0;
        
        // initialize dp array
        int[] dp = new int[n];
        for (int i = 0; i < dp.length; i++) {
            if (obstacleGrid[0][i] == 1) {
                dp[i] = 0;
                break; // rest of the first row cannot be reached
            } else {
                dp[i] = 1;
            }
        }
        
        // dynamic programming, keep only one row in memory
        for (int row = 1; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (col == 0) {
                    if (dp[col] != 0) // only update dp[0] if the previous dp[0] is reachable
                        dp[col] = obstacleGrid[row][col] == 1 ? 0 : 1; 
                } else {
                    if (obstacleGrid[row][col] == 1) {
                        dp[col] = 0;
                    } else {
                        dp[col] = dp[col] + dp[col-1];
                    }
                }
            }
        }
        
        // number of unique path to reach last row, last col (bottom right)
        return dp[n-1];
    }
}
