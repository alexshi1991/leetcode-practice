/*
 * Problem: https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/
 *
 * Idea:   1. do a linear scan of the array starting from the 3rd element,
 *            overwrite any extra repeats( more than 3 in a row)
 *         2. idea is to construct the result in-place in the beginning of the array
 */


public class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length < 3) return nums.length;
        int pos = 2; 
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] != nums[pos-1] 
               || nums[i] != nums[pos-2]) {
                nums[pos++] = nums[i];
            }
        }
        return pos;
    }
}
