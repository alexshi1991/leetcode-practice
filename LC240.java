/*
 * Problem:  https://leetcode.com/problems/search-a-2d-matrix-ii/
 *
 * Idea:     1. start from the top right corner
 *           2. compare the element with the target value:
 *              if elem smaller than target, then eliminate entire row (look at next row)
 *              if elem greater than target, then eliminate entire col (look at prev col)
 *           3. the running time is O(m+n) since each row and each col 
 *              are eliminated exactly once in the worst case
 *
 */

public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 
            || matrix[0].length == 0)  return false;
        int row = 0, col = matrix[0].length - 1;
        while (col >= 0 && row <= matrix.length - 1) { // start from top-right corner
            if (matrix[row][col] == target) return true;
            else if (matrix[row][col] < target) {
                row++; // eliminate row
            } else if (matrix[row][col] > target) {
                col--; // eliminate col
            }
        }
        return false;
    }
}
