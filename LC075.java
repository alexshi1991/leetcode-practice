/*
 * Problem:  https://leetcode.com/problems/sort-colors/
 *
 * Idea:     1. two-pass counting sort is pretty straight forward
 *           2. single-pass approach is based on swapping,
 *              a) keep track of the position of lastRed (0) and position of firstBlue(2)
 *              b) when encounter red (0), swap it with first white (1)
 *              c) when encounter blue(2), swap it with last white(1)
 *              d) when encounter white(1), just skip
 */


public class Solution {
    
    // single-pass 
    public void sortColors(int[] nums) {
        if (nums == null || nums.length < 2) { return; }
        int lastRed = -1;
        int firstBlue = nums.length;
        for (int i = 0; i < firstBlue;) {
            if (nums[i] == 0) {
                swap(nums, ++lastRed, i++); 
            } else if (nums[i] == 2) {
                swap(nums, --firstBlue, i); 
            } else {
                i++;
            }
        }
    }
    
    // helper
    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
    
    // two-pass counting sort solution
    public void sortColors(int[] nums) {
        if (nums == null) return;
        int redCount = 0, whiteCount = 0, blueCount = 0;
        for (int num: nums) {
            switch (num) {
                case 0: redCount++; break;
                case 1: whiteCount++; break;
                case 2: blueCount++; break;
                default: break;
            }
        }
        int pos = 0;
        while (redCount-- > 0) nums[pos++] = 0;
        while (whiteCount-- > 0) nums[pos++] = 1;
        while (blueCount-- > 0) nums[pos++] = 2;
    }
}
