/*
 * Problem: https://leetcode.com/problems/word-search/
 *
 * Idea:   1. backtracking, recursion
 *         2. create a boolean[][] the same size as board[][]
 *            to track which elements of the board have already been used
 *         3. the recursive function tries to find a match 
 *            to the 1st char of word from four directions
 *         4. use a helper to check if a certain coordinate (i,j) is in range
 *
 */

public class Solution {
    public boolean exist(char[][] board, String word) {
        if (board == null || board[0] == null) return false;
        boolean[][] visited = new boolean[board.length][board[0].length];
        int currRow = 0, currCol = 0;
        boolean found = false;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    visited[i][j] = true;
                    found = searchWord(word.length() > 1? word.substring(1): "", board, visited, i, j);
                    if (found) return true;
                    visited[i][j] = false;
                }
            }
        }
        return found;
    }
    
    private boolean searchWord(String word, char[][] board, boolean[][] visited, int currRow, int currCol) {
        // base case
        if (word.equals("")) return true;
        
        boolean found = false;
        // top
        if (inRange(currRow - 1, currCol, board) && (visited[currRow-1][currCol] == false) && (word.charAt(0) == board[currRow-1][currCol])) {
            visited[currRow-1][currCol] = true;
            found = searchWord(word.length() > 1? word.substring(1) : "" , board, visited, currRow-1, currCol);
            if (found) return true;
            visited[currRow-1][currCol] = false;
        }
        // right
        if (inRange(currRow, currCol + 1, board) && (visited[currRow][currCol+1] == false) && (word.charAt(0) == board[currRow][currCol+1])) {
            visited[currRow][currCol+1] = true;
            found = searchWord(word.length() > 1? word.substring(1) : "" , board, visited, currRow, currCol+1);
            if (found) return true;
            visited[currRow][currCol+1] = false;
        }
        // bottome
        if (inRange(currRow + 1, currCol, board) && (visited[currRow+1][currCol] == false) && (word.charAt(0) == board[currRow+1][currCol])) {
            visited[currRow+1][currCol] = true;
            found = searchWord(word.length() > 1? word.substring(1) : "" , board, visited, currRow+1, currCol);
            if (found) return true;
            visited[currRow+1][currCol] = false;
        }
        // left
        if (inRange(currRow, currCol-1, board) && (visited[currRow][currCol-1] == false) && (word.charAt(0) == board[currRow][currCol-1])) {
            visited[currRow][currCol-1] = true;
            found = searchWord(word.length() > 1? word.substring(1) : "" , board, visited, currRow, currCol-1);
            if (found) return true;
            visited[currRow][currCol-1] = false;
        }
        return false;
    }
    
    // helper - check if a coordinate is within range of the board
    private boolean inRange(int row, int col, char[][] board) {
        return row >= 0 && row < board.length && col >= 0 && col < board[0].length;
    }
}
