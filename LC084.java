/*
 * Problem: https://leetcode.com/problems/largest-rectangle-in-histogram/
 *
 * Idea:    1. For every bar 'b', we calculate the area with 'b' as the smallest bar in the rectangle
 *          2. We need to know the index of first smaller bar left of 'x' and index of first smaller bar right of 'x'
 *          3. Maintain a stack of bars. (stack actually holds bar indexes)
 *             a) every bar is pushed to stack once
 *             b) a bar is popped from stack when a bar of smaller height is seen
 *             c) when a bar is popped, we calculate the area with the popped bar as the smallest bar
 *             d) we know the bar in the stack before popped bar is the first smaller bar to its left
 *                and the current bar is the first smaller bar to its right, therefore we have the width
 *          4. When the array is exhasted, we need to pop each remaining item off the stack and calculate its rectangle area
 *          5. Algorithm runs in linear time
 */


public class Solution {
    public int largestRectangleArea(int[] heights) {
        
        if (heights == null || heights.length == 0) return 0;
        
        // stack holds indexes of heights[] array
        // bars stored in stack are always in increasing order of
        // their heights
        Stack<Integer> stack = new Stack<>();
        
        int maxArea = heights[0];
        
        int i = 0;
        while (i < heights.length) {
            // if this bar is higher than the bar on top stack, push it to stack
            if (stack.isEmpty() || heights[stack.peek()] <= heights[i]) {
                stack.push(i);
                i++;
            } else {
                // if this bar is lower than top bar of stack, then calculate area of
                // rectangle with stack top as the smallest bar. 
                int stackTop = stack.pop();
                int height = heights[stackTop];
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                maxArea = Math.max(maxArea, height * width);
            }
        }
        // now pop the remaining bars off the stack and calculate area
        // with every popped bar as smallest bar
        while (!stack.isEmpty()) {
            int stackTop = stack.pop();
            int height = heights[stackTop];
            int width = stack.isEmpty() ? i : i - stack.peek() - 1;
            maxArea = Math.max(maxArea, height * width);
        }
        
        return maxArea;
    }
}
