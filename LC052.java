/*
 * Problem: https://leetcode.com/problems/n-queens-ii/
 *
 * Idea:    1. backtracking idea similar to n-queens-i
 *          2. no need to save the result each time a solution is found,
 *             just increment the counter instead
 */


public class Solution {
    
    class Counter {
        private int counter;
        public Counter() { 
            this.counter = 0; 
        }
        public void increment() { 
            this.counter++; 
        }
        public int getCounter() {
            return this.counter;
        }
    }
    
    public int totalNQueens(int n) {
        Counter counter = new Counter();
        int[] cols = new int[n];
        Arrays.fill(cols, -1);
        dfs(cols, n, 0, counter);
        return counter.getCounter();
    }
    
    // depth-first search, track col positions for each row,
    // can reuse the same int[] cols since we are not saving 
    // the board config each time we found a solution
    private void dfs(int[] cols, int n, int row, Counter counter) {
        if (row == n) { 
            counter.increment(); 
        } else {
            for (int col = 0; col < n; col++) {
                if (placeQueenOK(cols, col, row)) {
                    cols[row] = col;
                    dfs(cols, n, row + 1, counter);
                    cols[row] = -1;
                }
            }
        }
    }
    
    // returns true if a Queen can be placed at currCol, currRow
    private boolean placeQueenOK(int[] cols, int currCol, int currRow) {
        for (int row = 0; row < currRow; row++) {
            int col = cols[row];
            if (currCol == col) {
                return false;
            }
            if (Math.abs(currCol - col) == currRow - row) {
                return false;
            }
        }
        return true;
    }
}
