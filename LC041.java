/*
 * Problem: https://leetcode.com/problems/first-missing-positive/
 * 
 * Idea:    1. put 1 in 1st slot, 2 in 2nd slot, so on and so forth
 *          2. need to examine the element at position i again after a swap operation, that item may not be in the right position 
 */


public class Solution {
    public int firstMissingPositive(int[] nums) {
        for(int i = 0; i < nums.length; i++) {
            int n = nums[i];
            if (n > 0 && n < nums.length && (i+1) != n && nums[n - 1] != n) {
                // put n into the nth slot in the array
                swap(nums, n, i);
                i--; // still need to consider the element that just got swapped with n
            }
        }
        // 1 should be at 1st slot, 2 should be at 2nd, 3 should be at 3rd, so on and forth
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            } 
        }
        return nums.length + 1;
    }
    
    // put n into nth slot in the array, i.e, exchange item in position originalPos with position n - 1 
    private void swap(int[] nums, int n, int originalPos) {
        int temp = nums[n - 1];
        nums[n - 1] = n;
        nums[originalPos] = temp;
    }
}
