/*
 * Problem:  https://leetcode.com/problems/move-zeroes/
 * 
 * Idea:     scan input array left->right, keep track of the left most slot(zero)
 *
 */

public class Solution {
    public void moveZeroes(int[] nums) {
        int zeroIdx = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0 && zeroIdx == -1) {
                zeroIdx = i;
            } else {
                if (nums[i] != 0 && zeroIdx >= 0) { // there's a slot(zero) for this num
                    exchange(nums, zeroIdx, i);
                    zeroIdx++;
                }
            }
        }
    }
    
    private void exchange(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
