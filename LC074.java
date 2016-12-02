/*
 * Problem: https://leetcode.com/problems/search-a-2d-matrix/
 *
 * Idea:    1. binary search to find the row
 *          2. binary search to find the col
 */

public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // binary search to find the row
        int start = 0, end = matrix.length- 1;
        int mid, row;
        while (start + 1 < end) {
            mid = start + (end - start) / 2;
            if (matrix[mid][0] == target) return true;
            if (matrix[mid][0] > target)  end = mid;
            if (matrix[mid][0] < target) start = mid;
        }
        if (matrix[start][0] == target) return true;
        if (matrix[end][0] == target) return true;
        row = matrix[end][0] < target ? end: start;
        
        // binary search to find the element within the row
        start = 0;
        end = matrix[0].length - 1;
        while (start + 1 < end) {
            mid = start + (end - start) / 2;
            if (matrix[row][mid] == target) return true;
            if (matrix[row][mid] > target) end = mid;
            if (matrix[row][mid] < target) start = mid;
        }
        if (matrix[row][start] == target) return true;
        if (matrix[row][end] == target) return true;
        return false;
    }
}
