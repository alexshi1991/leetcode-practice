/*
 * Problem: https://leetcode.com/problems/pascals-triangle/
 *
 * Idea:    generate new row from last row
 */

public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> pascal = new ArrayList<>();
        if (numRows == 0) return pascal;
        
        // first row
        List<Integer> firstRow = new ArrayList<>();
        firstRow.add(1);
        pascal.add(firstRow);
        
        // generate the next n-1 rows
        List<Integer> lastRow = firstRow; // keep track of last row
        List<Integer> currRow = null;
        for (int i = 1; i < numRows; i++) {
            currRow = new ArrayList<>();
            // fill in the (i+1) elements of this row
            for (int j = 0; j < i+1; j++) {
                if (j == 0 || j == i) {
                    currRow.add(1);
                } else {
                    currRow.add(lastRow.get(j-1) + lastRow.get(j));
                }
            }
            lastRow = currRow;
            pascal.add(currRow);
        }
        
        return pascal;
    }
}
