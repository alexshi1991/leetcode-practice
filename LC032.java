/*
 * Problem: https://leetcode.com/problems/longest-valid-parentheses/
 *
 * Idea: 1. use a stack too maintain unmatched left parens
 *       2. every unmatched right paren starts the search for a new valid substring
 *       3. every matched right paren generates a new maxLen with the last unmatched left paren
 *       4. O(n) time complexity
 */


public class Solution {
    public int longestValidParentheses(String s) {
        if (s == null || s.length() < 2) return 0;
        
        Stack<Integer> left = new Stack<Integer>();
        int lastUnmatchedRight = -1;
        int maxLen = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                left.push(i);
            } else {
                if (left.isEmpty()) {
                    lastUnmatchedRight = i; // i+1 is the new beginning of valid substring
                } else {
                    left.pop();
                    if (left.isEmpty()) {
                        maxLen = Math.max(maxLen, i - lastUnmatchedRight);
                    } else {
                        // there are consecutive '('s 
                        maxLen = Math.max(maxLen, i - left.peek());
                    }
                }
            }
        }
        return maxLen;
    }
}
