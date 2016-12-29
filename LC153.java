/*
 * Problem:  https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
 *
 * Idea:     binary search
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
            if (nums[mid] > nums[start] && nums[mid] > nums[end]) {
                start = mid;
            } else {
                end = mid;
            }
        }
        return Math.min(nums[start], nums[end]);        
    }
}
