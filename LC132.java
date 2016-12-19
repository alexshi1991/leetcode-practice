/*
 * Problem: https://leetcode.com/problems/palindrome-partitioning-ii/
 *
 * Idea:    1. dynamic programming, solve current prob by utilizing result of smaller probs
 *          2. dp[i] == min cuts needed for s.substring(0, i)
 *          3. when calculating dp[i]:
 *             a) we find all the  0 <= j <= i that satisfies: s[j...i] is palindrome
 *             b) find the min cut of all the splits and +1 to get min cuts for curr prob / str
 *
 */


public class Solution {
    public int minCut(String s) {
        if (s == null || s.length() == 0) return 0;
        
        // initialize dp array
        // cut[i] == min cuts needed for s.substring(0, i)
        int[] cut = new int[s.length()+1];
        cut[0] = 0;
        
        // auxiliary 2-d array for efficient look-up, 
        // by default, every entry is initialized to false
        boolean[][] isPalindrome = new boolean[s.length()][s.length()];
        
        int start = 0, end = 0;
        for (int i = 1; i <= s.length(); i++) {
            cut[i] = Integer.MAX_VALUE;
            for (int j = 1; j <= i; j++) {
                start = i - j;
                end = i - 1;
                if (s.charAt(start) == s.charAt(end)
                  && (end - start <= 2 || isPalindrome[start+1][end-1])) {
                      isPalindrome[start][end] = true;
                }
                if (isPalindrome[start][end] && cut[i - j] != Integer.MAX_VALUE) {
                    cut[i] = Math.min(cut[i], cut[i-j] + 1);
                }
            }
        }
        
        return cut[s.length()] - 1;
    }
}
