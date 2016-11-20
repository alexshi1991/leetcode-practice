/*
 * Problem: https://leetcode.com/problems/rotate-image/
 *
 * Idea:  rotate the matrix like an onion, rotate one layer at a time
 */


public class Solution {
    // in-place rotation
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        // rotate the matrix like an onion, rotate one layer at a time
        for (int layer = 0; layer < n / 2; layer++) {
            for (int i = layer; i < n - layer - 1; i++) {
                int tmp = matrix[layer][i]; // save top
                matrix[layer][i] = matrix[n-i-1][layer]; // left -> top
                matrix[n-i-1][layer] = matrix[n-layer-1][n-i-1]; // bottom -> left
                matrix[n-layer-1][n-i-1] = matrix[i][n-layer-1]; // right -> bottom
                matrix[i][n-layer-1] = tmp; // top -> right
            }
        }
    }
}
