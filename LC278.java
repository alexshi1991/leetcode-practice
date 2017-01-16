/*
 * Problem:  https://leetcode.com/problems/first-bad-version/
 *
 * Idea:     binary search
 *
 */


/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int left = 1, right = n, mid;
        while (left + 1 < right) {
            mid = left + (right - left) / 2;
            if (!isBadVersion(mid)) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return isBadVersion(left) ? left : right;
    }
}
