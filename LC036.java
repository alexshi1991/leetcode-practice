/*
 * Problem: https://leetcode.com/problems/valid-sudoku/
 *
 * Idea:    1. validate for each row, then each col, then each submatrix (3 X 3)
 *          2. use a boolean array to track if certain number already appeared in row/col/submatrix
 */



public class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean[] numbers = new boolean[10]; // one extra dummy space for '0'
        // row
        for (int row = 0; row < 9; row++) {
            Arrays.fill(numbers, false);
            for (int col = 0; col < 9; col++) {
                int number = board[row][col] - '0';
                if (number == '.' - '0') {
                    continue;
                }
                if (numbers[number] == true) {
                    return false;
                }
                numbers[number] = true;
            }
        }
        // col
        for (int col = 0; col < 9; col++) {
            Arrays.fill(numbers, false);
            for (int row = 0; row < 9; row++) {
                int number = board[row][col] - '0';
                if (number == '.' - '0') {
                    continue;
                }
                if (numbers[number] == true) {
                    return false;
                }
                numbers[number] = true;
            }
        }
        // submatrix
        for (int row = 0; row < 9; row += 3) {
            for (int col = 0; col < 9; col += 3) {
                Arrays.fill(numbers, false);
                for (int i = row; i < row + 3; i++) {
                    for (int j = col; j < col + 3; j++) {
                        int number = board[i][j] - '0';
                        if (number == '.' - '0') {
                            continue;
                        }
                        if (numbers[number] == true) {
                            return false;
                        }
                        numbers[number] = true;
                    }
                }
            }
        }
        return true;
    }
}
