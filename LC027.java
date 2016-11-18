/*
 * Problem: https://leetcode.com/problems/remove-element/
 *
 * Idea: scan input array, copy non-val items to front of array, effectively overwrite all the elems that need to be removed
 */


public class Solution {
    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) return 0;
        int i = 0, j = 0;
        while (j < nums.length) {
            if (nums[j] != val) {
                nums[i++] = nums[j];
            }
            j++;
        }
        return i;
    }
}
