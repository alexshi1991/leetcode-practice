/*
 * Problem: https://leetcode.com/problems/interleaving-string/
 *
 * Idea:   1. recursion + memoization
 *         2. reason for memoization is we might be solving the same subprob twice
 *            consider: s1 = "bahi"
 *                      s2 = "abade"
 *                      s3 = "ababadefg"
 *                      two different ways to interleave "ababa", but the same subprob
 */

public class Solution {
    Set<String> memo = new HashSet<String>();
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1 == null || s2 == null || s3 == null) return false;
        if (s1.length() + s2.length() != s3.length()) return false;
        if (s1.equals("") && s2.equals("") && s3.equals("")) return true;
        
        if (memo.contains(s1 + "#" + s2)) return false; // memoization
        
        boolean matchToS1 = false, matchToS2 = false;
        if (s1.length() > 0 && s1.charAt(0) == s3.charAt(0)) {
            matchToS1 = true;
        }
        if (s2.length() > 0 && s2.charAt(0) == s3.charAt(0)) {
            matchToS2 = true;
        }
        if (matchToS1 && isInterleave(s1.substring(1), s2, s3.substring(1))) {
            return true;
        }
        if (matchToS2 && isInterleave(s1, s2.substring(1), s3.substring(1))) {
            return true;
        }
        
        memo.add(s1 + "#" + s2); // memoization
        
        return false;
    }
}
