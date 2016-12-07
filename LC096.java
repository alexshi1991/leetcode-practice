/*
 * Problem: https://leetcode.com/problems/unique-binary-search-trees/
 *
 * Idea:    1. dynamic programming
 *          2. # of unique BSTs for 1...n => SUM(# of unique BSTs using j as root) (1 <= j <= n)
 *          3. # of unique BSTs using j as root ===> (# of unique BSTs for 1...j-1) * (# of unique BSTs for j+1...i)
 *          4. # of unique BSTs for j+1...i ==> # of unique BSTs for 1...i-j
 */



public class Solution {
    public int numTrees(int n) {
        // dp[i] means # of unique BSTs that store value 1...n
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        // # of unique BSTs for 1...n => SUM(# of unique BSTs using j as root) (1 <= j <= n)
        for(int i = 2; i <= n; i++) {
            // # of unique BSTs using j as root 
            // ===> (# of unique BSTs for 1...j-1) * (# of unique BSTs for j+1...i)
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[j-1] * dp[i-j];
            }
        }
        return dp[n];
    }
}
