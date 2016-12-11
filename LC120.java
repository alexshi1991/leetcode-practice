/*
 * Problem: https://leetcode.com/problems/triangle/
 *
 * Idea:    1. dynamic programming, starting from the bottom row
 *          2. when we compute dp[col]:
 *             a) we look at Math.min(dp[col], dp[col+1])
 *             b) we add triangle.get(row).get(col) to it
 *          3. result is at dp[0]
 */


public class Solution {
    // dynamic programming solution
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) return 0;
        
        // initialize dp array
        List<Integer> lastRow = triangle.get(triangle.size() - 1);
        int[] dp = new int[lastRow.size()];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = lastRow.get(i);
        }
        
        // bottom-up dp, uses only O(n) extra space
        // by keeping only 1 row in memory
        for (int row = triangle.size() - 2; row >= 0; row--) {
            for (int col = 0; col <= row; col++) {
                dp[col] = triangle.get(row).get(col) + Math.min(dp[col], dp[col+1]);
            }
        }
        
        return dp[0];
    }
}
