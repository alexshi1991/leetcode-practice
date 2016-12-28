/*
 * Problem:  https://leetcode.com/problems/evaluate-reverse-polish-notation/
 *
 * Idea:     1. use a stack to save operands
 *           2. when encounter an operand, push onto stack
 *           3. when encounter an operator, retrieve the top two items on stack,
 *              perform calculation with two operands and the operator,
 *              push back result onto stack
 *           4. end result is the last item in the stack when the input token array is exhausted
 */

public class Solution {
    
    public int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length == 0) {
            return 0;
        }
        Stack<Integer> stack = new Stack<Integer>();
        String token = null;
        for (int i = 0; i < tokens.length; i++) {
            token = tokens[i];
            if (!isOperator(token)) {
                stack.push(Integer.parseInt(token));
            } else {
                int operand2 = stack.pop(); // order matters
                int operand1 = stack.pop();
                int result = evaluateExpression(operand1, operand2, token);
                stack.push(result);
            }
        }
        return stack.peek();
    }
    
    // helper - decides whether a token is an operator
    private boolean isOperator(String token) {
        if (token.equals("+") || token.equals("-")
            || token.equals("*") || token.equals("/")) {
            return true;    
        }
        return false;
    }
    
    // helper - evaluates the expression
    private int evaluateExpression(int operand1, int operand2, String token) {
        switch(token) {
            case "+": return operand1 + operand2;
            case "-": return operand1 - operand2;
            case "*": return operand1 * operand2;
            default : return operand1 / operand2; // "/"
        }
    }
}
