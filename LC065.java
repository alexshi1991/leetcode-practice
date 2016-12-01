/*
 * Problem: https://leetcode.com/problems/valid-number/
 *
 * Idea:    1. use 3 booleans dot, exp, num to denote the current status:
 *             a) dot = true if we have encountered a '.' in s
 *             b) exp = true if we have encountered a 'e' in s
 *             c) num = true if current evaluation results a valid number (a number can end with '.')
 */

public class Solution {
    public boolean isNumber(String s) {
        if (s == null) return false;
        s = s.trim();
        if (s.length() == 0) return false;
        boolean dot = false;
        boolean exp = false;
        boolean num = false;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // skip first '+'/'-' sign
            if (i == 0 && (c == '+' || c == '-')) {
                continue;
            }
            if (Character.isDigit(c)) {
                num = true;
            } else if (c == '.') {
                if (exp || dot) return false;
                dot = true;
            } else if (c == 'e') {
                if (exp || !num) return false;
                exp = true;
                num = false;
            } else if (c == '+' || c == '-') {
                if (s.charAt(i-1) != 'e') return false;
            } else {
                return false;
            }
        }
        return num;
    }
}


