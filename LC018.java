/*
 * Problem: https://leetcode.com/problems/4sum/
 *
 * Idea:  1. similar to 3sum, instead of using one for-loop, 4sum uses 2 for-loops
 */


public class Solution {
	public List<List<Integer>> fourSum(int[] nums, int target) {
	    
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        
        if (nums == null || nums.length < 4) { return result; }
        
        // sort the input array so that numbers are in ascending order
        Arrays.sort(nums);
        
        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue; // skip duplicates for i
            }
        	for (int j = i + 1; j < nums.length - 2; j++) {
            	if (j > i + 1 && nums[j] == nums[j - 1]) {
            		continue; // skip duplicates for j
            	}
                int left = j + 1;
                int right = nums.length - 1;
                while (left < right) {
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum == target) {
                        // new entry in the result
                        result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        left++;
                        right--;
                        // skip duplicates for left and right
                        while (left < right && nums[left] == nums[left - 1]) {
                        	left++;
                        }
                        while (left < right && nums[right] == nums[right + 1]) {
                        	right--;
                        }
                    } else if (sum < target) {
                        left++;
                    } else if (sum > target) {
                        right--;
                    }
                }	
        	}
        }
        return result;
    }
}