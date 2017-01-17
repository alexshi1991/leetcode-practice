/*
 * Problem: https://leetcode.com/problems/game-of-life/
 *
 * Idea:    1. expand the # of states from 2 (live or dead) to 4 (capture both current and next state)
 *          
 *          2. the following mapping is used: 
 *             00    -->    dead(next) <--- dead(curr)
 *             01    -->    dead(next) <--- live(curr)
 *             10    -->    live(next) <--- dead(curr)
 *             11    -->    live(next) <--- live(curr)
 *
 *          3. for each cell, computes the next state based on neighboring cells curr state
 *          4. switch from curr state to next state by :   board[i][j] >>= 1
 *
 */

public class Solution {
    public void gameOfLife(int[][] board) {
        if (board == null || board.length == 0) return;
        int m = board.length, n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                
                int lives = liveNeighbors(board, m, n, i, j);
                
                // at the start every 2nd bit is 0 (e.g state is either 00 or 01)
                
                // transition live -> live
                if (board[i][j] == 1 && lives >= 2 && lives <= 3) {
                    board[i][j] = 3;  // next state is live, map to state 11
                }
                // transition dead -> live
                if (board[i][j] == 0 && lives == 3) {
                    board[i][j] = 2;  // next state is live, map to state 10
                }
                
                // transitions live -> dead, and dead -> dead 
                // are automatically achieved when we switch to 2nd bit
            }
        }
        
        // switch from current state(1st bit) to next state(2nd bit)
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                board[i][j] >>= 1;
    }
    
    // helper - calculates number of living neighbors for a given cell
    private int liveNeighbors(int[][] board, int m, int n, int i, int j) {
        int lives = 0;
        for (int x = Math.max(i - 1, 0); x <= Math.min(i + 1, m - 1); x++) {
            for (int y = Math.max(j - 1, 0); y <= Math.min(j + 1, n - 1); y++) {
                lives += board[x][y] & 1;
            }
        }
        lives -= board[i][j] & 1;
        return lives;
    }
    
}
