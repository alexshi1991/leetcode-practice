/*
 * Problem:  https://leetcode.com/problems/maximal-square/
 *
 * Idea:     1. dynamic programming 
 *           2. space usage can be further optimized by keeping only 1 row in memory
 *
 */


public class Solution {
    
    // keep only 1 row in memory, O(n) extra space
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0) return 0;
        if (matrix[0] == null || matrix[0].length == 0) return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int[] dp = new int[n+1];
        int maxsqlen = 0;
        int prevDiag = 0;  // save the diagnal element
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                int temp = dp[j];
                if (matrix[i-1][j-1] == '1') {
                    dp[j] = Math.min(Math.min(dp[j-1], prevDiag), dp[j]) + 1;
                    maxsqlen = Math.max(dp[j], maxsqlen);
                } else {
                    dp[j] = 0; // important since we are reusing the same row
                }
                prevDiag = temp;
            }
        }
        return maxsqlen * maxsqlen;
    }
    
    // keep all rows in memory, O(m*n) extra space
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0) return 0;
        if (matrix[0] == null || matrix[0].length == 0) return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m+1][n+1];
        int maxsqlen = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (matrix[i-1][j-1] == '1') {
                    dp[i][j] = Math.min(Math.min(dp[i][j - 1], dp[i-1][j-1]), dp[i-1][j]) + 1;
                    maxsqlen = Math.max(dp[i][j], maxsqlen);
                }
            }
        }
        return maxsqlen * maxsqlen;
    }
}
