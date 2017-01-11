/*
 * Problem: https://leetcode.com/problems/power-of-two/
 *
 * Idea: bit manipulation
 */

public class Solution {
    public boolean isPowerOfTwo(int n) {
        while (n > 1) {
            if ((n & 1) != 0) {
                return false;
            }
            n >>= 1;
        }
        return n == 1;
    }
}
