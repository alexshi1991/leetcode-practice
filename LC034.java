/*
 * Problem: https://leetcode.com/problems/search-for-a-range/
 *
 * Idea: 1. Two iterations of binary search
 *       2. One to find left bound, one to find right bound
 *       3. O(logN)
 */


public class Solution {
    public int[] searchRange(int[] A, int target) {
        int[] result = new int[2];
        // search for the left bound
        int start = 0, end = A.length - 1, mid;
        while (start + 1 < end) {
            mid = start + (end - start) / 2;
            if (A[mid] >= target) {
                end = mid;
            } else if (A[mid] < target) {
                start = mid;
            }
        }
        if (A[start] == target) {
            result[0] = start;
        } else if (A[end] == target) {
            result[0] = end;
        } else {
            // not found
            result[0] = -1;
            result[1] = -1;
            return result;
        }
        
        // search for the right bound
        start = 0;
        end = A.length - 1;
        while (start + 1 < end) {
            mid = start + (end - start) / 2;
            if (A[mid] <= target) {
                start = mid;
            } else if (A[mid] > target) {
                end = mid;
            }
        }
        if (A[end] == target) {
            result[1] = end;
        } else if (A[start] == target) {
            result[1] = start;
        }
        
        return result;
    }
}
