/*
 * Problem: https://leetcode.com/problems/search-insert-position/
 *
 * Idea: binary search
 */

public class Solution {
    public int searchInsert(int[] nums, int target) {
        int start = 0, end = nums.length - 1, mid;
        
        // find the first element that is greater than or equal to the target
        while (start + 1 < end) {
            mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return mid; // since there is no duplicates
            } else if (nums[mid] < target) {
                start = mid;
            } else if (nums[mid] > target) {
                end = mid;
            }
        }
        
        // examine elements at start and end after while loop exit
        if (nums[start] >= target) {
            return start;
        } else if (nums[end] < target) {
            return end + 1;
        } else {
            return end;
        }
    }
}
