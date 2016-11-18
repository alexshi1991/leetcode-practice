/*
 * Problem: https://leetcode.com/problems/remove-duplicates-from-sorted-array/
 *
 * Idea: two pointers, copy unique items to the front of array
 */


public class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums == null) return 0;
        if (nums.length <= 1) return nums.length;
        int prev = 0, pos = 1;
        while (pos < nums.length) {
            while (pos < nums.length && nums[pos] == nums[prev]) {
                pos++;
            }
            if (pos == nums.length) break;
            nums[prev+1] = nums[pos];
            prev++;
            pos++;
        }
        return prev+1;
    }
}
