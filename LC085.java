/*
 * Problem: https://leetcode.com/problems/maximal-rectangle/ 
 *
 * Idea:    1. this is a 2-dimensinal version of #084 - largest rectangle in histogram
 *          2. key to this problem is to construct a height matrix,
 *                a) height matrix has the same dimension as matrix
 *                b) each entry in the height matrix represents 
 *                   height of '1's use current element as base
 *                c) just need to call largestRectangleArea() for each row and find the max
 *             
 */

public class Solution {
    public int maximalRectangle(char[][] matrix) {
    
    	if (matrix == null || matrix.length == 0) return 0;
    
    	// calculate height matrix
    	int m = matrix.length;
    	int n = matrix[0].length;
    	int[][] height = new int[m][n];
    	for (int i = 0; i < n; i++) {
    		height[0][i] = matrix[0][i] - '0';
    	}
    	for (int i = 1; i < m; i++) {
    		for (int j = 0; j < n; j++) {
    			if (matrix[i][j] == '0') {
    				height[i][j] = 0;
    			} else {
    				height[i][j] = height[i - 1][j] + 1;
    			}
    		}
    	}
    
    	// use the largest rectangular area helper in histogram problem to solve
    	// for each row
    	int maxArea = Integer.MIN_VALUE;
    	for (int i = 0; i < m; i++) {
    		maxArea = Math.max(maxArea, largestRectangleArea(height[i]));
    	}
    
    	return maxArea;
    }
    
    // helper - the solution for leetcode#084,
    // see #084 for explanation of this function
    private int largestRectangleArea(int[] height) {
    	if (height == null || height.length == 0) return 0;
    
    	Stack<Integer> stack = new Stack<Integer>();
    	int max = 0, i = 0;
    
    	while (i < height.length) {
    		if (stack.isEmpty() || height[i] >= height[stack.peek()]) {
    			stack.push(i);
    			i++;
    		} else {
    			int h = height[stack.pop()];
    			int wid = stack.isEmpty() ? i : i - stack.peek() - 1;
    			max = Math.max(h * wid, max);
    		}
    	}
    
    	while (!stack.isEmpty()) {
    		int h = height[stack.pop()];
    		int wid = stack.isEmpty() ? i : i - stack.peek() - 1;
    		max = Math.max(h * wid, max);
    	}
    
    	return max;
    }
}
