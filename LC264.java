/*
 * Problem:  https://leetcode.com/problems/ugly-number-ii/
 *
 * Idea:     1. use 3 indexes to track next ugly number to be multiplies by prime factor 2, 3 and 5
 *           2. each prime factor will privide a candidate for the next ugly number 
 *           3. index that generated the next ugly number will advance/increment one while other two indexes remain the same
 *
 */

public class Solution {
    public int nthUglyNumber(int n) {
        int[] ugly = new int[n];
        ugly[0] = 1;
        // idx2 is the position of last ugly num that multiplied with prime factor 2
        // idx3, idx5 are the equivalant
        int idx2 = 0, idx3 = 0, idx5 = 0; 
        // factor2 is the candidate provided by last multiplying prime factor 2 to an ugly num
        // factor3 and factor5 are the equivalant
        int factor2 = 2, factor3 = 3, factor5 = 5;
        for (int i = 1; i < n; i++) {
            int min = Math.min(Math.min(factor2, factor3), factor5);
            ugly[i] = min;
            if (factor2 == min) {
                factor2 = 2*ugly[++idx2];
            }
            if (factor3 == min) {
                factor3 = 3*ugly[++idx3];
            }
            if (factor5 == min) {
                factor5 = 5*ugly[++idx5];
            }
        }
        return ugly[n-1];
    }
}
