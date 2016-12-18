/*
 * Problem: https://leetcode.com/problems/surrounded-regions/
 *
 * Idea:    1. use all Os at 4 sides as starting point to find all reachable Os using BFS
 *          2. mark all the reachable Os using 'Y'
 *          3. the remaining Os that are not marked as 'Y' are unreachable Os, flip them to 'X'
 *          4. the Os that marked as 'Y' should be marked back to 'O' 
 *
 */

public class Solution {
    // helper class
    class Coordinate {
        int row;
        int col;
        public Coordinate(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
    
    public void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return;
        }
        
        int m = board.length;
        int n = board[0].length;
        Queue<Coordinate> queue = new LinkedList<Coordinate>();
        
        // add Os at 4 sides to the queue
        for (int row = 0; row < m; row++) {
            if (board[row][0] == 'O') {
                queue.add(new Coordinate(row, 0));
            }
            if (board[row][n - 1] == 'O') {
                queue.add(new Coordinate(row, n - 1));
            }
        }
        for (int col = 0; col < n; col++) {
            if (board[0][col] == 'O') {
                queue.add(new Coordinate(0, col));
            }
            if (board[m-1][col] == 'O') {
                queue.add(new Coordinate(m - 1, col));
            }
        }
        
        // BFS to find all reachable O
        while (!queue.isEmpty()) {
            Coordinate c = queue.remove();
            int row = c.row;
            int col = c.col;
            // visit node
            board[row][col] = 'Y';
            // inspect neighbors
            if (row > 0 && board[row - 1][col] == 'O') {
                queue.add(new Coordinate(row - 1, col));
            }
            if (row < m - 1 && board[row + 1][col] == 'O') {
                queue.add(new Coordinate(row + 1, col));
            }
            if (col > 0 && board[row][col - 1] == 'O') {
                queue.add(new Coordinate(row, col - 1));
            }
            if (col < n - 1 && board[row][col + 1] == 'O') {
                queue.add(new Coordinate(row, col + 1));
            }
        }
        
        // flip the remaining Os in the matrix as they are surrounded by X
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == 'Y') {
                    board[i][j] = 'O';
                }
            }
        }
    }
}
