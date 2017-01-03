/*
 * Problem:  https://leetcode.com/problems/number-of-islands/
 *
 * Idea:     1. use DFS to find islands (connected lands)
 *           2. avoid using extra space by marking visited land with 'X' in the grid
 *              (and restore it after identifying all the islands)
 *
 */


public class Solution {
    public int numIslands(char[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) return 0;
        int m = grid.length;
        int n = grid[0].length;
        int islands = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    explore(grid, i, j); // find an island from adjacent lands
                    islands++;
                }
            }
        }
        // restore(grid);  // restore 'X' to '1' if needed
        return islands;
    }
    
    // from land grid[i][j], find island by searching ajacent lands, using dfs
    private void explore(char[][] grid, int row, int col) {
        grid[row][col] = 'X';
        if (row-1 >= 0 && grid[row-1][col] == '1') {
            explore(grid, row-1, col);   // top
        }
        if (col+1 < grid[0].length && grid[row][col+1] == '1') {
            explore(grid, row, col+1);  // right
        }
        if (row+1 < grid.length && grid[row+1][col] == '1') {
            explore(grid, row+1, col);  // bottom
        }
        if (col-1 >= 0 && grid[row][col-1] == '1') {
            explore(grid, row, col-1);  // left
        }
    }
    
    private void restore(char[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 'X') {
                    grid[i][j] = '1';
                }
            }
        }
    }
 }
