/*
 * Problem:  https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/
 *
 * Idea:     1. binary search
 *           2. however, with the possible duplicates in the sorted array,
 *              worst case running time becomes O(n) due to linear scanning
 *
 */

public class Solution {
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int start = 0;
        int end = nums.length - 1;
        int mid;
        while (start + 1 < end) {
            mid = start + (end - start) / 2;
            if (nums[mid] >= nums[start] && nums[mid] > nums[end]) {
                start = mid;
            } else if (nums[mid] == nums[start] && nums[mid] == nums[end]) {
                int min = Integer.MAX_VALUE;
                // do a linear scan from start to end
                for (int i = start; i <= end; i++) {
                    min = Math.min(min, nums[i]);
                }
                return min;
            } else {
                end = mid;
            }
        }
        return Math.min(nums[start], nums[end]);        
    }
}
