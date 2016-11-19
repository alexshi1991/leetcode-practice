/*
 * Problem: https://leetcode.com/problems/search-in-rotated-sorted-array/
 *
 * Idea:    1. binary search, when cutting down the range in half, slightly different
 *          2. compare A[mid] with A[start]
 *          3. if A[mid] > A[start], it means A[start...mid] is sorted 
 *          4. if A[mid] < A[start], it means A[mid...end] is sorted
 *          5. depending on target value, move start/end pointer
 */


public class Solution {
    public int search(int[] A, int target) {
        int start = 0, end = A.length - 1, mid;
        while (start + 1 < end) {
            mid = start + (end - start) / 2;
            if (A[mid] == target) return mid;
            if (A[mid] > A[start]) {
                /*
                 * arr[] = [3, 4, 5, 6, 0, 1, 2], A[mid] = 6
                 */
                if (A[start] <= target && target <= A[mid]) {
                    end = mid;
                } else {
                    start = mid;
                }
            } else if (A[mid] < A[start]) {
                /*
                 * arr[] = [5, 6, 0, 1, 2, 3], A[mid] = 0
                 */
                if (A[end] >= target && target >= A[mid]) {
                    start = mid;
                } else {
                    end = mid;
                }
            }
        }
        if (A[start] == target) return start;
        if (A[end] == target) return end;
        
        return -1;
    }
}
