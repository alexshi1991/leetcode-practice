/*
 * Problem: https://leetcode.com/problems/string-to-integer-atoi/
 * 
 * Idea: 1. use LONG to store result for comparison with INTEGER.MAX_VALUE and INTEGER.MIN_VALUE
 *       2. scan input string from left to right, build result dynamically
 */


public class Solution {
    public int myAtoi(String str) {
        str = str.trim();
        if (str == null || str.length() == 0) { return 0;}
        int sign = 1;
        int pos = 0;
        if (str.charAt(0) == '+') { sign = 1; pos = 1; }
        if (str.charAt(0) == '-') { sign = -1; pos = 1; }
        long res = 0;
        while (pos < str.length()) {
            char c = str.charAt(pos);
            if (!isDigit(c)) { break; }
            res = res * 10 + (c - '0');
            if (res * sign > Integer.MAX_VALUE) { return Integer.MAX_VALUE;}
            if (res * sign < Integer.MIN_VALUE) { return Integer.MIN_VALUE;}
            pos++;
        }
        return (int)res * sign;
    }
    
    private boolean isDigit(char c) {
        return (c >= '0') && (c <= '9');
    }
}
