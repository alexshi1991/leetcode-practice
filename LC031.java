/*
 * Problem: https://leetcode.com/problems/next-permutation/
 *
 * Idea:    1. location position from right where nums[pos] < nums[pos+1]
 *          2. locate first num nums[j] from right that is larger than nums[pos]
 *          3. exchange nums[j] and nums[pos]
 *          4. reverse section in the array nums[pos: end]
 */


public class Solution {
    public void nextPermutation(int[] nums) {
        // sanity check
        if (nums == null || nums.length < 2) {
            return;
        }
        
        // locate the position of the first successive pair of digits from right side where
        // nums[pos] < nums[pos + 1]
        int pos = nums.length - 2;
        while (pos >= 0 && nums[pos + 1] <= nums[pos]) {
            pos--;
        }
        
        // if pos < 0, it means no larger permutation is possible, skip directly to reversing
        if (pos >= 0) {
            // digits to the right of nums[pos] are already in descending order, locate the first digit larger than nums[pos] 
            int j = nums.length - 1;
            while (j > pos && nums[j] <= nums[pos]) {
                j--;
            }
            exchangePos(nums, pos, j);
        }

        // now digits to the right of nums[pos] are still in descending order, but need to be reversed to ascending order
        // in order to get the correct result
        reverseSection(nums, pos + 1, nums.length - 1);
    }
    
    // exchange the positions of two numbers in an array
    private void exchangePos(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    // reverse digits in a given section of the array
    private void reverseSection(int[] nums, int start, int end) {
        for (int i = start, j = end; i < j; i++, j--) {
            exchangePos(nums, i, j);
        }
    }
}
