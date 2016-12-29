/*
 * Problem:  https://leetcode.com/problems/min-stack/
 *
 * Idea:     1. use a separate stack for the minValues
 *           2. update the minValues stack as push() and pop() called
 *
 */

public class MinStack {

    private Stack<Integer> stack;
    private Stack<Integer> minValues;
    
    public MinStack() {
        stack = new Stack<Integer>();
        minValues = new Stack<Integer>();
    }
    
    public void push(int x) {
        stack.push(x);
        if (minValues.isEmpty() || x <= minValues.peek()) {
            minValues.push(x);
        }
    }

    public void pop() {
        if (stack.pop().equals(minValues.peek())){
            minValues.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minValues.peek();
    }
}

