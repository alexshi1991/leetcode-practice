/*
 * Problem: https://leetcode.com/problems/implement-strstr/
 *
 * Idea: 1. look for needle from each char in haystack, sliding window of size needle.length()
 *       2. straight-forward O(m*n) solution, m = len(haystack), n = len(needle)
 */

public class Solution {
    public int strStr(String haystack, String needle) {
        int start = 0;
        while (haystack.length() - start >= needle.length()) {
            int matchingChars = 0;
            int j = start;
            for (int i = 0; i < needle.length(); i++) {
                if (needle.charAt(i) == haystack.charAt(j)) {
                    matchingChars++;
                    j++;
                } else {
                    break;
                }
            }
            if (matchingChars == needle.length()) {
                return start; 
            }
            start++;
        }
        return -1;
    }
    
    // same idea, more elegant implementation
    public int strStr(String haystack, String needle) {
        for (int i = 0; ; i++) {
            for (int j = 0; ; j++) {
                if (j == needle.length()) return i;
                if (i + j == haystack.length()) return -1;
                if (needle.charAt(j) != haystack.charAt(i + j)) break;
            }
        }
    }
}
