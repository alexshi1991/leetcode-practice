/*
 * Problem: https://leetcode.com/problems/pascals-triangle-ii/
 *
 * Idea:    1. generate curr row from last row
 *          2. keep only the last row in memory
 */


public class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> lastRow = new LinkedList<>();
        lastRow.add(1);
        List<Integer> currRow = new LinkedList<>();
        for (int row = 1; row <= rowIndex; row++) {
            for (int i = 0; i <= row; i++) {
                if (i == 0)  {
                    currRow.add(1); // first elem
                } else if (i == row) {
                    currRow.add(1); // last elem
                } else {
                    currRow.add(lastRow.get(i) + lastRow.get(i - 1));
                }
            }
            // exchange lastRow and currRow
            List<Integer> tmp = lastRow;
            lastRow = currRow;
            currRow = tmp;
            currRow.clear();
        }
        
        return lastRow;
    }
}
