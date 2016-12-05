/*
 * Problem: https://leetcode.com/problems/decode-ways/
 *
 * Idea:   1. dynamic programming
 *         2. dp[i] is only related to dp[i-1] and dp[i-2]
 *         3. either consider decode curr char separately (dp[i-1] different ways), 
 *            or, if the 'prev char + curr char' is a valid two digit (between 10 and 26),
 *            decode the combined str separately (dp[i-2] different ways)
 *         4. add the result of above two approaches together, we get dp[i]
 */

public class Solution {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) return 0;
        if (s.charAt(0) == '0') return 0;
        
        // initialize dp array
        int[] dp = new int[s.length()];
        dp[0] = 1; // only 1 way to decode single char message
        
        // dp[i] means how many ways to decode s.substring(0,i+1)
        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            // case 1: decode c separately
            if (c != '0') {
                dp[i] = dp[i-1];
            }
            // case 2: try to decode c together with the prev digit
            int twoDigit = Integer.parseInt(s.substring(i-1, i+1));
            if (twoDigit >= 10 && twoDigit <= 26) {
                if (i - 2 == -1) {
                    dp[i] += 1; // if the string is "10", prevents indexOutOfBound
                } else {
                    dp[i] += dp[i-2];
                }
            }
        }
        
        return dp[s.length()-1];
    }
}

