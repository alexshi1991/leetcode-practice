/*
 * Problem: https://leetcode.com/problems/set-matrix-zeroes/
 *
 * Idea:    1. use the first row to mark cols that need to be cleared
 *          2. use the first col to mark rows that need to be cleared
 *          3. use two special booleans to mark whether first row and first col need to be cleared
 *          4. clear the rows except first, clear the cols except first
 *          5. clear first row and first col if needed
 *          6. in-place solution requires no extra space
 */

public class Solution {
    public void setZeroes(int[][] matrix) {
        if (matrix == null) return;
        if (matrix.length == 0) return;
        if (matrix[0] == null) return;
        if (matrix[0].length == 0) return;
        
        int m = matrix.length;
        int n = matrix[0].length;
        
        boolean clearRow0 = false;
        boolean clearCol0 = false;
        
        // mark the columns and rows to be cleared
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (matrix[row][col] == 0) {
                    if (row == 0) {
                        clearRow0 = true;
                    }
                    if (col == 0) {
                        clearCol0 = true;
                    }
                    matrix[row][0] = 0;
                    matrix[0][col] = 0;
                }
            }
        }
        
        // use first column '0' markers to clear all rows except first row
        for (int row = 1; row < m; row++) {
            if (matrix[row][0] == 0) {
                for (int col = 1; col < n; col++) {
                    matrix[row][col] = 0;
                }
            }
        }
        
        // use first row '0' markers to clear all cols except first
        for (int col = 1; col < n; col++) {
            if (matrix[0][col] == 0) {
                for (int row = 1; row < m; row++) {
                    matrix[row][col] = 0;
                }
            }
        }
        
        // clear row 0 if necessary
        if (clearRow0) {
            for (int col = 0; col < n; col++) {
                matrix[0][col] = 0;
            }
        }
        
        // clear col 0 if necessary
        if (clearCol0) {
            for (int row = 0; row < m; row++) {
                matrix[row][0] = 0;
            }
        }
        
    }
}
