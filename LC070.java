/*
 * Problem: https://leetcode.com/problems/climbing-stairs/
 *
 * Idea:    1. dynamic programing
 *          2. dp[n] = dp[n-1] + dp[n-2]
 *          3. two approaches: memoization and bottom-up dp
 */

public class Solution {
    
    // no recursion, bottom-up dynamic programing
    public int climbStairs(int n) {
        if (n <= 1) return 1;
        int[] dp = new int[n];
        dp[0] = 1; dp[1] = 2;
        for (int i = 2; i < n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n-1];
    }
    
    
    // memoization with recursion, top-down dynamic programming
    public int climbStairs(int n) {
        Map<Integer, Integer> solved = new HashMap<>();
        return climbStairsRecur(n, solved);
    }
    
    // recursive helper
    private int climbStairsRecur(int n, Map<Integer, Integer> solved) {
        if (n <= 1) { return 1; } // base case
        int rec1 = 0;
        int rec2 = 0;
        if (solved.get(n-1) != null) {
            rec1 = solved.get(n-1);
        } else {
            rec1 = climbStairsRecur(n-1, solved);
            solved.put(n-1, rec1);
        }
        
        if (solved.get(n-2) != null) {
        	rec2 = solved.get(n-2);
        } else {
        	rec2 = climbStairs(n-2); 
        	solved.put(n-2, rec2);   
        }
        
        return rec1 + rec2;
    }
}
