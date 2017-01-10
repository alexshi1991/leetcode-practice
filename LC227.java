/*
 * Problem:  https://leetcode.com/problems/basic-calculator-ii/
 *
 * Idea:     1. use a stack to store all the intermidiate result (3, -5, 6/2, 7*8)
 *           2. add all the intermidiate in the stack to get final result
 *
 */

public class Solution {
    public int calculate(String s) {
        if (s == null || s.length() == 0)  return 0;
        Stack<Integer> stack = new Stack<>();
        int num = 0;
        char operator = '+';
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = num * 10 + s.charAt(i) - '0';
            }
            if (!Character.isDigit(c) && c != ' ' || (i == (s.length() - 1))){
                if (operator == '-') {
                    stack.push(-num);
                } else if (operator == '+') {
                    stack.push(num);
                } else if (operator == '*') {
                    stack.push(stack.pop() * num);
                } else if (operator == '/') {
                    stack.push(stack.pop() / num);
                }
                operator = c;
                num = 0;
            }
        }
        
        int result = 0;
        while (!stack.isEmpty()) {
            result += stack.pop();
        }
       
        return result;
    }
}
