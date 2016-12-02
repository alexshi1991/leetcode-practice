/*
 * Problem: https://leetcode.com/problems/edit-distance/
 *
 * Idea:   1. 2-D dynamic programming
 *         2.     B I C Y C L E
 *              0 1 2 3 4 5 6 7
 *            B 1 0 1 2 3 4 5 6
 *            Y 2 1 1 2 2 3 4 5
 *            T 3 2 2 2 3 3 4 5
 *            E 4 3 3 3 3 4 4 4
 *         3. the minimum distance 4 is obtained by 
 *            a) deleting I, C, C in BICYCLE
 *            b) replacing L in BICYCLE with T 
 */


public class Solution {
    public int minDistance(String word1, String word2) {
        
        int m = word1.length();
        int n = word2.length();
        
        // initialize dp array
        int[][] dp = new int[m+1][n+1];
        for (int i = 0; i < n + 1; i++) {
            dp[0][i] = i;
        }
        for (int i = 0; i < m + 1; i++) {
            dp[i][0] = i;
        }
        
        // dp
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (word1.charAt(i-1) == word2.charAt(j-1)) {
                    // match
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    // no match
                    // the edit distance is the minimum of the following:
                    // 1. dp[i-1][j-1] + 1 means replacing a character
                    // 2. dp[i][j-1] + 1   means inserting a character in word2
                    // 3. dp[i-1][j] + 1   means deleting a character in word1
                    dp[i][j] = Math.min(dp[i-1][j-1] + 1, Math.min(dp[i][j-1] + 1, dp[i-1][j] + 1));
                }
            }
        }
        
        // result at bottom right
        return dp[m][n];
    }
}
