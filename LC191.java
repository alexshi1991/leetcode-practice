/*
 * Problem: https://leetcode.com/problems/number-of-1-bits/
 *
 * Idea:    bit manipulation
 */


public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            count += (n & 1);
            n >>>= 1; // use >>> instead of >>, this is logical right shift, >> is arithmetic right shift
        }
        return count;        
    }
}
