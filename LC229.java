/*
 * Problem: https://leetcode.com/problems/majority-element-ii/
 *
 * Idea:    Moore voting algorithm generalized to support two majority elements,
 *          unlike the first majorityElement problem, we need a second pass to check
 *          the number of occurrence of the result elements returned by the main algorithm
 *
 *          3 cases to consider here:
 * 
 *          1. there are no elements that appears more than n/3 times, then whatever the algorithm 
 *             returns from 1st round wound be rejected in the second round.
 *          2. there is only one element that appears more than n/3 times, 
 *             the other candicate will be rejected by the 2nd round
 *          3. there are two elments appears more than n/3 times. Both candidates satisfy the majority requirement
 *
 */


public class Solution {
    public List<Integer> majorityElement(int[] nums) {
        
        List<Integer> result = new ArrayList<Integer>();
        if (nums == null || nums.length == 0) return result;
        if (nums.length == 1) {
            result.add(nums[0]);
            return result;
        }
        
        // initialization
        int majority1 = nums[0], count1 = 1;
        int majority2 = nums[0], count2 = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == majority1) {
                count1++;
            } else if (nums[i] == majority2) {
                count2++;
            } else if (count1 == 0) {
                majority1 = nums[i];
                count1 = 1;
            } else if (count2 == 0) {
                majority2 = nums[i];
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }
        
        // check how many times has majority1 and majority2 occurred in the nums array
        count1 = 0;
        count2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == majority1) count1++;
            if (nums[i] == majority2) count2++;
        }
        if (count1 > (nums.length / 3)) {
            result.add(majority1);    
        }
        if (majority2 != majority1 && count2 > (nums.length / 3)) {
            result.add(majority2);
        }
        return result;        
    }
}
