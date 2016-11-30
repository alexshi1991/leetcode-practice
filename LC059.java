/*
 * Problem: https://leetcode.com/problems/spiral-matrix-ii/
 *
 * Idea:    1. build one layer at a time:  top -> right -> bottom -> left
 *          2. when n is odd, matrix[n/2][n/2] is the last item that needs to be filled separately
 */

public class Solution {
    public int[][] generateMatrix(int n) {
        
        // allocate matrix
        int[][] matrix = new int[n][n];
        
        int num = 1;
        // fill one layer at a time
        for (int layer = 0; layer < n / 2; layer++) {
            
            // top
            for (int i = layer; i < n - 1 - layer; i++) {
                matrix[layer][i] = num;
                num++;
            }
            
            // right
            for (int i = layer; i < n - 1 - layer; i++) {
                matrix[i][n - 1 - layer] = num;
                num++;
            }
            
            // bottom
            for (int i = n - 1 - layer; i > layer; i--) {
                matrix[n - 1 - layer][i] = num;
                num++;
            }
            
            // left
            for (int i = n - 1 - layer; i > layer; i--) {
                matrix[i][layer] = num;
                num++;
            }
        }
        
        // the last piece
        if (n % 2 != 0) {
            matrix[n/2][n/2] = n * n;
        }
        
        return matrix;
    }
}
