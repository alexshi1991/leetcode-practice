/*
 * Problem: https://leetcode.com/problems/n-queens/
 *
 * Idea:   1. recursion, backtracking
 *         2. use List<Integer> to represent col positions for each row
 *         3. build the output result from this List<Integer>
 *         4. proper modularization
 */


public class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        if (n <= 0) { return result; }
        search(n, result, new ArrayList<Integer>());
        return result;
    }
    
    // recursively find the solutions to N-Queens puzzle,
    // use List<Integer> to represent Queens' col position for each row
    private void search(int n, List<List<String>> result, List<Integer> cols) {
        if (cols.size() == n) {
            result.add(drawChessBoard(cols));
            return;
        }
        for (int col = 0; col < n; col++) {
            if (!placeQueenOK(cols, col)) {
                continue;
            }
            cols.add(col);
            search(n, result, cols);
            cols.remove(cols.size() - 1); // backtracking
        }
    }
    
    // returns true if it is possible to place a new Queen at column: col on a new row
    private boolean placeQueenOK(List<Integer> cols, int currCol) {
        int currRow = cols.size();
        for (int row = 0; row < currRow; row++) {
            int col = cols.get(row);
            if (col == currCol) {
                return false;
            } else if (Math.abs(col - currCol) == Math.abs(row - currRow)) {
                return false; // on diagonal line
            }
        }
        return true;
    }
    
    // generate the output (fill a n*n board with '.'s and 'Q's)
    private List<String> drawChessBoard(List<Integer> cols) {
        List<String> board = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int row = 0; row < cols.size(); row++) {
            for (int col = 0; col < cols.size(); col++) {
                if (col == cols.get(row)) {
                    sb.append("Q");
                } else {
                    sb.append(".");
                }
            }
            board.add(sb.toString());
            sb.setLength(0);
        }
        return board;
    }
}
