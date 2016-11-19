/*
 * Problem: https://leetcode.com/problems/sudoku-solver/
 *
 * Idea:    1. recursion, backtracking, dfs
 *          2. every recursive call, try to fill one position in sudoku, and recur on a smaller input
 *          3. helper function to validate if row, col, submatrix all satisfy sudoku requirement  
 */

public class Solution {
    public void solveSudoku(char[][] board) {
        solve(0, 0, board);
    }
    
    // recursive helper
    private boolean solve(int i, int j, char[][] board) {
    	if (i == 9) {
    	    i = 0; j++;
    	    if (j == 9) return true; 
    	}
    	if (board[i][j] != '.')  // skip filled cells
    	    return solve(i+1, j, board);
    	
    	// try fill board[i][j] with valid vals in 1...9 
    	for (int val = 1; val <= 9; val++) {
    	    if (valid(i, j, val, board)) {  
    		    board[i][j] = Character.forDigit(val, 10);   
    		    if (solve(i+1, j, board))  
    		        return true;
    	    }
    	}
    	board[i][j] = '.'; // reset on backtrack
    	return false;
    }
    
    // return true if the assignment board[i][j] = val keeps the sudoku valid
    private boolean valid(int i, int j, int val, char[][] board) {
        // check if row i contains val
        for (int col = 0; col < board[0].length; col++) {
            if (board[i][col] - '0' == val) {
                return false;
            }
        }
        // check if col j contains val
        for (int row = 0; row < board.length; row++) {
            if (board[row][j] - '0' == val) {
                return false;
            }
        }
        // submatrix (locate the corresponding one first)
        int x = (i / 3) * 3, y = (j / 3) * 3;
        for (int row = x; row < x + 3; row++) {
            for (int col = y; col < y + 3; col++) {
                if (board[row][col] - '0' == val) {
                    return false;
                }
            }
        }
        return true;
    }
}
