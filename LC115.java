/*
 * Problem: https://leetcode.com/problems/distinct-subsequences/
 *
 * Idea:    1. 2-d dynamic programming, similar to that edit distance prob
 *          2. dp[i][j] means distinct sequence of t[0...j] in s[0...i]
 *          3. if we look at a subprob: how many "rabbi" in "rabbbi"
 *             a) we look at how many "rabbi" in "rabbb" which is 0
 *             b) (because the last 'i' match)we look at how any "rabb" in "rabbb", which is 3
 *             c) we combine the two results, we get 3
 *
 *          Visual example:
 *              r a b b i t  
 *            1 0 0 0 0 0 0  
 *          r 1 1 0 0 0 0 0
 *          a 1 1 1 0 0 0 0
 *          b 1 1 1 1 0 0 0
 *          b 1 1 1 2 1 0 0 
 *          b 1 1 1 3 3 0 0
 *          i 1 1 1 3 3 3 0
 *          t 1 1 1 3 3 3 3 
 */


public class Solution {
    public int numDistinct(String s, String t) {
        if (s == null || t == null)  return 0;
        int m = s.length();
        int n = t.length();
        
        // initialize a 2-d dp array
        int[][] nums = new int[m+1][n+1];
        for (int i = 0; i < m; i++) {
            nums[i][0] = 1;
        }
        for (int i = 1; i < n; i++) {
            nums[0][i] = 0;
        }
        
        // run dp
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                nums[i][j] = nums[i-1][j];
                if (s.charAt(i-1) == t.charAt(j-1)) {
                    nums[i][j] += nums[i-1][j-1];
                }
            }
        }
        
        return nums[m][n];
    }
}
