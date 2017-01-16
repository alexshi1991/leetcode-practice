/*
 * Problem:  https://leetcode.com/problems/h-index-ii/
 *
 * Idea:     1. binary search
 *           2. if mid elem satisfies requirement, 
 *              we still divide the prob size in half and keep looking for the max hIndex value
 *
 */

public class Solution {
    public int hIndex(int[] citations) {
        int hIndex = 0;
        if (citations == null || citations.length == 0) return hIndex;
        int left = 0, right = citations.length - 1;
        int mid;
        while (left + 1 < right) {
            mid = left + (right - left) / 2;
            if (citations[mid] >= (citations.length - mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        if (citations[left] >= citations.length - left) {
            hIndex = citations.length - left;
        } else if (citations[right] >= citations.length - right) {
            hIndex = citations.length - right;
        }
        return hIndex;
    }
}
