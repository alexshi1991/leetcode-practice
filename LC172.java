/*
 * Problem: https://leetcode.com/problems/factorial-trailing-zeroes/
 *
 * Idea:    count the number of 5 factors in n!
 *
 */


public class Solution {
    public int trailingZeroes(int n) {
        if (n == 0) return 0;
        return n / 5 + trailingZeroes(n / 5);
    }
}
