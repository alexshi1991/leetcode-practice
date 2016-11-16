/*
 * Problem: https://leetcode.com/problems/valid-parentheses/
 *
 * Idea:  1. use a stack
 *        2. when encounter left paren, push to stack
 *        3. when encounter right paren, pop stack and compare to see whether left and right parens match
 */

public class Solution {
    public boolean isValid(String s) {
        Stack<Character> leftParen = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            switch (c) {
                case '(':
                case '{':
                case '[':
                    leftParen.push(c);
                    break;
                case ')':
                case '}':
                case ']':
                    if (leftParen.isEmpty() || !matchingParen(leftParen.pop(), c)) {
                        return false;
                    }
                    break;
            }
        }
        return leftParen.isEmpty();
    }
    
    // returns true if two parens match
    private boolean matchingParen(char left, char right) {
        return (left == '(' && right == ')') || 
               (left == '{' && right == '}') || 
               (left == '[' && right == ']'); 
    }
}
