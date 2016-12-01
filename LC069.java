/*
 * Problem: https://leetcode.com/problems/sqrtx/
 *
 * Idea:    1. binary search
 *          2. if sqrt(x) is not integer, find floor(sqrt(x))
 */

public class Solution {
    public int mySqrt(int x) {
        int left = 1, right = x;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (mid == x / mid) {
                return mid;
            } else if (mid < x / mid) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return right; // right * right < x < left * left
    }
}
