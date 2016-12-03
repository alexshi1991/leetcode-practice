/*
 * Problem: https://leetcode.com/problems/search-in-rotated-sorted-array-ii/
 *
 * Idea:    1. binary search
 *          2. unlike in the related question, where no duplicates are allowed in array,
 *             at any iteration of binary search, nums[start] == nums[mid] can occur
 *          3. when this occurs, the target may be in either half of the array
 *          4. worst-case running time is O(n)
 */


public class Solution {
    public boolean search(int[] nums, int target) {
        int start = 0, end = nums.length - 1, mid;
        while (start + 1 < end) {
            mid = start + (end - start) / 2;
            if (nums[mid] == target) return true;
            if (nums[mid] > nums[start]) {
                /*
                 * arr[] = [3, 4, 4, 6, 0, 2, 2], nums[mid] = 6
                 */
                if (nums[start] <= target && target <= nums[mid]) {
                    end = mid;
                } else {
                    start = mid;
                }
            } else if (nums[mid] < nums[start]) {
                /*
                 * arr[] = [5, 5, 0, 0, 2, 3], nums[mid] = 0
                 */
                if (nums[end] >= target && target >= nums[mid]) {
                    start = mid;
                } else {
                    end = mid;
                }
            } else if (nums[mid] == nums[start]) {
                /*
                 * lets say target is 0
                 * arr[] = [3, 3, 3, 3, 0, 1, 2], nums[mid] = nums[start] = 3
                 * arr[] = [3, 4, 0, 3, 3, 3, 3], nums[mid] = nums[start] = 3
                 * when this happens, problem size can not be cut down by half
                 */
                 start++;
            }
        }
        if (nums[start] == target || nums[end] == target) return true;
        
        return false;
    }
}
