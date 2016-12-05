/*
 * Problem: https://leetcode.com/problems/reverse-integer/
 *
 * Idea: get digits from input number one at a time (LSB first),
 *       use formula: result = result * 10 + newdigit to generate end result
 */


public class Solution {
    public int reverse(int x) {
        if (x == Integer.MIN_VALUE) { return 0; } // -2147483648 will overflow
        int sign = (x >= 0) ? 1: -1;
        x = Math.abs(x);
        int result = 0;
        while (x != 0) {
            // overflow
            if (result > ((Integer.MAX_VALUE - (x % 10)) / 10)) {
                result = 0;
                break;
            }
            result = result * 10 + x % 10;
            x /= 10;
        }
        return sign * result;
    }
}
