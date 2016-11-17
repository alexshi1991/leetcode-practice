/*
 * Problem: https://leetcode.com/problems/generate-parentheses/
 *
 * Idea: 1. recursion, backtracking, keep track of # of left and right parens
 *       2. when # of left paren equals # of right paren, add to result list
 *       3. when # of left paren smaller than # of right paren, invalid string, discard
 */


public class Solution {

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        int numLeftParen = 0, numRightParen = 0;
        recGenerateParenthesis("", result, numLeftParen, numRightParen, n);
        return result;
    }
    
    private void recGenerateParenthesis(String curr, List<String> result, int numLeftParen, int numRightParen, int n) {
        if (numLeftParen == n && numRightParen == n) {
            result.add(curr);
            return;
        }
        if (numLeftParen > n || numRightParen > n || numRightParen > numLeftParen) {
            return; 
        }
        recGenerateParenthesis(curr + '(', result, numLeftParen+1, numRightParen, n);
        recGenerateParenthesis(curr + ')', result, numLeftParen, numRightParen+1, n);
    }
    
}
