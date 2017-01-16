/*
 * Problem:  https://leetcode.com/problems/missing-number/
 *
 * Idea:     put each array elem into its supposed position (e.g. number 3 should be in index 3)
 *
 */

public class Solution {
    public int missingNumber(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i && nums[i] < nums.length) { // num out of place
                exchange(nums, nums[i], i);
                i--;
            }
        }
        // scan for first out-of-place num
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == i) {
                res++;
            } else {
                break;
            }
        }
        return res;
    }
    
    private void exchange(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
