/*
 * Problem: https://leetcode.com/problems/merge-sorted-array/
 *
 * Idea:    1. fill the array backwards,
 *             take advantage of the fact that we know exactly will be m+n elems
 *          2. pay attention to the fact that nums1 could be exhausted before nums2
 */

public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // fill the array backwards
        int pos = m + n - 1;
        int pos1 = m - 1, pos2 = n - 1;
        while (pos2 >= 0) {
            // check for pos1 >= 0, because if pos1 < 0, it means
            // all nums1 elems have been merged
            if (pos1 >= 0 && nums2[pos2] < nums1[pos1]) {
                nums1[pos] = nums1[pos1];
                pos1--;
                pos--;
            } else {
                nums1[pos] = nums2[pos2];
                pos2--;
                pos--;
            }
        }
    }
}
