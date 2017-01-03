/*
 * Problem: https://leetcode.com/problems/bitwise-and-of-numbers-range/
 *
 * Idea:    find the left-most common bit for m and n
 *
 */


public class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        int mask = Integer.MAX_VALUE;
        while ((m & mask) != (n & mask)) {
            mask = mask << 1;
        }
        return n & mask;
    }
}
