/*
 * Problem:  https://leetcode.com/problems/perfect-squares/
 *
 * Idea:     1. dynamic programming 
 *           2. if number i is perfect square, then dp[i] = 1
 *           3. otherwise, we compare (dp[1] + dp[i-1]) ,  (dp[2] + dp[i-2]), ... find a minimum count
 *
 */

public class Solution {
    public int numSquares(int n) {
        if (n <= 0) return 0;
        if (n == 1) return 1;
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i < dp.length; i++) {
            if (isPerfectSquare(i)) {
                dp[i] = 1;
            } else {
                int mid = 1 + (i-2) / 2; // avoid duplicate consideration
                int minCount = Integer.MAX_VALUE;
                for (int j = 1; j <= mid; j++) {
                    minCount = Math.min(minCount, dp[j] + dp[i-j]);
                }
                dp[i] = minCount;
            }
        }
        return dp[n];
    }
    
    // check if a number is a perfect square
    private boolean isPerfectSquare(int n) {
        int closestRoot = (int) Math.sqrt(n);
        return n == closestRoot * closestRoot;
    }
}
