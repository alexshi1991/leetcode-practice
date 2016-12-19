/*
 * Problem:  https://leetcode.com/problems/single-number/
 *
 * Idea:     1. bit manipulation, xor all the elems in the array
 *           2. A ^ A = 0
 *
 */


public class Solution {
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int num: nums) {
            result ^= num;
        }
        return result;
    }
}
