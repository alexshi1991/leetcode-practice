/*
 * Problem: https://leetcode.com/problems/zigzag-conversion/
 * 
 * Idea: build strings for each row , map index in the original string to the correct row
 */


public class Solution {
    public String convert(String s, int numRows) {
        if (numRows <= 1) return s;
        
        StringBuilder[] sbs = new StringBuilder[numRows];
        for (int i = 0; i < sbs.length; i++) {
            sbs[i] = new StringBuilder();
        }
        int increment = 1, row = 0;
        for (int i = 0; i < s.length(); i++) {
            sbs[row].append(s.charAt(i));
            row += increment; // go to next row
            if (row % (numRows - 1) == 0) {
                increment *= -1; // reverse direction
            }
        }
        
        // aggregate result
        StringBuilder result = sbs[0];
        for (int i = 1; i < numRows; i++) {
            result.append(sbs[i]);
        }
        return result.toString();
    }
}