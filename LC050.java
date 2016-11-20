/*
 * Problem: https://leetcode.com/problems/powx-n/
 *
 * Idea:    1. recursion, everytime cut the problem size in half
 *          2. myPow(x, n) = myPow(x * x, n / 2) if n % 2 == 0
 *             myPow(x, n) = x * myPow(x * x, n / 2) if n % 2 == 1
 *          3. if n < 0, convert prob:
 *             myPow(x, n) -> myPow(1/x, -n)
 *          4. use long variable to avoid negative overflow (when handling Integer.MIN_VALUE)
 */


public class Solution {
    // O(logN), every recursive call cut down the problem size by half
    public double myPow(double x, int n) {
        if (n == 0) return 1;
        if (x == 0) return 0;
        long m = n; // avoid overflow when trying to negate an int (Integer.MIN_VALUE)
        if (m < 0) {
            m = -m;
            x = 1 / x;
        }
        if (m % 2 == 0) {
            return myPow(x*x, (int) (m / 2));
        }
        return x * myPow(x*x, (int) (m / 2));
    }
}
