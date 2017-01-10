/*
 * Problem: https://leetcode.com/problems/basic-calculator/
 *
 * Idea:    1. Use a single stack
 *          2. Everytime a left paren '(' occurs, push onto stack the current result and sign before it (operator '+' or '-')
 *          e. Everytime a right paren ')' occurs, computes the current result (value in paren) and add it (or minus it) to/from prev saved result
 */

public class Solution {
    public int calculate(String s) {
        if (s == null)  return 0;
        int result = 0;
        int num = 0;
        int sign = 1;  // 1 for '+', -1 for '-' 
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = 10 * num + (int) (c - '0');
            } else if (c == '+') {
                result += sign * num;
                num = 0;
                sign = 1;
            } else if (c == '-') {
                result += sign * num;
                num = 0;
                sign = -1;
            } else if (c == '(') {
                stack.push(result);
                stack.push(sign);
                // reset the sign and result for the value in the parenthesis
                sign = 1; 
                result = 0;
            } else if (c == ')') {
                result += sign * num;
                num = 0;
                result *= stack.pop(); // stack.pop() is the sign before the parenthesis
                result += stack.pop(); // stack.pop() now is the result calculated before the parenthesis
            }
        }
        if(num != 0) result += sign * num;
        return result;
    }
}
