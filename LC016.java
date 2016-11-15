/*
 * Problem: https://leetcode.com/problems/3sum-closest/
 *
 * Idea:  1. sort the input array
 *        2. use each item in the array as first item in evaluated triplet
 *        3. use two pointers, left points to i+1, right points to end of array, bi-directional scan
 *        4. keep track of the current best sum
 */


public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length < 3) { return 0;}
        
        int bestSumDis = Integer.MAX_VALUE;
        int bestSum = nums[0] + nums[1] + nums[2];
        
        Arrays.sort(nums);
        
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i+1, right = nums.length-1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                int currDis = sum - target;
                int currAbsDis = Math.abs(currDis);
                if (currAbsDis == 0) {
                    return target; // found exact match, can not do better
                }
                if (currAbsDis < bestSumDis) {
                    bestSumDis = currAbsDis;
                    bestSum = sum;
                }
                if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        
        return bestSum;
    }
}