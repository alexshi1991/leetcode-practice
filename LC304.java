/*
 * Problem:  https://leetcode.com/problems/range-sum-query-2d-immutable/
 *
 * Idea:     1. construct a 2D matrix [m+1][n+1]
 *           2. each cell (i, j) has the area sum with (0,0) as top-left and (i, j) as bottom right
 *           3. when calculating result, divide the area into four parts
 *
 */

public class NumMatrix {
    
    private int[][] sum;

    public NumMatrix(int[][] matrix) {
        if (matrix != null && matrix.length > 0 
            && matrix[0] != null && matrix[0].length > 0) {
            int m = matrix.length;
            int n = matrix[0].length;
            sum = new int[m+1][n+1];
            
            for (int i = 0; i < m+1; i++)  // dummy row
                sum[i][0] = 0;  
            for (int j = 0; j < n+1; j++)  // dummy col
                sum[0][j] = 0;
            
            sum[1][1] = matrix[0][0];
            for (int j = 2; j < n+1; j++) { // first row
                sum[1][j] = sum[1][j-1] + matrix[0][j-1];
            }
            
            for (int i = 2; i < m+1; i++) { // first col
                sum[i][1] = sum[i-1][1] + matrix[i-1][0];
            }
            
            // fill the rest of the sum matrix
            for (int i = 2; i < m+1; i++) {
                for (int j = 2; j < n+1; j++) {
                    sum[i][j] = sum[i][j-1] + sum[i-1][j] - sum[i-1][j-1] + matrix[i-1][j-1];
                }
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int topLeft = sum[row1][col1];
        int bottomLeft = sum[row2+1][col1] - topLeft;
        int topRight = sum[row1][col2+1] - topLeft;
        int bottomRight = sum[row2+1][col2+1] - topLeft - bottomLeft - topRight;
        return bottomRight;
    }
}


// Your NumMatrix object will be instantiated and called as such:
// NumMatrix numMatrix = new NumMatrix(matrix);
// numMatrix.sumRegion(0, 1, 2, 3);
// numMatrix.sumRegion(1, 2, 3, 4);
