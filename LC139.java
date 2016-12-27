/*
 * Problem:  https://leetcode.com/problems/word-break/
 *
 * Idea:     dynamic programming
 *
 */


public class Solution {
    public boolean wordBreak(String s, Set<String> wordDict) {
        if (s == null) return false;
        if (s.length() == 0) return wordDict.isEmpty();
        
        // initialize dp array
        // dp[i] == true means s.substring(0,i) can be segmented into dictionary words
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                String newStr = s.substring(j, i);
                if (dp[j] == true && wordDict.contains(newStr)) {
                    dp[i] = true;
                    break;
                } 
            }
        }
        
        return dp[s.length()];
    }
}
