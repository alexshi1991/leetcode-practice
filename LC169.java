/*
 * Problem: https://leetcode.com/problems/majority-element/
 *
 * Idea:    moore voting algorithm, O(n) time, constant space
 *
 */

public class Solution {
    public int majorityElement(int[] nums) {
        int majority = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (count == 0) {
                majority = nums[i];
            }
            if (majority == nums[i]) count++;
            if (majority != nums[i]) count--;
        }
        return majority;        
    }
}
